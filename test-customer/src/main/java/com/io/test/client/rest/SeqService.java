package com.io.test.client.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author: wangtianzhu
 * @Date: 2021-09-02
 */
@FeignClient(value = "test-spring-seq",path = "/test")
public interface SeqService {

    @GetMapping("hello")
    TestParam sayHello();

    @PostMapping(value = "hello", headers = {"Content-Type=application/json;charset=UTF-8"})
    TestParam sayHello(TestParam testParam);

}
