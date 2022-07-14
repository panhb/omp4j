package com.hengheng.util.omp4j.model.request.portlist;

import com.hengheng.util.omp4j.model.base.ListRequest;
import com.hengheng.util.omp4j.model.base.BaseFilter;
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

    @Data
    public static class PortListFilter extends BaseFilter {

        private String comment;
        private Integer total;
        private Integer tcp;
        private Integer udp;

    }
}

