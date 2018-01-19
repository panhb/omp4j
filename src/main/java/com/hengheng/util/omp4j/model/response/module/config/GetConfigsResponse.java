package com.hengheng.util.omp4j.model.response.module.config;

import com.hengheng.util.omp4j.model.response.base.ListResponse;
import com.hengheng.util.omp4j.model.response.elem.ConfigElement;
import com.hengheng.util.omp4j.model.response.elem.orig.Filtered;
import com.hengheng.util.omp4j.model.response.elem.orig.MaxStart;
import lombok.Data;

import java.util.List;

/**
 * @author panhb
 */
@Data
public class GetConfigsResponse extends ListResponse {

    private List<ConfigElement> config;
    private MaxStart configs;
    private Filtered config_count;

}

