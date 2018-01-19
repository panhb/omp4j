package com.hengheng.util.omp4j.model.response.elem.comb;

import com.hengheng.util.omp4j.model.base.BaseModel;
import lombok.Data;

import java.util.List;

/**
 * @author panhb
 */
@Data
public class ReportErrors extends BaseModel{

    private String count;
    private List<ReportError> error;

}
