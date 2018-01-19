package com.hengheng.util.omp4j.model.response.elem.comb;

import com.hengheng.util.omp4j.model.base.BaseModel;
import com.hengheng.util.omp4j.model.response.elem.orig.FullFiltered;
import com.hengheng.util.omp4j.model.response.elem.orig.Page;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class ReportHostResultCount extends BaseModel{

    private String page;
    private Page false_positive;
    private Page hole;
    private Page info;
    private Page log;
    private Page warning;

}
