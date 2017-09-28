/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:Notice.java 
 * 包名:org.lv.shop.entity.notice 
 * 创建日期:2017年5月28日上午11:41:28 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.entity.notice;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：Notice    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年5月28日 上午11:41:28    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年5月28日 上午11:41:28    
 * 修改备注：       
 * @version   
 */
public class Notice implements Serializable{
	private static final long serialVersionUID = 5325953741284090768L;
	private String noticeId;//公告主键
	private String noticeName;//公告标题
	private String noticeContext;//公告内荣
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date noticeCreateTime;//公告开始时间
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date noticeEndTime;//公告结束时间
	private Integer noticeStatus;//公告状态 1:正常 0:停用
	private Integer noticeValidatorStatus;//公告审核状态 1：审核通过，0:待审核， 2:审核未通过
	public String getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
	}
	public String getNoticeName() {
		return noticeName;
	}
	public void setNoticeName(String noticeName) {
		this.noticeName = noticeName;
	}
	public String getNoticeContext() {
		return noticeContext;
	}
	public void setNoticeContext(String noticeContext) {
		this.noticeContext = noticeContext;
	}
	public Date getNoticeCreateTime() {
		return noticeCreateTime;
	}
	public void setNoticeCreateTime(Date noticeCreateTime) {
		this.noticeCreateTime = noticeCreateTime;
	}
	public Date getNoticeEndTime() {
		return noticeEndTime;
	}
	public void setNoticeEndTime(Date noticeEndTime) {
		this.noticeEndTime = noticeEndTime;
	}
	public Integer getNoticeStatus() {
		return noticeStatus;
	}
	public void setNoticeStatus(Integer noticeStatus) {
		this.noticeStatus = noticeStatus;
	}
	public Integer getNoticeValidatorStatus() {
		return noticeValidatorStatus;
	}
	public void setNoticeValidatorStatus(Integer noticeValidatorStatus) {
		this.noticeValidatorStatus = noticeValidatorStatus;
	}
	   
	/**    
	 * 创建一个新的实例 Notice.    
	 *    
	 * @param noticeId
	 * @param noticeName
	 * @param noticeContext
	 * @param noticeCreateTime
	 * @param noticeEndTime
	 * @param noticeStatus
	 * @param noticeValidatorStatus  
	 */
	public Notice(String noticeId, String noticeName, String noticeContext, Date noticeCreateTime, Date noticeEndTime,
			Integer noticeStatus, Integer noticeValidatorStatus) {
		super();
		this.noticeId = noticeId;
		this.noticeName = noticeName;
		this.noticeContext = noticeContext;
		this.noticeCreateTime = noticeCreateTime;
		this.noticeEndTime = noticeEndTime;
		this.noticeStatus = noticeStatus;
		this.noticeValidatorStatus = noticeValidatorStatus;
	}
	   
	/**    
	 * 创建一个新的实例 Notice.    
	 *      
	 */
	public Notice() {
		super();
	}
	
	
	
}
