
/**  
 * 项目名：myframe_maven  
 * 包名：com.rogue.business.login  
 * 文件名：LoginController.java  
 * 版本信息：  
 * 日期：2014年10月1日-下午9:46:24  
 * Copyright (c)2014 Rogue-版权所有  
 *   
 */
 
package com.rogue.business.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rogue.module.SysUser;


/**  
 *   
 * 类名称：LoginController  
 * 类描述：系统登录部分的前端控制器
 * 创建人：Rogue  
 * 修改人：Rogue  
 * 修改时间：2014年10月1日 下午9:46:24  
 * 修改备注：  
 * @version 1.0.0  
 *   
 */

@Controller
public class LoginController {
	
	/**  
	 * login(系统发出登录请求时的处理方法)  
	 * (这里描述这个方法适用条件 – 可选)  
	 * @param request
	 * @param response
	 * @param command
	 * @return   
	 * ModelAndView  
	 * @exception   
	 * @since  1.0.0  
	 */
	@RequestMapping(value = "login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, SysUser command) {
		String username = command.getUsername();
		ModelAndView mv = new ModelAndView("index", "command", "LOGIN SUCCESS, " + username);
		return mv;
	}
}