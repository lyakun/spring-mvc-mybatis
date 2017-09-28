/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:UserMapper.java 
 * 包名:org.lv.shop.mapper.user 
 * 创建日期:2017年5月31日下午8:13:39 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.mapper.user;

import java.util.List;

import org.lv.shop.entity.menu.Menu;
import org.lv.shop.entity.menu.Permission;
import org.lv.shop.entity.user.RoleR;
import org.lv.shop.entity.user.User;
import org.lv.shop.util.Page;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：UserMapper    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年5月31日 下午8:13:39    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年5月31日 下午8:13:39    
 * 修改备注：       
 * @version   
 */
public interface UserMapper {

	/** insertUser(用户的增加方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月31日 下午9:07:37    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月31日 下午9:07:37    
	 * 修改备注： 
	 * @param user  
	 */
	void insertUser(User user);

	/** getUserList(查询用户列表)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月31日 下午9:44:29    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月31日 下午9:44:29    
	 * 修改备注： 
	 * @param page
	 * @return  
	 */
	List<User> getUserList(Page page);

	/** getUserCount(查询总条数)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月31日 下午9:45:27    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月31日 下午9:45:27    
	 * 修改备注： 
	 * @param page
	 * @return  
	 */
	int getUserCount(Page page);

	/** deleteUserByUserId(用户的删除方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月31日 下午11:12:16    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月31日 下午11:12:16    
	 * 修改备注： 
	 * @param userId  
	 */
	void deleteUserByUserId(String userId);

	/** toupdateUserById(根据id查询要修改的用户)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月31日 下午11:19:19    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月31日 下午11:19:19    
	 * 修改备注： 
	 * @param userId
	 * @return  
	 */
	User toupdateUserById(String userId);

	/** updateUser(保存修改)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月31日 下午11:27:53    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月31日 下午11:27:53    
	 * 修改备注： 
	 * @param user  
	 */
	void updateUser(User user);

	/** userLogin(用户登录)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月3日 上午9:05:19    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月3日 上午9:05:19    
	 * 修改备注： 
	 * @param user
	 * @return  
	 */
	User userLogin(User user);

	/** getRoleList(这里用一句话描述这个方法的作用)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月21日 下午6:23:17    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月21日 下午6:23:17    
	 * 修改备注： 
	 * @param userId
	 * @return  
	 */
	List<RoleR> getRoleList(String userId);

	/** getMenuList(这里用一句话描述这个方法的作用)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月21日 下午6:39:24    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月21日 下午6:39:24    
	 * 修改备注： 
	 * @param roleId
	 * @return  
	 */
	List<Menu> getMenuList(String roleId);

	/** getUserByUserName(这里用一句话描述这个方法的作用)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月21日 下午7:17:10    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月21日 下午7:17:10    
	 * 修改备注： 
	 * @param userName
	 * @return  
	 */
	User getUserByUserName(String userName);


}
