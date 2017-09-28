/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:BrandController.java 
 * 包名:org.lv.shop.entity.brand 
 * 创建日期:2017年5月19日下午8:31:13 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.entity.brand;

import java.io.Serializable;
import java.util.Date;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：BrandController    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年5月19日 下午8:31:13    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年5月19日 下午8:31:13    
 * 修改备注：       
 * @version   
 */
public class Brand implements Serializable{
	private static final long serialVersionUID = -7167644756009115632L;
	private String brandId;	//品牌表的主键
	private String brandName;	//品牌名称
	private Date createtime;	//品牌的创建时间
	private Date updatetime;	//品牌的修改时间
	private String brandImg;	//品牌的头像
	
	   
	public String getBrandImg() {
		return brandImg;
	}


	public void setBrandImg(String brandImg) {
		this.brandImg = brandImg;
	}


	/**    
	 * 创建一个新的实例 Brand.    
	 *    
	 * @param brandId
	 * @param brandName
	 * @param createtime
	 * @param updatetime  
	 */
	public Brand(String brandId, String brandName, Date createtime, Date updatetime) {
		super();
		this.brandId = brandId;
		this.brandName = brandName;
		this.createtime = createtime;
		this.updatetime = updatetime;
	}

	   
	/**    
	 * 创建一个新的实例 Brand.    
	 *      
	 */
	public Brand() {
		super();
	}


	public String getBrandId() {
		return brandId;
	}


	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}


	public String getBrandName() {
		return brandName;
	}


	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}


	public Date getCreatetime() {
		return createtime;
	}


	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


	public Date getUpdatetime() {
		return updatetime;
	}


	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	
}
