package com.hengheng.util.omp4j.model.response.elem;

import com.hengheng.util.omp4j.model.response.elem.common.CommonResult;
import com.hengheng.util.omp4j.model.response.elem.orig.Growing;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class ConfigElement extends CommonResult {

    private Growing family_count;
    private Growing nvt_count;
    private String type;

}
