package com.hengheng.util.omp4j.model.response.elem;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.hengheng.util.omp4j.model.base.BaseModel;
import com.hengheng.util.omp4j.model.response.elem.comb.Host;
import com.hengheng.util.omp4j.model.response.elem.common.CommonResult;
import com.hengheng.util.omp4j.model.response.elem.orig.Preference;
import lombok.Data;

import java.util.List;

/**
 * @author panhb
 */
@Data
public class TaskElement extends CommonResult {

    private String alterable;
    private Info config;
    private Info target;
    private String hosts_ordering;
    private Info scanner;
    /**
     * Delete Requested|Done|New|Requested|Running|Stop Requested|Stopped|Internal Error
     */
    private String status;
    private String progress;
    private ReportCount report_count;
    private String trend;
    private Info schedule;
    private String schedule_periods;
    private TaskReport first_report;
    private TaskReport last_report;
    private String observers;
    private String result_count;
    private List<Preference> preferences;

    public Progress getProgress_parse() {
        if(StrUtil.isNotBlank(progress) && progress.contains("host_progress")){
            return JSON.parseObject(progress,Progress.class);
        }
        return null;
    }

    @Data
    public static class Info extends BaseModel {

        private String id;
        private String name;
        private String type;
        private String trash;
        private String next_time;

    }

    @Data
    public static class ReportCount extends BaseModel{

        private String text;
        private String finished;

    }

    @Data
    public static class Progress extends BaseModel{

        private String text;
        private Host host_progress;

    }

    @Data
    public static class TaskReport extends BaseModel {

        private TaskReportInfo report;

        @Data
        public static class TaskReportInfo extends BaseModel {

            private String id;
            private String timestamp;
            private String scan_start;
            private String scan_end;
            private String severity;
            private TaskResultCount result_count;

            @Data
            public static class TaskResultCount extends BaseModel{

                private String debug;
                private String hole;
                private String info;
                private String log;
                private String warning;
                private String false_positive;

            }
        }
    }
}

