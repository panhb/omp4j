package com.hengheng.util.omp4j.model.base;

import lombok.Data;

/**
 * @author panhb
 */
@Data
public class BaseResponse extends BaseModel {

    private String status;
    private String status_text;

}
