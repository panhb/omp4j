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

    private static final Map<String, ExecuteTypeEnum> ENUM_MAP = new HashMap<>();
    private String code;

    static {
        for(ExecuteTypeEnum as : ExecuteTypeEnum.values()) {
            ENUM_MAP.put(as.code, as);
        }
    }

    ExecuteTypeEnum(String code) {
        this.code = code;
    }

    public static ExecuteTypeEnum getByCode(String code) {
        return ENUM_MAP.get(code);
    }

    public String getCode() {
        return this.code;
    }

}
