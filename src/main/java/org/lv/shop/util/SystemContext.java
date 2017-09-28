/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:SystemContext.java 
 * 包名:org.lv.shop.util 
 * 创建日期:2017年6月7日下午3:47:30 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.util;

import com.mongodb.MongoClient;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：SystemContext    
 * 类描述：    系统的常量
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年6月7日 下午3:47:30    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年6月7日 下午3:47:30    
 * 修改备注：       
 * @version   
 */
public class SystemContext {
	public static final String XML_PATH="D:/xml/";
	public static final String EXCEL_PATH="D:/excel/";
	public static final String XML_SUFFFIX=".xml";
	public static final String EXCEL_SUFFFIX=".xls";
	public static final String ZIP_File=".zip";
	public static final MongoClient mongo=new MongoClient("127.0.0.1:27017");
}
