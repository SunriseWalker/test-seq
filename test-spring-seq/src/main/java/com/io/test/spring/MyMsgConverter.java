package com.io.test.spring;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.GenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.lang.Nullable;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

/**
 * @Author: wangtianzhu
 * @Date: 2021-08-31
 */
public class MyMsgConverter extends AbstractHttpMessageConverter {

    private static final Logger log = LoggerFactory.getLogger(MyMsgConverter.class);

    public MyMsgConverter(){
        super(Charset.forName("UTF-8"),new MediaType[]{MediaType.APPLICATION_JSON, new MediaType("application","*+json")});
        log.info("in AbstractJackson2HttpMessageConverter  structure");
    }

    @Override
    protected Object readInternal(Class aClass, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        log.info("in AbstractHttpMessageConverter  readInternal");
        String s = StreamUtils.copyToString(inputMessage.getBody(), Charset.forName("utf-8"));
        try {
            return JSONObject.parseObject(s,aClass);
        } catch (Exception e) {
            log.error("exception when java deserialize, the input is:{}",  e);
            return null;

        }
    }

    @Override
    protected void writeInternal(Object  t, HttpOutputMessage outputMessage) throws  HttpMessageNotWritableException {
        log.info("in AbstractHttpMessageConverter  writeInternal");
        try {
            outputMessage.getBody().write(JSON.toJSONString(t).getBytes("utf-8"));
            outputMessage.getBody().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected boolean supports(Class aClass) {
        return true;
    }

}
