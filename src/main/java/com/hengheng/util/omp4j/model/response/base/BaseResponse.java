package com.hengheng.util.omp4j.model.response.base;

import com.hengheng.util.omp4j.model.base.BaseModel;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class BaseResponse extends BaseModel {

    private String status;
    private String status_text;

}
