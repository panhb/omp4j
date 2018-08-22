package com.hengheng.util.omp4j.service;


import com.hengheng.util.omp4j.service.impl.ExecuteCmdImpl;

/**
 * @author panhb
 */
public class ExecuteCmdFactory implements IExecuteFactory {

    @Override
    public ExecuteCmd getExecuteCmd() {
        return new ExecuteCmdImpl();
    }

}
