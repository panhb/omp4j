package com.hengheng.util.omp4j.model.response.elem.comb;

import com.hengheng.util.omp4j.model.base.BaseModel;
import com.hengheng.util.omp4j.model.response.elem.orig.TaskResultCount;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class TaskReportInfo extends BaseModel {

    private String id;
    private String timestamp;
    private String scan_start;
    private String scan_end;
    private String severity;
    private TaskResultCount result_count;

}
