/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:UserRole.java 
 * 包名:org.lv.shop.entity.user 
 * 创建日期:2017年6月21日下午5:04:32 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.entity.user;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：UserRole    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年6月21日 下午5:04:32    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年6月21日 下午5:04:32    
 * 修改备注：       
 * @version   
 */
public class UserRole {
	private int urId;
	private String userId;
	private int roleId;
	public int getUrId() {
		return urId;
	}
	public void setUrId(int urId) {
		this.urId = urId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	   
	/**    
	 * 创建一个新的实例 UserRole.    
	 *    
	 * @param urId
	 * @param userId
	 * @param roleId  
	 */
	public UserRole(int urId, String userId, int roleId) {
		super();
		this.urId = urId;
		this.userId = userId;
		this.roleId = roleId;
	}
	   
	/**    
	 * 创建一个新的实例 UserRole.    
	 *      
	 */
	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
