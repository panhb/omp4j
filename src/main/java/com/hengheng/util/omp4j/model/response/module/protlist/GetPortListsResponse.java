package com.hengheng.util.omp4j.model.response.module.protlist;

import com.hengheng.util.omp4j.model.base.BaseModel;
import com.hengheng.util.omp4j.model.base.ListResponse;
import com.hengheng.util.omp4j.model.response.elem.TargetElement;
import com.hengheng.util.omp4j.model.response.elem.common.CommonResult;
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

    @Data
    public static class PortListElement extends CommonResult {

        private PortCount port_count;
        private List<PortRange> port_ranges;
        private List<TargetElement> targets;

        @Data
        public static class PortCount extends BaseModel {

            private String all;
            private String tcp;
            private String udp;

        }

        @Data
        public static class PortRange extends BaseModel {

            private String id;
            private String start;
            private String end;
            private String type;
            private String comment;

        }
    }
}

