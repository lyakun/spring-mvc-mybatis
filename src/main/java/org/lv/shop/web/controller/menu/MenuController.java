/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:MenuController.java 
 * 包名:org.lv.shop.web.controller.menu 
 * 创建日期:2017年5月27日下午2:06:37 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.web.controller.menu;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.lv.shop.entity.menu.Menu;
import org.lv.shop.entity.user.User;
import org.lv.shop.service.menu.MenuService;
import org.lv.shop.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：MenuController    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年5月27日 下午2:06:37    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年5月27日 下午2:06:37    
 * 修改备注：       
 * @version   
 */
@Controller
@RequestMapping("menu")
public class MenuController {
	@Autowired
	private MenuService menuService;
	/**
	 * getTreeList(获取菜单树)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月27日 下午2:07:40    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月27日 下午2:07:40    
	 * 修改备注：
	 * @param response 
	 */
	@RequestMapping("getTreeList")
	public void getTreeList(HttpServletResponse response){
		Subject subject = SecurityUtils.getSubject();
		User user= (User)subject.getPrincipal();
		List<Map> menuList=menuService.getTreeList(user.getUserId());
		JsonUtil.outJson(menuList, response);
	}
	/**
	 * getTreeAllList(获取所有的树)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月23日 下午8:11:32    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月23日 下午8:11:32    
	 * 修改备注：
	 */
	@RequestMapping("getTreeAllList")
	@ResponseBody
	public List<Map> getTreeAllList(HttpServletResponse response ,String id){
		List<Map> menuList=menuService.getTreeListAll(id);
		return menuList;
	}
}
