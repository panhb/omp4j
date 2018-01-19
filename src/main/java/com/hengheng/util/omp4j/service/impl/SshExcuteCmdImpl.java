package com.hengheng.util.omp4j.service.impl;

import com.hengheng.util.omp4j.exceptions.OmpUtilsException;
import com.hengheng.util.omp4j.model.ExcuteModel;
import com.hengheng.util.omp4j.service.ExcuteCmd;
import com.hengheng.util.omp4j.utils.SshShellUtils;
import com.xiaoleilu.hutool.log.Log;
import com.xiaoleilu.hutool.log.LogFactory;
import com.xiaoleilu.hutool.util.StrUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author panhb
 */
public class SshExcuteCmdImpl implements ExcuteCmd{

    private final static Log log = LogFactory.get();

    @Override
    public String excuteCmd(ExcuteModel excuteModel) throws OmpUtilsException {
        StringBuilder sb = new StringBuilder("omp");
        sb.append(" ").append("-u").append(" ").append(excuteModel.getUsername());
        sb.append(" ").append("-w").append(" ").append(excuteModel.getPassword());
        if(StrUtil.isNotBlank(excuteModel.getHost())){
            sb.append(" ").append("-h").append(" ").append(excuteModel.getHost());
        }
        if(StrUtil.isNotBlank(excuteModel.getPort())){
            sb.append(" ").append("-p").append(" ").append(excuteModel.getPort());
        }
        sb.append(" ").append("-iX").append(" '").append(excuteModel.getXmlCmd()).append("'");
        try {
            String result = SshShellUtils.sshShell(excuteModel.getSshIp(),excuteModel.getSshUser(),excuteModel.getSshPort(),
                    excuteModel.getSshPrivateKey(),excuteModel.getSshPassphrase(),sb.toString(),
                    excuteModel.getSshSleepSpec() == null ? excuteModel.getSshSleep() : excuteModel.getSshSleepSpec());
            return getXml(result);
        }catch (Exception e){
            throw new OmpUtilsException(e.getMessage());
        }
    }

    private String getXml(String result){
        String[] infos = result.split("\r\n");
        StringBuilder sb = new StringBuilder();
        String startRegEx = "<*_response";
        String statusRegEx = "status=\"200|201|202|400|401|403|404|409|500|503\"";
        String endRegEx = "</.*_response>";
        Pattern startPattern = Pattern.compile(startRegEx);
        Pattern statusPattern = Pattern.compile(statusRegEx);
        Pattern endPattern = Pattern.compile(endRegEx);
        Boolean flag = false;
        for(int i = 0 ; i < infos.length ; i++){
            String info = infos[i];
            Matcher startMatcher = startPattern.matcher(info);
            Matcher statusMatcher = statusPattern.matcher(info);
            Matcher endMatcher = endPattern.matcher(info);
            if(startMatcher.find() && statusMatcher.find()){
                log.info("start:"+i);
                flag = true;
            }
            if(flag){
                sb.append(info.trim());
            }
            if(endMatcher.find()){
                log.info("end:"+i);
                break;
            }
        }
        return sb.toString();
    }
}
