/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:ProductServiceImpl.java 
 * 包名:org.lv.shop.service.product 
 * 创建日期:2017年5月17日下午4:34:52 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.service.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.lv.shop.entity.desc.Desc;
import org.lv.shop.entity.product.ImgAll;
import org.lv.shop.entity.product.Product;
import org.lv.shop.mapper.product.ProductMapper;
import org.lv.shop.util.Page;
import org.lv.shop.util.SystemContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：ProductServiceImpl    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年5月17日 下午4:34:52    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年5月17日 下午4:34:52    
 * 修改备注：       
 * @version   
 */
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductMapper productMapper;
	/* (non-Javadoc)    
	 * @see org.lv.shop.service.product.ProductService#getProductList(org.lv.shop.util.Page)    
	 */
	@Override
	public void getProductList(Page page) {
		List list=productMapper.getProductList(page);
		int count=productMapper.getProductListCount(page);
		page.setPagesumcount(count);
		page.setList(list);
	}
	/* (non-Javadoc)    
	 * @see org.lv.shop.service.product.ProductService#insertProduct(org.lv.shop.entity.product.Product)    
	 */
	@Override
	public void insertProduct(Product product) {
		Date date=new Date();
		product.setCreatetime(date);
		product.setUpdatetime(date);
		product.setProductId(UUID.randomUUID().toString());
		productMapper.insertProduct(product);
		//产品子图
		if(StringUtils.isNotBlank(product.getImgUrlArray())){
			String[] str=product.getImgUrlArray().split(",");
			ImgAll imgAll=new ImgAll();
			imgAll.setProductId(product.getProductId());
			for (int i = 0; i < str.length; i++) {
				imgAll.setImgUrl(str[i]);
				productMapper.insertImgAll(imgAll);
			}
		}
		//产品描述
		if(StringUtils.isNotBlank(product.getDesc().getProductDesc())){
			Desc desc=new Desc();
			desc.setId(product.getProductId());
			desc.setProductDesc(product.getDesc().getProductDesc());
			productMapper.insertDesc(desc);
		}
	}
	/* (根据id删除)    
	 * @see org.lv.shop.service.product.ProductService#deleteProductById(java.lang.String)    
	 */
	@Override
	public void deleteProductById(String id) {
		productMapper.deleteProductById(id);
	}
	/* (non-Javadoc)    
	 * @see org.lv.shop.service.product.ProductService#toupdateProductById(java.lang.String)    
	 */
	@Override
	public Product toupdateProductById(String id) {
		return productMapper.toupdateProductById(id);
	}
	/* (non-Javadoc)    
	 * @see org.lv.shop.service.product.ProductService#updateProductById(org.lv.shop.entity.product.Product)    
	 */
	@Override
	public void updateProductById(Product product) {
		product.setUpdatetime(new Date());
		ImgAll imgAll=new ImgAll();
		if(StringUtils.isNotBlank(product.getImgUrlArray())){
			String[] str=product.getImgUrlArray().split(",");
			imgAll.setProductId(product.getProductId());
			for (int i = 0; i < str.length; i++) {
				imgAll.setImgUrl(str[i]);
				productMapper.insertImgAll(imgAll);
			}
			productMapper.updateProductById(product);
		}else{
			productMapper.updateProductById(product);
		}
	}
	/* (non-Javadoc)    
	 * @see org.lv.shop.service.product.ProductService#deleteAllProductByIds(java.lang.String)    
	 */
	@Override
	public void deleteAllProductByIds(String id) {
		String[] ids=id.split(",");
		productMapper.deleteAllProductByIds(ids);
	}
	/* (non-Javadoc)    
	 * @see org.lv.shop.service.product.ProductService#getshowProductImgAllPageById(java.lang.String)    
	 */
	@Override
	public List getshowProductImgAllPageById(String id) {
		return productMapper.getshowProductImgAllPageById(id);
	}
	/* (non-Javadoc)    
	 * @see org.lv.shop.service.product.ProductService#deleteFile(java.lang.String)    
	 */
	@Override
	public void deleteFile(String id) {
		int ids=Integer.valueOf(id);
		productMapper.deleteFile(ids);
	}
	/* (product的批量分段增加方法)    
	 * @see org.lv.shop.service.product.ProductService#insertProductAll(java.util.List)    
	 */
	@Override
	public void insertProductAll(List<Product> list) {
		List<Product> arrlist=new ArrayList<Product>();
		for (int i = 0; i < list.size(); i++) {
			if((i/700)==0){
				arrlist.add(list.get(i));
				
			}else{
				productMapper.insertProductAll(arrlist);
			}			
		}
		productMapper.insertProductAll(arrlist);
	}
	/* (non-Javadoc)    
	 * @see org.lv.shop.service.product.ProductService#toupdateProductImgById(java.lang.String)    
	 */
	@Override
	public List<Product> toupdateProductImgById(String id) {
		String[] split = id.split(",");
		List<Product> list=new ArrayList<Product>();
		for (int i = 0; i < split.length; i++) {
			Product product =productMapper.toupdateProductImgById(split[i]);
			list.add(product);
		}
		return list;
	}
	/* (non-Javadoc)    
	 * @see org.lv.shop.service.product.ProductService#updateProductAllById(org.lv.shop.entity.product.Product)    
	 */
	@Override
	public void updateProductAllById(Product product) {
		if(null!=product){
			String productId = product.getProductId();
			String productImg = product.getImgUrlArray();
			String[] split = productId.split(",");
			String[] split2 = productImg.split(",");
			for (int i = 0; i < split.length; i++) {
				Product pro=new Product();
				pro.setProductId(split[i]);
				pro.setProductImg(split2[i]);
				pro.setUpdatetime(new Date());
				productMapper.updateProductAllById(pro);
			}
		}
	}
	/* (non-Javadoc)    
	 * @see org.lv.shop.service.product.ProductService#getProdcutByBrandId(java.lang.String)    
	 */
	@Override
	public List<Product> getProdcutByBrandId(String brandId) {
		return productMapper.getProdcutByBrandId(brandId);
	}
	/* (non-Javadoc)    
	 * @see org.lv.shop.service.product.ProductService#getProductAllList(org.lv.shop.entity.product.Product)    
	 */
	@Override
	public List<Product> getProductAllList(Product product) {
		return productMapper.getProductAllList(product);
	}
	/* (non-Javadoc)    
	 * @see org.lv.shop.service.product.ProductService#getProductImgAll()    
	 */
	@Override
	public List<ImgAll> getProductImgAll() {
		return productMapper.getProductImgAll();
	}
	/* (non-Javadoc)    
	 * @see org.lv.shop.service.product.ProductService#getProductListExport()    
	 */
	@Override
	public List<Product> getProductListExport() {
		return productMapper.getProductListExport();
	}
	/* (non-Javadoc)    
	 * @see org.lv.shop.service.product.ProductService#dowmFileById(java.lang.String)    
	 */
	@Override
	public ImgAll dowmFileById(String id) {
		return productMapper.downFileById(id);
	}
	/* (non-Javadoc)    
	 * @see org.lv.shop.service.product.ProductService#getImgByIds(java.lang.String)    
	 */
	@Override
	public List<ImgAll> getImgByIds(String id) {
		String[] ids=id.split(",");
		return productMapper.getImgByIds(ids);
	}
	/* (non-Javadoc)    
	 * @see org.lv.shop.service.product.ProductService#fileUplod(org.springframework.web.multipart.MultipartFile)    
	 */
	@Override
	public String fileUplod(MultipartFile imgfile) throws IOException {
		DB db = SystemContext.mongo.getDB("gang");
		DBObject query=new BasicDBObject("_id",UUID.randomUUID().toString());
		GridFS gridFS=new GridFS(db);
		GridFSDBFile fsdbFile=gridFS.findOne(query);
		if(fsdbFile==null){
			GridFSInputFile fsInputFile=gridFS.createFile(imgfile.getInputStream());
			fsInputFile.setId(query);
			fsInputFile.setFilename(imgfile.getOriginalFilename());
			fsInputFile.save();
		}
		return  query.get("_id").toString();
	}
	/* (non-Javadoc)    
	 * @see org.lv.shop.service.product.ProductService#getImgAllById(java.lang.String)    
	 */
	@Override
	public GridFSDBFile getImgAllById(String id) {
		DB db = SystemContext.mongo.getDB("gang");
		DBObject query=new BasicDBObject("_id",id);
		GridFS gridFS=new GridFS(db);
		GridFSDBFile fsdbFile=gridFS.findOne(query);
		return fsdbFile;
	}

}
