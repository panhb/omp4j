package com.hengheng.util.omp4j.model.request.filter;

import com.hengheng.util.omp4j.model.request.filter.base.BaseFilter;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class ReportFilter extends BaseFilter {

    private String host;
    private String location;
    private String type;
    private String original_type;
    private Boolean auto_type;
    private String description;
    private String task;
    private String report;
    private String cvss_base;
    private String nvt_version;
    private String severity;
    private String original_severity;
    private String vulnerability;
    private String date;
    private String report_id;
    private String solution_type;
    private Integer qod;
    private String qod_type;
    private String task_id;
    private String cve;

}
