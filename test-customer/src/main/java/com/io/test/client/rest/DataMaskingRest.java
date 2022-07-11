package com.io.test.client.rest;

import com.io.test.client.masking.User;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wangtianzhu
 * @Date: 2022-07-11
 */
@Api("数据脱敏")
@RestController
@Slf4j
public class DataMaskingRest {

    @PostMapping("get/masking")
    public User getUser(){
        User user = new User();
        user.setId(1L);
        user.setAge(18);
        user.setName("砸电视");
        user.setEmail("122324wt@126.com");
        return user;
    }
}
