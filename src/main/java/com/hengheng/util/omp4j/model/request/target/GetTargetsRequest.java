package com.hengheng.util.omp4j.model.request.target;

import com.hengheng.util.omp4j.model.base.ListRequest;
import com.hengheng.util.omp4j.model.base.BaseFilter;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class GetTargetsRequest extends ListRequest {

    private String target_id;
    private Boolean trash;
    private Boolean tasks;
    private TargetFilter filter;

    @Data
    public static class TargetFilter extends BaseFilter {

        private String comment;
        private String hosts;
        private Integer exclude_hosts;
        private String ips;
        private String port_list;
        private String ssh_credential;
        private String smb_credential;
        private String esxi_credential;
        private String snmp_credential;

    }
}

