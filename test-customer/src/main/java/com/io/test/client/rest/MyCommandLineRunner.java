package com.io.test.client.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: wangtianzhu
 * @Date: 2021-09-03
 */
@Slf4j
@Component
public class MyCommandLineRunner implements CommandLineRunner,Ordered {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    SeqService seqService;

    @Override
    public void run(String... args) throws Exception {
        restTemplate.getForObject("http://test-spring-seq/test/hello", TestParam.class);
        log.info("===========================feign start=======================================");
        TestParam testParam =new TestParam();
        testParam.setMsg("feign request send ");
        testParam= seqService.sayHello(testParam);
        log.warn("=============================feign end=====================================");
        log.warn("===========================restTemplate start=======================================");
        testParam.setMsg("restTemplate request send ");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<TestParam> httpEntity = new HttpEntity<>(testParam,headers);

        String url = "http://test-spring-seq/test/hello";
        testParam = restTemplate.postForObject(url, httpEntity, TestParam.class);
        log.info("===============================restTemplate end===================================");
    }

    @Override
    public int getOrder() {
        return Integer.MIN_VALUE+1;
    }
}
