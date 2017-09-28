/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:UserController.java 
 * 包名:org.lv.shop.web.controller.user 
 * 创建日期:2017年5月31日下午8:11:26 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.web.controller.user;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.lv.shop.entity.user.User;
import org.lv.shop.service.user.UserService;
import org.lv.shop.util.FileUpload;
import org.lv.shop.util.JsonUtil;
import org.lv.shop.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：UserController    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年5月31日 下午8:11:26    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年5月31日 下午8:11:26    
 * 修改备注：       
 * @version   
 */
@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;
	/**
	 * getUserListPage(跳转用户列表页面)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月31日 下午8:20:59    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月31日 下午8:20:59    
	 * 修改备注： 
	 * @return
	 */
	@RequestMapping("getUserListPage")
	public String getUserListPage(){
		return "user/user_list_page";
	}
	/**
	 * toUserAddPage(跳转用户增加页面)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月31日 下午8:51:06    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月31日 下午8:51:06    
	 * 修改备注： 
	 * @return
	 */
	@RequestMapping("toUserAddPage")
	public String toUserAddPage(){
		return "user/user_add_page";
	}
	/**
	 * insertUser(用户增加方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月31日 下午9:03:38    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月31日 下午9:03:38    
	 * 修改备注： 
	 * @return
	 */
	@RequestMapping("insertUser")
	public String insertUser(User user){
		userService.insertUser(user);
		return "../../login";
	}
	/**
	 * getUserList(获取用户列表)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月31日 下午9:37:39    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月31日 下午9:37:39    
	 * 修改备注：
	 * @param response 
	 */
	@RequestMapping("getUserList")
	public void getUserList(Integer offset,Integer limit,User user, HttpServletResponse response){
		page.setStrat(offset);
		page.setPagecount(limit);
		page.setObj(user);
		userService.getUserList(page);
		Map map=new HashMap();
		map.put("total",page.getPagesumcount());
		map.put("rows", page.getList());
		String str = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd");
		JsonUtil.outJson(str, response);
	}
	private Page page=new Page();
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	/**
	 * deleteUserByUserId(用的删除方法根据id)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月31日 下午11:07:30    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月31日 下午11:07:30    
	 * 修改备注：
	 * @param response 
	 */
	@RequestMapping("deleteUserByUserId")
	public void deleteUserByUserId(User user, HttpServletResponse response){
		userService.deleteUserByUserId(user);
		JsonUtil.outJson("1", response);
	}
	/**
	 * toupdateUserPage(跳转用户修改页面)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月31日 下午11:15:59    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月31日 下午11:15:59    
	 * 修改备注： 
	 * @param user
	 * @param map
	 * @return
	 */
	@RequestMapping("toupdateUserPage")
	public String toupdateUserPage(User user,ModelMap map){
		User u=userService.toupdateUserById(user);
		map.put("user",u);
		return "user/user_update_page";
	}
	/**
	 * updateUser(保存修改)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月31日 下午11:25:47    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月31日 下午11:25:47    
	 * 修改备注： 
	 * @param response 
	 * @return
	 */
	@RequestMapping("updateUser")
	public String updateUser(User user, HttpServletResponse response){
		userService.updateUser(user);
		return "redirect:/user/getUserListPage.gang";
	}
	/**
	 * uplodUserImg(用户的头像上传方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月1日 下午1:52:20    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月1日 下午1:52:20    
	 * 修改备注： 
	 * @param imgfile
	 * @param request
	 * @param response
	 */
	@RequestMapping("uplodUserImg")
	public void uplodUserImg(@RequestParam("imgfile")MultipartFile imgfile, HttpServletRequest request, HttpServletResponse response){
		String uploadFile;
		Map map=new HashMap();
		try {
			uploadFile = FileUpload.uploadFile(imgfile, request);
			map.put("img", uploadFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JsonUtil.outJson(map, response);
	}
	/**
	 * userLogin(登录方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月3日 上午9:03:02    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月3日 上午9:03:02    
	 * 修改备注：
	 * @param response 
	 * @param map 
	 */
	@RequestMapping("userLogin")
	public void userLogin(User user,HttpServletRequest request, HttpServletResponse response){
		String code = (String)request.getSession().getAttribute("code");
		if(!code.equals(user.getImgCode())){
			JsonUtil.outJson("验证码错误", response);
		}else{
			//通过用户名密码拿到令牌
			UsernamePasswordToken token=new UsernamePasswordToken(user.getLoggerName(),user.getUserPassWord());
			//获取当前用户
			Subject subject=SecurityUtils.getSubject();
			//身份认证
			try{
				token.setRememberMe(true);
				//拿着令牌去登录
				subject.login(token);
				if(subject.isAuthenticated()){
					//吧验证通过的用户放到session中
					User u = (User)subject.getPrincipal();
					subject.getSession().setAttribute("user",u);
					JsonUtil.outJson(1, response);
				}else{
					JsonUtil.outJson(0, response);
				}
				//boolean permitted = subject.isPermitted("user:list");
			}catch(AuthenticationException e){
			}
		}
	}
	/**
	 * getIndexPage(跳转index页面)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月3日 上午9:14:15    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月3日 上午9:14:15    
	 * 修改备注： 
	 * @return
	 */
	@RequestMapping("getIndexPage")
	public String getIndexPage(){
		return "../../index";
	}
	/**
	 * logout(注销方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月22日 下午4:46:48    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月22日 下午4:46:48    
	 * 修改备注： 
	 * @return
	 */
	@RequestMapping("logout")
	public String logout(){
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:/";
	}
	/**
	 * toupdateUserRolePageByUserId(跳转用户赋角色页面)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月23日 下午7:57:00    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月23日 下午7:57:00    
	 * 修改备注： 
	 * @return
	 */
	@RequestMapping("toupdateUserRolePageByUserId")
	public String toupdateUserRolePageByUserId(User user,ModelMap map){
		map.put("userId",user.getUserId());
		return "user/user_role_page";
	}
	/**
	 * toupdateRolePageByUserId(跳转角色赋权限页面)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月24日 上午9:52:05    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月24日 上午9:52:05    
	 * 修改备注： 
	 * @return
	 */
	@RequestMapping("toupdateRolePageByUserId")
	public String toupdateRolePageByUserId(User user,ModelMap map){
		map.put("userId",user.getUserId());
		return "role/role_menu_page";
	}
}
