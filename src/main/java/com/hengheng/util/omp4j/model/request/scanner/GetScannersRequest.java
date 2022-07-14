package com.hengheng.util.omp4j.model.request.scanner;

import com.hengheng.util.omp4j.model.base.ListRequest;
import com.hengheng.util.omp4j.model.base.BaseFilter;
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

    @Data
    public static class ScannerFilter extends BaseFilter {

        private String comment;
        private String host;
        private Integer port;
        private String type;

    }
}

