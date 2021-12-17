package com.io.test.client.rest;

import com.io.test.client.eneity.ReqParam;
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
    ReqParam sayHello();

    @PostMapping(value = "hello", headers = {"Content-Type=application/json;charset=UTF-8"})
    ReqParam sayHello(ReqParam reqParam);

}
