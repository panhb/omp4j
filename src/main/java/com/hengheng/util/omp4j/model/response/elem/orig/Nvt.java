package com.hengheng.util.omp4j.model.response.elem.orig;

import com.hengheng.util.omp4j.model.base.BaseModel;
import com.hengheng.util.omp4j.utils.RefUtils;
import lombok.Data;

import java.util.List;

/**
 * @author panhb
 */
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

    @Data
    public static class TagsInfo extends BaseModel {

        private String cvss_base_vector;
        private String vuldetect;
        private String summary;
        private String solution;
        private String solution_type;
        private String qod_type;
        private String impact;
        private String insight;

    }
}

