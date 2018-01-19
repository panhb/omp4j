package com.hengheng.util.omp4j.model.request.module.result;

import com.hengheng.util.omp4j.model.request.base.ListRequest;
import com.hengheng.util.omp4j.model.request.filter.ResultFilter;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class GetResultsRequest extends ListRequest {

    private String result_id;
    private String task_id;
    private Boolean note_details;
    private Boolean override_details;
    private Boolean details;
    private ResultFilter filter;

}

