package com.io.test.client.rest;

import com.io.test.client.service.AsyncTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wangtianzhu
 * @Date: 2021-12-17
 */
@RestController
@Slf4j
public class AsyncRest {
    @Autowired
    private AsyncTaskService asyncTaskService;

    @RequestMapping("/task")
    public void task() throws InterruptedException {
        for (int i=0; i < 2;  i++){
            long t1 = System.currentTimeMillis();
            asyncTaskService.doTask1();
            asyncTaskService.doTask2();
            Thread.sleep(1500);
            long t2 = System.currentTimeMillis();
            log.info("main cost {} ms", t2-t1);
        }
    }
}
