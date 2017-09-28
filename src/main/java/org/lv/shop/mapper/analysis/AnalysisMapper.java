/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:AnalysisMapper.java 
 * 包名:org.lv.shop.mapper.analysis 
 * 创建日期:2017年6月13日下午4:58:34 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.mapper.analysis;

import java.util.List;
import java.util.Map;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：AnalysisMapper    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年6月13日 下午4:58:34    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年6月13日 下午4:58:34    
 * 修改备注：       
 * @version   
 */
public interface AnalysisMapper {

	/** getAnalysis(获取每天的产品录入量)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月13日 下午5:13:28    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月13日 下午5:13:28    
	 * 修改备注： 
	 * @return  
	 */
	List<Map> getAnalysis();

	/** getAnalysisByCondition(根据日期获取当天的各个品牌的录入信息)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月13日 下午6:59:12    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月13日 下午6:59:12    
	 * 修改备注： 
	 * @param datetime
	 * @return  
	 */
	List<Map> getAnalysisByCondition(String datetime);

}
