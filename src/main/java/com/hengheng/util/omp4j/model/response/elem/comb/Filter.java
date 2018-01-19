package com.hengheng.util.omp4j.model.response.elem.comb;

import com.hengheng.util.omp4j.model.base.BaseModel;
import com.hengheng.util.omp4j.model.response.elem.orig.Keyword;
import lombok.Data;

import java.util.List;

/**
 * @author panhb
 */
@Data
public class Filter extends BaseModel {

    private String id;
    private String term;
    private List<Keyword> keywords;

}

