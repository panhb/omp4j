package com.hengheng.util.omp4j.service.impl;

import com.hengheng.util.omp4j.exceptions.OmpUtilsException;
import com.hengheng.util.omp4j.model.ExcuteModel;
import com.hengheng.util.omp4j.service.ExcuteCmd;
import com.hengheng.util.omp4j.utils.CommandUtils;
import com.xiaoleilu.hutool.util.StrUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author panhb
 */
public class ExcuteCmdImpl implements ExcuteCmd{

    @Override
    public String excuteCmd(ExcuteModel excuteModel) throws OmpUtilsException {
        List<String> list = new ArrayList<>();
        list.add("-u");
        list.add(excuteModel.getUsername());
        list.add("-w");
        list.add(excuteModel.getPassword());
        if(StrUtil.isNotBlank(excuteModel.getHost())){
            list.add("-h");
            list.add(excuteModel.getHost());
        }
        if(StrUtil.isNotBlank(excuteModel.getPort())){
            list.add("-p");
            list.add(excuteModel.getPort());
        }
        list.add("-iX");
        list.add(excuteModel.getXmlCmd());
        String[] arguments = list.toArray(new String[0]);
        return CommandUtils.excute("omp", arguments);
    }
}
