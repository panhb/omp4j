package com.hengheng.util.omp4j.model.response.elem;

import com.hengheng.util.omp4j.model.response.elem.comb.Host;
import com.hengheng.util.omp4j.model.response.elem.common.CommonResult;
import com.hengheng.util.omp4j.model.response.elem.orig.Nvt;
import com.hengheng.util.omp4j.model.response.elem.orig.Qod;
import lombok.Data;

import java.util.List;

/**
 * @author panhb
 */
@Data
public class ResultElement extends CommonResult {
    private Host host;
    private String port;
    private Nvt nvt;
    private String scan_nvt_version;
    private String threat;
    private String severity;
    private Qod qod;
    private String description;
    private String original_threat;
    private String original_severity;
    private List<String> notes;
    private List<String> overrides;

}

