package com.hengheng.util.omp4j.service;

import com.hengheng.util.omp4j.service.impl.SshExecuteCmdImpl;

/**
 * @author panhb
 */
public class SshExecuteCmdFactory implements IExecuteFactory {

    @Override
    public ExecuteCmd getExecuteCmd() {
        return new SshExecuteCmdImpl();
    }

}
