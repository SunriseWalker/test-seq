package com.io.test.client.rest;

import com.io.test.client.eneity.ReqParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: wangtianzhu
 * @Date: 2021-09-02
 */
@RestController
@RequestMapping("/client")
@Slf4j
public class ClientRest {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    SeqService seqService;

    @GetMapping("hello")
    public ReqParam sayHello() {
        log.info("client  seqService controller");
        return seqService.sayHello();
    }

    @GetMapping("/hello1")
    public ReqParam sayHello1() {
        log.info("client restTemplate controller");
        String url = "http://test-spring-seq/test/hello";
//        String url="http://localhost:8080/test/hello";
        return restTemplate.getForObject(url, ReqParam.class);
    }

    @PostMapping("/template/hello")
    public ReqParam templateHello(@RequestBody ReqParam reqParam) {
        String msg = reqParam.getMsg();
        log.info(" client template controller, msg=" + msg);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ReqParam> httpEntity = new HttpEntity<>(reqParam,headers);
        String url = "http://test-spring-seq/test/hello";
        ReqParam rs = restTemplate.postForObject(url, httpEntity, ReqParam.class);
        return rs;
    }

    @PostMapping("/feign/hello")
    public ReqParam feignHello(@RequestBody ReqParam reqParam) {
        String msg = reqParam.getMsg();
        log.info("client feign controller, msg=" + msg);
        return seqService.sayHello(reqParam);
    }

}
