package com.hengheng.util.omp4j.model.request.report;

import com.hengheng.util.omp4j.model.base.ListRequest;
import com.hengheng.util.omp4j.model.base.BaseFilter;
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

    @Data
    public static class ReportFormatFilter extends BaseFilter {

        private String extension;
        private String content_type;
        private String summary;
        private String description;
        private Boolean trust;
        private String trust_time;
        private Boolean active;

    }
}

