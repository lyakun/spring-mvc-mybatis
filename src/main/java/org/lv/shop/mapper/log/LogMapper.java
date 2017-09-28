/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:LogMapper.java 
 * 包名:org.lv.shop.mapper.log 
 * 创建日期:2017年6月6日下午12:21:07 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.mapper.log;

import java.util.List;

import org.lv.shop.entity.log.Log;
import org.lv.shop.util.Page;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：LogMapper    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年6月6日 下午12:21:07    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年6月6日 下午12:21:07    
 * 修改备注：       
 * @version   
 */
public interface LogMapper {


	/** insertLog(日志记录的保存方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月6日 下午12:29:34    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月6日 下午12:29:34    
	 * 修改备注： 
	 * @param log  
	 */
	void insertLog(Log log);

	/** getLogList(查询日志记录并携带条件)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月6日 下午12:43:22    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月6日 下午12:43:22    
	 * 修改备注： 
	 * @param page  
	 * @return 
	 */
	List<Log> getLogList(Page page);

	/** getLogListCount(查询总条数)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月6日 下午12:55:01    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月6日 下午12:55:01    
	 * 修改备注： 
	 * @param page
	 * @return  
	 */
	int getLogListCount(Page page);
}
