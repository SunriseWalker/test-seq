package com.io.test.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author dk
 */
@ControllerAdvice
public class MyRespAdvice implements ResponseBodyAdvice {

    private static final Logger logger = LoggerFactory.getLogger(MyRespAdvice.class);

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        logger.info("in ResponseBodyAdvice, supports");
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        logger.info("in ResponseBodyAdvice, beforeBodyWrite");
        return body;
    }
}
