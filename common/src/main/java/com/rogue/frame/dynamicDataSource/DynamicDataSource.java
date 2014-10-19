package com.rogue.frame.dynamicDataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**  
 *   
 * 类名称：DynamicDataSource  
 * 类描述：在Spring 2.0.1中引入了AbstractRoutingDataSource, 
 * 		该类充当了DataSource的路由中介, 能有在运行时, 根据某种key值来动态切换到真正的DataSource上。
 * 	 	Spring动态配置多数据源，即在大型应用中对数据进行切分，并且采用多个数据库实例进行管理，这样可以有效提高系统的水平伸缩性。
 * 		而这样的方案就会不同于常见的单一数据实例的方案，这就要程序在运行时根据当时的请求及系统状态来动态的决定将数据存储在哪个数据库实例中，
 * 		以及从哪个数据库提取数据。  
 * 创建人：Rogue  
 * 修改人：Rogue  
 * 修改时间：2014年10月19日 下午12:58:38  
 * 修改备注：  
 * @version 1.0.0  
 *   
 */
 
public class DynamicDataSource extends AbstractRoutingDataSource {
	@Override
	protected Object determineCurrentLookupKey() {
		return DataSourceContextHolder.getDataSourceType();
	}
}
