/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:LogController.java 
 * 包名:org.lv.shop.web.controller.log 
 * 创建日期:2017年6月6日下午12:35:29 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.web.controller.log;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.lv.shop.entity.log.Log;
import org.lv.shop.service.log.LogService;
import org.lv.shop.util.JsonUtil;
import org.lv.shop.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：LogController    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年6月6日 下午12:35:29    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年6月6日 下午12:35:29    
 * 修改备注：       
 * @version   
 */
@Controller
@RequestMapping("log")
public class LogController {
	@Autowired
	private LogService logService;
	private Page page=new Page();
	
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	/**
	 * getLogPage(跳转日志记录查询页面)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月6日 下午12:37:54    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月6日 下午12:37:54    
	 * 修改备注： 
	 * @return
	 */
	@RequestMapping("getLogPage")
	public String getLogPage(){
		return "log/log_list_page";
	}
	/**
	 * getLogList(日志记录查询方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月6日 下午12:39:06    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月6日 下午12:39:06    
	 * 修改备注： 
	 * @param log
	 * @param response 
	 */
	@RequestMapping("getLogList")
	public void getLogList(Log log,Integer offset,Integer limit, HttpServletResponse response){
		page.setStrat(offset);
		page.setPagecount(limit);
		page.setObj(log);
		logService.getLogList(page);
		Map map=new HashMap();
		map.put("total",page.getPagesumcount());
		map.put("rows", page.getList());
		String jsonLog = JSON.toJSONStringWithDateFormat(map,"yyyy-MM-dd HH:mm:ss");
		JsonUtil.outJson(jsonLog, response);
	}
}
