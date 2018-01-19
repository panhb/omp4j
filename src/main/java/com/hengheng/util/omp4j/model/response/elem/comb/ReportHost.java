package com.hengheng.util.omp4j.model.response.elem.comb;

import com.hengheng.util.omp4j.model.base.BaseModel;
import com.hengheng.util.omp4j.model.response.elem.orig.Asset;
import com.hengheng.util.omp4j.model.response.elem.orig.Page;
import lombok.Data;

import java.util.List;

/**
 * @author panhb
 */
@Data
public class ReportHost extends BaseModel{

    private String ip;
    private String start;
    private String end;
    private Asset asset;
    private Page port_count;
    private ReportHostResultCount result_count;
    private List<ReportDetail> detail;

}
