/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:Role.java 
 * 包名:org.lv.shop.entity.user 
 * 创建日期:2017年6月21日下午5:06:01 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.entity.user;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：Role    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年6月21日 下午5:06:01    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年6月21日 下午5:06:01    
 * 修改备注：       
 * @version   
 */
public class RoleR {
	private String roleId;
	private String roleName;
	   
	/**    
	 * 创建一个新的实例 Role.    
	 *    
	 * @param roleId
	 * @param roleName  
	 */
	public RoleR(String roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}

	   
	/**    
	 * 创建一个新的实例 Role.    
	 *      
	 */
	public RoleR() {
		super();
		// TODO Auto-generated constructor stub
	}


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
	
}
