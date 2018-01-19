package com.hengheng.util.omp4j.model.response.module.result;

import com.hengheng.util.omp4j.model.response.base.ListResponse;
import com.hengheng.util.omp4j.model.response.elem.ResultElement;
import com.hengheng.util.omp4j.model.response.elem.orig.Filtered;
import com.hengheng.util.omp4j.model.response.elem.orig.MaxStart;
import lombok.Data;

import java.util.List;

/**
 * @author panhb
 */
@Data
public class GetResultsResponse extends ListResponse {

    private List<ResultElement> result;
    private MaxStart results;
    private Filtered result_count;

}

