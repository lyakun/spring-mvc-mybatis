/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:Article.java 
 * 包名:org.lv.shop.entity.article 
 * 创建日期:2017年6月1日下午6:44:13 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.entity.article;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：Article    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年6月1日 下午6:44:13    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年6月1日 下午6:44:13    
 * 修改备注：       
 * @version   
 */
public class Article implements Serializable{

	private static final long serialVersionUID = 7129028981828639496L;
	private String articleId;  //主键
	private String articleName;   //文章标题
	private String articleContext;   //文章内容
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date articleCreateDateTime;  //创房时间
	private String founder;  //创建人
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	public String getArticleName() {
		return articleName;
	}
	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}
	public String getArticleContext() {
		return articleContext;
	}
	public void setArticleContext(String articleContext) {
		this.articleContext = articleContext;
	}
	public Date getArticleCreateDateTime() {
		return articleCreateDateTime;
	}
	public void setArticleCreateDateTime(Date articleCreateDateTime) {
		this.articleCreateDateTime = articleCreateDateTime;
	}
	public String getFounder() {
		return founder;
	}
	public void setFounder(String founder) {
		this.founder = founder;
	}
	   
	/**    
	 * 创建一个新的实例 Article.    
	 *    
	 * @param articleId
	 * @param articleName
	 * @param articleContext
	 * @param articleCreateDateTime
	 * @param founder  
	 */
	public Article(String articleId, String articleName, String articleContext, Date articleCreateDateTime,
			String founder) {
		super();
		this.articleId = articleId;
		this.articleName = articleName;
		this.articleContext = articleContext;
		this.articleCreateDateTime = articleCreateDateTime;
		this.founder = founder;
	}
	   
	/**    
	 * 创建一个新的实例 Article.    
	 *      
	 */
	public Article() {
		super();
	}
	/* (non-Javadoc)    
	 * @see java.lang.Object#toString()    
	 */
	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", articleName=" + articleName + ", articleContext=" + articleContext
				+ ", articleCreateDateTime=" + articleCreateDateTime + ", founder=" + founder + "]";
	}
	
}
