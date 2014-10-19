
/**  
 * 项目名：myframe_maven  
 * 包名：com.rogue.frame.common.dao  
 * 文件名：CommonDao.java  
 * 版本信息：  
 * 日期：2014年10月4日-下午8:49:32  
 * Copyright (c)2014 Rogue-版权所有  
 *   
 */
 
package com.rogue.frame.common.dao;


/**  
 *   
 * 类名称：CommonDao  
 * 类描述：通用数据连接层(DAO)接口, 放置一些常用的数据库操作方法
 * 创建人：Rogue  
 * 修改人：Rogue  
 * 修改时间：2014年10月4日 下午8:49:32  
 * 修改备注：  
 * @version 1.0.0  
 *   
 */

public interface CommonDao{
	
	/**  
	 * insertObject(插入一条数据到数据库中, 参数为任意类型的POJO)  
	 * (这里描述这个方法适用条件 – 可选)  
	 * @param obj
	 * @throws Exception   
	 * void  
	 * @exception   
	 * @since  1.0.0  
	 */
	public void insertObject(Object obj) throws Exception;
	
	
	/**  
	 * updateObject(更新数据库中的一条数据, 参数为任意类型的POJO)  
	 * (这里描述这个方法适用条件 – 可选)  
	 * @param obj
	 * @throws Exception   
	 * void  
	 * @exception   
	 * @since  1.0.0  
	 */
	public void updateObject(Object obj) throws Exception;
	
	
	/**  
	 * deleteObject(从数据库中删除一条数据, 参数为任意类型的POJO)  
	 * (这里描述这个方法适用条件 – 可选)  
	 * @param obj
	 * @throws Exception   
	 * void  
	 * @exception   
	 * @since  1.0.0  
	 */
	public void deleteObject(Object obj) throws Exception;
	
	
	/**  
	 * saveOrUpdateObject(向数据库中添加一条数据或者更新数据库中的一条数据, 参数为任意类型的POJO)  
	 * (这里描述这个方法适用条件 – 可选)  
	 * @param obj
	 * @throws Exception   
	 * void  
	 * @exception   
	 * @since  1.0.0  
	 */
	public void saveOrUpdateObject(Object obj) throws Exception;
}
