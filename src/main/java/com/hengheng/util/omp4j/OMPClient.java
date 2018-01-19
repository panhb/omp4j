package com.hengheng.util.omp4j;

import com.alibaba.fastjson.JSON;
import com.hengheng.util.omp4j.exceptions.OmpUtilsException;
import com.hengheng.util.omp4j.model.ExcuteModel;
import com.hengheng.util.omp4j.model.request.base.BaseRequest;
import com.hengheng.util.omp4j.model.request.module.config.GetConfigsRequest;
import com.hengheng.util.omp4j.model.request.module.report.GetReportFormatsRequest;
import com.hengheng.util.omp4j.model.request.module.report.GetReportsRequest;
import com.hengheng.util.omp4j.model.request.module.result.GetResultsRequest;
import com.hengheng.util.omp4j.model.request.module.scanner.GetScannersRequest;
import com.hengheng.util.omp4j.model.request.module.target.GetTargetsRequest;
import com.hengheng.util.omp4j.model.request.module.task.*;
import com.hengheng.util.omp4j.model.response.module.config.GetConfigsResponse;
import com.hengheng.util.omp4j.model.response.module.report.GetReportFormatsResponse;
import com.hengheng.util.omp4j.model.response.module.report.GetReportsResponse;
import com.hengheng.util.omp4j.model.response.module.result.GetResultsResponse;
import com.hengheng.util.omp4j.model.response.module.scanner.GetScannersResponse;
import com.hengheng.util.omp4j.model.response.module.target.GetTargetsResponse;
import com.hengheng.util.omp4j.model.response.module.task.*;
import com.hengheng.util.omp4j.service.ExcuteCmd;
import com.hengheng.util.omp4j.service.ExcuteCmdFactory;
import com.hengheng.util.omp4j.utils.CommandUtils;
import com.hengheng.util.omp4j.utils.RefUtils;
import com.hengheng.util.omp4j.utils.XmlUtils;
import com.xiaoleilu.hutool.log.Log;
import com.xiaoleilu.hutool.log.LogFactory;
import com.xiaoleilu.hutool.util.StrUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author panhb
 */
public class OMPClient {

    private final static Log log = LogFactory.get();

    public final static String SSH = "ssh";
    public final static String CMD = "cmd";

    private ExcuteModel excuteModel;
    private ExcuteCmd excuteCmd;

    public ExcuteModel getExcuteModel() {
        return excuteModel;
    }

    public OMPClient(ExcuteModel excuteModel, String type) {
        this.excuteModel = excuteModel;
        this.excuteCmd = ExcuteCmdFactory.getInstance(type);
    }

    public CreateTaskResponse createTask(CreateTaskRequest createTaskRequest) throws OmpUtilsException {
        return excute(createTaskRequest,CreateTaskResponse.class);
    }

    public ModifyTaskResponse modifyTask(ModifyTaskRequest modifyTaskRequest) throws OmpUtilsException {
        return excute(modifyTaskRequest,ModifyTaskResponse.class);
    }

    public DeleteTaskResponse deleteTask(DeleteTaskRequest deleteTaskRequest) throws OmpUtilsException {
        return excute(deleteTaskRequest,DeleteTaskResponse.class);
    }

    public StartTaskResponse startTask(StartTaskRequest startTaskRequest) throws OmpUtilsException {
        return excute(startTaskRequest,StartTaskResponse.class);
    }

    public StopTaskResponse stopTask(StopTaskRequest stopTaskRequest) throws OmpUtilsException {
        return excute(stopTaskRequest,StopTaskResponse.class);
    }

    public ResumeTaskResponse resumeTask(ResumeTaskRequest resumeTaskRequest) throws OmpUtilsException {
        return excute(resumeTaskRequest,ResumeTaskResponse.class);
    }

    public GetTasksResponse getTasks(GetTasksRequest getTasksRequest) throws OmpUtilsException {
        return excute(getTasksRequest,true,GetTasksResponse.class);
    }

    public GetConfigsResponse getConfigs(GetConfigsRequest getConfigsRequest) throws OmpUtilsException {
        return excute(getConfigsRequest,true,GetConfigsResponse.class);
    }

    public GetReportFormatsResponse getReportFormats(GetReportFormatsRequest getReportFormatsRequest) throws OmpUtilsException {
        return excute(getReportFormatsRequest,true,GetReportFormatsResponse.class);
    }

    public GetResultsResponse getResults(GetResultsRequest getResultsRequest) throws OmpUtilsException {
        return excute(getResultsRequest,true,GetResultsResponse.class);
    }

    public GetScannersResponse getScanners(GetScannersRequest getScannersRequest) throws OmpUtilsException {
        return excute(getScannersRequest,true,GetScannersResponse.class);
    }

    public GetTargetsResponse getTargets(GetTargetsRequest getTargetsRequest) throws OmpUtilsException {
        return excute(getTargetsRequest,true,GetTargetsResponse.class);
    }

    public GetReportsResponse getReports(GetReportsRequest getReportsRequest) throws OmpUtilsException {
        return excute(getReportsRequest,true,GetReportsResponse.class);
    }

    private <T> T excute(BaseRequest baseRequest,Class<T> tClass) throws OmpUtilsException {
        return excute(baseRequest,false,tClass);
    }

    private <T> T excute(BaseRequest baseRequest,Boolean filter,Class<T> tClass) throws OmpUtilsException {
        String cmd;
        if(filter){
            cmd = RefUtils.model2Str(baseRequest);
        }else{
            cmd = XmlUtils.obj2Xml(baseRequest);
        }
        excuteModel.setXmlCmd(cmd);
        String xml = excuteCmd.excuteCmd(excuteModel);
        excuteModel.setSshSleepSpec(null);
        String json = XmlUtils.xml2JSON(xml);
        return JSON.parseObject(json,tClass);
    }

}
