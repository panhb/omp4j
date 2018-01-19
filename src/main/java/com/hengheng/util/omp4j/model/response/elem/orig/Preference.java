package com.hengheng.util.omp4j.model.response.elem.orig;

import com.hengheng.util.omp4j.model.base.BaseModel;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class Preference extends BaseModel {

    private String name;
    private String scanner_name;
    private String value;

}
