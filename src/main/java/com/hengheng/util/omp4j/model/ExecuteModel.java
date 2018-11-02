package com.hengheng.util.omp4j.model;

import com.hengheng.util.omp4j.enums.ExecuteTypeEnum;
import com.hengheng.util.omp4j.model.base.BaseModel;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author panhb
 */
@Data
@RequiredArgsConstructor
public class ExecuteModel extends BaseModel {

    /**
     * 执行类型
     */
    @NonNull
    private ExecuteTypeEnum type;

    /**
     * openvas 用户名
     */
    @NonNull
    private String username;

    /**
     * openvas 密码
     */
    @NonNull
    private String password;

    /**
     * openvas 端口
     */
    private String port;

    /**
     * openvas ip地址
     */
    private String host;

    /**
     * 主机IP
     */
    private String sshHost;

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
     * 密钥的密码/密钥文件路径为空时，用户密码
     */
    private String sshPassphrase;

}
