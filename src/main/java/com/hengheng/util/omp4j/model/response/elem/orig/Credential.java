package com.hengheng.util.omp4j.model.response.elem.orig;

import com.hengheng.util.omp4j.model.base.BaseModel;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class Credential extends BaseModel{

    private String id;
    private String name;
    private String trash;
    private String port;

}
