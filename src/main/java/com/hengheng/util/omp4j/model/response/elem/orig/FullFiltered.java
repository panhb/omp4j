package com.hengheng.util.omp4j.model.response.elem.orig;

import com.hengheng.util.omp4j.model.base.BaseModel;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class FullFiltered extends BaseModel{

    private String full;
    private String filtered;
}
