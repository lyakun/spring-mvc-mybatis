/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:OutFile.java 
 * 包名:org.lv.shop.util 
 * 创建日期:2017年6月5日下午6:33:10 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.util;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：OutFile    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年6月5日 下午6:33:10    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年6月5日 下午6:33:10    
 * 修改备注：       
 * @version   
 */
public class OutFile {
	/**
	 * outXml(导出xml)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月5日 下午7:11:28    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月5日 下午7:11:28    
	 * 修改备注： 
	 * @param response
	 * @param document
	 * @param fileName
	 * @throws IOException
	 */
	public static void outXml(HttpServletResponse response,Document document,String fileName) throws IOException{
		OutputStream outputStream = response.getOutputStream();
		response.reset();
		response.setHeader("Content-disposition", "attachment; filename="+fileName);
		response.setContentType("application/msexcel");
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		XMLWriter writer=new XMLWriter(outputStream,format);
		writer.write(document);
		writer.flush();
		writer.close();
	}
	/**
	 * outExcel(导出excel)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月5日 下午7:43:57    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月5日 下午7:43:57    
	 * 修改备注： 
	 * @param response
	 * @param workbook
	 * @param fileName
	 * @throws IOException
	 */
	public static void outExcel(HttpServletResponse response,HSSFWorkbook workbook,String fileName) throws IOException{
		OutputStream outputStream = response.getOutputStream();
		response.reset();
		response.setHeader("Content-disposition", "attachment; filename="+fileName);
		response.setContentType("application/msexcel");
		workbook.write(outputStream);
		outputStream.close();
	}
}
