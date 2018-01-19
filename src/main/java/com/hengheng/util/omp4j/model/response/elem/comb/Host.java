package com.hengheng.util.omp4j.model.response.elem.comb;

import com.hengheng.util.omp4j.model.base.BaseModel;
import com.hengheng.util.omp4j.model.response.elem.orig.Asset;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class Host extends BaseModel {

    private String text;
    private Asset asset;
}
