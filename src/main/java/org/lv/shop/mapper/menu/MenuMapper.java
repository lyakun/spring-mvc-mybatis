/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:MenuMapper.java 
 * 包名:org.lv.shop.mapper.menu 
 * 创建日期:2017年5月27日下午2:14:18 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.mapper.menu;

import java.util.List;

import org.lv.shop.entity.menu.Menu;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：MenuMapper    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年5月27日 下午2:14:18    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年5月27日 下午2:14:18    
 * 修改备注：       
 * @version   
 */
public interface MenuMapper {

	/** getTreeList(获取树)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月27日 下午2:15:04    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月27日 下午2:15:04    
	 * 修改备注： 
	 * @param userId 
	 * @return  
	 */
	List<Menu> getTreeList(String userId);

	/** getTreeListAll(这里用一句话描述这个方法的作用)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月23日 下午8:14:08    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月23日 下午8:14:08    
	 * 修改备注： 
	 * @param id 
	 * @return  
	 */
	List<Menu> getTreeListAll();

	/** getTreeListAllByUserId(这里用一句话描述这个方法的作用)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月24日 上午7:23:22    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月24日 上午7:23:22    
	 * 修改备注： 
	 * @param id
	 * @return  
	 */
	List<Menu> getTreeListAllByUserId(String id);

}
