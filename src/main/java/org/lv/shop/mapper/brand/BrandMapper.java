/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:BrandMapper.java 
 * 包名:org.lv.shop.mapper.brand 
 * 创建日期:2017年5月19日下午8:31:34 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.mapper.brand;

import java.util.List;

import org.lv.shop.entity.brand.Brand;
import org.lv.shop.util.Page;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：BrandMapper    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年5月19日 下午8:31:34    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年5月19日 下午8:31:34    
 * 修改备注：       
 * @version   
 */
public interface BrandMapper {

	/** getBrandList(获取brand集合)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月21日 上午10:11:46    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月21日 上午10:11:46    
	 * 修改备注： 
	 * @param page  
	 */
	List getBrandList(Page page);

	/** getBrandListCount(获取Brand总条数)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月21日 上午10:15:29    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月21日 上午10:15:29    
	 * 修改备注： 
	 * @param page
	 * @return  
	 */
	int getBrandListCount(Page page);

	/** insertBrand(brand的增加方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月21日 上午10:34:04    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月21日 上午10:34:04    
	 * 修改备注： 
	 * @param brand  
	 */
	void insertBrand(Brand brand);

	/** deleteBrandById(根据Id删除brand)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月21日 上午10:58:13    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月21日 上午10:58:13    
	 * 修改备注： 
	 * @param id  
	 */
	void deleteBrandById(String id);

	/** touodateBrandPage(根据id查出要修改的brand)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月21日 上午11:04:19    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月21日 上午11:04:19    
	 * 修改备注： 
	 * @param id
	 * @return  
	 */
	Brand touodateBrandPage(String id);

	/** updateBrandById(根据Id修改brand)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月21日 下午1:44:28    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月21日 下午1:44:28    
	 * 修改备注： 
	 * @param brand  
	 */
	void updateBrandById(Brand brand);

	/** deleteAllBrandtByIds(brand的批量删除方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月21日 下午1:54:59    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月21日 下午1:54:59    
	 * 修改备注： 
	 * @param id  
	 */
	void deleteAllBrandtByIds(String[] ids);

	/** getBrandListAll(查询品牌所有)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月25日 下午6:38:04    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月25日 下午6:38:04    
	 * 修改备注： 
	 * @return  
	 */
	List<Brand> getBrandListAll();

}
