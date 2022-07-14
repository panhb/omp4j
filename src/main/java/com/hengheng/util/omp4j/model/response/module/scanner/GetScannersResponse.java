package com.hengheng.util.omp4j.model.response.module.scanner;

import com.hengheng.util.omp4j.model.base.ListResponse;
import com.hengheng.util.omp4j.model.response.elem.common.CommonResult;
import com.hengheng.util.omp4j.model.response.elem.orig.Credential;
import com.hengheng.util.omp4j.model.response.elem.orig.Filtered;
import com.hengheng.util.omp4j.model.response.elem.orig.MaxStart;
import lombok.Data;

import java.util.List;

/**
 * @author panhb
 */
@Data
public class GetScannersResponse extends ListResponse {

    private List<ScannerElement> scanner;
    private MaxStart scanners;
    private Filtered scanner_count;

    @Data
    public static class ScannerElement extends CommonResult {

        private String host;
        private String port;
        private String type;
        private String ca_pub;
        private Credential credential;

    }
}

