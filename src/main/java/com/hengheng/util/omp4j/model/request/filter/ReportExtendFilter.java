package com.hengheng.util.omp4j.model.request.filter;

import com.hengheng.util.omp4j.model.request.filter.base.BaseFilter;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class ReportExtendFilter extends BaseFilter {

    private String task_id;
    private String date;
    private String status;
    private Boolean task;
    private String severity;
    private Integer false_positive;
    private Integer log;
    private Integer low;
    private Integer medium;
    private Integer high;
    private Integer hosts;
    private Integer result_hosts;
    private Integer fp_per_host;
    private Integer log_per_host;
    private Integer low_per_host;
    private Integer medium_per_host;
    private Integer high_per_host;

}
