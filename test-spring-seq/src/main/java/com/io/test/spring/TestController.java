package com.io.test.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

/**
 * @author dk
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @TestMark
    @GetMapping("hello")
    public TestParam sayHello(){
        logger.info("in controller");
        return new TestParam("hello world");
    }

    @TestMark
    @PostMapping("hello")
    public TestParam sayHello(@Valid @RequestBody TestParam testParam){
        String msg = testParam.getMsg();
        logger.info("in controller, msg="+ msg);
        return new TestParam("hello world, msg="+ msg);
    }
}
