package com.hengheng.util.omp4j.model.request.target;

import com.hengheng.util.omp4j.model.base.BaseRequest;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import lombok.Data;

/**
 * @author panhb
 */
@XStreamAlias("modify_target")
@Data
public class ModifyTargetRequest extends BaseRequest {

    @XStreamAsAttribute
    private String target_id;
    private String comment;
    private String name;
    private String hosts;
    private String hosts_ordering;
    private String exclude_hosts;

}


