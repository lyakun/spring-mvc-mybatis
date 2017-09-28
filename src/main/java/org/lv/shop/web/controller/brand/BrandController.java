/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:BrandController.java 
 * 包名:org.lv.shop.web.controller.brand 
 * 创建日期:2017年5月19日下午8:32:38 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.web.controller.brand;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.lv.shop.entity.brand.Brand;
import org.lv.shop.service.brand.BrandService;
import org.lv.shop.util.FileUpload;
import org.lv.shop.util.JsonUtil;
import org.lv.shop.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：BrandController    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年5月19日 下午8:32:38    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年5月19日 下午8:32:38    
 * 修改备注：       
 * @version   
 */
@Controller
@RequestMapping("brand")
public class BrandController {
	@Autowired
	private BrandService brandService;
	private Page page=new Page();
	/**
	 * getBrandPage(跳转品牌查询页面)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月21日 上午10:06:53    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月21日 上午10:06:53    
	 * 修改备注： 
	 * @return
	 */
	@RequestMapping("getBrandPage")
	public String getBrandPage(){
		return"brand/brand_list_page";
	}
	/**
	 * getBrandList(获取品牌集合)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月21日 上午10:07:23    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月21日 上午10:07:23    
	 * 修改备注： 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getBrandList")
	public String getBrandList(Brand brand,Integer offset,Integer limit){
		page.setStrat(offset);
		page.setPagecount(limit);
		page.setObj(brand);
		brandService.getBrandList(page);
		Map map=new HashMap();
		map.put("total", page.getPagesumcount());
		map.put("rows", page.getList());
		Gson gson=new Gson();
		String json = gson.toJson(map);
		return json;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	/**
	 * getAddBrandPage(跳转brand的增加页面)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月21日 上午10:31:15    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月21日 上午10:31:15    
	 * 修改备注： 
	 * @return
	 */
	@RequestMapping("getAddBrandPage")
	public String getAddBrandPage(){
		return "brand/add_brand_page";
	}
	/**
	 * insertBrand(brand的增加方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月21日 上午10:32:20    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月21日 上午10:32:20    
	 * 修改备注： 
	 * @param brand
	 * @return
	 */
	@RequestMapping("insertBrand")
	public String insertBrand( Brand brand){
		brandService.insertBrand(brand);
		return "redirect:/brand/getBrandPage.gang";
	}
	/**
	 * uplodBrandImg(brand的图片上传方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月21日 上午10:41:05    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月21日 上午10:41:05    
	 * 修改备注： 
	 * @param imgfile
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("uplodBrandImg")
	public String uplodBrandImg(@RequestParam("imgfile")MultipartFile imgfile,HttpServletRequest request){
		Map map=new HashMap();
		String imgUrl=null;
		try {
			imgUrl=FileUpload.uploadFile(imgfile, request);
		} catch (IOException e) {
			e.printStackTrace();
		}
		map.put("img", imgUrl);
		Gson gson=new Gson();
		String str=gson.toJson(map);
		return str;
	}
	/**
	 * deleteBrandById(根据Id删除Brand)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月21日 上午11:01:41    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月21日 上午11:01:41    
	 * 修改备注： 
	 * @param id
	 * @param response
	 */
	@RequestMapping("deleteBrandById")
	public void deleteBrandById(String id, HttpServletResponse response){
		Map map=new HashMap();
		brandService.deleteBrandById(id);
		map.put("stratus","ok");
		JsonUtil.outJson(map, response);
	}
	
	/**
	 * updateBrandById(修改方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月21日 下午1:42:31    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月21日 下午1:42:31    
	 * 修改备注： 
	 * @return
	 */
	@RequestMapping("updateBrandById")
	public String updateBrandById(Brand brand){
		brandService.updateBrandById(brand);
		return "redirect:/brand/getBrandPage.gang";
	}
	/**
	 * deleteAllBrandtByIds(brand的批量删除方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月21日 下午1:53:08    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月21日 下午1:53:08    
	 * 修改备注：
	 * @param response 
	 */
	@RequestMapping("deleteAllBrandtByIds")
	public void deleteAllBrandtByIds(String id, HttpServletResponse response){
		Map map=new HashMap();
		brandService.deleteAllBrandtByIds(id);
		map.put("stratus","ok");
		JsonUtil.outJson(map, response);
	}
	/**
	 * exportExcel(导出Excel方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月24日 下午7:16:51    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月24日 下午7:16:51    
	 * 修改备注：
	 */
	@RequestMapping("exportExcel")
	public void exportExcel(HttpServletResponse response){
			HSSFWorkbook workbook=brandService.exportExcel();
			try {
				OutputStream outputStream = response.getOutputStream();
				response.reset();
				response.setHeader("Content-disposition", "attachment; filename=gang.xls");
				response.setContentType("application/msexcel");
				workbook.write(outputStream);
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	/**
	 * toupdateBrandImgById(跳转品牌表的批量修改的页面)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月25日 下午11:50:21    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月25日 下午11:50:21    
	 * 修改备注： 
	 * @param id
	 * @return
	 */
	@RequestMapping("toupdateBrandImgById")
	public String toupdateBrandImgById(String id,ModelMap map){
		List<Brand> brandList=brandService.toupdateBrandImgById(id);
		map.put("brandList",brandList);
		return "brand/update_brand_page";
	}
}
