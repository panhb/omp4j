package com.hengheng.util.omp4j.model.response.elem;

import com.hengheng.util.omp4j.model.response.elem.common.CommonResult;
import com.hengheng.util.omp4j.model.response.elem.orig.Trust;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class ReportFormatElement extends CommonResult {

    private String extension;
    private String content_type;
    private String summary;
    private String description;
    private String predefined;
    private String active;
    private Trust trust;

}
