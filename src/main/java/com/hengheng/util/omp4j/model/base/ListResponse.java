package com.hengheng.util.omp4j.model.base;

import com.hengheng.util.omp4j.model.response.elem.comb.Filter;
import com.hengheng.util.omp4j.model.response.elem.comb.Sort;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class ListResponse extends BaseResponse {

    private Filter filters;
    private Sort sort;

}
