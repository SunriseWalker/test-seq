package com.io.test.client.masking;

import java.io.Serializable;

/**
 * @Author: wangtianzhu
 * @Date: 2022-07-11
 */
public class User implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 姓名
     */
    @DataMasking(maskFunc = DataMaskingFunc.ALL_MASK)
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮箱
     */
    @DataMasking(maskFunc = DataMaskingFunc.ALL_MASK)
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
