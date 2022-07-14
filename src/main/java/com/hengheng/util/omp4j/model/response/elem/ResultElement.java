package com.hengheng.util.omp4j.model.response.elem;

import com.hengheng.util.omp4j.model.base.BaseModel;
import com.hengheng.util.omp4j.model.response.elem.comb.Host;
import com.hengheng.util.omp4j.model.response.elem.common.CommonResult;
import com.hengheng.util.omp4j.model.response.elem.orig.Nvt;
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

    @Data
    public static class Qod extends BaseModel {

        private String value;
        private String type;

    }
}

