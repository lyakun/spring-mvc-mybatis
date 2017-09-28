/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:RoleMapper.java 
 * 包名:org.lv.shop.mapper.role 
 * 创建日期:2017年6月5日下午6:19:41 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.mapper.role;

import java.util.List;

import org.lv.shop.entity.role.Role;
import org.lv.shop.util.Page;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：RoleMapper    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年6月5日 下午6:19:41    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年6月5日 下午6:19:41    
 * 修改备注：       
 * @version   
 */
public interface RoleMapper {
	 public abstract List<Role> getRoleList(Page paramPage);

	  public abstract int getRoleListCount(Page paramPage);

	  public abstract void insertRole(Role paramRole);
}
