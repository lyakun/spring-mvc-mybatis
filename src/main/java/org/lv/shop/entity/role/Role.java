/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:Role.java 
 * 包名:org.lv.shop.entity.role 
 * 创建日期:2017年6月5日下午6:18:30 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.entity.role;

import java.io.Serializable;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：Role    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年6月5日 下午6:18:30    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年6月5日 下午6:18:30    
 * 修改备注：       
 * @version   
 */
public class Role implements Serializable{
	private static final long serialVersionUID = 1107463506L;
	private String roleId;
	private String roleName;
	private String roleContext;
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleContext() {
		return roleContext;
	}
	public void setRoleContext(String roleContext) {
		this.roleContext = roleContext;
	}
	   
	/**    
	 * 创建一个新的实例 Role.    
	 *    
	 * @param roleId
	 * @param roleName
	 * @param roleContext  
	 */
	public Role(String roleId, String roleName, String roleContext) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleContext = roleContext;
	}
	   
	/**    
	 * 创建一个新的实例 Role.    
	 *      
	 */
	public Role() {
		super();
	}
	
}
