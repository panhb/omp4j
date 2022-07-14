package com.hengheng.util.omp4j.model.request.config;

import com.hengheng.util.omp4j.model.base.ListRequest;
import com.hengheng.util.omp4j.model.base.BaseFilter;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class GetConfigsRequest extends ListRequest {

    private String config_id ;
    private Boolean trash;
    private Boolean details;
    private Boolean families;
    private Boolean preferences;
    private Boolean tasks;
    private ConfigFilter filter;

    @Data
    public static class ConfigFilter extends BaseFilter {

        private String comment;
        private String nvt_selector;
        private Integer families_total;
        private Integer nvts_total;
        private Boolean families_trend;
        private Boolean nvts_trend;

    }
}

