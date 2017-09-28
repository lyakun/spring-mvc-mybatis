/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:MenuMapper.java 
 * 包名:org.lv.shop.entity.menu 
 * 创建日期:2017年5月27日下午12:30:43 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.entity.menu;

import java.io.Serializable;
import java.util.Map;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：MenuMapper    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年5月27日 下午12:30:43    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年5月27日 下午12:30:43    
 * 修改备注：       
 * @version   
 */
public class Menu implements Serializable{
	private static final long serialVersionUID = 147766221214889670L;
	private int menuId;//菜单主键 
	private Integer pid;//父节点id
	private String menuName;//菜单名称
	private String menuUrl;//菜单链接
	private String permission;//权限
	private String type;//类型0:为菜单 1:为按钮
	private Map state;
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Map getState() {
		return state;
	}
	public void setState(Map state) {
		this.state = state;
	}
	   
	/**    
	 * 创建一个新的实例 Menu.    
	 *    
	 * @param menuId
	 * @param pid
	 * @param menuName
	 * @param menuUrl
	 * @param permission
	 * @param type
	 * @param state  
	 */
	public Menu(int menuId, Integer pid, String menuName, String menuUrl, String permission, String type, Map state) {
		super();
		this.menuId = menuId;
		this.pid = pid;
		this.menuName = menuName;
		this.menuUrl = menuUrl;
		this.permission = permission;
		this.type = type;
		this.state = state;
	}
	   
	/**    
	 * 创建一个新的实例 Menu.    
	 *      
	 */
	public Menu() {
		super();
	}
	
	
	   
	
	
	
}
