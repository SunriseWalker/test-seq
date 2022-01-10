package com.io.test.client.aviator;

import com.googlecode.aviator.AviatorEvaluator;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Aviator运算符操作：
 * 包括算数运算符、关系运算符、逻辑操作符、正则匹配操作符、三元表达式，并且还致辞操作符的优先级以及括号的强制优先级。
 * @Author: wtz
 * @Date: 2021-12-28
 */
public class AviatorSimpleTest {
    /**
     * 算数表达式:
     * Aviator的数值类型只支持Long和Double，任何整数都将会转换成Long，任何浮点数都会转换成Double，包括用户传入的变量数值。
     */
    @Test
    public void test1() {
        Long sum = (Long)AviatorEvaluator.execute("1 + 2 + 3");
        System.out.println(sum);
    }
    /**
     * 逻辑表达式
     */
    @Test
    public void test2() {
        Boolean result = (Boolean)AviatorEvaluator.execute("3 > 1 && 2 != 4 || true");
        System.out.println(result);
    }
    /**
     * 往表达式传入值
     */
    @Test
    public void test3() {
        Map<String, Object> env = new HashMap<>();
        env.put("name", "ruilin.shao");
        String str = "'hello ' + name";
        String result = (String) AviatorEvaluator.execute(str, env);
        System.out.println(result);
        //写法二
        String result2 = (String)AviatorEvaluator.exec(str, "便利蜂");
        System.out.println(result2);
    }
    /**
     * 三元表达式
     */
    @Test
    public void test4() {
        String result = (String)AviatorEvaluator.execute("3 > 0 ? yes : no");
        System.out.println(result);
    }
    /**
     * 函数调用
     */
    @Test
    public void test5() {
        System.out.println("string.length('hello') = " + AviatorEvaluator.execute("string.length('hello')"));//求字符串长度,不能用String.length();
        System.out.println("string.contains('hello', 'h') = " + AviatorEvaluator.execute("string.contains('hello', 'h')"));//判断字符串中是否包含某个字符串
        System.out.println("math.pow(-3, 2) = " + AviatorEvaluator.execute("math.pow(-3, 2)"));
        System.out.println("math.sqrt(9.0) = " + AviatorEvaluator.execute("math.sqrt(9.0)"));
    }

    @Test
    public void test6(){
        String expression = "num1 > num2 && isCar";
        Map<String,Object> paramMap = new HashMap<>();

        System.out.println(AviatorEvaluator.execute(expression, paramMap));
    }
}

