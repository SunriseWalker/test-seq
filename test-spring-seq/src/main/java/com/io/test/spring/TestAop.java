package com.io.test.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAop {

    private static final Logger logger = LoggerFactory.getLogger(TestAop.class);

    @Pointcut("@annotation(testMark)")
    public void marked(TestMark testMark){}

    @Before("marked(testMark)")
    public void before(TestMark testMark){
        logger.info("in before");
    }

    @Around("marked(testMark)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint, TestMark testMark) throws Throwable {
        logger.info("in around, before");
        Object obj = proceedingJoinPoint.proceed();
        logger.info("in around, after");
        return obj;
    }

    @After("marked(testMark)")
    public void after(TestMark testMark){
        logger.info("in after");
    }

}
