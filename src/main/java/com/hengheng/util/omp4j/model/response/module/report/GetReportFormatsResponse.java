package com.hengheng.util.omp4j.model.response.module.report;

import com.hengheng.util.omp4j.model.response.base.ListResponse;
import com.hengheng.util.omp4j.model.response.elem.ReportFormatElement;
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

}

