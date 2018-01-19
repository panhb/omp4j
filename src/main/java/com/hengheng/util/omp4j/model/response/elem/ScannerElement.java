package com.hengheng.util.omp4j.model.response.elem;

import com.hengheng.util.omp4j.model.response.elem.common.CommonResult;
import com.hengheng.util.omp4j.model.response.elem.orig.Credential;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class ScannerElement extends CommonResult {

    private String host;
    private String port;
    private String type;
    private String ca_pub;
    private Credential credential;

}
