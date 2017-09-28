/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:LogService.java 
 * 包名:org.lv.shop.service.log 
 * 创建日期:2017年6月6日下午12:19:39 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.service.log;

import org.lv.shop.entity.log.Log;
import org.lv.shop.util.Page;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：LogService    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年6月6日 下午12:19:39    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年6月6日 下午12:19:39    
 * 修改备注：       
 * @version   
 */
public interface LogService {

	/** insertLog(保存日志方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月6日 下午12:29:04    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月6日 下午12:29:04    
	 * 修改备注： 
	 * @param log  
	 */
	void insertLog(Log log);

	/** getLogList(查询日志记录并携带条件)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月6日 下午12:42:34    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月6日 下午12:42:34    
	 * 修改备注： 
	 * @param page  
	 */
	void getLogList(Page page);

}
