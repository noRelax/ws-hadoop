/**
 * Project Name:mapreduce
 * File Name:LoginController.java
 * Package Name:com.relax.www.rpc.client
 * Date:2016年10月27日下午1:57:49
 * Copyright (c) 2016, chenzhou1025@126.com All Rights Reserved.
 *
*/
/**
 * 海风app在线学习平台
 * @author: no_relax
 * @Title: LoginController.java 
 * @Package: com.relax.www.rpc.client
 * @date: 2016年10月27日-下午1:57:49
 * @version: Vpad1.2.0
 * @copyright: 2016上海风创信息咨询有限公司-版权所有
 * 
 */

package com.relax.www.rpc.client;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import com.relax.www.rpc.server.LoginServiceInterface;

/**
 * @ClassName: LoginController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author no_relax
 * @date 2016年10月27日 下午1:57:49
 * 
 */
public class LoginClient {
	public static void main(String[] args) throws IOException {
		LoginServiceInterface loginService = RPC.getProxy(LoginServiceInterface.class, 1L, new InetSocketAddress("192.168.60.25",10000), new Configuration());
		String loginResult = loginService.login("no relax");
		System.out.println(">>>>>>>>>>>>>>>>>>"+loginResult);
		RPC.stopProxy(loginService);
	}

}
