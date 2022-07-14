package com.hengheng.util.omp4j.model.request.task;

import com.hengheng.util.omp4j.model.base.ListRequest;
import com.hengheng.util.omp4j.model.base.BaseFilter;
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

    @Data
    public static class TaskFilter extends BaseFilter {

        private String status;
        private Integer total;
        private String first_report;
        private String last_report;
        private String threat;
        private String trend;
        private String severity;
        private String schedule;
        private String next_due;
        private String last;
        private Integer false_positive;
        private Integer log;
        private Integer low;
        private Integer medium;
        private Integer high;
        private Integer hosts;
        private Integer result_hosts;
        private Integer fp_per_host;
        private Integer log_per_host;
        private Integer low_per_host;
        private Integer medium_per_host;
        private Integer high_per_host;
        private String target;

    }
}

