package com.hengheng.util.omp4j.model.request.module.report;

import com.hengheng.util.omp4j.model.request.base.ListRequest;
import com.hengheng.util.omp4j.model.request.filter.ReportExtendFilter;
import com.hengheng.util.omp4j.model.request.filter.ReportFilter;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class GetReportsRequest extends ListRequest {

    private String report_id;
    private ReportExtendFilter report_filter;
    private String report_filt_id;
    private String type ;
    private String format_id;
    private String alert_id;
    private Boolean note_details;
    private Boolean override_details;
    private String host;
    private Integer host_first_result;
    private Integer host_max_results;
    private String host_levels;
    private String host_search_phrase;
    private Integer pos;
    private String delta_report_id;
    private Boolean ignore_pagination;
    private ReportFilter filter;

}

