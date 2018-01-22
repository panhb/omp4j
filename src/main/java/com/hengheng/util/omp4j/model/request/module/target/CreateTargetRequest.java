package com.hengheng.util.omp4j.model.request.module.target;

import com.hengheng.util.omp4j.model.request.base.BaseRequest;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @author panhb
 */
@XStreamAlias("create_target")
@Data
public class CreateTargetRequest extends BaseRequest {

    private String name;
    private String comment;
    private String hosts;
    private String exclude_hosts;
    private String copy;

}


