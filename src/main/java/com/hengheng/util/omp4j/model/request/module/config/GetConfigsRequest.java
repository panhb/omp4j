package com.hengheng.util.omp4j.model.request.module.config;

import com.hengheng.util.omp4j.model.request.base.ListRequest;
import com.hengheng.util.omp4j.model.request.filter.ConfigFilter;
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

}

