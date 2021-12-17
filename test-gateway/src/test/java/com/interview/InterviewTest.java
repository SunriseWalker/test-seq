package com.interview;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @Author: wangtianzhu
 * @Date: 2021-10-13
 */
public class InterviewTest {

    @Test
    public void modifyStr() throws NoSuchFieldException, IllegalAccessException {

        String s = "abc";
        //在中间修改N行代码，输出abcd，但需要保证s的引用不变
        //考查反射
        Field value = s.getClass().getDeclaredField("value");
        value.setAccessible(true);
        value.set(s,"abcd".toCharArray());

        System.out.println(s);
    }

    @Test
    public void equalsTest(){
        String s1= new String("abc"); //2个对象
        String s2 = "abc"; // 字符串常量对象
        // s1 == s2 ? true or false
        System.out.println(s2 == s1);
        // s2 == s3 ? true or false
        String s3 = s1.intern();
        System.out.println(s2 == s3);
    }

    @Test
    public void IntegerTest(){
        Integer i1 = 100;
        Integer i2 = 100;
        // i1==i2 ? true or false

        Integer i3 = 128;
        Integer i4 = 128;
        // i3 == i4 ? true or false
    }

    public void test(){
        new ArrayList<>();
        new LinkedList<>();

        new HashMap<>();
    }
}
