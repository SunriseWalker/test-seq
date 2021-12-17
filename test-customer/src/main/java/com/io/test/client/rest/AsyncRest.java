package com.io.test.client.rest;

import com.io.test.client.service.AsyncTaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 异步调用
 * @Author: wangtianzhu
 * @Date: 2021-12-17
 */
@Api("异步调用controller")
@RestController
@Slf4j
public class AsyncRest {
    @Autowired
    private AsyncTaskService asyncTaskService;

    @ApiOperation("异步调用task")
    @PostMapping("/task")
    public void task() throws InterruptedException {
        for (int i=0; i < 3;  i++){
            long t1 = System.currentTimeMillis();
            asyncTaskService.doTask1();
            asyncTaskService.doTask2();
            Thread.sleep(1000);
            long t2 = System.currentTimeMillis();
            log.info("main cost {} ms", t2-t1);
        }
    }
}
