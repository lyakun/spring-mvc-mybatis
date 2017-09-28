/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:ProductController.java 
 * 包名:org.lv.shop.web.controller.product 
 * 创建日期:2017年5月17日下午4:18:04 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.web.controller.product;

import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.lv.shop.entity.brand.Brand;
import org.lv.shop.entity.product.ImgAll;
import org.lv.shop.entity.product.Product;
import org.lv.shop.service.brand.BrandService;
import org.lv.shop.service.product.ProductService;
import org.lv.shop.util.FileUpload;
import org.lv.shop.util.JsonUtil;
import org.lv.shop.util.MongGridFSFilterUtil;
import org.lv.shop.util.OutFile;
import org.lv.shop.util.Page;
import org.lv.shop.util.SystemContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.mongodb.gridfs.GridFSDBFile;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：ProductController    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年5月17日 下午4:18:04    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年5月17日 下午4:18:04    
 * 修改备注：       
 * @version   
 */
@Controller
@RequestMapping("product")
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private BrandService brandService;
	private Page page=new Page();
	/**
	 * getProductPage(跳转查询页面)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月17日 下午4:33:02    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月17日 下午4:33:02    
	 * 修改备注： 
	 * @return
	 */
	@RequestMapping("getProductPage")
	@RequiresPermissions("product:list")
	public String getProductPage(ModelMap modelMap){
		List<Brand> brandList=brandService.getBrandListAll();
		modelMap.put("brandList", brandList);
		return "/product/product_page";
	}
	/**
	 * getProductList(获取product集合)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月17日 下午4:33:25    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月17日 下午4:33:25    
	 * 修改备注： 
	 * @param offset
	 * @param limit
	 * @param product
	 * @return
	 */
	@RequestMapping("getProductList")
	@ResponseBody
	@RequiresPermissions("product:list")
	public String getProductList(Integer offset,Integer limit,Product product){
		page.setStrat(offset);
		page.setPagecount(limit);
		page.setObj(product);
		productService.getProductList(page);
		Map map=new HashMap();
		map.put("total", page.getPagesumcount());
		map.put("rows", page.getList());
		Gson gson=new Gson();
		String str=gson.toJson(map);
		return str;
	}
	/**
	 * getProductAddPage(跳转增加页面)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月17日 下午5:58:35    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月17日 下午5:58:35    
	 * 修改备注： 
	 * @return
	 */
	@RequestMapping("getProductAddPage")
	@RequiresPermissions("product:add")
	public String getProductAddPage(ModelMap map){
		List<Brand> brandList=brandService.getBrandListAll();
		map.put("brandList",brandList);
		return "product/product_add_page";
	}
	/**
	 * insertProduct(product的增加方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月17日 下午6:04:42    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月17日 下午6:04:42    
	 * 修改备注： 
	 * @return
	 */
	@RequestMapping("insertProduct")
	@RequiresPermissions("product:add")
	public String insertProduct(Product product){
		productService.insertProduct(product);
		return "redirect:/product/getProductPage.gang";
	}
	/**
	 * deleteProductById(product根据id删除)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月18日 上午7:52:34    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月18日 上午7:52:34    
	 * 修改备注： 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("deleteProductById")
	@RequiresPermissions("product:delete")
	public String deleteProductById(String id){
		productService.deleteProductById(id);
		return "1";
	}
	/**
	 * toupdateProductById(根据id查询出需要修改的product)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月18日 上午8:09:16    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月18日 上午8:09:16    
	 * 修改备注： 
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping("toupdateProductById")
	@RequiresPermissions("product:toupdate")
	public String toupdateProductById(String id,ModelMap map){
		Product product= productService.toupdateProductById(id);
		List list=productService.getshowProductImgAllPageById(id);
		List<Brand> brandList=brandService.getBrandListAll();
		map.put("brandList", brandList);
		map.put("product",product);
		map.put("list",list);
		return "product/product_update_page";
	}
	/**
	 * updateProductById(根据id保存修改后的product)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月18日 上午8:10:00    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月18日 上午8:10:00    
	 * 修改备注： 
	 * @return
	 */
	@RequestMapping("updateProductById")
	@RequiresPermissions("product:update")
	public String updateProductById(Product product){
		productService.updateProductById(product);
		return "redirect:/product/getProductPage.gang";
	}
	/**
	 * deleteAllProductByIds(批量删除product)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月18日 上午10:29:49    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月18日 上午10:29:49    
	 * 修改备注： 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("deleteAllProductByIds")
	@RequiresPermissions("product:deletes")
	public String deleteAllProductByIds(String id){
		productService.deleteAllProductByIds(id);
		return "1";
	}
	/**
	 * uplodProductImg(product图片上传方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月19日 下午4:28:25    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月19日 下午4:28:25    
	 * 修改备注： 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("uplodProductImg")
	public String uplodProductImg(@RequestParam("imgfile")MultipartFile imgfile,HttpServletRequest request){
		String productImgUrl="";
		try {
			//productImgUrl=productService.fileUplod(imgfile);
			productImgUrl = FileUpload.uploadFile(imgfile, request);
			//productImgUrl = MongGridFSFilterUtil.saveFile(imgfile, request, "gang");
		} catch (IOException e) {
			e.printStackTrace();
		}
		Map  map=new HashMap();
		map.put("img",productImgUrl );
		Gson json=new Gson();
		String str=json.toJson(map);
		return str;
	}
	/**
	 * productImgAllUplodPage(跳转产品相册增加页面)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月20日 下午7:41:20    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月20日 下午7:41:20    
	 * 修改备注： 
	 * @return
	 */
	@RequestMapping("productImgAllUplodPage")
	public String productImgAllUplodPage(){
		return "product/imgAllUplod_page";
	}
	/**
	 * getshowProductImgAllPageById(通过productId获取相册集合展示页面)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月20日 下午10:57:04    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月20日 下午10:57:04    
	 * 修改备注： 
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping("getshowProductImgAllPageById")
	public String getshowProductImgAllPageById(String id,ModelMap map){
		List list=productService.getshowProductImgAllPageById(id);
		map.put("list", list);
		return "product/showProductImgAll_Page";
	}
	/**
	 * deleteFile(根据Id删除子相册)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月21日 下午11:16:12    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月21日 下午11:16:12    
	 * 修改备注：
	 * @param response 
	 */
	@RequestMapping("deleteFile")
	public void deleteFile(String id, HttpServletResponse response){
		productService.deleteFile(id);
		Map map=new HashMap();
		map.put("stratus","ok");
		JsonUtil.outJson(map, response);
	}
	/**
	 * exportExcel(导出Excel方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月23日 下午8:02:41    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月23日 下午8:02:41    
	 * 修改备注：
	 * @throws IOException 
	 */
	@RequestMapping("exportExcel")
	@RequiresPermissions("product:excel")
	public void exportExcel(HttpServletResponse response,Product product) throws IOException{
		//默认导出03
		HSSFWorkbook workbook=new HSSFWorkbook();
		String brandId = product.getBrand().getBrandId();
		if(brandId!=""&&brandId!=null){
			List<Product> productList=productService.getProdcutByBrandId(product.getBrand().getBrandId());
			HSSFSheet createSheet =workbook.createSheet();
			createSheet(productList, workbook, createSheet);
		}else{
			List<Brand> list=brandService.getBrandListAll();
			for (int i = 0; i < list.size(); i++) {
				HSSFSheet index=workbook.createSheet();
				workbook.setSheetName(i, list.get(i).getBrandName());
				List<Product> productList=productService.getProdcutByBrandId(list.get(i).getBrandId());
				if(productList.size()>0){
					createSheet(productList, workbook, index);
				}
			}
		}
		OutputStream outputStream = response.getOutputStream();
		response.reset();
		response.setHeader("Content-disposition", "attachment; filename=gang.xls");
		response.setContentType("application/msexcel");
		workbook.write(outputStream);
		outputStream.close();
	}
	/** createSheet(这里用一句话描述这个方法的作用)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月31日 上午8:12:51    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月31日 上午8:12:51    
	 * 修改备注： 
	 * @param list
	 * @param workbook
	 * @param createSheet  
	 */
	private void createSheet(List<Product> productList, HSSFWorkbook workbook, HSSFSheet createSheet) {
		HSSFRow createRow = createSheet.createRow(0);
		HSSFCellStyle liststyle=workbook.createCellStyle();
		createRow.createCell(0).setCellValue("编号");;
		createRow.createCell(1).setCellValue("产品名称");
		createRow.createCell(2).setCellValue("产品价格");
		createRow.createCell(3).setCellValue("品牌价格");
		createRow.createCell(4).setCellValue("产品库存");
		createRow.createCell(5).setCellValue("创建日期");
		createRow.createCell(6).setCellValue("修改日期");
		int index=1;
		for (int j = 0; j < productList.size(); j++) {
				liststyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));
				createRow=createSheet.createRow(index++);
				HSSFCell cell =createRow.createCell(0);
				cell.setCellValue(productList.get(j).getProductId());
				cell.setCellStyle(liststyle);
				HSSFCell productNameCell = createRow.createCell(1);
				productNameCell.setCellValue(productList.get(j).getProductName());
				productNameCell.setCellStyle(liststyle);
				HSSFCell productPriceCell=createRow.createCell(2);
				productPriceCell.setCellValue(productList.get(j).getProductPrice());
				productPriceCell.setCellStyle(liststyle);
				HSSFCell brandNameCell=createRow.createCell(3);
				brandNameCell.setCellValue(productList.get(j).getBrand().getBrandName());
				brandNameCell.setCellStyle(liststyle);
				HSSFCell stockCell=createRow.createCell(4);
				stockCell.setCellValue(productList.get(j).getStock());
				stockCell.setCellStyle(liststyle);
				HSSFCell updateTimeCell=createRow.createCell(5);
				updateTimeCell.setCellValue(productList.get(j).getUpdatetime());
				HSSFCell brandTimeCell=createRow.createCell(6);
				brandTimeCell.setCellValue(productList.get(j).getCreatetime());
				brandTimeCell.setCellStyle(liststyle);
		}
	}
	/**
	 * inportExcel(导入Excel的方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月25日 下午9:29:53    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月25日 下午9:29:53    
	 * 修改备注： 
	 * @param excel
	 * @param response
	 * @throws ParseException
	 */
	@RequestMapping("inportExcel")
	@RequiresPermissions("product:excel")
	public void inportExcel(@RequestParam("excel")MultipartFile excel, HttpServletResponse response) throws ParseException{
		String fileName=excel.getOriginalFilename();
		String houzui = fileName.substring(fileName.lastIndexOf("."),fileName.length());
		Workbook workbook=null;
			try {
				List<Product> list=new ArrayList<Product>();
				if((".xlsx").equals(houzui)){
					workbook=new XSSFWorkbook(excel.getInputStream());
				}
				else{
					workbook=new HSSFWorkbook(excel.getInputStream());
				}
				int sheetcount= workbook.getNumberOfSheets();
				for (int j = 0; j < sheetcount; j++) {
				
				Sheet sheet = workbook.getSheetAt(j);
				Row row = sheet.getRow(0);
				int count=sheet.getLastRowNum();
				//SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				for (int i = 1; i <=count; i++) {
					Product product=new Product();
					row=sheet.getRow(i);
					Date date=new Date();
					product.setProductId(UUID.randomUUID().toString());
					product.setProductName(row.getCell(0).getStringCellValue());
					product.setProductPrice(row.getCell(1).getNumericCellValue());
					product.setCreatetime(date);
					product.setUpdatetime(date);
					list.add(product);
				}
				
				}
				productService.insertProductAll(list);
				Map map=new HashMap();
				map.put("stats","sucess");
				JsonUtil.outJson(map, response);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
	/**
	 * toupdateProductImgById(跳转批量修改product的主图的页面)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月25日 下午9:30:17    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月25日 下午9:30:17    
	 * 修改备注： 
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping("toupdateProductImgById")
	public String toupdateProductImgById(String id,ModelMap map){
			List<Product> list=productService.toupdateProductImgById(id);
			map.put("list", list);
		return "product/product_updateAllImg_page";
	}
	/**
	 * updateProductAllById(批量修改产品的主图)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月25日 下午10:56:17    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月25日 下午10:56:17    
	 * 修改备注： 
	 * @param product
	 * @return
	 */
	@RequestMapping("updateProductAllById")
	public String updateProductAllById(Product product){
			productService.updateProductAllById(product);
		return "redirect:/product/getProductPage.gang";
	}
	/**
	 * exportXml(导出xml)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月5日 下午6:30:14    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月5日 下午6:30:14    
	 * 修改备注：
	 */
	@RequestMapping("exportXml")
	@RequiresPermissions("product:excel")
	public void exportXml(HttpServletResponse response,Product product){
			List<Product> productLsit=productService.getProductAllList(product);
			List<ImgAll> imgList=productService.getProductImgAll();
			Document document=DocumentHelper.createDocument();
			Element element = document.addElement("productList");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			for (Product productInfo : productLsit) {
				Element productElement = element.addElement("product");
				productElement.addAttribute("id",productInfo.getProductId());
				Element productNameElement = productElement.addElement("productName");
				productNameElement.addText(productInfo.getProductName());
				Element priceElement = productElement.addElement("productPrice");
				priceElement.addText(""+productInfo.getProductPrice());
				Element brandName = productElement.addElement("brandName");
				brandName.addText(productInfo.getBrand().getBrandName());
				Element brandId = productElement.addElement("brandId");
				brandId.addText(productInfo.getBrand().getBrandId());
				Element createTimeElement = productElement.addElement("createTime");
				createTimeElement.addText(sdf.format(productInfo.getCreatetime()));
				//产品主图
				Element productImgElement = productElement.addElement("productImg");
				productImgElement.addText(productInfo.getProductImg());
				//产品子图
				Element imgAllElement = productElement.addElement("productAllImg");
				for (ImgAll imgAll : imgList) {
					if(imgAll.getProductId().equals(productInfo.getProductId())){
						Element imgElement = imgAllElement.addElement("img");
						imgElement.addAttribute("src",imgAll.getImgUrl());
					}
				}
			}
			try {
				OutFile.outXml(response, document, "gang.xml");
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	/**
	 * downFileById(根据id下载文件)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月11日 下午12:18:06    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月11日 下午12:18:06    
	 * 修改备注： 
	 * @param id
	 * @param response
	 * @param request
	 */
	@RequestMapping("downFileById")
	public void downFileById(String id,HttpServletResponse response,HttpServletRequest request){
		ImgAll imgAll=productService.dowmFileById(id);
		String newPath = request.getRealPath(imgAll.getImgUrl());
		FileUpload.downFile(newPath, request, response);
	}
	/**
	 * downFileZip(打包下载文件)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月11日 下午12:17:48    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月11日 下午12:17:48    
	 * 修改备注： 
	 * @param id
	 * @param response
	 * @param request
	 */
	@RequestMapping("downFileZip")
	public void downFileZip(String id,HttpServletResponse response,HttpServletRequest request){
		List<ImgAll> imgList=productService.getImgByIds(id);
		List<String> urlList=new ArrayList<String>();
		for (ImgAll imgAll : imgList) {
			urlList.add(imgAll.getImgUrl());
		}
		FileUpload.downZipFile(request, response, urlList, UUID.randomUUID().toString()+SystemContext.ZIP_File);
	}
	/**
	 * getImgAllById(根据Id获取图片)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月11日 下午9:16:28    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月11日 下午9:16:28    
	 * 修改备注：
	 * @throws IOException 
	 */
	@RequestMapping("getImgAllById")
	public void getImgAllById(String id,HttpServletResponse response) throws IOException{
		MongGridFSFilterUtil.findOne(id, response, "gang");
	}
}

