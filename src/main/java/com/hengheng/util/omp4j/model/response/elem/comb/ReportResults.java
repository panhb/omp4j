package com.hengheng.util.omp4j.model.response.elem.comb;

import com.hengheng.util.omp4j.model.base.BaseModel;
import com.hengheng.util.omp4j.model.response.elem.ResultElement;
import lombok.Data;

import java.util.List;

/**
 * @author panhb
 */
@Data
public class ReportResults extends BaseModel{

    private String max;
    private String start;
    private List<ResultElement> result;

}
