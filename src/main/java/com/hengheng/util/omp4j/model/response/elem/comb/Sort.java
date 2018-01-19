package com.hengheng.util.omp4j.model.response.elem.comb;

import com.hengheng.util.omp4j.model.base.BaseModel;
import com.hengheng.util.omp4j.model.response.elem.orig.Order;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class Sort extends BaseModel {

    private Order field;
}

