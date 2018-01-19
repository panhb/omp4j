package com.hengheng.util.omp4j.model.response.elem.comb;

import com.hengheng.util.omp4j.model.base.BaseModel;
import com.hengheng.util.omp4j.model.response.elem.orig.Tag;
import lombok.Data;

import java.util.List;

/**
 * @author panhb
 */
@Data
public class UserTags extends BaseModel {

    private String count;
    private List<Tag> tag;

}