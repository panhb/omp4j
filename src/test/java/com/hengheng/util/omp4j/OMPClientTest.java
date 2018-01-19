package com.hengheng.util.omp4j;

import com.alibaba.fastjson.JSON;
import com.hengheng.util.omp4j.model.ExcuteModel;
import com.hengheng.util.omp4j.model.request.filter.*;
import com.hengheng.util.omp4j.model.request.filter.base.BaseFilter;
import com.hengheng.util.omp4j.model.request.module.config.GetConfigsRequest;
import com.hengheng.util.omp4j.model.request.module.report.GetReportFormatsRequest;
import com.hengheng.util.omp4j.model.request.module.report.GetReportsRequest;
import com.hengheng.util.omp4j.model.request.module.result.GetResultsRequest;
import com.hengheng.util.omp4j.model.request.module.scanner.GetScannersRequest;
import com.hengheng.util.omp4j.model.request.module.target.GetTargetsRequest;
import com.hengheng.util.omp4j.model.request.module.task.*;
import com.hengheng.util.omp4j.model.request.module.task.common.CommonId;
import com.hengheng.util.omp4j.model.response.module.config.GetConfigsResponse;
import com.hengheng.util.omp4j.model.response.module.report.GetReportFormatsResponse;
import com.hengheng.util.omp4j.model.response.module.report.GetReportsResponse;
import com.hengheng.util.omp4j.model.response.module.result.GetResultsResponse;
import com.hengheng.util.omp4j.model.response.module.scanner.GetScannersResponse;
import com.hengheng.util.omp4j.model.response.module.target.GetTargetsResponse;
import com.hengheng.util.omp4j.model.response.module.task.*;
import com.xiaoleilu.hutool.log.Log;
import com.xiaoleilu.hutool.log.LogFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

/**
 * @author panhb
 */
public class OMPClientTest {

    private final static Log log = LogFactory.get();

    OMPClient ompClient;

    @Before
    public void initClient(){
        ExcuteModel excuteModel = new ExcuteModel();
        excuteModel.setUsername("admin");
        excuteModel.setPassword("admin");

        ompClient = new OMPClient(excuteModel,OMPClient.CMD);
    }

    @Test
    public void createTaskTest() throws Exception {
        CreateTaskRequest createTaskRequest = new CreateTaskRequest();
        CommonId target = new CommonId();
        CommonId config = new CommonId();
        CommonId scanner = new CommonId();
        target.setId("7e7f3397-2d77-4122-9104-32d19976ed0e");
        config.setId("daba56c8-73ec-11df-a475-002264764cea");
        scanner.setId("08b69003-5fc2-4037-a479-93b440211c73");
        createTaskRequest.setConfig(config);
        createTaskRequest.setScanner(scanner);
        createTaskRequest.setTarget(target);
        createTaskRequest.setName("panhbtest_"+ UUID.randomUUID());
        CreateTaskResponse createTaskResponse = ompClient.createTask(createTaskRequest);
        log.info(JSON.toJSONString(createTaskResponse));
    }

    @Test
    public void modifyTaskTest() throws Exception{
        ModifyTaskRequest modifyTaskRequest = new ModifyTaskRequest();
        modifyTaskRequest.setTask_id("a733c5ef-d4cb-4546-9fac-cfa18292dd3f");
        modifyTaskRequest.setComment("20180115test");
        ModifyTaskResponse modifyTaskResponse = ompClient.modifyTask(modifyTaskRequest);
        log.info(JSON.toJSONString(modifyTaskResponse));
    }

    @Test
    public void deleteTaskTest() throws Exception{
        DeleteTaskRequest deleteTaskRequest = new DeleteTaskRequest();
        deleteTaskRequest.setTask_id("b5080c48-41be-4c69-abd9-61f912f7e7aa");
        DeleteTaskResponse deleteTaskResponse = ompClient.deleteTask(deleteTaskRequest);
        log.info(JSON.toJSONString(deleteTaskResponse));
    }

    @Test
    public void startTaskTest() throws Exception{
        StartTaskRequest startTaskRequest = new StartTaskRequest();
        startTaskRequest.setTask_id("a733c5ef-d4cb-4546-9fac-cfa18292dd3f");
        ompClient.getExcuteModel().setSshSleepSpec(1000L);
        StartTaskResponse startTaskResponse = ompClient.startTask(startTaskRequest);
        log.info(JSON.toJSONString(startTaskResponse));
    }

    @Test
    public void stopTaskTest() throws Exception{
        StopTaskRequest stopTaskRequest = new StopTaskRequest();
        stopTaskRequest.setTask_id("a733c5ef-d4cb-4546-9fac-cfa18292dd3f");
        StopTaskResponse stopTaskResponse = ompClient.stopTask(stopTaskRequest);
        log.info(JSON.toJSONString(stopTaskResponse));
    }

    @Test
    public void resumeTaskTest() throws Exception{
        ResumeTaskRequest resumeTaskRequest = new ResumeTaskRequest();
        resumeTaskRequest.setTask_id("a733c5ef-d4cb-4546-9fac-cfa18292dd3f");
        ResumeTaskResponse resumeTaskResponse = ompClient.resumeTask(resumeTaskRequest);
        log.info(JSON.toJSONString(resumeTaskResponse));
    }

    @Test
    public void getTasksTest() throws Exception{
        GetTasksRequest getTasksRequest = new GetTasksRequest();
        TaskFilter taskFilter = new TaskFilter();
        initBaseFilter(taskFilter);
        getTasksRequest.setFilter(taskFilter);

        GetTasksResponse getTasksResponse = ompClient.getTasks(getTasksRequest);
        log.info(JSON.toJSONString(getTasksResponse));
    }

    @Test
    public void getConfigsTest() throws Exception{
        GetConfigsRequest getConfigsRequest = new GetConfigsRequest();
        ConfigFilter configFilter = new ConfigFilter();
        initBaseFilter(configFilter);
        getConfigsRequest.setFilter(configFilter);

        GetConfigsResponse getConfigsResponse = ompClient.getConfigs(getConfigsRequest);
        log.info(JSON.toJSONString(getConfigsResponse));
    }

    @Test
    public void getReportFormatsTest() throws Exception{
        GetReportFormatsRequest getReportFormatsRequest = new GetReportFormatsRequest();
        ReportFormatFilter reportFormatFilter = new ReportFormatFilter();
        initBaseFilter(reportFormatFilter);
        getReportFormatsRequest.setFilter(reportFormatFilter);

        GetReportFormatsResponse getReportFormatsResponse = ompClient.getReportFormats(getReportFormatsRequest);
        log.info(JSON.toJSONString(getReportFormatsResponse));
    }

    @Test
    public void getResultsTest() throws Exception{
        GetResultsRequest getResultsRequest = new GetResultsRequest();
        ResultFilter resultFilter = new ResultFilter();
        initBaseFilter(resultFilter);
        getResultsRequest.setFilter(resultFilter);

        GetResultsResponse getResultsResponse = ompClient.getResults(getResultsRequest);
        log.info(JSON.toJSONString(getResultsResponse));
    }

    @Test
    public void getScannersTest() throws Exception{
        GetScannersRequest getScannersRequest = new GetScannersRequest();
        ScannerFilter scannerFilter = new ScannerFilter();
        initBaseFilter(scannerFilter);
        getScannersRequest.setFilter(scannerFilter);

        GetScannersResponse getScannersResponse = ompClient.getScanners(getScannersRequest);
        log.info(JSON.toJSONString(getScannersResponse));
    }

    @Test
    public void getTargetsTest() throws Exception{
        GetTargetsRequest getTargetsRequest = new GetTargetsRequest();
        TargetFilter targetFilter = new TargetFilter();
        initBaseFilter(targetFilter);
        getTargetsRequest.setFilter(targetFilter);

        GetTargetsResponse getTargetsResponse = ompClient.getTargets(getTargetsRequest);
        log.info(JSON.toJSONString(getTargetsResponse));
    }

    @Test
    public void getReportsTest() throws Exception{
        GetReportsRequest getReportsRequest = new GetReportsRequest();
        ReportExtendFilter reportExtendFilter = new ReportExtendFilter();
        initBaseFilter(reportExtendFilter);
        getReportsRequest.setReport_filter(reportExtendFilter);

        ompClient.getExcuteModel().setSshSleepSpec(2000L);
        GetReportsResponse getReportsResponse = ompClient.getReports(getReportsRequest);
        log.info(JSON.toJSONString(getReportsResponse));
    }

    private void initBaseFilter(BaseFilter baseFilter){
        baseFilter.setFirst(1);
        baseFilter.setRows(1);
    }

}
