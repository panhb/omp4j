package com.hengheng.util.omp4j.model.base;

import com.thoughtworks.xstream.annotations.XStreamOmitField;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class BaseRequest extends BaseModel {

    @XStreamOmitField
    private Long sleepMillisecond;

}
