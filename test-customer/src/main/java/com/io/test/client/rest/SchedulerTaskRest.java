package com.io.test.client.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 多线程环境下，解决多个定时器冲突问题
 * 1.为Async 实现一个自定义线程池
 * 2.在Scheduled任务添加@Async
 * @Author: wangtianzhu
 * @Date: 2021-12-17
 */
@Component
@Slf4j
public class SchedulerTaskRest {
    private static final SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm:ss");
    private int count=0;
    @Scheduled(cron="0/2 * * * * ?")
    @Async
    public void process(){
        log.info("英文:this is scheduler task runing "+(count++));
    }

    @Scheduled(fixedRate = 2000)
    @Async
    public void currentTime(){
        log.info("中文:现在时间"+dateFormat.format(new Date()));
    }

}
