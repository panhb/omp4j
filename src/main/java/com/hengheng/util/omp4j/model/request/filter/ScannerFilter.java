package com.hengheng.util.omp4j.model.request.filter;

import com.hengheng.util.omp4j.model.request.filter.base.BaseFilter;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class ScannerFilter extends BaseFilter {

    private String comment;
    private String host;
    private Integer port;
    private String type;

}
