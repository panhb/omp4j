package com.hengheng.util.omp4j.utils;

import com.hengheng.util.omp4j.exceptions.OmpUtilsException;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.xiaoleilu.hutool.log.Log;
import com.xiaoleilu.hutool.log.LogFactory;
import com.xiaoleilu.hutool.util.StrUtil;
import lombok.Cleanup;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author panhb
 */
public class SshShellUtils {

	private static Log log = LogFactory.get();

	/**
	 * 利用JSch包实现远程主机SHELL命令执行
	 * @param ip 主机IP
	 * @param user 主机登陆用户名
	 * @param port 主机ssh2登陆端口，如果取默认值，传-1
	 * @param privateKey 密钥文件路径
	 * @param passphrase 密钥的密码
	 * @param shellCommand shell命令
	 * @param sleep 线程睡眠时间
	 */
	public static String sshShell(String ip, String user, int port ,String privateKey ,String passphrase ,String shellCommand,Long sleep) throws Exception {
		String result = "";
		Session session;
		Channel channel;
		JSch jsch = new JSch();
		//设置密钥和密码
		if (StrUtil.isNotBlank(privateKey)) {
            if (StrUtil.isNotBlank(passphrase)) {
            	//设置带口令的密钥
                jsch.addIdentity(privateKey, passphrase);
            } else {
            	//设置不带口令的密钥
                jsch.addIdentity(privateKey);
            }
        }
		if(port <= 0){
			//连接服务器，采用默认端口
			session = jsch.getSession(user, ip);
		}else{
			//采用指定的端口连接服务器
			session = jsch.getSession(user, ip ,port);
		}
		//如果服务器连接不上，则抛出异常
		if (session == null) {
			throw new OmpUtilsException("session is null");
		}
		//设置登陆主机的密码
		//设置第一次登陆的时候提示，可选值：(ask | yes | no)
		session.setConfig("StrictHostKeyChecking", "no");
		int maxBufferSize = Integer.MAX_VALUE;
		session.setConfig("max_input_buffer_size", ""+maxBufferSize);
		//设置登陆超时时间
		session.connect(30000);
		channel = session.openChannel("shell");
		channel.connect(1000);
		//获取输入流和输出流
		@Cleanup InputStream instream = channel.getInputStream();
		@Cleanup OutputStream outstream = channel.getOutputStream();
		//发送需要执行的SHELL命令，需要用\n结尾，表示回车
		shellCommand += " \n";
		outstream.write(shellCommand.getBytes());
		outstream.flush();
		//异步执行，获取返回结果要睡眠
		try {
			Thread.sleep(sleep);
		} catch (InterruptedException e) {
			log.error(e);
		}
		//获取命令执行的结果
		if (instream.available() > 0) {
			byte[] data = new byte[instream.available()];
			int nLen = instream.read(data);
			if (nLen < 0) {
				throw new OmpUtilsException("network error.");
			}
			//转换输出结果并打印出来
			result = new String(data, 0, nLen);
		}
		session.disconnect();
		channel.disconnect();
		return result;
	}
}

