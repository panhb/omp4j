package com.hengheng.util.omp4j.model.response.module.scanner;

import com.hengheng.util.omp4j.model.response.base.ListResponse;
import com.hengheng.util.omp4j.model.response.elem.ScannerElement;
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

}

