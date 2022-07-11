package com.io.test.client.masking;

/**
 * @Author: wangtianzhu
 * @Date: 2022-07-11
 */
public interface DataMaskingOperation {
    String MASK_CHAR = "*";

    String mask(String content, String maskChar);

}
