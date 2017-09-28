/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:Log.java 
 * 包名:org.lv.shop.entity.log 
 * 创建日期:2017年6月6日下午12:21:29 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.entity.log;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：Log    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年6月6日 下午12:21:29    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年6月6日 下午12:21:29    
 * 修改备注：       
 * @version   
 */
public class Log implements Serializable{
	private static final long serialVersionUID = 1307951170836250005L;
	private String logId;//日志主键
	private int logType;//日志类型
	private String logContext;//日志内容
	private Date createTime;//日志创建时间
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date maxTime;//最大时间用于区间查询
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date minTime;//最小时间用于区间查询
	private String url;//当前请求的url
	private long excatueTime;//当前方法效率
	private String parame;//请求参数
	
	public String getParame() {
		return parame;
	}
	public void setParame(String parame) {
		this.parame = parame;
	}
	public long getExcatueTime() {
		return excatueTime;
	}
	public void setExcatueTime(long excatueTime) {
		this.excatueTime = excatueTime;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getLogId() {
		return logId;
	}
	public void setLogId(String logId) {
		this.logId = logId;
	}
	public int getLogType() {
		return logType;
	}
	public void setLogType(int logType) {
		this.logType = logType;
	}
	public String getLogContext() {
		return logContext;
	}
	public void setLogContext(String logContext) {
		this.logContext = logContext;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getMaxTime() {
		return maxTime;
	}
	public void setMaxTime(Date maxTime) {
		this.maxTime = maxTime;
	}
	public Date getMinTime() {
		return minTime;
	}
	public void setMinTime(Date minTime) {
		this.minTime = minTime;
	}
	   
	/**    
	 * 创建一个新的实例 Log.    
	 *    
	 * @param logId
	 * @param logType
	 * @param logContext
	 * @param createTime
	 * @param maxTime
	 * @param minTime  
	 */
	public Log(String logId, int logType, String logContext, Date createTime, Date maxTime, Date minTime) {
		super();
		this.logId = logId;
		this.logType = logType;
		this.logContext = logContext;
		this.createTime = createTime;
		this.maxTime = maxTime;
		this.minTime = minTime;
	}
	   
	/**    
	 * 创建一个新的实例 Log.    
	 *      
	 */
	public Log() {
		super();
	}
	
	
}
