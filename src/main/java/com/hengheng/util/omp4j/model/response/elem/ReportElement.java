package com.hengheng.util.omp4j.model.response.elem;

import com.hengheng.util.omp4j.model.response.elem.comb.ReportReport;
import com.hengheng.util.omp4j.model.response.elem.common.CommonResult;
import com.hengheng.util.omp4j.model.response.elem.orig.NameId;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class ReportElement extends CommonResult {

    private String format_id;
    private String extension;
    private String content_type;
    private NameId task;
    private NameId report_format;
    private ReportReport report;

}
