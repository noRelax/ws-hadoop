/**
 * 海风app在线学习平台
 * @author: no_relax
 * @Title: LoginServiceImpl.java 
 * @Package: com.relax.www.rpc.server
 * @date: 2016年10月27日-下午12:08:18
 * @version: Vpad1.2.0
 * @copyright: 2016上海风创信息咨询有限公司-版权所有
 * 
 */

package com.relax.www.rpc.server;

/**
 * @ClassName: LoginServiceImpl
 * @Description: TODO(登陆接口业务实现类)
 * @author no_relax
 * @date 2016年10月27日 下午12:08:18
 * 
 */
public class LoginServiceImpl implements LoginServiceInterface {

	public String login(String name) {

		return "Hello, " + name + ". Welcome you!";
	}

}
