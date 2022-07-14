package com.hengheng.util.omp4j.model.response.module.config;

import com.hengheng.util.omp4j.model.base.BaseModel;
import com.hengheng.util.omp4j.model.base.ListResponse;
import com.hengheng.util.omp4j.model.response.elem.common.CommonResult;
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

    @Data
    public static class ConfigElement extends CommonResult {

        private Growing family_count;
        private Growing nvt_count;
        private String type;

        @Data
        public static class Growing extends BaseModel {

            private String text;
            private String growing;

        }
    }
}

