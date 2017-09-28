/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:BrandService.java 
 * 包名:org.lv.shop.service.brand 
 * 创建日期:2017年5月19日下午8:31:47 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  

package org.lv.shop.service.brand;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.lv.shop.entity.brand.Brand;
import org.lv.shop.entity.menu.Menu;
import org.lv.shop.mapper.brand.BrandMapper;
import org.lv.shop.util.CacheManager;
import org.lv.shop.util.Page;
import org.lv.shop.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：BrandService    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年5月19日 下午8:31:47    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年5月19日 下午8:31:47    
 * 修改备注：       
 * @version   
 */
@Service
public class BrandServiceImpl implements BrandService{
	@Autowired
	private BrandMapper brandMapper;
	private static JedisCluster jedis=new JedisCluster(new HostAndPort("192.168.1.156",6379));
	

	/* (non-Javadoc)    
	 * @see org.lv.shop.service.brand.BrandService#getBrandList(org.lv.shop.util.Page)    
	 */
	@Override
	public void getBrandList(Page page) {
		List list=brandMapper.getBrandList(page);
		page.setList(list);
		int count=brandMapper.getBrandListCount(page);
		page.setPagesumcount(count);
	}

	/* (non-Javadoc)    
	 * @see org.lv.shop.service.brand.BrandService#insertBrand(org.lv.shop.entity.brand.Brand)    
	 */
	@Override
	public void insertBrand(Brand brand) {
		brand.setBrandId(UUID.randomUUID().toString());
		String[] brandName=brand.getBrandName().split(",");
		String[] brandImg=brand.getBrandImg().split(",");
		for (int i = 0; i < brandImg.length; i++) {
			Date date=new Date();
			brand.setCreatetime(date);
			brand.setUpdatetime(date);
			brand.setBrandId(UUID.randomUUID().toString());
			brand.setBrandName(brandName[i]);
			brand.setBrandImg(brandImg[i]);
			brandMapper.insertBrand(brand);
		}
		jedis.del("brandList");
	}

	/* (non-Javadoc)    
	 * @see org.lv.shop.service.brand.BrandService#deleteBrandById(java.lang.String)    
	 */
	@Override
	public void deleteBrandById(String id) {
		brandMapper.deleteBrandById(id);
	}

	/* (non-Javadoc)    
	 * @see org.lv.shop.service.brand.BrandService#touodateBrandPage(java.lang.String)    
	 */
	@Override
	public void updateBrandById(Brand brand) {
		if(null!=brand){
			String[] brandImg = brand.getBrandImg().split(",");
			String[] brandId = brand.getBrandId().split(",");
			String[] brandName = brand.getBrandName().split(",");
			for (int i = 0; i < brandId.length; i++) {
				brand.setUpdatetime(new Date());
				brand.setBrandId(brandId[i]);
				brand.setBrandImg(brandImg[i]);
				brand.setBrandName(brandName[i]);
				brandMapper.updateBrandById(brand);
			}
			jedis.del("brandList");
		}
	}

	/* (non-Javadoc)    
	 * @see org.lv.shop.service.brand.BrandService#deleteAllBrandtByIds(java.lang.String)    
	 */
	@Override
	public void deleteAllBrandtByIds(String id) {
		String[] ids=id.split(",");
		brandMapper.deleteAllBrandtByIds(ids);
		jedis.del("brandList");
	}

	/* (non-Javadoc)    
	 * @see org.lv.shop.service.brand.BrandService#exportExcel()    
	 */
	@Override
	public HSSFWorkbook exportExcel() {
		HSSFWorkbook workbook=new HSSFWorkbook();
		HSSFSheet createSheet = workbook.createSheet();
		HSSFRow createRow = createSheet.createRow(0);
		createRow.createCell(0).setCellValue("编号");;
		createRow.createCell(1).setCellValue("名称");;
		createRow.createCell(2).setCellValue("创建时间");;
		createRow.createCell(3).setCellValue("修改时间");;
		return workbook;
	}

	/* (non-Javadoc)    
	 * @see org.lv.shop.service.brand.BrandService#getBrandListAll()    
	 */
	@Override
	public List<Brand> getBrandListAll() {
		//List<Brand> brandListAll= (List<Brand>)CacheManager.getInstance().getObj("brandList");
		//去redis中查询list
		List<Brand> brandListAll = JSONObject.parseArray(jedis.get("brandList"), Brand.class);
		if(brandListAll==null){
			//如果为空就去数据库空查询
			brandListAll = brandMapper.getBrandListAll();
			 //CacheManager.getInstance().putObj("brandListAll",brandListAll);
			//并放入到redis中
			jedis.setex("brandList",24*60*60,JSONObject.toJSONString(brandListAll));
		}
		return brandListAll;
	}

	/* (non-Javadoc)    
	 * @see org.lv.shop.service.brand.BrandService#toupdateBrandImgById(java.lang.String)    
	 */
	@Override
	public List<Brand> toupdateBrandImgById(String id) {
		List<Brand> list=new ArrayList<Brand>();
		if(StringUtils.isNotBlank(id)){
			String[] split = id.split(",");
			for (int i = 0; i < split.length; i++) {
				Brand brand= brandMapper.touodateBrandPage(split[i]);
				list.add(brand);
			}
		}
		return list;
	}

}
