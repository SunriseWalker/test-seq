package com.io.test.client.masking;

import java.lang.annotation.*;

/**
 * 自定义数据注解，并可以配置数据脱敏策略
 *
 * @Author: wangtianzhu
 * @Date: 2022-07-11
 */
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataMasking {

    DataMaskingFunc maskFunc() default DataMaskingFunc.NO_MASK;

}