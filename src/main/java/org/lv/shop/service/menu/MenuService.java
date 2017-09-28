/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:MenuService.java 
 * 包名:org.lv.shop.service.menu 
 * 创建日期:2017年5月27日下午2:08:32 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.service.menu;

import java.util.List;
import java.util.Map;

import org.lv.shop.entity.menu.Menu;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：MenuService    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年5月27日 下午2:08:32    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年5月27日 下午2:08:32    
 * 修改备注：       
 * @version   
 */
public interface MenuService {

	/** getTreeList(获取树)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月27日 下午2:13:16    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月27日 下午2:13:16    
	 * 修改备注： 
	 * @return  
	 */
	List<Map> getTreeList(String userId);

	/** getTreeListAll(这里用一句话描述这个方法的作用)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月23日 下午8:13:12    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月23日 下午8:13:12    
	 * 修改备注： 
	 * @param id 
	 * @return  
	 */
	List<Map> getTreeListAll(String id);

}
