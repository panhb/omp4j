package com.hengheng.util.omp4j.model.request.result;

import com.hengheng.util.omp4j.model.base.ListRequest;
import com.hengheng.util.omp4j.model.base.BaseFilter;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class GetResultsRequest extends ListRequest {

    private String result_id;
    private String task_id;
    private Boolean note_details;
    private Boolean override_details;
    private Boolean details;
    private ResultFilter filter;

    @Data
    public static class ResultFilter extends BaseFilter {

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
}

