/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:TextBrandServiceImpl.java 
 * 包名:org.lv.shop.service.brand 
 * 创建日期:2017年5月22日下午6:27:04 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.service.brand;

import java.util.UUID;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lv.shop.entity.brand.Brand;
import org.lv.shop.util.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：TextBrandServiceImpl    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年5月22日 下午6:27:04    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年5月22日 下午6:27:04    
 * 修改备注：       
 * @version   
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-common.xml"})
public class TextBrandServiceImpl extends AbstractJUnit4SpringContextTests{
	@Resource(name="brandServiceImpl") 
	private BrandService brandService;
	private Page page=new Page();
	/**
	 * getBrandList(获取brand的集合)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月22日 下午7:09:43    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月22日 下午7:09:43    
	 * 修改备注：
	 */
	@Test
	public void getBrandList(){
		Brand brand=new Brand();
		page.setObj(brand);
		page.setStrat(0);
		page.setPagecount(5);
		brandService.getBrandList(page);
		System.out.println(page.getList());
	}
	/**
	 * insertBrand(brand的增加方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月22日 下午7:30:26    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月22日 下午7:30:26    
	 * 修改备注：
	 */
	@Test
	public void insertBrand(){
		Brand brand=new Brand();
		brand.setBrandId(UUID.randomUUID().toString());
		brand.setBrandName("白痴");
		brandService.insertBrand(brand);
	}
	/**
	 * deleteBrand(brand的删除方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月22日 下午7:32:36    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月22日 下午7:32:36    
	 * 修改备注：
	 */
	@Test
	public void deleteBrand(){
		brandService.deleteBrandById("");
	}
	/**
	 * toupdateBrand(根据Id查询出要修改的brand)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月22日 下午8:00:44    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月22日 下午8:00:44    
	 * 修改备注：
	 */
	@Test
	public void toupdateBrand(){
		//Brand updatebrand = brandService.touodateBrandPage("4d5b8a0c9f87");
		//System.out.println(updatebrand.getBrandImg());
	}
	/**
	 * updateBrand(修改方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月22日 下午8:02:34    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月22日 下午8:02:34    
	 * 修改备注：
	 */
	@Test
	public void updateBrand(){
		Brand brand=new Brand();
		brand.setBrandId("4d5b8a0c9f87");
		brand.setBrandName("你好");
		brandService.updateBrandById(brand);
	}
	
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	
}
