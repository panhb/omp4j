package com.hengheng.util.omp4j.model.request.common;

import com.hengheng.util.omp4j.model.base.BaseModel;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class CommonId extends BaseModel {

    @XStreamAsAttribute
    private String id;

}
