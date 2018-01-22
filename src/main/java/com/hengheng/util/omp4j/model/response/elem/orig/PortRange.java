package com.hengheng.util.omp4j.model.response.elem.orig;

import com.hengheng.util.omp4j.model.base.BaseModel;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class PortRange extends BaseModel {

    private String id;
    private String start;
    private String end;
    private String type;
    private String comment;

}
