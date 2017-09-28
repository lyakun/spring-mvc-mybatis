/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:HelloJob.java 
 * 包名:org.lv.shop.timing 
 * 创建日期:2017年6月7日下午2:14:52 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.timing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.lv.shop.entity.brand.Brand;
import org.lv.shop.entity.product.Product;
import org.lv.shop.service.brand.BrandService;
import org.lv.shop.service.product.ProductService;
import org.lv.shop.util.SystemContext;
import org.lv.shop.util.WebContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：HelloJob    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年6月7日 下午2:14:52    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年6月7日 下午2:14:52    
 * 修改备注：       
 * @version   
 */
@Component("tiggerJob")
public class TiggerJob {
	@Autowired
	private ProductService productService;
	@Autowired
	private BrandService brandService;
	/**
	 * excportExcel(定时生成excel)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月7日 下午7:25:42    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月7日 下午7:25:42    
	 * 修改备注：
	 */
	public void excportExcel(){
		List<Product> productList=productService.getProductListExport();
		List<Brand> brandList = brandService.getBrandListAll();
		HSSFWorkbook workbook=new HSSFWorkbook();
		//根据品牌创建sheet
		for (Brand brand : brandList) {
			HSSFSheet createSheet = workbook.createSheet(brand.getBrandName());
			List<Product> productInfo=buidList(productList,brand.getBrandId());
			//创建sheet数据
			buidExcl(productInfo,createSheet);
		}
		//输出excel
		outExcel(WebContext.getRsponse(),workbook,buidExcelName(productList.size()));
		
	}
	/** buidFileName(返回excel文件的名称)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月7日 下午8:02:00    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月7日 下午8:02:00    
	 * 修改备注： 
	 * @return  
	 */
	private String buidExcelName(int count) {
		Date date = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		File folder=new File(SystemContext.EXCEL_PATH);
		if(!folder.exists()){
			folder.mkdirs();
		}
		String replace = sdf.format(date).replace(" ", "_").replace(":", "-");
		return SystemContext.EXCEL_PATH+replace+"_"+count+SystemContext.EXCEL_SUFFFIX;
	}
	/** outExcel(这里用一句话描述这个方法的作用)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月7日 下午7:51:37    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月7日 下午7:51:37    
	 * 修改备注：   
	 */
	private void outExcel(HttpServletResponse response,HSSFWorkbook workbook,String name) {
		FileOutputStream outputStream=null;
		try {
			outputStream=new FileOutputStream(name);
			workbook.write(outputStream);
			outputStream.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(null!=outputStream){
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/** buidExcl(根据传过来的sheet和集合生成excel)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月7日 下午7:38:58    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月7日 下午7:38:58    
	 * 修改备注： 
	 * @param productInfo
	 * @param createSheet  
	 */
	private void buidExcl(List<Product> productInfo, HSSFSheet createSheet) {
		HSSFRow createRow = createSheet.createRow(0);
		createRow.createCell(0).setCellValue("产品名称");
		createRow.createCell(1).setCellValue("品牌");
		createRow.createCell(2).setCellValue("库存");
		int count=1;
		for (Product row : productInfo) {
			createRow=createSheet.createRow(count++);
			createRow.createCell(0).setCellValue(row.getProductName());
			createRow.createCell(1).setCellValue(row.getBrand().getBrandName());
			createRow.createCell(2).setCellValue(row.getStock());
		}
	}
	/** buidList(返回每类品牌的集合)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月7日 下午7:34:27    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月7日 下午7:34:27    
	 * 修改备注： 
	 * @param productList
	 * @param brandId  
	 */
	private List<Product> buidList(List<Product> productList, String brandId) {
		List<Product> productInfo=new ArrayList<Product>();
		for (Product product : productList) {
			if(product.getBrand().getBrandId().equals(brandId)){
				productInfo.add(product);
			}
		}
		return productInfo;
	}
	/**
	 * exportXML(定时生成xml到硬盘上)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月7日 下午6:25:08    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月7日 下午6:25:08    
	 * 修改备注：
	 */
	public void exportXML(){
		List<Product> productList=productService.getProductListExport();
		Document document = DocumentHelper.createDocument();
		Element productListElement = document.addElement("productList");
		for (Product product : productList) {
			Element productElement = productListElement.addElement("product");
			productElement.addElement("productName").addText(product.getProductName());
			productElement.addElement("brandName").addText(product.getBrand().getBrandName());
			productElement.addElement("stock").addText(""+product.getStock());
		}
		OutputFormat format=OutputFormat.createCompactFormat();
		format.setEncoding("utf-8");
		XMLWriter writer=null;
		try {
			writer=new XMLWriter(new FileWriter(buidFileName(productList.size())),format);
			writer.write(document);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(null!=writer){
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	private String buidFileName(int count){
		Date date = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		File folder=new File(SystemContext.XML_PATH);
		if(!folder.exists()){
			folder.mkdirs();
		}
		String replace = sdf.format(date).replace(" ", "_").replace(":", "-");
		return SystemContext.XML_PATH+replace+SystemContext.XML_SUFFFIX;
	}
}
