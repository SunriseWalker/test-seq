package com.io.test.client.masking;

import org.springframework.util.StringUtils;

/**
 * 自定义Serializer，参考jackson的StringSerializer，下面的示例只针对String类型进行脱敏
 *
 * @Author: wangtianzhu
 * @Date: 2022-07-11
 */
public enum DataMaskingFunc {
    /**
     *  脱敏转换器
     */
    NO_MASK((str, maskChar) -> {
        return str;
    }),
    ALL_MASK((str, maskChar) -> {
        if (StringUtils.hasLength(str)) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                sb.append(StringUtils.hasLength(maskChar) ? maskChar : DataMaskingOperation.MASK_CHAR);
            }
            return sb.toString();
        } else {
            return str;
        }
    });

    private final DataMaskingOperation operation;

    DataMaskingFunc(DataMaskingOperation operation) {
        this.operation = operation;
    }

    public DataMaskingOperation operation() {
        return this.operation;
    }
}
