package com.hengheng.util.omp4j.utils;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.hengheng.util.omp4j.model.request.filter.ReportExtendFilter;
import com.hengheng.util.omp4j.model.request.filter.ReportFilter;
import com.hengheng.util.omp4j.model.request.module.report.GetReportsRequest;
import com.hengheng.util.omp4j.model.response.elem.orig.TagsInfo;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author panhb
 */
@Slf4j
public class RefUtils {

    private static Field[] getFields(Class<?> model){
        String type = "class java.lang.Object";
        if(type.equals(model.toString())){
            return model.getDeclaredFields();
        }else{
            return ArrayUtil.addAll(model.getDeclaredFields(), getFields(model.getSuperclass()));
        }
    }

    public static String model2Str(Object model) {
        return model2Str(model,true);

    }

    public static String model2Str(Object model,boolean doubleQuotationMarks) {
        StringBuilder sb = new StringBuilder();
        if(model != null){
            String simpleName = model.getClass().getSimpleName();
            String get = "Get",request = "Request";
            Field[] fields;
            if (simpleName.startsWith(get) && simpleName.endsWith(request)) {
                String name = StrUtil.removeSuffix(simpleName,request);
                name = StrUtil.toUnderlineCase(name).toLowerCase();
                sb.append("<").append(name).append(" ");
                fields = ArrayUtil.addAll(model.getClass().getDeclaredFields(),
                        model.getClass().getSuperclass().getDeclaredFields());
            } else {
                fields = getFields(model.getClass());
            }
            try {
                for (Field field : fields) {
                    sb = transferField(model, doubleQuotationMarks, field, sb);
                }
            }catch (Exception e){
                log.error(e.getMessage(), e);
            }
            if(simpleName.startsWith(get) && simpleName.endsWith(request)){
                sb.append("/>");
            }
        }
        return sb.toString();
    }

    private static StringBuilder transferField(Object model,boolean doubleQuotationMarks,
                                               Field field, StringBuilder sb) throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        field.setAccessible(true);
        String name = field.getName();
        // 获取属性类型
        String type = field.getGenericType().toString();
        String methodName = getMethodName(name);
        if(name.endsWith("filter")){
            Method m = model.getClass().getMethod(methodName);
            Object object = m.invoke(model);
            if(object != null){
                sb.append(name).append("=\"").append(model2Str(m.invoke(model),false)).append("\" ");
            }
        }
        if (type.equals("class java.lang.String")) {
            Method m = model.getClass().getMethod(methodName);
            String value = (String) m.invoke(model);
            if (value != null) {
                if("sortReverse".equals(name)){
                    sb.append("sort-reverse");
                }else{
                    sb.append(name);
                }
                if(doubleQuotationMarks){
                    sb.append("=\"").append(value).append("\" ");
                }else{
                    sb.append("=").append(value).append(" ");
                }
            }
        }
        if (type.equals("class java.lang.Integer")) {
            Method m = model.getClass().getMethod(methodName);
            Integer value = (Integer) m.invoke(model);
            if (value != null) {
                sb.append(name);
                if(doubleQuotationMarks){
                    sb.append("=\"").append(value).append("\" ");
                }else{
                    sb.append("=").append(value).append(" ");
                }
            }
        }
        if (type.equals("class java.lang.Boolean")) {
            Method m = model.getClass().getMethod(methodName);
            Boolean value = (Boolean) m.invoke(model);
            if (value != null) {
                sb.append(name);
                if(doubleQuotationMarks){
                    sb.append("=\"").append(value ? 1 : 0).append("\" ");
                }else{
                    sb.append("=").append(value ? 1 : 0).append(" ");
                }
            }
        }
        return sb;
    }

    private static String getMethodName(String name) {
        return "get" + name.replaceFirst(name.substring(0, 1), name.substring(0, 1)
                .toUpperCase());
    }

    public static TagsInfo getTagsInfo(String tags) {
        if (StrUtil.isNotBlank(tags)) {
            TagsInfo tagsInfo = new TagsInfo();
            String[] tagList = StrUtil.split(tags, "|");
            for (String tag : tagList) {
                int location = tag.indexOf("=");
                if (location != -1) {
                    String name = tag.substring(0,location);
                    String value = tag.substring(location+1);
                    try {
                        invokeSet(tagsInfo, name, value);
                    } catch (Exception e) {
                        log.error("解析tags错误", e);
                    }
                }
            }
            return tagsInfo;
        }
        return null;
    }

    @SneakyThrows
    private static void invokeSet(TagsInfo tagsInfo, String name, String value) {
        String methodName = setMethodName(name);
        Method m = tagsInfo.getClass().getDeclaredMethod(methodName, String.class);
        m.invoke(tagsInfo, value);
    }

    private static String setMethodName(String name) {
        return "set" + name.replaceFirst(name.substring(0, 1), name.substring(0, 1)
                .toUpperCase());
    }

    public static void main(String[] args) {
//        ReportFilter reportFilter = new ReportFilter();
//        reportFilter.setFirst(1);
//        reportFilter.setRows(10);
//        reportFilter.setTask_id("087bb973-6970-43d4-b29d-89e7d5b4285d");
//
//        ReportExtendFilter reportExtendFilter = new ReportExtendFilter();
//        reportExtendFilter.setHigh(0);
//        reportExtendFilter.setTask_id("087bb973-6970-43d4-b29d-89e7d5b4285d");
//        reportExtendFilter.setTask(true);
//
//        GetReportsRequest reportsRequest = new GetReportsRequest();
//        reportsRequest.setAlert_id("087bb973-6970-43d4-b29d-89e7d5b4285d");
//        reportsRequest.setIgnore_pagination(true);
//        reportsRequest.setFilter(reportFilter);
//        reportsRequest.setReport_filter(reportExtendFilter);
//
//        log.info(model2Str(reportsRequest));


        String tags = "cvss_base_vector=AV:N/AC:H/Au:N/C:P/I:N/A:N|summary=The remote SSH server is configured to allow weak MD5 and/or 96-bit MAC algorithms.|solution=Disable the weak MAC algorithms.|solution_type=Mitigation|qod_type=remote_active";
        log.info(JSON.toJSONString(getTagsInfo(tags)));
    }
}
