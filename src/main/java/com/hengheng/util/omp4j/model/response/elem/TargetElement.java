package com.hengheng.util.omp4j.model.response.elem;

import com.hengheng.util.omp4j.model.response.elem.common.CommonResult;
import com.hengheng.util.omp4j.model.response.elem.orig.Credential;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class TargetElement extends CommonResult {

    private String hosts;
    private String exclude_hosts;
    private String max_hosts;
    private Credential port_list;
    private Credential ssh_credential;
    private Credential smb_credential;
    private Credential esxi_credential;
    private Credential snmp_credential;
    private String reverse_lookup_only;
    private String reverse_lookup_unify;
    private String alive_tests;

}
