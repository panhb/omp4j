package com.hengheng.util.omp4j.model.response.elem;

import com.alibaba.fastjson.JSON;
import com.hengheng.util.omp4j.model.response.elem.comb.Progress;
import com.hengheng.util.omp4j.model.response.elem.comb.TaskReport;
import com.hengheng.util.omp4j.model.response.elem.common.CommonResult;
import com.hengheng.util.omp4j.model.response.elem.orig.Info;
import com.hengheng.util.omp4j.model.response.elem.orig.Preference;
import com.hengheng.util.omp4j.model.response.elem.orig.ReportCount;
import com.xiaoleilu.hutool.util.StrUtil;
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

}

