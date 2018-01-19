package com.hengheng.util.omp4j.model.response.elem.common;

import com.hengheng.util.omp4j.model.base.BaseModel;
import com.hengheng.util.omp4j.model.response.elem.comb.Permissions;
import com.hengheng.util.omp4j.model.response.elem.comb.UserTags;
import com.hengheng.util.omp4j.model.response.elem.orig.Name;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class CommonResult extends BaseModel {

    private String id;
    private String name;
    private Name owner;
    private String comment;
    private String creation_time;
    private String modification_time;
    private UserTags user_tags;

    private String in_use;
    private String writable;
    private Permissions permissions;

}

