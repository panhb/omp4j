package com.hengheng.util.omp4j.service;

import com.hengheng.util.omp4j.OMPClient;
import com.hengheng.util.omp4j.service.impl.ExcuteCmdImpl;
import com.hengheng.util.omp4j.service.impl.SshExcuteCmdImpl;

/**
 * @author panhb
 */
public class ExcuteCmdFactory {

    public static ExcuteCmd getInstance(String type){
        if(OMPClient.SSH.equals(type)){
            return new SshExcuteCmdImpl();
        }else{
            return new ExcuteCmdImpl();
        }
    }
}
