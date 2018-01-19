package com.hengheng.util.omp4j.model.response.module.task;

import com.hengheng.util.omp4j.model.response.base.ListResponse;
import com.hengheng.util.omp4j.model.response.elem.TaskElement;
import com.hengheng.util.omp4j.model.response.elem.orig.Filtered;
import com.hengheng.util.omp4j.model.response.elem.orig.MaxStart;
import lombok.Data;

import java.util.List;

/**
 * @author panhb
 */
@Data
public class GetTasksResponse extends ListResponse {

    private List<TaskElement> task;
    private MaxStart tasks;
    private Filtered task_count;
    private String apply_overrides;

}

