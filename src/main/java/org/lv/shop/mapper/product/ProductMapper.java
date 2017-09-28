/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:ProductMapper.java 
 * 包名:org.lv.shop.mapper.product 
 * 创建日期:2017年5月17日下午4:20:16 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.mapper.product;

import java.util.List;

import org.lv.shop.entity.desc.Desc;
import org.lv.shop.entity.product.ImgAll;
import org.lv.shop.entity.product.Product;
import org.lv.shop.util.Page;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：ProductMapper    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年5月17日 下午4:20:16    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年5月17日 下午4:20:16    
 * 修改备注：       
 * @version   
 */
public interface ProductMapper {

	/** getProductList(获取product集合)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月17日 下午4:41:40    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月17日 下午4:41:40    
	 * 修改备注： 
	 * @param page
	 * @return  
	 */
	List getProductList(Page page);

	/** getProductListCount(获取product总条数)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月17日 下午4:42:11    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月17日 下午4:42:11    
	 * 修改备注： 
	 * @param list
	 * @return  
	 */
	int getProductListCount(Page page);

	/** insertProduct(这里用一句话描述这个方法的作用)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月17日 下午6:27:57    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月17日 下午6:27:57    
	 * 修改备注： 
	 * @param product  
	 */
	void insertProduct(Product product);

	/** deleteProductById(根据id删除product)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月18日 上午7:54:38    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月18日 上午7:54:38    
	 * 修改备注： 
	 * @param id  
	 */
	void deleteProductById(String id);

	/** toupdateProductById(根据id查询出需要修该的product)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月18日 上午8:03:13    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月18日 上午8:03:13    
	 * 修改备注： 
	 * @param id
	 * @return  
	 */
	Product toupdateProductById(String id);

	/** updateProductById(根据Id保存修改后的product)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月18日 上午8:12:22    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月18日 上午8:12:22    
	 * 修改备注： 
	 * @param product  
	 */
	void updateProductById(Product product);

	/** deleteAllProductByIds(批量删除)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月18日 上午10:31:29    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月18日 上午10:31:29    
	 * 修改备注： 
	 * @param id  
	 */
	void deleteAllProductByIds(String[] ids);

	/** insertImgAll(这里用一句话描述这个方法的作用)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月20日 下午7:27:04    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月20日 下午7:27:04    
	 * 修改备注： 
	 * @param imgAll  
	 */
	void insertImgAll(ImgAll imgAll);

	/** getshowProductImgAllPageById(查出产品的相册集合)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月20日 下午7:48:02    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月20日 下午7:48:02    
	 * 修改备注： 
	 * @param id
	 * @return  
	 */
	List getshowProductImgAllPageById(String id);

	/** deleteFile(根据id删除产品相册)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月21日 下午11:21:53    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月21日 下午11:21:53    
	 * 修改备注： 
	 * @param id  
	 */
	void deleteFile(String id);

	/** deleteFile(这里用一句话描述这个方法的作用)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月21日 下午11:24:00    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月21日 下午11:24:00    
	 * 修改备注： 
	 * @param ids  
	 */
	void deleteFile(int ids);

	/** insertProductAll(product的批量增加)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月23日 下午10:10:32    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月23日 下午10:10:32    
	 * 修改备注： 
	 * @param arrlist  
	 */
	void insertProductAll(List<Product> arrlist);

	/** toupdateProductImgById(获取批量修改的product的主图)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月25日 下午9:54:30    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月25日 下午9:54:30    
	 * 修改备注： 
	 * @param string
	 * @return  
	 */
	Product toupdateProductImgById(String string);

	/** updateProductAllById(批量保存)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月25日 下午11:03:39    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月25日 下午11:03:39    
	 * 修改备注： 
	 * @param pro  
	 */
	void updateProductAllById(Product pro);

	/** insertDesc(产品描述增加方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月28日 上午11:18:11    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月28日 上午11:18:11    
	 * 修改备注： 
	 * @param desc  
	 */
	void insertDesc(Desc desc);

	/** getProdcutByBrandId(按照品牌查出产品集合)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月31日 下午2:51:19    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月31日 下午2:51:19    
	 * 修改备注： 
	 * @param brandId
	 * @return  
	 */
	List<Product> getProdcutByBrandId(String brandId);

	/** getProductAllList(查询所有产品集合)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月5日 下午7:38:08    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月5日 下午7:38:08    
	 * 修改备注： 
	 * @param product
	 * @return  
	 */
	List<Product> getProductAllList(Product product);

	/** getProductImgAll(获取产品子图所有)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月5日 下午8:21:59    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月5日 下午8:21:59    
	 * 修改备注： 
	 * @return  
	 */
	List<ImgAll> getProductImgAll();

	/** getProductListExport(查询库存紧张的产品)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月7日 下午4:23:08    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月7日 下午4:23:08    
	 * 修改备注： 
	 * @return  
	 */
	List<Product> getProductListExport();

	/** downFileById(根据Id查询子图)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月11日 下午12:00:52    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月11日 下午12:00:52    
	 * 修改备注： 
	 * @param id
	 * @return  
	 */
	ImgAll downFileById(String id);

	/** getImgByIds(批量下载)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月11日 下午12:29:41    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月11日 下午12:29:41    
	 * 修改备注： 
	 * @param ids
	 * @return  
	 */
	List<ImgAll> getImgByIds(String[] ids);
}
