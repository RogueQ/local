package com.rogue.frame.dynamicDataSource;


/**  
 *   
 * 类名称：DataSourceContextHolder  
 * 类描述：  
 * 创建人：Rogue  
 * 修改人：Rogue  
 * 修改时间：2014年10月19日 下午12:58:15  
 * 修改备注：  
 * @version 1.0.0  
 *   
 */
 
public class DataSourceContextHolder {
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>(); // 线程本地环境

	// 设置数据源类型
	public static void setDataSourceType(String dataSourceType) {
		contextHolder.set(dataSourceType);
	}

	// 获取数据源类型 　　
	public static String getDataSourceType() {
		return (String) contextHolder.get();
	}
	
	// 清除数据源类型
	public static void clearDataSourceType() {
		contextHolder.remove();
	}
}
