/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:AnalysisService.java 
 * 包名:org.lv.shop.service.analysis 
 * 创建日期:2017年6月13日下午4:57:34 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.service.analysis;

import java.util.Map;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：AnalysisService    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年6月13日 下午4:57:34    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年6月13日 下午4:57:34    
 * 修改备注：       
 * @version   
 */
public interface AnalysisService {

	/** getAnalysis(这里用一句话描述这个方法的作用)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月13日 下午5:12:38    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月13日 下午5:12:38    
	 * 修改备注： 
	 * @return  
	 */
	Map getAnalysis();

	/** getAnalysisByCondition(这里用一句话描述这个方法的作用)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月13日 下午6:58:18    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月13日 下午6:58:18    
	 * 修改备注： 
	 * @param datetime
	 * @return  
	 */
	Map getAnalysisByCondition(String datetime);

}
