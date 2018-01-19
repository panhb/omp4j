package com.hengheng.util.omp4j.model.response.elem.comb;

import com.hengheng.util.omp4j.model.base.BaseModel;
import com.hengheng.util.omp4j.model.response.elem.orig.Nvt;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class ReportError extends BaseModel {

    private String port;
    private String description;
    private String scan_nvt_version;
    private String severity;
    private Host host;
    private Nvt nvt;

}
