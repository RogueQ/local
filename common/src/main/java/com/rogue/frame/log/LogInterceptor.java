
/**  
 * 项目名：myframe_maven  
 * 包名：com.rogue.frame.log  
 * 文件名：LogService.java  
 * 版本信息：  
 * 日期：2014年10月2日-下午7:16:29  
 * Copyright (c)2014 Rogue-版权所有  
 *   
 */
 
package com.rogue.frame.log;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


/**  
 *   
 * 类名称：LogInterceptor  
 * 类描述：基于Spring Aop，使用log4j实现日志记录
 * 注意：
 *  1、@Aspect：意思是这个类为切面类
 *  2、@Component：因为作为切面类需要Spring管理起来，所以在初始化时就需要将这个类初始化加入Spring的管理；
 *  3、@Pointcut：定义一个切入点
 *  4、@Around 切入点逻辑(Advice) 表示环绕通知 还有@before(前置通知)@after(后置通知)@AfterReturning(返回通知)@AfterThrowing(异常通知) 
 *  4、execution…:切入点语法
 * 创建人：Rogue  
 * 修改人：Rogue  
 * 修改时间：2014年10月2日 下午7:16:29  
 * 修改备注：  
 * @version 1.0.0  
 *   
 */
@Aspect
@Component
public class LogInterceptor {
	
	/**  
	 * pointCut(定义一个切入点)  
	 * (这里描述这个方法适用条件 – 可选)     
	 * void  
	 * @exception   
	 * @since  1.0.0  
	 */
	@Pointcut("execution(* com.rogue..*.* (..))")
	public void pointCut(){}
	
	/**  
	 * doAround(环绕通知,使用org.aspectj.lang.ProceedingJoinPoint表示连接点对象，
	 * 该类是JoinPoint的子接口,任何一个增强方法都可以通过将第一个入参声明为JoinPoint访问到连接点上下文的信息)  
	 * (这里描述这个方法适用条件 – 可选)  
	 * @param jp
	 * @return
	 * @throws Throwable   
	 * Object  
	 * @exception   
	 * @since  1.0.0  
	 */
	@Around("pointCut()")
	public Object doAround(ProceedingJoinPoint jp) throws Throwable{
		Logger logger = Logger.getLogger(LogInterceptor.class);
        logger.info("Spring Aop 环绕通知--Start");
        long startMillis = System.currentTimeMillis();
        Object obj = jp.proceed(); // 通过反射执行目标对象的连接点处的方法
        long endMillis = System.currentTimeMillis();
        logger.info("Spring Aop 环绕通知--End 执行时间：" + (endMillis - startMillis) + " ms");
        return obj;
	}
	
	/**  
	 * doBefore(前置通知)  
	 * (这里描述这个方法适用条件 – 可选)     
	 * void  
	 * @exception   
	 * @since  1.0.0  
	 */
	@Before("pointCut()")
	public void doBefore(){
		
	}
	
	/**  
	 * doAfter(后置通知)  
	 * (这里描述这个方法适用条件 – 可选)     
	 * void  
	 * @exception   
	 * @since  1.0.0  
	 */
	@After("pointCut()")
	public void doAfter(){
		
	}
	
	/**  
	 * doAfterReturn(返回通知)  
	 * (这里描述这个方法适用条件 – 可选)     
	 * void  
	 * @exception   
	 * @since  1.0.0  
	 */
	@AfterReturning("pointCut()")
	public void doAfterReturn(){
		
	}
	
	/**  
	 * doAfterThrowing(异常通知)  
	 * (这里描述这个方法适用条件 – 可选)     
	 * void  
	 * @exception   
	 * @since  1.0.0  
	 */
	@AfterThrowing("pointCut()")
	public void doAfterThrowing(){
		
	}
}
