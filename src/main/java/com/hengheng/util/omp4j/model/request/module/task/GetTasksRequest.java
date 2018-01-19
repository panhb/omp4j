package com.hengheng.util.omp4j.model.request.module.task;

import com.hengheng.util.omp4j.model.request.base.ListRequest;
import com.hengheng.util.omp4j.model.request.filter.TaskFilter;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class GetTasksRequest extends ListRequest {

    private String task_id;
    private Boolean trash;
    private Boolean details;
    private Boolean ignore_pagination;
    private Boolean schedules_only;
    private TaskFilter filter;

}

