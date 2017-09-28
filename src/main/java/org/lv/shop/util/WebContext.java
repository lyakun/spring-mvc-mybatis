/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:WebContext.java 
 * 包名:org.lv.shop.util 
 * 创建日期:2017年6月6日下午4:25:09 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：WebContext    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年6月6日 下午4:25:09    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年6月6日 下午4:25:09    
 * 修改备注：       
 * @version   
 */
public class WebContext {
	//将request放入到ThreadLocal中
	private static ThreadLocal<HttpServletRequest> local=new ThreadLocal<>();
	//将respone放入到ThreadLocal中
	private  static ThreadLocal<HttpServletResponse> responselocal=new ThreadLocal<>();
	//给每个线程设置request
	public static void setRequest(HttpServletRequest request){
		local.set(request);
	}
	//获取唯一的request
	public static HttpServletRequest getRequest(){
		return local.get();
	}
	//给每个线程设置response
	public static void setresponse(HttpServletResponse response){
		responselocal.set(response);
	}
	//获取唯一的response
	public static HttpServletResponse getRsponse(){
		return responselocal.get();
	}
	//清空
	public static void destory(){
		local.remove();
		responselocal.remove();
	}
}
