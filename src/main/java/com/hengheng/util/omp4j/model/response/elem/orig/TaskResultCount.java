package com.hengheng.util.omp4j.model.response.elem.orig;

import com.hengheng.util.omp4j.model.base.BaseModel;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class TaskResultCount extends BaseModel{

    private String debug;
    private String hole;
    private String info;
    private String log;
    private String warning;
    private String false_positive;

}
