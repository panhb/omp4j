package com.hengheng.util.omp4j.utils;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import com.hengheng.util.omp4j.exceptions.OmpUtilsException;
import com.hengheng.util.omp4j.model.request.report.GetReportsRequest;
import com.hengheng.util.omp4j.model.response.elem.orig.Nvt;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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

    private static String model2Str(Object model, boolean doubleQuotationMarks) {
        StringBuilder sb = new StringBuilder();
        if(model != null){
            String simpleName = model.getClass().getSimpleName();
            String get = "Get", request = "Request";
            boolean b = simpleName.startsWith(get) && simpleName.endsWith(request);
            if (b) {
                String name = StrUtil.removeSuffix(simpleName,request);
                name = StrUtil.toUnderlineCase(name).toLowerCase();
                sb.append("<").append(name).append(" ");
            }
            Field[] fields = getFields(model.getClass());
            try {
                Arrays.stream(fields).forEach(field ->
                        transferField(model, doubleQuotationMarks, field, sb));
            }catch (Exception e){
                log.error(e.getMessage(), e);
            }
            if(b){
                sb.append("/>");
            }
        }
        return sb.toString();
    }

    @SneakyThrows
    private static void transferField(Object model, boolean doubleQuotationMarks,
                                      Field field, StringBuilder sb) {
        field.setAccessible(true);
        // 获取属性名
        String name = field.getName();
        // 获取属性类型
        String type = field.getGenericType().toString();
        String methodName = getMethodName(name);
        String sleepMillisecond = "sleepMillisecond",
                filter = "filter",
                strClass = "class java.lang.String",
                intClass = "class java.lang.Integer",
                longClass = "class java.lang.Long",
                boolClass = "class java.lang.Boolean";
        // 字段名已filter结尾的特殊处理
        if(name.endsWith(filter)){
            Method m = model.getClass().getMethod(methodName);
            Object object = m.invoke(model);
            if(object != null){
                sb.append(name).append("=\"").append(model2Str(object,false)).append("\" ");
            }
        } else if (strClass.equals(type)) {
            Method m = model.getClass().getMethod(methodName);
            String value = (String) m.invoke(model);
            if (value != null) {
                String sortReverse = "sortReverse";
                if(sortReverse.equals(name)){
                    name = "sort-reverse";
                }
                autoAppend(sb, doubleQuotationMarks, name, value);
            }
        } else if (intClass.equals(type)) {
            Method m = model.getClass().getMethod(methodName);
            Integer value = (Integer) m.invoke(model);
            if (value != null) {
                autoAppend(sb, doubleQuotationMarks, name, value.toString());
            }
        } else if (longClass.equals(type)) {
            Method m = model.getClass().getMethod(methodName);
            Long value = (Long) m.invoke(model);
            if (value != null) {
                autoAppend(sb, doubleQuotationMarks, name, value.toString());
            }
        } else if (boolClass.equals(type)) {
            Method m = model.getClass().getMethod(methodName);
            Boolean value = (Boolean) m.invoke(model);
            if (value != null) {
                autoAppend(sb, doubleQuotationMarks, name, value ? "1" : "0");
            }
        } else {
            if (!sleepMillisecond.equals(name)) {
                throw new OmpUtilsException("命令转换错误,不支持的类型:" + type + ",目前只支持:String,Integer,Long,Boolean");
            }
        }
    }

    private static void autoAppend(StringBuilder sb, boolean doubleQuotationMarks, String name, String value) {
        sb.append(name);
        if(doubleQuotationMarks){
            sb.append("=\"").append(value).append("\" ");
        }else{
            sb.append("=").append(value).append(" ");
        }
    }

    private static String getMethodName(String name) {
        return "get" + name.replaceFirst(name.substring(0, 1), name.substring(0, 1)
                .toUpperCase());
    }

    public static Nvt.TagsInfo getTagsInfo(String tags) {
        if (StrUtil.isBlank(tags)) {
            return null;
        }
        Nvt.TagsInfo tagsInfo = new Nvt.TagsInfo();
        List<String> tagList = StrUtil.split(tags, "|");
        try {
            tagList.forEach(tag -> {
                int location = tag.indexOf("=");
                if (location != -1) {
                    String name = tag.substring(0, location);
                    String value = tag.substring(location + 1);
                    invokeSet(tagsInfo, name, value);
                }
            });
        } catch (Exception e) {
            log.error("解析tags错误", e);
            return null;
        }
        return tagsInfo;
    }

    @SneakyThrows
    private static void invokeSet(Nvt.TagsInfo tagsInfo, String name, String value) {
        String methodName = setMethodName(name);
        Method m = tagsInfo.getClass().getDeclaredMethod(methodName, String.class);
        m.invoke(tagsInfo, value);
    }

    private static String setMethodName(String name) {
        return "set" + name.replaceFirst(name.substring(0, 1), name.substring(0, 1)
                .toUpperCase());
    }

    public static void main(String[] args) {
        GetReportsRequest.ReportFilter reportFilter = new GetReportsRequest.ReportFilter();
        reportFilter.setFirst(1);
        reportFilter.setRows(10);
        reportFilter.setTask_id("087bb973-6970-43d4-b29d-89e7d5b4285d");

        GetReportsRequest.ReportExtendFilter reportExtendFilter = new GetReportsRequest.ReportExtendFilter();
        reportExtendFilter.setHigh(0);
        reportExtendFilter.setTask_id("087bb973-6970-43d4-b29d-89e7d5b4285d");
        reportExtendFilter.setTask(true);

        GetReportsRequest reportsRequest = new GetReportsRequest();
        reportsRequest.setAlert_id("087bb973-6970-43d4-b29d-89e7d5b4285d");
        reportsRequest.setIgnore_pagination(true);
        reportsRequest.setFilter(reportFilter);
        reportsRequest.setReport_filter(reportExtendFilter);
        reportsRequest.setSleepMillisecond(1000L);

        log.info(model2Str(reportsRequest));

        String tags = "cvss_base_vector=AV:N/AC:H/Au:N/C:P/I:N/A:N|summary=The remote SSH server is configured to allow weak MD5 and/or 96-bit MAC algorithms.|solution=Disable the weak MAC algorithms.|solution_type=Mitigation|qod_type=remote_active";
        log.info(Objects.requireNonNull(getTagsInfo(tags)).toString());
    }
}
