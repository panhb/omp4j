package com.hengheng.util.omp4j.model.response.module.target;

import com.hengheng.util.omp4j.model.response.base.ListResponse;
import com.hengheng.util.omp4j.model.response.elem.TargetElement;
import com.hengheng.util.omp4j.model.response.elem.orig.Filtered;
import com.hengheng.util.omp4j.model.response.elem.orig.MaxStart;
import lombok.Data;

import java.util.List;

/**
 * @author panhb
 */
@Data
public class GetTargetsResponse extends ListResponse {

    private List<TargetElement> target;
    private MaxStart targets;
    private Filtered target_count;

}

