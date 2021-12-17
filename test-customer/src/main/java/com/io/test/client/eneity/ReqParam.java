package com.io.test.client.eneity;

import java.io.Serializable;

/**
 * @Author: wangtianzhu
 * @Date: 2021-09-02
 */
public class ReqParam implements Serializable {
    private String msg;
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
