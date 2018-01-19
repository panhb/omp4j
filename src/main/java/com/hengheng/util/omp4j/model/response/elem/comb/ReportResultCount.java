package com.hengheng.util.omp4j.model.response.elem.comb;

import com.hengheng.util.omp4j.model.base.BaseModel;
import com.hengheng.util.omp4j.model.response.elem.orig.FullFiltered;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class ReportResultCount extends BaseModel{

    private String text;
    private String full;
    private String filtered;
    private FullFiltered debug;
    private FullFiltered hole;
    private FullFiltered info;
    private FullFiltered log;
    private FullFiltered warning;

}
