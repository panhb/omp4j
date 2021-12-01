package com.hengheng.util.omp4j.service.impl;

import cn.hutool.core.util.StrUtil;
import com.hengheng.util.omp4j.model.ExecuteModel;
import com.hengheng.util.omp4j.service.ExecuteCmd;
import com.hengheng.util.omp4j.utils.SshShellUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author panhb
 */
@Slf4j
public class SshExecuteCmdImpl implements ExecuteCmd {

    @SneakyThrows
    @Override
    public String executeCmd(ExecuteModel model, String ompCmd, long sleep) {
        StringBuilder sb = new StringBuilder("omp");
        sb.append(" ").append("-u").append(" ").append(model.getUsername());
        sb.append(" ").append("-w").append(" ").append(model.getPassword());
        if(StrUtil.isNotBlank(model.getHost())){
            sb.append(" ").append("-h").append(" ").append(model.getHost());
        }
        if(StrUtil.isNotBlank(model.getPort())){
            sb.append(" ").append("-p").append(" ").append(model.getPort());
        }
        sb.append(" ").append("-iX").append(" '").append(ompCmd).append("'");
        String result = SshShellUtils.sshShell(model.getSshHost(), model.getSshUser(),
                model.getSshPort(), model.getSshPrivateKey(),
                model.getSshPassphrase(), sb.toString(), sleep);
        return getXml(result);
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
        boolean flag = false;
        for (String info : infos) {
            Matcher startMatcher = startPattern.matcher(info);
            Matcher statusMatcher = statusPattern.matcher(info);
            Matcher endMatcher = endPattern.matcher(info);
            if (startMatcher.find() && statusMatcher.find()) {
                flag = true;
            }
            if (flag) {
                sb.append(info.trim());
            }
            if (endMatcher.find()) {
                break;
            }
        }
        return sb.toString();
    }
}
