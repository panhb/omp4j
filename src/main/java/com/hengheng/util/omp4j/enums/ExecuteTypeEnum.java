package com.hengheng.util.omp4j.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 执行类型枚举
 *
 * @author hongbo.pan
 * @date 2018/8/22
 */
public enum ExecuteTypeEnum {

    /**
     * CMD
     */
    CMD("CMD"),

    /**
     * SSH
     */
    SSH("SSH"),

    ;

    private static Map<String, ExecuteTypeEnum> enumMap = new HashMap<>();
    private String code;

    static {
        for(ExecuteTypeEnum as : ExecuteTypeEnum.values()) {
            enumMap.put(as.code, as);
        }
    }

    ExecuteTypeEnum(String code) {
        this.code = code;
    }

    public static ExecuteTypeEnum getByCode(String code) {
        return  enumMap.get(code);
    }

    public String getCode() {
        return this.code;
    }

}
