package com.hengheng.util.omp4j.model.response.elem.comb;

import com.hengheng.util.omp4j.model.base.BaseModel;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class Progress extends BaseModel{

    private String text;
    private Host host_progress;

}
