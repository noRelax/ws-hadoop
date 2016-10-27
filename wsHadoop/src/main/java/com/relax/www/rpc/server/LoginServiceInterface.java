/**
 * 海风app在线学习平台
 * @author: no_relax
 * @Title: LoginServiceInterface.java 
 * @Package: com.relax.www.rpc
 * @date: 2016年10月27日-下午12:03:26
 * @version: Vpad1.2.0
 * @copyright: 2016上海风创信息咨询有限公司-版权所有
 * 
 */

package com.relax.www.rpc.server;

/**
 * @ClassName: LoginServiceInterface
 * @Description: TODO(定义rpc协议接口)
 * @author no_relax
 * @date 2016年10月27日 下午12:03:26
 * 
 */
public interface LoginServiceInterface {
	static final long versionID = 1L;

	String login(String name);
}
