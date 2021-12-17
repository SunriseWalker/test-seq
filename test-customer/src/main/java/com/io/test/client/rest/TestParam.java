package com.io.test.client.rest;

import java.io.Serializable;

/**
 * @Author: wangtianzhu
 * @Date: 2021-09-02
 */
public class TestParam implements Serializable {
    private String msg;
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
