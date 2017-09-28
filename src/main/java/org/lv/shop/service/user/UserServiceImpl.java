/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:UserServiceImpl.java 
 * 包名:org.lv.shop.service.user 
 * 创建日期:2017年5月31日下午8:12:17 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.service.user;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.lv.shop.entity.menu.Menu;
import org.lv.shop.entity.menu.Permission;
import org.lv.shop.entity.user.RoleR;
import org.lv.shop.entity.user.User;
import org.lv.shop.mapper.user.UserMapper;
import org.lv.shop.util.Md5Util;
import org.lv.shop.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：UserServiceImpl    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年5月31日 下午8:12:17    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年5月31日 下午8:12:17    
 * 修改备注：       
 * @version   
 */
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private  UserMapper userMapper;

	/* (non-Javadoc)    
	 * @see org.lv.shop.service.user.UserService#insertUser(org.lv.shop.entity.user.User)    
	 */
	@Override
	public void insertUser(User user) {
		user.setUserId(UUID.randomUUID().toString());
		String password = Md5Util.jiami(user.getUserPassWord());
	    user.setUserPassWord(password);
		userMapper.insertUser(user);
	}

	/* (non-Javadoc)    
	 * @see org.lv.shop.service.user.UserService#getUserList(org.lv.shop.util.Page)    
	 */
	@Override
	public void getUserList(Page page) {
		List<User> list=userMapper.getUserList(page);
		int count=userMapper.getUserCount(page);
		page.setList(list);
		page.setPagesumcount(count);
	}

	/* (non-Javadoc)    
	 * @see org.lv.shop.service.user.UserService#deleteUserByUserId(org.lv.shop.entity.user.User)    
	 */
	@Override
	public void deleteUserByUserId(User user) {
		userMapper.deleteUserByUserId(user.getUserId());
	}

	/* (non-Javadoc)    
	 * @see org.lv.shop.service.user.UserService#toupdateUserById(org.lv.shop.entity.user.User)    
	 */
	@Override
	public User toupdateUserById(User user) {
		return userMapper.toupdateUserById(user.getUserId());
	}

	/* (non-Javadoc)    
	 * @see org.lv.shop.service.user.UserService#updateUser(org.lv.shop.entity.user.User)    
	 */
	@Override
	public void updateUser(User user) {
		userMapper.updateUser(user);
	}

	/* (non-Javadoc)    
	 * @see org.lv.shop.service.user.UserService#userLogin(org.lv.shop.entity.user.User)    
	 */
	@Override
	public int userLogin(User user,HttpServletRequest request) {
		String password = Md5Util.jiami(user.getUserPassWord());
	    user.setUserPassWord(password);
		User u=userMapper.userLogin(user);
		if(null!=u){
			HttpSession session = request.getSession();
			session.setAttribute("u", u);
			return 1;
		}
		else{
			return 0;
		}
	}

	/* (non-Javadoc)    
	 * @see org.lv.shop.service.user.UserService#getRoleList(java.lang.String)    
	 */
	@Override
	public List<RoleR> getRoleList(String userId) {
		return userMapper.getRoleList(userId);
	}

	/* (non-Javadoc)    
	 * @see org.lv.shop.service.user.UserService#getMenuList(java.lang.String)    
	 */
	@Override
	public List<Menu> getMenuList(String roleId) {
		return userMapper.getMenuList(roleId);
	}

	/* (non-Javadoc)    
	 * @see org.lv.shop.service.user.UserService#getUserByUserName(java.lang.String)    
	 */
	@Override
	public User getUserByUserName(String userName) {
		return userMapper.getUserByUserName(userName);
	}
}
