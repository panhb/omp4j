package com.hengheng.util.omp4j.model.response.module.report;

import com.hengheng.util.omp4j.model.base.BaseModel;
import com.hengheng.util.omp4j.model.base.ListResponse;
import com.hengheng.util.omp4j.model.response.elem.comb.ReportReport;
import com.hengheng.util.omp4j.model.response.elem.common.CommonResult;
import com.hengheng.util.omp4j.model.response.elem.orig.Filtered;
import com.hengheng.util.omp4j.model.response.elem.orig.MaxStart;
import lombok.Data;

import java.util.List;

/**
 * @author panhb
 */
@Data
public class GetReportsResponse extends ListResponse {

    private List<ReportElement> report;
    private MaxStart reports;
    private Filtered report_count;

    @Data
    public static class ReportElement extends CommonResult {

        private String format_id;
        private String extension;
        private String content_type;
        private NameId task;
        private NameId report_format;
        private ReportReport report;

        @Data
        public static class NameId extends BaseModel {

            private String name;
            private String id;
        }
    }
}

