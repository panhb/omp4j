package com.hengheng.util.omp4j.model.response.module.report;

import com.hengheng.util.omp4j.model.response.base.ListResponse;
import com.hengheng.util.omp4j.model.response.elem.ReportElement;
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

}

