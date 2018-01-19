package com.hengheng.util.omp4j.utils;

import com.hengheng.util.omp4j.model.request.filter.ReportExtendFilter;
import com.hengheng.util.omp4j.model.request.filter.ReportFilter;
import com.hengheng.util.omp4j.model.request.module.report.GetReportsRequest;
import com.xiaoleilu.hutool.log.Log;
import com.xiaoleilu.hutool.log.LogFactory;
import com.xiaoleilu.hutool.util.ArrayUtil;
import com.xiaoleilu.hutool.util.StrUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author panhb
 */
public class RefUtils {

    private final static Log log = LogFactory.get();

    private static Field[] getFields(Class<?> model){
        String type = "class java.lang.Object";
        if(type.equals(model.toString())){
            return model.getDeclaredFields();
        }else{
            return ArrayUtil.addAll(model.getDeclaredFields(),getFields(model.getSuperclass()));
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
            if(simpleName.startsWith(get) && simpleName.endsWith(request)){
                String name = StrUtil.removeSuffix(simpleName,request);
                name = StrUtil.toUnderlineCase(name).toLowerCase();
                sb.append("<").append(name).append(" ");
                fields = ArrayUtil.addAll(model.getClass().getDeclaredFields(),model.getClass().getSuperclass().getDeclaredFields());
            }else{
                fields = getFields(model.getClass());
            }
            try{
                for(Field field : fields) {
                    field.setAccessible(true);
                    String name = field.getName();
                    // 获取属性类型
                    String type = field.getGenericType().toString();
                    String getMethodName = "get" + name.replaceFirst(name.substring(0, 1), name.substring(0, 1)
                            .toUpperCase());
                    if(name.endsWith("filter")){
                        Method m = model.getClass().getMethod(getMethodName);
                        Object object = m.invoke(model);
                        if(object != null){
                            sb.append(name).append("=\"").append(model2Str(m.invoke(model),false)).append("\" ");
                        }
                    }
                    if (type.equals("class java.lang.String")) {
                        Method m = model.getClass().getMethod(getMethodName);
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
                        Method m = model.getClass().getMethod(getMethodName);
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
                        Method m = model.getClass().getMethod(getMethodName);
                        Boolean value = (Boolean) m.invoke(model);
                        if (value != null) {
                            sb.append(name);
                            if(doubleQuotationMarks){
                                sb.append("=\"").append(value?1:0).append("\" ");
                            }else{
                                sb.append("=").append(value?1:0).append(" ");
                            }
                        }
                    }
                }
            }catch (Exception e){
                log.error(e);
            }
            if(simpleName.startsWith(get) && simpleName.endsWith(request)){
                sb.append("/>");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReportFilter reportFilter = new ReportFilter();
        reportFilter.setFirst(1);
        reportFilter.setRows(10);
        reportFilter.setTask_id("087bb973-6970-43d4-b29d-89e7d5b4285d");

        ReportExtendFilter reportExtendFilter = new ReportExtendFilter();
        reportExtendFilter.setHigh(0);
        reportExtendFilter.setTask_id("087bb973-6970-43d4-b29d-89e7d5b4285d");
        reportExtendFilter.setTask(true);

        GetReportsRequest reportsRequest = new GetReportsRequest();
        reportsRequest.setAlert_id("087bb973-6970-43d4-b29d-89e7d5b4285d");
        reportsRequest.setIgnore_pagination(true);
        reportsRequest.setFilter(reportFilter);
        reportsRequest.setReport_filter(reportExtendFilter);

        log.info(model2Str(reportsRequest));
    }
}
