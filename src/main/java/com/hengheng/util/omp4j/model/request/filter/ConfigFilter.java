package com.hengheng.util.omp4j.model.request.filter;

import com.hengheng.util.omp4j.model.request.filter.base.BaseFilter;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class ConfigFilter extends BaseFilter {

    private String comment;
    private String nvt_selector;
    private Integer families_total;
    private Integer nvts_total;
    private Boolean families_trend;
    private Boolean nvts_trend;

}
