package com.hengheng.util.omp4j.service.impl;

import cn.hutool.core.util.StrUtil;
import com.hengheng.util.omp4j.model.ExecuteModel;
import com.hengheng.util.omp4j.service.ExecuteCmd;
import com.hengheng.util.omp4j.utils.CommandUtils;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

/**
 * @author panhb
 */
public class ExecuteCmdImpl implements ExecuteCmd {

    @SneakyThrows
    @Override
    public String executeCmd(ExecuteModel model, String ompCmd, @Deprecated long sleep) {
        List<String> list = new ArrayList<>();
        list.add("-u");
        list.add(model.getUsername());
        list.add("-w");
        list.add(model.getPassword());
        if(StrUtil.isNotBlank(model.getHost())){
            list.add("-h");
            list.add(model.getHost());
        }
        if(StrUtil.isNotBlank(model.getPort())){
            list.add("-p");
            list.add(model.getPort());
        }
        list.add("-iX");
        list.add(ompCmd);
        String[] arguments = list.toArray(new String[0]);
        return CommandUtils.execute("omp", arguments);
    }
}
