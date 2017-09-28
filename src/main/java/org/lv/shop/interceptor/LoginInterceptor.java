/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:loginInterceptor.java 
 * 包名:org.lv.shop.interceptor 
 * 创建日期:2017年6月3日上午8:50:45 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.interceptor;

import javax.interceptor.Interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.lv.shop.entity.user.User;
import org.lv.shop.util.WebContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：loginInterceptor    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年6月3日 上午8:50:45    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年6月3日 上午8:50:45    
 * 修改备注：       
 * @version   
 */
@Interceptor
public class LoginInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		User user=(User)session.getAttribute("u");
		String requestUri = request.getRequestURI();
		//给webContext设置request和response
		/*try {
			WebContext.setRequest(request);
			WebContext.setresponse(response);
		}finally{
			//清空
			WebContext.destory();
		}*/
		 if(requestUri.contains("userLogin.gang")||requestUri.contains("toUserAddPage.gang")
				 ||requestUri.contains("insertUser.gang")){
			 return true;
		 }
		 if(user==null){
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return false;
		}
		return true;
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}
