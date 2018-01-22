package com.hengheng.util.omp4j.model.response.module.protlist;

import com.hengheng.util.omp4j.model.response.base.ListResponse;
import com.hengheng.util.omp4j.model.response.elem.PortListElement;
import com.hengheng.util.omp4j.model.response.elem.orig.Filtered;
import com.hengheng.util.omp4j.model.response.elem.orig.MaxStart;
import lombok.Data;

import java.util.List;

/**
 * @author panhb
 */
@Data
public class GetPortListsResponse extends ListResponse {

    private List<PortListElement> port_list;
    private MaxStart port_lists;
    private Filtered port_list_count;

}

