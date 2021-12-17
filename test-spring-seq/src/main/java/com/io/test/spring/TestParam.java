package com.io.test.spring;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @Author: wangtianzhu
 * @Date: 2021-09-02
 */
public class TestParam implements Serializable {
    @NotEmpty(message = "消息不能空白")
    private String msg;

    public TestParam(@NotEmpty(message = "消息不能空白") String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
