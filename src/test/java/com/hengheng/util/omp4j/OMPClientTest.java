package com.hengheng.util.omp4j;

import com.alibaba.fastjson.JSON;
import com.hengheng.util.omp4j.enums.ExecuteTypeEnum;
import com.hengheng.util.omp4j.model.ExecuteModel;
import com.hengheng.util.omp4j.model.request.filter.*;
import com.hengheng.util.omp4j.model.request.filter.base.BaseFilter;
import com.hengheng.util.omp4j.model.request.module.config.GetConfigsRequest;
import com.hengheng.util.omp4j.model.request.module.portlist.GetPortListsRequest;
import com.hengheng.util.omp4j.model.request.module.report.GetReportFormatsRequest;
import com.hengheng.util.omp4j.model.request.module.report.GetReportsRequest;
import com.hengheng.util.omp4j.model.request.module.result.GetResultsRequest;
import com.hengheng.util.omp4j.model.request.module.scanner.GetScannersRequest;
import com.hengheng.util.omp4j.model.request.module.target.GetTargetsRequest;
import com.hengheng.util.omp4j.model.request.module.task.*;
import com.hengheng.util.omp4j.model.request.common.CommonId;
import com.hengheng.util.omp4j.model.response.module.config.GetConfigsResponse;
import com.hengheng.util.omp4j.model.response.module.protlist.GetPortListsResponse;
import com.hengheng.util.omp4j.model.response.module.report.GetReportFormatsResponse;
import com.hengheng.util.omp4j.model.response.module.report.GetReportsResponse;
import com.hengheng.util.omp4j.model.response.module.result.GetResultsResponse;
import com.hengheng.util.omp4j.model.response.module.scanner.GetScannersResponse;
import com.hengheng.util.omp4j.model.response.module.target.GetTargetsResponse;
import com.hengheng.util.omp4j.model.response.module.task.*;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

/**
 * @author panhb
 */
@Slf4j
public class OMPClientTest {

    private OMPClient ompClient;

    @SneakyThrows
    @Before
    public void initClient(){
        ExecuteModel model = new ExecuteModel(ExecuteTypeEnum.SSH,
                "admin", "admin");
        model.setSshHost("52.81.25.26");
        model.setSshPort(22);
        model.setSshUser("ubuntu");
        model.setSshPassphrase("a58e50b49cd8d90d");
        ompClient = new OMPClient(model);
    }

    @SneakyThrows
    @Test
    public void createTaskTest() {
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

    @SneakyThrows
    @Test
    public void modifyTaskTest() {
        ModifyTaskRequest modifyTaskRequest = new ModifyTaskRequest();
        modifyTaskRequest.setTask_id("a733c5ef-d4cb-4546-9fac-cfa18292dd3f");
        modifyTaskRequest.setComment("20180115test");
        ModifyTaskResponse modifyTaskResponse = ompClient.modifyTask(modifyTaskRequest);
        log.info(JSON.toJSONString(modifyTaskResponse));
    }

    @SneakyThrows
    @Test
    public void deleteTaskTest() {
        DeleteTaskRequest deleteTaskRequest = new DeleteTaskRequest();
        deleteTaskRequest.setTask_id("b5080c48-41be-4c69-abd9-61f912f7e7aa");
        DeleteTaskResponse deleteTaskResponse = ompClient.deleteTask(deleteTaskRequest);
        log.info(JSON.toJSONString(deleteTaskResponse));
    }

    @SneakyThrows
    @Test
    public void startTaskTest() {
        StartTaskRequest startTaskRequest = new StartTaskRequest();
        startTaskRequest.setTask_id("a733c5ef-d4cb-4546-9fac-cfa18292dd3f");
        ompClient.setSshSleepSpec(1000L);
        StartTaskResponse startTaskResponse = ompClient.startTask(startTaskRequest);
        log.info(JSON.toJSONString(startTaskResponse));
    }

    @SneakyThrows
    @Test
    public void stopTaskTest() {
        StopTaskRequest stopTaskRequest = new StopTaskRequest();
        stopTaskRequest.setTask_id("a733c5ef-d4cb-4546-9fac-cfa18292dd3f");
        StopTaskResponse stopTaskResponse = ompClient.stopTask(stopTaskRequest);
        log.info(JSON.toJSONString(stopTaskResponse));
    }

    @SneakyThrows
    @Test
    public void resumeTaskTest() {
        ResumeTaskRequest resumeTaskRequest = new ResumeTaskRequest();
        resumeTaskRequest.setTask_id("a733c5ef-d4cb-4546-9fac-cfa18292dd3f");
        ResumeTaskResponse resumeTaskResponse = ompClient.resumeTask(resumeTaskRequest);
        log.info(JSON.toJSONString(resumeTaskResponse));
    }

    @SneakyThrows
    @Test
    public void getTasksTest() {
        GetTasksRequest getTasksRequest = new GetTasksRequest();
        TaskFilter taskFilter = new TaskFilter();
        initBaseFilter(taskFilter);
        getTasksRequest.setFilter(taskFilter);

        GetTasksResponse getTasksResponse = ompClient.getTasks(getTasksRequest);
        log.info(JSON.toJSONString(getTasksResponse));
    }

    @SneakyThrows
    @Test
    public void getConfigsTest() {
        GetConfigsRequest getConfigsRequest = new GetConfigsRequest();
        ConfigFilter configFilter = new ConfigFilter();
        initBaseFilter(configFilter);
        getConfigsRequest.setFilter(configFilter);

        GetConfigsResponse getConfigsResponse = ompClient.getConfigs(getConfigsRequest);
        log.info(JSON.toJSONString(getConfigsResponse));
    }

    @SneakyThrows
    @Test
    public void getReportFormatsTest() {
        GetReportFormatsRequest getReportFormatsRequest = new GetReportFormatsRequest();
        ReportFormatFilter reportFormatFilter = new ReportFormatFilter();
        initBaseFilter(reportFormatFilter);
        getReportFormatsRequest.setFilter(reportFormatFilter);

        GetReportFormatsResponse getReportFormatsResponse = ompClient.getReportFormats(getReportFormatsRequest);
        log.info(JSON.toJSONString(getReportFormatsResponse));
    }

    @SneakyThrows
    @Test
    public void getResultsTest() {
        GetResultsRequest getResultsRequest = new GetResultsRequest();
        ResultFilter resultFilter = new ResultFilter();
        initBaseFilter(resultFilter);
        getResultsRequest.setFilter(resultFilter);

        GetResultsResponse getResultsResponse = ompClient.getResults(getResultsRequest);
        log.info(JSON.toJSONString(getResultsResponse));
    }

    @SneakyThrows
    @Test
    public void getScannersTest() {
        GetScannersRequest getScannersRequest = new GetScannersRequest();
        ScannerFilter scannerFilter = new ScannerFilter();
        initBaseFilter(scannerFilter);
        getScannersRequest.setFilter(scannerFilter);

        GetScannersResponse getScannersResponse = ompClient.getScanners(getScannersRequest);
        log.info(JSON.toJSONString(getScannersResponse));
    }

    @SneakyThrows
    @Test
    public void getTargetsTest() {
        GetTargetsRequest getTargetsRequest = new GetTargetsRequest();
        TargetFilter targetFilter = new TargetFilter();
        initBaseFilter(targetFilter);
        getTargetsRequest.setFilter(targetFilter);

        GetTargetsResponse getTargetsResponse = ompClient.getTargets(getTargetsRequest);
        log.info(JSON.toJSONString(getTargetsResponse));
    }

    @SneakyThrows
    @Test
    public void getReportsTest() {
        GetReportsRequest getReportsRequest = new GetReportsRequest();
        ReportExtendFilter reportExtendFilter = new ReportExtendFilter();
        initBaseFilter(reportExtendFilter);
        getReportsRequest.setReport_filter(reportExtendFilter);

        ompClient.setSshSleepSpec(2000L);
        GetReportsResponse getReportsResponse = ompClient.getReports(getReportsRequest);
        log.info(JSON.toJSONString(getReportsResponse));
    }

    @SneakyThrows
    @Test
    public void getPortListsTest() {
        GetPortListsResponse getPortListsResponse = ompClient.getPortLists(new GetPortListsRequest());
        log.info(JSON.toJSONString(getPortListsResponse));
    }

    private void initBaseFilter(BaseFilter baseFilter){
        baseFilter.setFirst(1);
        baseFilter.setRows(1);
    }

}
