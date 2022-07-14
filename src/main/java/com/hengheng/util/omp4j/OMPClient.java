package com.hengheng.util.omp4j;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.hengheng.util.omp4j.enums.ExecuteTypeEnum;
import com.hengheng.util.omp4j.exceptions.OmpUtilsException;
import com.hengheng.util.omp4j.model.ExecuteModel;
import com.hengheng.util.omp4j.model.base.BaseRequest;
import com.hengheng.util.omp4j.model.request.config.GetConfigsRequest;
import com.hengheng.util.omp4j.model.request.portlist.GetPortListsRequest;
import com.hengheng.util.omp4j.model.request.report.GetReportFormatsRequest;
import com.hengheng.util.omp4j.model.request.report.GetReportsRequest;
import com.hengheng.util.omp4j.model.request.result.GetResultsRequest;
import com.hengheng.util.omp4j.model.request.scanner.GetScannersRequest;
import com.hengheng.util.omp4j.model.request.target.CreateTargetRequest;
import com.hengheng.util.omp4j.model.request.target.DeleteTargetRequest;
import com.hengheng.util.omp4j.model.request.target.GetTargetsRequest;
import com.hengheng.util.omp4j.model.request.target.ModifyTargetRequest;
import com.hengheng.util.omp4j.model.request.task.CreateTaskRequest;
import com.hengheng.util.omp4j.model.request.task.DeleteTaskRequest;
import com.hengheng.util.omp4j.model.request.task.GetTasksRequest;
import com.hengheng.util.omp4j.model.request.task.ModifyTaskRequest;
import com.hengheng.util.omp4j.model.request.task.ResumeTaskRequest;
import com.hengheng.util.omp4j.model.request.task.StartTaskRequest;
import com.hengheng.util.omp4j.model.request.task.StopTaskRequest;
import com.hengheng.util.omp4j.model.base.BaseResponse;
import com.hengheng.util.omp4j.model.response.module.config.GetConfigsResponse;
import com.hengheng.util.omp4j.model.response.module.protlist.GetPortListsResponse;
import com.hengheng.util.omp4j.model.response.module.report.GetReportFormatsResponse;
import com.hengheng.util.omp4j.model.response.module.report.GetReportsResponse;
import com.hengheng.util.omp4j.model.response.module.result.GetResultsResponse;
import com.hengheng.util.omp4j.model.response.module.scanner.GetScannersResponse;
import com.hengheng.util.omp4j.model.response.module.target.CreateTargetResponse;
import com.hengheng.util.omp4j.model.response.module.target.DeleteTargetResponse;
import com.hengheng.util.omp4j.model.response.module.target.GetTargetsResponse;
import com.hengheng.util.omp4j.model.response.module.target.ModifyTargetResponse;
import com.hengheng.util.omp4j.model.response.module.task.*;
import com.hengheng.util.omp4j.service.ExecuteCmd;
import com.hengheng.util.omp4j.service.ExecuteCmdFactory;
import com.hengheng.util.omp4j.service.IExecuteFactory;
import com.hengheng.util.omp4j.service.SshExecuteCmdFactory;
import com.hengheng.util.omp4j.utils.RefUtils;
import com.hengheng.util.omp4j.utils.XmlUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author panhb
 */
@Slf4j
public class OMPClient {

    /**
     * 执行命令参数
     */
    private final ExecuteModel model;

    /**
     * 执行命令实例
     */
    private final ExecuteCmd cmd;

    /**
     * SSH模式下线程睡眠时间
     */
    private static long sleep = 500L;

    public OMPClient(ExecuteModel model) {
        this(model, sleep);
    }

    @SneakyThrows
    public OMPClient(ExecuteModel model, long sleepMillisecond) {
        this.model = model;
        IExecuteFactory executeFactory;
        if (ExecuteTypeEnum.SSH.equals(model.getType())) {
            executeFactory = new SshExecuteCmdFactory();
        } else if (ExecuteTypeEnum.CMD.equals(model.getType())) {
            executeFactory = new ExecuteCmdFactory();
        } else {
            throw new OmpUtilsException("错误的执行类型");
        }
        this.cmd = executeFactory.getExecuteCmd();
        sleep = sleepMillisecond;
    }

    @SneakyThrows
    public CreateTaskResponse createTask(CreateTaskRequest createTaskRequest) {
        return execute(createTaskRequest, CreateTaskResponse.class);
    }

    @SneakyThrows
    public CreateTargetResponse createTarget(CreateTargetRequest createTargetRequest) {
        return execute(createTargetRequest, CreateTargetResponse.class);
    }

    @SneakyThrows
    public ModifyTaskResponse modifyTask(ModifyTaskRequest modifyTaskRequest) {
        return execute(modifyTaskRequest, ModifyTaskResponse.class);
    }

    @SneakyThrows
    public ModifyTargetResponse modifyTarget(ModifyTargetRequest modifyTargetRequest) {
        return execute(modifyTargetRequest, ModifyTargetResponse.class);
    }

    @SneakyThrows
    public DeleteTaskResponse deleteTask(DeleteTaskRequest deleteTaskRequest) {
        return execute(deleteTaskRequest, DeleteTaskResponse.class);
    }

    @SneakyThrows
    public DeleteTargetResponse deleteTarget(DeleteTargetRequest deleteTargetRequest) {
        return execute(deleteTargetRequest, DeleteTargetResponse.class);
    }

    @SneakyThrows
    public StartTaskResponse startTask(StartTaskRequest startTaskRequest) {
        return execute(startTaskRequest, StartTaskResponse.class);
    }

    @SneakyThrows
    public StopTaskResponse stopTask(StopTaskRequest stopTaskRequest) {
        return execute(stopTaskRequest, StopTaskResponse.class);
    }

    @SneakyThrows
    public ResumeTaskResponse resumeTask(ResumeTaskRequest resumeTaskRequest) {
        return execute(resumeTaskRequest, ResumeTaskResponse.class);
    }

    @SneakyThrows
    public GetTasksResponse getTasks(GetTasksRequest getTasksRequest) {
        return execute(getTasksRequest,true, GetTasksResponse.class);
    }

    @SneakyThrows
    public GetConfigsResponse getConfigs(GetConfigsRequest getConfigsRequest) {
        return execute(getConfigsRequest,true, GetConfigsResponse.class);
    }

    @SneakyThrows
    public GetReportFormatsResponse getReportFormats(GetReportFormatsRequest getReportFormatsRequest) {
        return execute(getReportFormatsRequest,true, GetReportFormatsResponse.class);
    }

    @SneakyThrows
    public GetResultsResponse getResults(GetResultsRequest getResultsRequest) {
        return execute(getResultsRequest,true, GetResultsResponse.class);
    }

    @SneakyThrows
    public GetScannersResponse getScanners(GetScannersRequest getScannersRequest) {
        return execute(getScannersRequest,true, GetScannersResponse.class);
    }

    @SneakyThrows
    public GetTargetsResponse getTargets(GetTargetsRequest getTargetsRequest) {
        return execute(getTargetsRequest,true, GetTargetsResponse.class);
    }

    @SneakyThrows
    public GetReportsResponse getReports(GetReportsRequest getReportsRequest) {
        return execute(getReportsRequest,true, GetReportsResponse.class);
    }

    @SneakyThrows
    public GetPortListsResponse getPortLists(GetPortListsRequest getPortListsRequest) {
        return execute(getPortListsRequest,true, GetPortListsResponse.class);
    }

    @SneakyThrows
    private <T extends BaseResponse> T execute(BaseRequest baseRequest, Class<T> tClass) {
        return execute(baseRequest,false, tClass);
    }

    @SneakyThrows
    private <T extends BaseResponse> T execute(BaseRequest baseRequest, Boolean filter, Class<T> tClass) {
        String command;
        if(filter){
            command = RefUtils.model2Str(baseRequest);
        }else{
            command = XmlUtils.obj2Xml(baseRequest);
        }
        String xml = this.cmd.executeCmd(model, command,
                baseRequest.getSleepMillisecond() != null ? baseRequest.getSleepMillisecond() : sleep);
        if (StrUtil.isNotBlank(xml)) {
            String json = XmlUtils.xml2Json(xml);
            return JSON.parseObject(json, tClass);
        }
        return null;
    }

}
