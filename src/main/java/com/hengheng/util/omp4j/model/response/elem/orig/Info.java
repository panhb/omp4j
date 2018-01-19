package com.hengheng.util.omp4j.model.response.elem.orig;

import com.hengheng.util.omp4j.model.base.BaseModel;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class Info extends BaseModel {

    private String id;
    private String name;
    private String type;
    private String trash;
    private String next_time;

}

