/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:UserService.java 
 * 包名:org.lv.shop.service.user 
 * 创建日期:2017年5月31日下午8:12:03 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.service.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.lv.shop.entity.menu.Menu;
import org.lv.shop.entity.menu.Permission;
import org.lv.shop.entity.user.RoleR;
import org.lv.shop.entity.user.User;
import org.lv.shop.util.Page;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：UserService    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年5月31日 下午8:12:03    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年5月31日 下午8:12:03    
 * 修改备注：       
 * @version   
 */
public interface UserService {

	/** insertUser(用户增加方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月31日 下午9:05:53    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月31日 下午9:05:53    
	 * 修改备注： 
	 * @param user  
	 */
	void insertUser(User user);

	/** getUserList(查询用户列表并分页)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月31日 下午9:43:35    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月31日 下午9:43:35    
	 * 修改备注： 
	 * @param page  
	 */
	void getUserList(Page page);

	/** deleteUserByUserId(用户的删除方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月31日 下午11:11:27    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月31日 下午11:11:27    
	 * 修改备注： 
	 * @param user  
	 */
	void deleteUserByUserId(User user);

	/** toupdateUserById(根据id查询要修改的用户)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月31日 下午11:18:31    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月31日 下午11:18:31    
	 * 修改备注： 
	 * @param user
	 * @return  
	 */
	User toupdateUserById(User user);

	/** updateUser(保存修改)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月31日 下午11:27:18    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月31日 下午11:27:18    
	 * 修改备注： 
	 * @param user  
	 */
	void updateUser(User user);

	/** userLogin(登录方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月3日 上午9:04:34    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月3日 上午9:04:34    
	 * 修改备注： 
	 * @param user
	 * @param request 
	 * @return  
	 */
	int userLogin(User user, HttpServletRequest request);

	/** getRoleList(这里用一句话描述这个方法的作用)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月21日 下午5:55:23    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月21日 下午5:55:23    
	 * 修改备注： 
	 * @param userId
	 * @return  
	 */
	List<RoleR> getRoleList(String userId);

	/** getMenuList(这里用一句话描述这个方法的作用)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月21日 下午6:38:33    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月21日 下午6:38:33    
	 * 修改备注： 
	 * @param roleId
	 * @return  
	 */
	List<Menu> getMenuList(String roleId);

	/** getUserByUserName(这里用一句话描述这个方法的作用)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月21日 下午7:16:28    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月21日 下午7:16:28    
	 * 修改备注： 
	 * @param userName
	 * @return  
	 */
	User getUserByUserName(String userName);



}
