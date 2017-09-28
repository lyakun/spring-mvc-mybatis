/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:BrandService.java 
 * 包名:org.lv.shop.service.brand 
 * 创建日期:2017年5月19日下午8:32:12 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.service.brand;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.lv.shop.entity.brand.Brand;
import org.lv.shop.util.Page;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：BrandService    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年5月19日 下午8:32:12    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年5月19日 下午8:32:12    
 * 修改备注：       
 * @version   
 */
public interface BrandService {

	/** getBrandList(获取brand集合并分页)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月21日 上午10:11:13    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月21日 上午10:11:13    
	 * 修改备注： 
	 * @param page  
	 */
	void getBrandList(Page page);

	/** insertBrand(brand的增加方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月21日 上午10:33:11    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月21日 上午10:33:11    
	 * 修改备注： 
	 * @param brand  
	 */
	void insertBrand(Brand brand);

	/** deleteBrandById(根据Id删除Brand)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月21日 上午10:57:34    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月21日 上午10:57:34    
	 * 修改备注： 
	 * @param id  
	 */
	void deleteBrandById(String id);

	/** updateBrandById(根据id修改brand)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月21日 下午1:43:52    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月21日 下午1:43:52    
	 * 修改备注： 
	 * @param brand  
	 */
	void updateBrandById(Brand brand);

	/** deleteAllBrandtByIds(批量删除)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月21日 下午1:54:27    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月21日 下午1:54:27    
	 * 修改备注： 
	 * @param id  
	 */
	void deleteAllBrandtByIds(String id);

	/** exportExcel(导出Excel方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月24日 下午7:21:15    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月24日 下午7:21:15    
	 * 修改备注： 
	 * @return  
	 */
	HSSFWorkbook exportExcel();

	/** getBrandListAll(查询品牌所有)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月25日 下午6:37:25    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月25日 下午6:37:25    
	 * 修改备注： 
	 * @return  
	 */
	List<Brand> getBrandListAll();

	/** toupdateBrandImgById(这里用一句话描述这个方法的作用)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月25日 下午11:52:59    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月25日 下午11:52:59    
	 * 修改备注： 
	 * @param id
	 * @return  
	 */
	List<Brand> toupdateBrandImgById(String id);
}
