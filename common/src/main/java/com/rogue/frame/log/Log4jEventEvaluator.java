
/**  
 * 项目名：common  
 * 包名：com.rogue.frame.log  
 * 文件名：Log4jEventEvaluator.java  
 * 版本信息：  
 * 日期：2014年10月3日-下午3:37:21  
 * Copyright (c)2014 Rogue-版权所有  
 *   
 */
 
package com.rogue.frame.log;

import org.apache.log4j.Level;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.TriggeringEventEvaluator;


/**  
 *   
 * 类名称：Log4jEventEvaluator  
 * 类描述： Log4j的SMTP的级别默认是ERROR级别 
 *		默认是ERROR级别，那就是说，只有程序出错了，才可以收到邮件。
 *		不过可以自定义的级别，实现TriggeringEventEvaluator接口
 * 创建人：Rogue  
 * 修改人：Rogue  
 * 修改时间：2014年10月3日 下午3:37:21  
 * 修改备注：  
 * @version 1.0.0  
 *   
 */

public class Log4jEventEvaluator implements TriggeringEventEvaluator {

	/* (non-Javadoc)  
	 * @see org.apache.log4j.spi.TriggeringEventEvaluator#isTriggeringEvent(org.apache.log4j.spi.LoggingEvent)  
	 */
	@Override
	public boolean isTriggeringEvent(LoggingEvent event) {
		return event.getLevel().isGreaterOrEqual(Level.DEBUG);
	}

}
