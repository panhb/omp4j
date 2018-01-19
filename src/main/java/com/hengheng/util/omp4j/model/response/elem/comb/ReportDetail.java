package com.hengheng.util.omp4j.model.response.elem.comb;

import com.hengheng.util.omp4j.model.base.BaseModel;
import com.hengheng.util.omp4j.model.response.elem.orig.Source;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class ReportDetail extends BaseModel{

    private String name;
    private String value;
    private String extra;
    private Source source;

}
