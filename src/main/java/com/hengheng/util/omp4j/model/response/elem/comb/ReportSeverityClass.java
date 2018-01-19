package com.hengheng.util.omp4j.model.response.elem.comb;

import com.hengheng.util.omp4j.model.base.BaseModel;
import com.hengheng.util.omp4j.model.response.elem.orig.SeverityRange;
import lombok.Data;

import java.util.List;

/**
 * @author panhb
 */
@Data
public class ReportSeverityClass extends BaseModel{

    private String id;
    private String name;
    private String full_name;
    private List<SeverityRange> severity_range;

}
