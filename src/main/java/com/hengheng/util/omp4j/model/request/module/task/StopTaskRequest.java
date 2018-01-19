package com.hengheng.util.omp4j.model.request.module.task;

import com.hengheng.util.omp4j.model.request.base.BaseRequest;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import lombok.Data;

/**
 * @author panhb
 */
@XStreamAlias("stop_task")
@Data
public class StopTaskRequest extends BaseRequest {

    @XStreamAsAttribute
    private String task_id;

}


