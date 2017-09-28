/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:Product.java 
 * 包名:org.lv.shop.entity.product 
 * 创建日期:2017年5月17日下午4:20:27 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.entity.product;

import java.io.Serializable;
import java.util.Date;

import org.lv.shop.entity.brand.Brand;
import org.lv.shop.entity.desc.Desc;
import org.springframework.format.annotation.DateTimeFormat;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：Product    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年5月17日 下午4:20:27    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年5月17日 下午4:20:27    
 * 修改备注：       
 * @version   
 */
public class Product implements Serializable{
	private static final long serialVersionUID = 5366399310739142792L;
	private String productId;  //产品表的主键
	private String productName;  //产品表的名称
	private double productPrice;  //产品的价格
	private Date createtime;    //产品创建时间
	private Date updatetime;	//产品修改时间
	private String productImg;	//产品的住相册
	private int productPriceMin;	//最小价格用于区间查询
	private int productPriceMax;	//最大价格用于区间查询
	private String imgUrlArray;	//用于接受子相册的路径
	private Brand brand =new Brand();//产品
	private Integer stock;  //产品的库存
	private Integer stockWarn;//警告库存
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date minCreatetime;//最小创建时间
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date maxCreatetime;//最大创建时间
	private Integer minStock;//最小库存
	private Integer maxStock;// 最大库存
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date minUpdatetime;//最小修改时间
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date maxUpdatetime;//最大修改时间
	private Desc desc=new Desc();
	private String sort="createtime";//排序字段
	private String sortBy="desc";//排序方式
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
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
	public String getProductImg() {
		return productImg;
	}
	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}
	public int getProductPriceMin() {
		return productPriceMin;
	}
	public void setProductPriceMin(int productPriceMin) {
		this.productPriceMin = productPriceMin;
	}
	public int getProductPriceMax() {
		return productPriceMax;
	}
	public void setProductPriceMax(int productPriceMax) {
		this.productPriceMax = productPriceMax;
	}
	public String getImgUrlArray() {
		return imgUrlArray;
	}
	public void setImgUrlArray(String imgUrlArray) {
		this.imgUrlArray = imgUrlArray;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Integer getStockWarn() {
		return stockWarn;
	}
	public void setStockWarn(Integer stockWarn) {
		this.stockWarn = stockWarn;
	}
	public Date getMinCreatetime() {
		return minCreatetime;
	}
	public void setMinCreatetime(Date minCreatetime) {
		this.minCreatetime = minCreatetime;
	}
	public Date getMaxCreatetime() {
		return maxCreatetime;
	}
	public void setMaxCreatetime(Date maxCreatetime) {
		this.maxCreatetime = maxCreatetime;
	}
	public Integer getMinStock() {
		return minStock;
	}
	public void setMinStock(Integer minStock) {
		this.minStock = minStock;
	}
	public Integer getMaxStock() {
		return maxStock;
	}
	public void setMaxStock(Integer maxStock) {
		this.maxStock = maxStock;
	}
	public Date getMinUpdatetime() {
		return minUpdatetime;
	}
	public void setMinUpdatetime(Date minUpdatetime) {
		this.minUpdatetime = minUpdatetime;
	}
	public Date getMaxUpdatetime() {
		return maxUpdatetime;
	}
	public void setMaxUpdatetime(Date maxUpdatetime) {
		this.maxUpdatetime = maxUpdatetime;
	}
	public Desc getDesc() {
		return desc;
	}
	public void setDesc(Desc desc) {
		this.desc = desc;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	   
	/**    
	 * 创建一个新的实例 Product.    
	 *    
	 * @param productId
	 * @param productName
	 * @param productPrice
	 * @param createtime
	 * @param updatetime
	 * @param productImg
	 * @param productPriceMin
	 * @param productPriceMax
	 * @param imgUrlArray
	 * @param brand
	 * @param stock
	 * @param stockWarn
	 * @param minCreatetime
	 * @param maxCreatetime
	 * @param minStock
	 * @param maxStock
	 * @param minUpdatetime
	 * @param maxUpdatetime
	 * @param desc
	 * @param sort
	 * @param sortBy  
	 */
	public Product(String productId, String productName, double productPrice, Date createtime, Date updatetime,
			String productImg, int productPriceMin, int productPriceMax, String imgUrlArray, Brand brand, Integer stock,
			Integer stockWarn, Date minCreatetime, Date maxCreatetime, Integer minStock, Integer maxStock,
			Date minUpdatetime, Date maxUpdatetime, Desc desc, String sort, String sortBy) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.productImg = productImg;
		this.productPriceMin = productPriceMin;
		this.productPriceMax = productPriceMax;
		this.imgUrlArray = imgUrlArray;
		this.brand = brand;
		this.stock = stock;
		this.stockWarn = stockWarn;
		this.minCreatetime = minCreatetime;
		this.maxCreatetime = maxCreatetime;
		this.minStock = minStock;
		this.maxStock = maxStock;
		this.minUpdatetime = minUpdatetime;
		this.maxUpdatetime = maxUpdatetime;
		this.desc = desc;
		this.sort = sort;
		this.sortBy = sortBy;
	}
	   
	/**    
	 * 创建一个新的实例 Product.    
	 *      
	 */
	public Product() {
		super();
	}
	/* (non-Javadoc)    
	 * @see java.lang.Object#toString()    
	 */
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", createtime=" + createtime + ", updatetime=" + updatetime + ", productImg=" + productImg
				+ ", productPriceMin=" + productPriceMin + ", productPriceMax=" + productPriceMax + ", imgUrlArray="
				+ imgUrlArray + ", brand=" + brand + ", stock=" + stock + ", stockWarn=" + stockWarn
				+ ", minCreatetime=" + minCreatetime + ", maxCreatetime=" + maxCreatetime + ", minStock=" + minStock
				+ ", maxStock=" + maxStock + ", minUpdatetime=" + minUpdatetime + ", maxUpdatetime=" + maxUpdatetime
				+ ", desc=" + desc + ", sort=" + sort + ", sortBy=" + sortBy + "]";
	}
	
	
	
	
	
}
