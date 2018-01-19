package com.hengheng.util.omp4j.model.response.elem.orig;

import com.hengheng.util.omp4j.model.base.BaseModel;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class Port extends BaseModel{

    private String text;
    private String host;
    private String severity;
    private String threat;

}
