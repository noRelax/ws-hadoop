/**
 * 海风app在线学习平台
 * @author: no_relax
 * @Title: LoginRpcServer.java 
 * @Package: com.relax.www.rpc.server
 * @date: 2016年10月27日-下午1:49:32
 * @version: Vpad1.2.0
 * @copyright: 2016上海风创信息咨询有限公司-版权所有
 * 
 */

package com.relax.www.rpc.server;

import java.io.IOException;
import java.util.Arrays;

import org.apache.hadoop.HadoopIllegalArgumentException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hdfs.server.common.HdfsServerConstants.StartupOption;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.RPC.Server;
import org.junit.Test;

public class LoginRpcServer {

	/**
	 * TODO(创建并启动RPC server)
	 * 
	 * @author: no_relax
	 * @Title: main
	 * @param args
	 * @throws IOException 
	 * @throws HadoopIllegalArgumentException 
	 * @since Vpad1.2.0
	 */
	public static void main(String[] args) throws HadoopIllegalArgumentException, IOException {
		// 构造RPC server
		RPC.Builder builder = new RPC.Builder(new Configuration());
		builder.setBindAddress("192.168.60.25").setPort(10000).setInstance(new LoginServiceImpl()).setProtocol(LoginServiceInterface.class);
		Server server = builder.build();
		server.start();
	}
	
	@Test
	public void test(){
		System.out.println(Arrays.asList(StartupOption.RECOVER.getName()));
	}

}
