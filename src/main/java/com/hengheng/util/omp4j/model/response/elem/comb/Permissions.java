package com.hengheng.util.omp4j.model.response.elem.comb;

import com.hengheng.util.omp4j.model.base.BaseModel;
import com.hengheng.util.omp4j.model.response.elem.orig.Name;
import lombok.Data;

import java.util.List;

/**
 * @author panhb
 */
@Data
public class Permissions extends BaseModel {

    private List<Name> permission;

}