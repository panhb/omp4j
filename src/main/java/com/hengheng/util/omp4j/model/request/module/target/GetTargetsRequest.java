package com.hengheng.util.omp4j.model.request.module.target;

import com.hengheng.util.omp4j.model.request.base.ListRequest;
import com.hengheng.util.omp4j.model.request.filter.TargetFilter;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class GetTargetsRequest extends ListRequest {

    private String target_id;
    private Boolean trash;
    private Boolean tasks;
    private TargetFilter filter;

}

