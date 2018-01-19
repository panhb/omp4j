package com.hengheng.util.omp4j.model.request.filter;

import com.hengheng.util.omp4j.model.request.filter.base.BaseFilter;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class ReportFormatFilter extends BaseFilter {

    private String extension;
    private String content_type;
    private String summary;
    private String description;
    private Boolean trust;
    private String trust_time;
    private Boolean active;

}
