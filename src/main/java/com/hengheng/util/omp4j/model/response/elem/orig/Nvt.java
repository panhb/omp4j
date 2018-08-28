package com.hengheng.util.omp4j.model.response.elem.orig;

import com.hengheng.util.omp4j.model.base.BaseModel;
import com.hengheng.util.omp4j.utils.RefUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author panhb
 */
@Slf4j
@Data
public class Nvt extends BaseModel {

    private String oid;
    private String type;
    private String name;
    private String family;
    private String cvss_base;
    private String cve;
    private String bid;
    private String xref;
    private String tags;
    private List<String> cert;

    public TagsInfo getTagsInfo() {
        return RefUtils.getTagsInfo(tags);
    }

}

