package com.hengheng.util.omp4j.model.request.task;

import com.hengheng.util.omp4j.model.base.BaseRequest;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import lombok.Data;

/**
 * @author panhb
 */
@XStreamAlias("start_task")
@Data
public class StartTaskRequest extends BaseRequest {

    @XStreamAsAttribute
    private String task_id;

}


