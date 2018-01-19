package com.hengheng.util.omp4j.model.response.elem.comb;

import com.hengheng.util.omp4j.model.base.BaseModel;
import com.hengheng.util.omp4j.model.response.elem.TaskElement;
import com.hengheng.util.omp4j.model.response.elem.orig.Count;
import com.hengheng.util.omp4j.model.response.elem.orig.FullFiltered;
import com.hengheng.util.omp4j.model.response.elem.orig.HostText;
import com.hengheng.util.omp4j.model.response.elem.orig.Version;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class ReportReport extends BaseModel{

    private String id;
    private Version omp;
    private Sort sort;
    private Filters filters;
    private ReportSeverityClass severity_class;
    private Count user_tags;
    private String scan_run_status;
    private Count hosts;
    private Count closed_cves;
    private Count vulns;
    private Count os;
    private Count apps;
    private Count ssl_certs;
    private TaskElement task;
    private ReportScan scan;
    private String timestamp;
    private String scan_start;
    private String timezone;
    private String timezone_abbrev;
    private ReportPorts ports;
    private ReportResults results;
    private ReportResultCount result_count;
    private FullFiltered severity;
    private ReportHost host;
    private HostText host_start;
    private HostText host_end;
    private String scan_end;
    private ReportErrors errors;
    private String report_format;

}
