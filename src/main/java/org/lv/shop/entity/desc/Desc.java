/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:Desc.java 
 * 包名:org.lv.shop.entity.desc 
 * 创建日期:2017年5月28日上午11:01:50 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.entity.desc;

import java.io.Serializable;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：Desc    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年5月28日 上午11:01:50    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年5月28日 上午11:01:50    
 * 修改备注：       
 * @version   
 */
public class Desc implements Serializable{
	private static final long serialVersionUID = 4712497107585240838L;
	private String id;
	private String productDesc;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	   
	/**    
	 * 创建一个新的实例 Desc.    
	 *    
	 * @param id
	 * @param productDesc  
	 */
	public Desc(String id, String productDesc) {
		super();
		this.id = id;
		this.productDesc = productDesc;
	}
	   
	/**    
	 * 创建一个新的实例 Desc.    
	 *      
	 */
	public Desc() {
		super();
	}
	
}
