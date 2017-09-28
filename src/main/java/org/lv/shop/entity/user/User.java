/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:User.java 
 * 包名:org.lv.shop.entity.user 
 * 创建日期:2017年5月31日下午8:13:52 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.entity.user;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：User    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年5月31日 下午8:13:52    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年5月31日 下午8:13:52    
 * 修改备注：       
 * @version   
 */
public class User implements Serializable{

	private static final long serialVersionUID = -8187262806893853721L;
	private String userId;//主键
	private String userName;//用户真实姓名
	private String loggerName;//登录名称
	private String userPassWord;//密码
	private Integer userSex;//性别
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date userBir;//个人生日
	private String userImg;//个人头像
	private String userEime;//个人邮箱
	private String userPhone;//个人手机号
	private String imgCode;//验证码
	
	public String getImgCode() {
		return imgCode;
	}
	public void setImgCode(String imgCode) {
		this.imgCode = imgCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLoggerName() {
		return loggerName;
	}
	public void setLoggerName(String loggerName) {
		this.loggerName = loggerName;
	}
	
	public String getUserPassWord() {
		return userPassWord;
	}
	public void setUserPassWord(String userPassWord) {
		this.userPassWord = userPassWord;
	}
	public Integer getUserSex() {
		return userSex;
	}
	public void setUserSex(Integer userSex) {
		this.userSex = userSex;
	}
	public Date getUserBir() {
		return userBir;
	}
	public void setUserBir(Date userBir) {
		this.userBir = userBir;
	}
	public String getUserImg() {
		return userImg;
	}
	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}
	public String getUserEime() {
		return userEime;
	}
	public void setUserEime(String userEime) {
		this.userEime = userEime;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	
	
	   
	   
	/**    
	 * 创建一个新的实例 User.    
	 *    
	 * @param userId
	 * @param userName
	 * @param loggerName
	 * @param userPassWord
	 * @param userSex
	 * @param userBir
	 * @param userImg
	 * @param userEime
	 * @param userPhone  
	 */
	public User(String userId, String userName, String loggerName, String userPassWord, Integer userSex, Date userBir,
			String userImg, String userEime, String userPhone) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.loggerName = loggerName;
		this.userPassWord = userPassWord;
		this.userSex = userSex;
		this.userBir = userBir;
		this.userImg = userImg;
		this.userEime = userEime;
		this.userPhone = userPhone;
	}
	/**    
	 * 创建一个新的实例 User.    
	 *      
	 */
	public User() {
		super();
	}
	/* (non-Javadoc)    
	 * @see java.lang.Object#toString()    
	 */
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", loggerName=" + loggerName + ", userPass="
				+ userPassWord + ", userSex=" + userSex + ", userBir=" + userBir + ", userImg=" + userImg + ", userEime="
				+ userEime + ", userPhone=" + userPhone + "]";
	}
	

}
