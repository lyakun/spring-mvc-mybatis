/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:TextProductServiceImpl.java 
 * 包名:org.lv.shop.service.product 
 * 创建日期:2017年5月22日上午11:43:09 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.service.product;

import java.util.UUID;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lv.shop.entity.product.Product;
import org.lv.shop.util.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：TextProductServiceImpl    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年5月22日 上午11:43:09    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年5月22日 上午11:43:09    
 * 修改备注：       
 * @version   
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-common.xml"})
public class TextProductServiceImpl {
	@Resource(name="productServiceImpl")
	private ProductService productService;
	/**
	 * getProductList(获取product的集合)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月22日 下午9:30:35    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月22日 下午9:30:35    
	 * 修改备注：
	 */
	@Test
	public void getProductList(){
		Product product=new Product();
		Page page=new Page();
		page.setStrat(0);
		page.setPagecount(5);
		page.setObj(product);
		productService.getProductList(page);
		System.out.println(page.getList());
	}
	/**
	 * insertProduct(product的增加方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月22日 下午9:32:46    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月22日 下午9:32:46    
	 * 修改备注：
	 */
	@Test
	public void insertProduct(){
		Product product=new Product();
		product.setProductId(UUID.randomUUID().toString());
		product.setProductName("金刚");
		product.setProductPrice(12.01);
		productService.insertProduct(product);
	}
	/**
	 * deleteProduct(product的删除方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月22日 下午9:37:22    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月22日 下午9:37:22    
	 * 修改备注：
	 */
	@Test
	public void deleteProduct(){
		productService.deleteProductById("d4215fe8-1163-4a4e-838a-6739a46480ec");
		productService.deleteFile("d4215fe8-1163-4a4e-838a-6739a46480ec");
		productService.deleteAllProductByIds("d4215fe8-1163-4a4e-838a-6739a46480ec");
	}
	/**
	 * toupdateproduct(根据product的id查出要修改的product)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月22日 下午9:40:15    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月22日 下午9:40:15    
	 * 修改备注：
	 */
	@Test
	public void toupdateproduct(){
		Product toupdateProductById = productService.toupdateProductById("");
		System.out.println(toupdateProductById);
	}
	/**
	 * updateProduct(product的修改方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月22日 下午9:41:52    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月22日 下午9:41:52    
	 * 修改备注：
	 */
	public void updateProduct(){
		Product product=new Product();
		product.setProductId("d4215fe8-1163-4a4e-838a-6739a46480ec");
		product.setProductName("你好");
		productService.updateProductById(product);
	}
}
