/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:ImgAll.java 
 * 包名:org.lv.shop.entity.product 
 * 创建日期:2017年5月20日下午5:30:35 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.entity.product;

import java.io.Serializable;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：ImgAll    
 * 类描述：    产品的相册实体类
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年5月20日 下午5:30:35    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年5月20日 下午5:30:35    
 * 修改备注：       
 * @version   
 */
public class ImgAll implements Serializable{
	private static final long serialVersionUID = -6158466591730707303L;
	private Integer imgId;   //相册表的主键
	private String productId;  //于产品表的主键逻辑相关联
	private String imgUrl;   //相册的上传后的路径
	   
	/**    
	 * 创建一个新的实例 ImgAll.    
	 *    
	 * @param imgId
	 * @param productId
	 * @param imgUrl  
	 */
	public ImgAll(Integer imgId, String productId, String imgUrl) {
		super();
		this.imgId = imgId;
		this.productId = productId;
		this.imgUrl = imgUrl;
	}

	   
	/**    
	 * 创建一个新的实例 ImgAll.    
	 *      
	 */
	public ImgAll() {
		super();
	}


	public Integer getImgId() {
		return imgId;
	}


	public void setImgId(Integer imgId) {
		this.imgId = imgId;
	}


	public String getProductId() {
		return productId;
	}


	public void setProductId(String productId) {
		this.productId = productId;
	}


	public String getImgUrl() {
		return imgUrl;
	}


	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
}
