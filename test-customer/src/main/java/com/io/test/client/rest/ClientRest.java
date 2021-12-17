package com.io.test.client.rest;

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
    public TestParam sayHello() {
        log.info("client  seqService controller");
        return seqService.sayHello();
    }

    @GetMapping("/hello1")
    public TestParam sayHello1() {
        log.info("client restTemplate controller");
        String url = "http://test-spring-seq/test/hello";
//        String url="http://localhost:8080/test/hello";
        return restTemplate.getForObject(url, TestParam.class);
    }

    @PostMapping("/template/hello")
    public TestParam templateHello(@RequestBody TestParam testParam) {
        String msg = testParam.getMsg();
        log.info(" client template controller, msg=" + msg);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<TestParam> httpEntity = new HttpEntity<>(testParam,headers);
        String url = "http://test-spring-seq/test/hello";
        TestParam rs = restTemplate.postForObject(url, httpEntity, TestParam.class);
        return rs;
    }

    @PostMapping("/feign/hello")
    public TestParam feignHello(@RequestBody TestParam testParam) {
        String msg = testParam.getMsg();
        log.info("client feign controller, msg=" + msg);
        return seqService.sayHello(testParam);
    }

}
