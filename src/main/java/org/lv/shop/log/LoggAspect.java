/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:LoggAspect.java 
 * 包名:org.lv.shop.log 
 * 创建日期:2017年6月6日上午11:11:13 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.log;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.lv.shop.entity.log.Log;
import org.lv.shop.service.log.LogService;
import org.lv.shop.util.WebContext;
import org.springframework.beans.factory.annotation.Autowired;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：LoggAspect    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年6月6日 上午11:11:13    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年6月6日 上午11:11:13    
 * 修改备注：       
 * @version   
 */
public class LoggAspect {
	private static final Logger LOG=Logger.getLogger(LoggAspect.class);
	@Autowired
	private LogService logService;
	/**
	 * doLog(对日志统一管理)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月6日 上午11:26:35    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月6日 上午11:26:35    
	 * 修改备注： 
	 * @param pjp
	 * @return
	 */
	public Object doLog(ProceedingJoinPoint pjp){
		Object reslut=null;
		//获取类的全称
		String canonicalName = pjp.getTarget().getClass().getCanonicalName();
		//获取方法名
		String name = pjp.getSignature().getName();
		//获取当前访问的url
		HttpServletRequest request = WebContext.getRequest();
		//获取请求的参数
		Map<String, String[]> parameterMap = request.getParameterMap();
		Set<Entry<String, String[]>> entrySet = parameterMap.entrySet();
		StringBuffer parame=new StringBuffer();
		for (Entry<String, String[]> entry : entrySet) {
			parame.append(entry.getKey()+":"+Arrays.toString(entry.getValue())+";");
		}
		LOG.info("开始执行---"+canonicalName+"."+name+"()"+request.getRequestURI());
		
		long excatue=0;
		 try {
			 long currentTimeMillis = System.currentTimeMillis();
			 //执行业务核心代码
			reslut = pjp.proceed();
			excatue=System.currentTimeMillis()-currentTimeMillis;
		} catch (Throwable e) {
			e.printStackTrace();
			LOG.error(canonicalName+"."+name+"()"+e);
			Log lg=new Log();
			lg.setLogType(2);
			lg.setLogId(UUID.randomUUID().toString());
			lg.setLogContext(canonicalName+"."+name+"()"+e);
			lg.setCreateTime(new Date());
			lg.setUrl(request.getRequestURI());
			lg.setExcatueTime(excatue);
			lg.setParame(parame.toString());
			logService.insertLog(lg);
		}
		 Log log=new Log();
			log.setLogId(UUID.randomUUID().toString());
			log.setLogContext("开始执行---"+canonicalName+"."+name+"()");
			log.setLogType(1);
			log.setCreateTime(new Date());
			log.setUrl(request.getRequestURI());
			log.setExcatueTime(excatue);
			log.setParame(parame.toString());
			logService.insertLog(log);
		return reslut;
	}
	//获取客户的真实iP
	private  String getIpAddress(HttpServletRequest request) {  
        String ip = request.getHeader("x-forwarded-for");  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("WL-Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_CLIENT_IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getRemoteAddr();  
        }  
        return ip;  
    }  
}
