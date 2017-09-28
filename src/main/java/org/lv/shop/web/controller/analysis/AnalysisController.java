/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:AnalysisController.java 
 * 包名:org.lv.shop.web.controller.analysis 
 * 创建日期:2017年6月13日下午4:56:44 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.web.controller.analysis;

import java.util.Map;

import org.lv.shop.service.analysis.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：AnalysisController    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年6月13日 下午4:56:44    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年6月13日 下午4:56:44    
 * 修改备注：       
 * @version   
 */
@Controller
@RequestMapping("analysis")
public class AnalysisController {
	@Autowired
	private AnalysisService analysisService;
	/**
	 * getAnalysis(获取每天的录入量)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月13日 下午5:50:06    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月13日 下午5:50:06    
	 * 修改备注： 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getAnalysis")
	public Map getAnalysis(){
		Map map=analysisService.getAnalysis();
		return map;
	}
	/**
	 * getAnalysisByCondition(根据日期获取当日各个品牌的录入量)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月13日 下午6:56:22    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月13日 下午6:56:22    
	 * 修改备注： 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getAnalysisByCondition")
	public Map getAnalysisByCondition(String datetime){
		return analysisService.getAnalysisByCondition(datetime);
	}
}
