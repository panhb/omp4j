package com.hengheng.util.omp4j.model.response.elem.orig;

import com.hengheng.util.omp4j.model.base.BaseModel;
import lombok.Data;

/**
 * @author hongbo.pan
 * @date 2018/8/28
 */
@Data
public class TagsInfo extends BaseModel {

    private String cvss_base_vector;
    private String vuldetect;
    private String summary;
    private String solution;
    private String solution_type;
    private String qod_type;
    private String impact;
    private String insight;

}
