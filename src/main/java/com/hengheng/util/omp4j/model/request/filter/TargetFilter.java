package com.hengheng.util.omp4j.model.request.filter;

import com.hengheng.util.omp4j.model.request.filter.base.BaseFilter;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class TargetFilter extends BaseFilter {

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
