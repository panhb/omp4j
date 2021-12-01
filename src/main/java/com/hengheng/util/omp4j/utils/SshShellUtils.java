package com.hengheng.util.omp4j.utils;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.StrUtil;
import com.hengheng.util.omp4j.exceptions.OmpUtilsException;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author panhb
 */
@Slf4j
public class SshShellUtils {

	private static JSch jsch;

	/**
	 * 利用JSch包实现远程主机SHELL命令执行
	 * @param ip 主机IP
	 * @param user 主机登陆用户名
	 * @param port 主机ssh2登陆端口，如果取默认值，传-1
	 * @param privateKey 密钥文件路径
	 * @param password 密钥的密码/密钥文件为空时，是登录密码
	 * @param shellCommand shell命令
	 * @param sleepTime 线程睡眠时间
	 */
	@SneakyThrows
	public static String sshShell(String ip, String user, int port, String privateKey,
								  String password, String shellCommand, long sleepTime) {
		if (jsch == null) {
			jsch = new JSch();
		}
		String result;
        Session session;
		//设置密钥和密码
		addIdentity(privateKey, password);
		session = getSession(user, password, ip, port);
		Channel channel = openChannel(session);
		try {
			//获取输入流和输出流
			@Cleanup InputStream inputStream = channel.getInputStream();
			@Cleanup OutputStream outputStream = channel.getOutputStream();
            //发送命令
			sendCommand(shellCommand, outputStream);
            //异步执行，获取返回结果要睡眠
			Thread.sleep(sleepTime);
			//获取命令执行的结果
			result = getResult(inputStream);
			disconnect(session, channel);
		} catch (IOException | InterruptedException e) {
			throw new OmpUtilsException("获取返回结果IO异常:"+e.getMessage(), e);
		}
		return result;
	}

	/**
	 * 设置密钥和密码
	 *
	 * @param privateKey
	 * @param passphrase
	 */
	@SneakyThrows
	private static void addIdentity(String privateKey, String passphrase) {
		if (StrUtil.isNotBlank(privateKey)) {
			try {
				if (StrUtil.isNotBlank(passphrase)) {
					//设置带口令的密钥
					jsch.addIdentity(privateKey, passphrase);
				} else {
					//设置不带口令的密钥
					jsch.addIdentity(privateKey);
				}
			} catch (JSchException e) {
				throw new OmpUtilsException("设置ssh连接密钥错误:"+e.getMessage(), e);
			}
		}
	}

    /**
     * 获取会话
     *
     * @param user 登陆主机的用户名
     * @param password 登陆主机的密码
     * @param ip
     * @param port
     * @return Session
     */
	@SneakyThrows
	private static Session getSession(String user, String password, String ip, int port) {
		Session session;
		try {
			if (port <= 0) {
				//连接服务器，采用默认端口
				session = jsch.getSession(user, ip);
			} else {
				//采用指定的端口连接服务器
				session = jsch.getSession(user, ip, port);
			}
		} catch (JSchException e) {
			throw new OmpUtilsException("获取session错误:" + e.getMessage(), e);
		}
		if (session == null) {
			throw new OmpUtilsException("session is null");
		}

        if (StrUtil.isNotBlank(password)) {
            //设置登陆主机的密码
            session.setPassword(password);
        }
		//设置第一次登陆的时候提示，可选值：(ask | yes | no)
		session.setConfig("StrictHostKeyChecking", "no");
		session.setConfig("max_input_buffer_size", "" + Integer.MAX_VALUE);
		//设置登陆超时时间
		try {
			session.connect(30000);
		} catch (JSchException e) {
			throw new OmpUtilsException("session连接超时:" + e.getMessage(), e);
		}
		return session;
	}

	/**
	 * openChannel
	 *
	 * @param session
	 * @return Channel
	 */
	@SneakyThrows
	private static Channel openChannel(Session session) {
		Channel channel;
		try {
			channel = session.openChannel("shell");
		} catch (JSchException e) {
			throw new OmpUtilsException("打开channel错误:" + e.getMessage(), e);
		}
		if (channel == null) {
			throw new OmpUtilsException("channel is null");
		}
		try {
			channel.connect(1000);
		} catch (JSchException e) {
			throw new OmpUtilsException("channel连接超时:" + e.getMessage(), e);
		}
		return channel;
	}

	/**
	 * getResult
	 *
	 * @param inputStream
	 */
	@SneakyThrows
	private static String getResult(InputStream inputStream) {
		String result = "";
		if (inputStream.available() > 0) {
			result = IoUtil.readUtf8(inputStream);
			if (StrUtil.isBlank(result)) {
				throw new OmpUtilsException("network error.");
			}
		}
		return result;
	}

	/**
	 * sendCommand
	 *
	 * @param shellCommand
	 * @param outputStream
	 */
	@SneakyThrows
	private static void sendCommand(String shellCommand, OutputStream outputStream) {
		//发送需要执行的SHELL命令，需要用\n结尾，表示回车
		shellCommand += " \n";
		outputStream.write(shellCommand.getBytes());
		outputStream.flush();
	}

	/**
	 * disconnect
	 *
	 * @param session
	 * @param channel
	 */
	@SneakyThrows
	private static void disconnect(Session session, Channel channel) {
		if (session != null) {
			session.disconnect();
		}
		if (channel != null) {
			channel.disconnect();
		}
	}
}

