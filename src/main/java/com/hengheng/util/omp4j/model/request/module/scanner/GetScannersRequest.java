package com.hengheng.util.omp4j.model.request.module.scanner;

import com.hengheng.util.omp4j.model.request.base.ListRequest;
import com.hengheng.util.omp4j.model.request.filter.ScannerFilter;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class GetScannersRequest extends ListRequest {

    private String scanner_id;
    private Boolean trash;
    private Boolean details;
    private ScannerFilter filter;

}

