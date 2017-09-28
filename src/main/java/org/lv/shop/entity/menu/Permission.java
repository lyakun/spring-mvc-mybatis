/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:Perimission.java 
 * 包名:org.lv.shop.entity.menu 
 * 创建日期:2017年6月21日下午4:00:31 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.entity.menu;

import java.io.Serializable;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：Perimission    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年6月21日 下午4:00:31    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年6月21日 下午4:00:31    
 * 修改备注：       
 * @version   
 */
public class Permission implements Serializable{
	private String perId;
	private String userId;
	private int menuId;
	   
	/**    
	 * 创建一个新的实例 Permission.    
	 *    
	 * @param perId
	 * @param userId
	 * @param menuId  
	 */
	public Permission(String perId, String userId, int menuId) {
		super();
		this.perId = perId;
		this.userId = userId;
		this.menuId = menuId;
	}

	public String getPerId() {
		return perId;
	}

	public void setPerId(String perId) {
		this.perId = perId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	   
	/**    
	 * 创建一个新的实例 Permission.    
	 *      
	 */
	public Permission() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
