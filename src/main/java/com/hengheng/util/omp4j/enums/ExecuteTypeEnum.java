package com.hengheng.util.omp4j.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 执行类型枚举
 *
 * @author hongbo.pan
 * @date 2018/8/22
 */
@AllArgsConstructor
@Getter
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

    public static ExecuteTypeEnum getByCode(String code) {
        return ENUM_MAP.get(code);
    }

}
