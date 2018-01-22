package com.hengheng.util.omp4j.model.request.module.task;

import com.hengheng.util.omp4j.model.request.base.BaseRequest;
import com.hengheng.util.omp4j.model.request.common.CommonId;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @author panhb
 */
@XStreamAlias("create_task")
@Data
public class CreateTaskRequest extends BaseRequest {

    private String name;
    private String comment;
    private CommonId config;
    private CommonId target;
    private CommonId scanner;

}


