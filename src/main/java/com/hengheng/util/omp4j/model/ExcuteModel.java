package com.hengheng.util.omp4j.model;

import com.hengheng.util.omp4j.model.base.BaseModel;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class ExcuteModel extends BaseModel{

    private String username;
    private String password;
    private String port;
    private String host;
    private String xmlCmd;

    /**
     * 主机IP
     */
    private String sshIp;
    /**
     * 主机ssh2登陆端口，如果取默认值，传-1
     */
    private int sshPort;
    /**
     * 主机登陆用户名
     */
    private String sshUser;
    /**
     * 密钥文件路径
     */
    private String sshPrivateKey;
    /**
     * 密钥的密码
     */
    private String sshPassphrase;
    /**
     * 线程睡眠时间
     */
    private Long sshSleep;
    /**
     * 线程睡眠时间,某些方法需要延长睡眠时间
     */
    private Long sshSleepSpec;

}
