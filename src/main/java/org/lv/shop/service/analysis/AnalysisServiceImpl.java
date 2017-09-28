/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:AnalysisServiceImpl.java 
 * 包名:org.lv.shop.service.analysis 
 * 创建日期:2017年6月13日下午4:57:51 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.service.analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.lv.shop.mapper.analysis.AnalysisMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：AnalysisServiceImpl    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年6月13日 下午4:57:51    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年6月13日 下午4:57:51    
 * 修改备注：       
 * @version   
 */
@Service
public class AnalysisServiceImpl implements AnalysisService{
	@Autowired
	private AnalysisMapper analysisMapper;

	/* (non-Javadoc)    
	 * @see org.lv.shop.service.analysis.AnalysisService#getAnalysis()    
	 */
	@Override
	public Map getAnalysis() {
		List<Map> mapList=analysisMapper.getAnalysis();
		List<String> list=new ArrayList<String>();
		List<Long> listLong=new ArrayList<Long>();
		for (Map map : mapList) {
			list.add((String) map.get("createtime"));
			listLong.add((Long) map.get("count"));
		}
		Map item=new HashMap();
		item.put("name", list);
		item.put("count",listLong);
		return item;
	}

	/* (non-Javadoc)    
	 * @see org.lv.shop.service.analysis.AnalysisService#getAnalysisByCondition(java.lang.String)    
	 */
	@Override
	public Map getAnalysisByCondition(String datetime) {
		List<Map> mapList=analysisMapper.getAnalysisByCondition(datetime);
		List<String> list=new ArrayList<String>();
		List<Map> listInfo=new ArrayList<Map>();
		for (Map item : mapList) {
			list.add((String) item.get("brandName"));
			Map map=new HashMap();
			map.put("value",item.get("count"));
			map.put("name",item.get("brandName"));
			listInfo.add(map);
		}
		Map map=new HashMap();
		map.put("legend",list);
		map.put("series",listInfo);
		return map;
	}
	
}
