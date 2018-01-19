package com.hengheng.util.omp4j.service;

import com.hengheng.util.omp4j.exceptions.OmpUtilsException;
import com.hengheng.util.omp4j.model.ExcuteModel;

/**
 * @author panhb
 */
public interface ExcuteCmd {

    String excuteCmd(ExcuteModel excuteModel) throws OmpUtilsException;

}
