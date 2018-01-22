package com.hengheng.util.omp4j.model.request.module.portlist;


import com.hengheng.util.omp4j.model.request.base.ListRequest;
import com.hengheng.util.omp4j.model.request.filter.PortListFilter;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class GetPortListsRequest extends ListRequest {

    private String port_list_id;
    private Boolean trash;
    private Boolean details;
    private Boolean targets;
    private PortListFilter filter;

}

