package com.io.test.client.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 进行业务处理，同时添加@Async注解，代表该方法为异步处理。
 * @Author: wangtianzhu
 * @Date: 2021-12-17
 */
@Service
@Slf4j
public class AsyncTaskService {

    @SneakyThrows
    @Async
    public void doTask1() {
        long t1 = System.currentTimeMillis();
        Thread.sleep(2000);
        long t2 = System.currentTimeMillis();
        log.info("task1 cost {} ms" , t2-t1);
    }

    @SneakyThrows
    @Async("asyncPoolTaskExecutor")
    public void doTask2() {
        long t1 = System.currentTimeMillis();
        Thread.sleep(3000);
        long t2 = System.currentTimeMillis();
        log.info("task2 cost {} ms" , t2-t1);
    }
}
