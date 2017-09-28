/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:LogServiceImpl.java 
 * 包名:org.lv.shop.service.log 
 * 创建日期:2017年6月6日下午12:19:30 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.service.log;

import java.util.List;

import org.lv.shop.entity.log.Log;
import org.lv.shop.mapper.log.LogMapper;
import org.lv.shop.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：LogServiceImpl    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年6月6日 下午12:19:30    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年6月6日 下午12:19:30    
 * 修改备注：       
 * @version   
 */
@Service
public class LogServiceImpl implements LogService{
	@Autowired
	private LogMapper logMapper;

	/* (non-Javadoc)    
	 * @see org.lv.shop.service.log.LogService#insertLog(org.lv.shop.entity.log.Log)    
	 */
	@Override
	public void insertLog(Log log) {
		logMapper.insertLog(log);
	}

	/* (non-Javadoc)    
	 * @see org.lv.shop.service.log.LogService#getLogList(org.lv.shop.util.Page)    
	 */
	@Override
	public void getLogList(Page page) {
		List<Log> log=logMapper.getLogList(page);
		int count=logMapper.getLogListCount(page);
		page.setPagesumcount(count);
		page.setList(log);
	}
}
