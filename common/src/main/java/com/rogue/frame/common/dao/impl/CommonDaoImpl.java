
/**  
 * 项目名：myframe_maven  
 * 包名：com.rogue.frame.common.dao.impl  
 * 文件名：CommonDaoImpl.java  
 * 版本信息：  
 * 日期：2014年10月4日-下午8:51:37  
 * Copyright (c)2014 Rogue-版权所有  
 *   
 */
 
package com.rogue.frame.common.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rogue.frame.common.dao.CommonDao;

/**  
 *   
 * 类名称：CommonDaoImpl  
 * 类描述：通用数据连接层(DAO)实现类, 放置一些常用的数据库操作方法的具体实现  
 * 创建人：Rogue  
 * 修改人：Rogue  
 * 修改时间：2014年10月4日 下午8:51:37  
 * 修改备注：  
 * @version 1.0.0  
 *   
 */

public class CommonDaoImpl extends HibernateDaoSupport implements CommonDao {

	
	/* (non-Javadoc)  
	 * @see com.rogue.frame.common.dao.CommonDao#insertObject(java.lang.Object)  
	 */
	@Override
	public void insertObject(Object obj) throws Exception {
		try {
			this.getHibernateTemplate().save(obj);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	/* (non-Javadoc)  
	 * @see com.rogue.frame.common.dao.CommonDao#updateObject(java.lang.Object)  
	 */
	@Override
	public void updateObject(Object obj) throws Exception {
		try {
			this.getHibernateTemplate().update(obj);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	/* (non-Javadoc)  
	 * @see com.rogue.frame.common.dao.CommonDao#deleteObject(java.lang.Object)  
	 */
	@Override
	public void deleteObject(Object obj) throws Exception {
		try {
			this.getHibernateTemplate().delete(obj);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	
	/* (non-Javadoc)  
	 * @see com.rogue.frame.common.dao.CommonDao#saveOrUpdateObject(java.lang.Object)  
	 */
	@Override
	public void saveOrUpdateObject(Object obj) throws Exception {
		try {
			this.getHibernateTemplate().saveOrUpdate(obj);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}
}
