package com.hengheng.util.omp4j.model.response.elem.comb;

import com.hengheng.util.omp4j.model.base.BaseModel;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class Sort extends BaseModel {

    private Order field;

    /**
     * @author panhb
     */
    @Data
    public static class Order extends BaseModel {

        private String text;
        private String order;
    }
}

