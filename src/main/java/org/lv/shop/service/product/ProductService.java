/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:ProductService.java 
 * 包名:org.lv.shop.service.product 
 * 创建日期:2017年5月17日下午4:34:35 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.service.product;

import java.io.IOException;
import java.util.List;

import org.lv.shop.entity.product.ImgAll;
import org.lv.shop.entity.product.Product;
import org.lv.shop.util.Page;
import org.springframework.web.multipart.MultipartFile;

import com.mongodb.gridfs.GridFSDBFile;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：ProductService    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年5月17日 下午4:34:35    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年5月17日 下午4:34:35    
 * 修改备注：       
 * @version   
 */
public interface ProductService {

	/** getProductList(获取product的集合方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月17日 下午4:39:20    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月17日 下午4:39:20    
	 * 修改备注： 
	 * @param page  
	 */
	void getProductList(Page page);

	/** insertProduct(product的增加方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月17日 下午6:27:31    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月17日 下午6:27:31    
	 * 修改备注： 
	 * @param product  
	 */
	void insertProduct(Product product);

	/** deleteProductById(product根据id删除)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月18日 上午7:53:21    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月18日 上午7:53:21    
	 * 修改备注： 
	 * @param id  
	 */
	void deleteProductById(String id);

	/** toupdateProductById(根据id查询出需要修改的product)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月18日 上午8:01:42    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月18日 上午8:01:42    
	 * 修改备注： 
	 * @param id
	 * @return  
	 */
	Product toupdateProductById(String id);

	/** updateProductById(根据id保存修改后的product)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月18日 上午8:11:33    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月18日 上午8:11:33    
	 * 修改备注： 
	 * @param product  
	 */
	void updateProductById(Product product);

	/** deleteAllProductByIds(批量删除product)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月18日 上午10:30:45    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月18日 上午10:30:45    
	 * 修改备注： 
	 * @param id  
	 */
	void deleteAllProductByIds(String id);

	/** getshowProductImgAllPageById(查出产品的相册集合)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月20日 下午7:47:00    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月20日 下午7:47:00    
	 * 修改备注： 
	 * @param id
	 * @return  
	 */
	List getshowProductImgAllPageById(String id);

	/** deleteFile(根据id删除产品相册)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月21日 下午11:21:02    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月21日 下午11:21:02    
	 * 修改备注： 
	 * @param id  
	 */
	void deleteFile(String id);

	/** insertProductAll(product的批量增加方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月23日 下午10:04:05    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月23日 下午10:04:05    
	 * 修改备注： 
	 * @param list  
	 */
	void insertProductAll(List<Product> list);

	/** toupdateProductImgById(批量修改product的主图片)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月25日 下午9:29:23    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月25日 下午9:29:23    
	 * 修改备注： 
	 * @param id
	 * @return  
	 */
	List<Product> toupdateProductImgById(String id);

	/** updateProductAllById(保存批量修改的产品主图)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月25日 下午10:59:00    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月25日 下午10:59:00    
	 * 修改备注： 
	 * @param product  
	 */
	void updateProductAllById(Product product);

	/** getProdcutByBrandId(按照品牌查出产品)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月31日 下午2:50:18    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月31日 下午2:50:18    
	 * 修改备注： 
	 * @param brandId
	 * @return  
	 */
	List<Product> getProdcutByBrandId(String brandId);

	/** getProductAllList(查询出所有产品集合)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月5日 下午7:17:31    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月5日 下午7:17:31    
	 * 修改备注： 
	 * @param product
	 * @return  
	 */
	List<Product> getProductAllList(Product product);

	/** getProductImgAll(获取所有子图)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月5日 下午8:18:37    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月5日 下午8:18:37    
	 * 修改备注： 
	 * @return  
	 */
	List<ImgAll> getProductImgAll();

	/** getProductListExport(查询库存紧张的产品)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月7日 下午4:21:22    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月7日 下午4:21:22    
	 * 修改备注： 
	 * @return  
	 */
	List<Product> getProductListExport();

	/** dowmFileById(根据id查询字图片)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月11日 下午12:00:04    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月11日 下午12:00:04    
	 * 修改备注： 
	 * @param id
	 * @return  
	 */
	ImgAll dowmFileById(String id);

	/** getImgByIds(批量下载)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月11日 下午12:27:23    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月11日 下午12:27:23    
	 * 修改备注： 
	 * @param id
	 * @return  
	 */
	List<ImgAll> getImgByIds(String id);

	/** fileUplod(将图片存储到mongodb中)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月11日 下午8:26:24    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月11日 下午8:26:24    
	 * 修改备注： 
	 * @param imgfile
	 * @return  
	 * @throws IOException 
	 */
	String fileUplod(MultipartFile imgfile) throws IOException;

	/** getImgAllById(获取mongo中的相册)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月11日 下午9:43:54    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月11日 下午9:43:54    
	 * 修改备注： 
	 * @param id
	 * @return  
	 */
	GridFSDBFile getImgAllById(String id);
}
