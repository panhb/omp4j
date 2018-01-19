package com.hengheng.util.omp4j.model.request.module.report;

import com.hengheng.util.omp4j.model.request.base.ListRequest;
import com.hengheng.util.omp4j.model.request.filter.ReportFormatFilter;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class GetReportFormatsRequest extends ListRequest {

    private String report_format_id;
    private Boolean trash;
    private Boolean alerts;
    private Boolean params;
    private Boolean details;
    private ReportFormatFilter filter;

}

