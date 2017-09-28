/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:Resource.java 
 * 包名:org.lv.shop.entity.user 
 * 创建日期:2017年6月21日下午5:06:55 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.entity.user;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：Resource    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年6月21日 下午5:06:55    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年6月21日 下午5:06:55    
 * 修改备注：       
 * @version   
 */
public class RoleResource {
	private int id;
	private int menuId;
	private int roleId;
	   
	/**    
	 * 创建一个新的实例 RoleResource.    
	 *    
	 * @param id
	 * @param menuId
	 * @param roleId  
	 */
	public RoleResource(int id, int menuId, int roleId) {
		super();
		this.id = id;
		this.menuId = menuId;
		this.roleId = roleId;
	}

	   
	/**    
	 * 创建一个新的实例 RoleResource.    
	 *      
	 */
	public RoleResource() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getMenuId() {
		return menuId;
	}


	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}


	public int getRoleId() {
		return roleId;
	}


	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
}
