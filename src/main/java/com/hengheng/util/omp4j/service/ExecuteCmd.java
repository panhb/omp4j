package com.hengheng.util.omp4j.service;

import com.hengheng.util.omp4j.exceptions.OmpUtilsException;
import com.hengheng.util.omp4j.model.ExecuteModel;

/**
 * @author panhb
 */
public interface ExecuteCmd {

    /**
     * 执行omp命令
     *
     * @param model
     * @param ompCmd
     * @param sleep
     * @return String
     * @throws OmpUtilsException
     */
    String executeCmd(ExecuteModel model, String ompCmd, long sleep) throws OmpUtilsException;

}
