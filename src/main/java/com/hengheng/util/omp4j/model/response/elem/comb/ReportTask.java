package com.hengheng.util.omp4j.model.response.elem.comb;

import com.hengheng.util.omp4j.model.base.BaseModel;
import com.hengheng.util.omp4j.model.response.elem.orig.Preference;
import com.hengheng.util.omp4j.model.response.elem.orig.Slave;
import lombok.Data;

import java.util.List;

/**
 * @author panhb
 */
@Data
public class ReportTask extends BaseModel{

    private Slave slave;
    private List<Preference> preferences;
}
