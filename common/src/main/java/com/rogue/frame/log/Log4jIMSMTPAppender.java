
/**  
 * 项目名：common  
 * 包名：com.rogue.frame.log  
 * 文件名：Log4jIMSMTPAppender.java  
 * 版本信息：  
 * 日期：2014年10月4日-下午2:14:58  
 * Copyright (c)2014 Rogue-版权所有  
 *   
 */
 
package com.rogue.frame.log;

import org.apache.log4j.net.SMTPAppender;


/**  
 *   
 * 类名称：Log4jIMSMTPAppender  
 * 类描述：log4j发送邮件时需要用到的自定义SMTPAppender  
 * 创建人：Rogue  
 * 修改人：Rogue  
 * 修改时间：2014年10月4日 下午2:14:58  
 * 修改备注：  
 * @version 1.0.0  
 *   
 */

public class Log4jIMSMTPAppender extends SMTPAppender {
	public Log4jIMSMTPAppender() {  
		super(new Log4jEventEvaluator());  
		Runtime.getRuntime().addShutdownHook(new Thread() {  
		    public void run() {  
		    	if (cb.length() > 0) {  
		        	sendBuffer();  
		    	}  
		    }  
		});
	}
}
