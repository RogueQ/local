package com.rogue.frame.dynamicDataSource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


/**  
 *   
 * 类名称：DynamicDataSourceAspect  
 * 类描述：基于Spring Aop，根据具体的境况通过DataSourceContextHolder.setDataSourceType(dataSourceType) 切换数据源
 * 创建人：Rogue  
 * 修改人：Rogue  
 * 修改时间：2014年10月19日 下午1:02:38  
 * 修改备注：  
 * @version 1.0.0  
 *   
 */
 
@Aspect
public class DynamicDataSourceAspect {
	
	
	/**  
	 * serviceExecution(这里用一句话描述这个方法的作用)  
	 * (这里描述这个方法适用条件 – 可选)     
	 * void  
	 * @exception   
	 * @since  1.0.0  
	 */
	@Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")  
    public void serviceExecution(){}  
      
    
    /**  
     * doBefore(前置通知，方法执行前执行)  
     * (这里描述这个方法适用条件 – 可选)  
     * @param jp   
     * void  
     * @exception   
     * @since  1.0.0  
     */
    @Before("serviceExecution()")  
    public void doBefore(JoinPoint jp) {  
        for(Object o : jp.getArgs()) {  
        	System.out.println("--->处理具体的逻辑 ，根据具体的境况DataSourceContextHolder.setDataSourceType()选取DataSource " + o);
        }  
    }  
    
    
    /**  
     * doAfter(后置通知，方法执行后执行)  
     * (这里描述这个方法适用条件 – 可选)  
     * @param jp   
     * void  
     * @exception   
     * @since  1.0.0  
     */
    @After("serviceExecution()")  
    public void doAfter(JoinPoint jp) {  
    	System.out.println("--->后置事件 ");
        for(Object o : jp.getArgs()) {  
        	System.out.println("--->处理具体的逻辑 ，根据具体的境况DataSourceContextHolder.setDataSourceType()选取DataSource " + o);
        }  
    }  
    
    @Around("serviceExecution()")  
    public void doAround(JoinPoint jp) {  
    	System.out.println("--->环绕事件 ");
        for(Object o : jp.getArgs()) {  
        	System.out.println("--->处理具体的逻辑 ，根据具体的境况DataSourceContextHolder.setDataSourceType()选取DataSource " + o);
        }  
    }  
    @AfterReturning("serviceExecution()")  
    public void doAfterReturning(JoinPoint jp) {  
    	System.out.println("--->返回事件 ");
        for(Object o : jp.getArgs()) {  
        	System.out.println("--->处理具体的逻辑 ，根据具体的境况DataSourceContextHolder.setDataSourceType()选取DataSource " + o);
        }  
    }  
    @AfterThrowing("serviceExecution()")  
    public void doAfterThrowing(JoinPoint jp) {  
        for(Object o : jp.getArgs()) {  
        	System.out.println("--->处理具体的逻辑 ，根据具体的境况DataSourceContextHolder.setDataSourceType()选取DataSource " + o);
        }  
    }  
    
}
