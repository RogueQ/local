/**  
 * 项目名：myframe_maven  
 * 包名：com.rogue.frame.log  
 * 文件名：Log4jHTMLLayOut.java  
 * 版本信息：  
 * 日期：2014年10月3日-下午2:43:01  
 * Copyright (c)2014 Rogue-版权所有  
 *   
 */

package com.rogue.frame.log;

import org.apache.log4j.HTMLLayout;
import org.apache.log4j.spi.LoggingEvent;

/**  
 *   
 * 类名称：Log4jHTMLLayOut  
 * 类描述：Log4jHTMLLayOut 类描述：自定义log4j的layout参数，
 * 		   由于log4j默认采用的纯文本方式.这样不便于我们在邮件中查看,因此覆盖它的layout,自定义属于我们自己的layout
 *       通过继承log4j的HTMLLayout并重写getContentType方法，避免了中文乱码  
 * 创建人：Rogue  
 * 修改人：Rogue  
 * 修改时间：2014年10月4日 下午3:02:04  
 * 修改备注：  
 * @version 1.0.0  
 *   
 */
 
public class Log4jHTMLLayOut extends HTMLLayout {

	StringBuffer sbuf;

	
	/* (non-Javadoc)  避免中文乱码
	 * @see org.apache.log4j.HTMLLayout#getContentType()  
	 */
	@Override
	public String getContentType() {
		return "text/html;charset=UTF-8";
	}

	public Log4jHTMLLayOut() {
		sbuf = new StringBuffer(1024*1024);
	}
	
	/* (non-Javadoc)  重写format方法自定义输出格式(可识别HTML标签)
	 * @see org.apache.log4j.HTMLLayout#format(org.apache.log4j.spi.LoggingEvent)  
	 */
	@Override
	public String format(LoggingEvent event) {
		sbuf.setLength(0);
		sbuf.append("日志等级：" + event.getLevel().toString() + "<br/>");
		sbuf.append("日志信息：" + event.getMessage().toString() + "<br/>");
		sbuf.append("所在类：" + event.getLocationInformation().getClassName() + "<br/>");
		sbuf.append("所在方法：" + event.getLocationInformation().getMethodName() + "<br/>");
		sbuf.append("所在行：" + event.getLocationInformation().getLineNumber());
		return sbuf.toString();
	}

	@Override
	public boolean ignoresThrowable() {
		return false;
	}
}
