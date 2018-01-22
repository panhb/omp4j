package com.hengheng.util.omp4j.model.request.filter;

import com.hengheng.util.omp4j.model.request.filter.base.BaseFilter;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class PortListFilter extends BaseFilter {

    private String comment;
    private Integer total;
    private Integer tcp;
    private Integer udp;

}
