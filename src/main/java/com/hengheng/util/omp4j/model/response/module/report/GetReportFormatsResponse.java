package com.hengheng.util.omp4j.model.response.module.report;

import com.hengheng.util.omp4j.model.base.BaseModel;
import com.hengheng.util.omp4j.model.base.ListResponse;
import com.hengheng.util.omp4j.model.response.elem.common.CommonResult;
import com.hengheng.util.omp4j.model.response.elem.orig.Filtered;
import com.hengheng.util.omp4j.model.response.elem.orig.MaxStart;
import lombok.Data;

import java.util.List;

/**
 * @author panhb
 */
@Data
public class GetReportFormatsResponse extends ListResponse {

    private List<ReportFormatElement> report_format;
    private MaxStart report_formats;
    private Filtered report_format_count;

    @Data
    public static class ReportFormatElement extends CommonResult {

        private String extension;
        private String content_type;
        private String summary;
        private String description;
        private String predefined;
        private String active;
        private Trust trust;

        @Data
        public static class Trust extends BaseModel {

            private String text;
            private String time;

        }
    }
}

