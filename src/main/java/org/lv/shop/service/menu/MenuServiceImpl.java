/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:MenuServiceImpl.java 
 * 包名:org.lv.shop.service.menu 
 * 创建日期:2017年5月27日下午2:08:45 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.service.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.lv.shop.entity.menu.Menu;
import org.lv.shop.mapper.menu.MenuMapper;
import org.lv.shop.util.CacheManager;
import org.lv.shop.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：MenuServiceImpl    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年5月27日 下午2:08:45    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年5月27日 下午2:08:45    
 * 修改备注：       
 * @version   
 */
@Service
public class MenuServiceImpl implements MenuService{
	@Autowired
	private MenuMapper menuMapper;
	private static JedisCluster jedis=new JedisCluster(new HostAndPort("192.168.1.156",6379));
	/* (non-Javadoc)    
	 * @see org.lv.shop.service.menu.MenuService#getTreeList()    
	 */
	@Override
	public List<Map> getTreeList(String userId) {
		//List<Menu> list = (List<Menu>) CacheManager.getInstance().getObj("list");
		List<Menu> list=JSONObject.parseArray(jedis.get(userId),Menu.class);
		if(null==list){
			 list=menuMapper.getTreeList(userId);
			 //缓存到oscache中
			 //CacheManager.getInstance().putObj("list",list);
			 //缓存在redis中
			 if(list.size()>0){
				 jedis.setex(userId,60,JSONObject.toJSONString(list));
			 }
		}
		List<Map> menuList=getTreeListByPid(list,0);
		for (Map map : menuList) {
			List<Map> children =getTreeChildren(map,list);
			map.put("nodes", children);
		}
		return menuList;
	}

	/** getTreeChildren(这里用一句话描述这个方法的作用)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月27日 下午2:47:28    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月27日 下午2:47:28    
	 * 修改备注： 
	 * @param menuId
	 * @param list
	 * @return  
	 */
	private List<Map> getTreeChildren(Map map, List<Menu> list) {
		List<Map> children = new ArrayList<Map>();
		for (Menu map2 : list) {
			if((int)map.get("id")==map2.getPid()){
				Map itemMap = new HashMap();
				itemMap.put("id",map2.getMenuId());
				itemMap.put("pid",map2.getPid());
				itemMap.put("text",map2.getMenuName());
				itemMap.put("url", map2.getMenuUrl());
				List<Map> treeChildren = getTreeChildren(itemMap,list);
				if(treeChildren.size()>0){
					itemMap.put("nodes",treeChildren);
				}
				children.add(itemMap);
			}
		}
		return children;
	}

	/** getTreeListByPid(这里用一句话描述这个方法的作用)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月27日 下午2:36:36    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月27日 下午2:36:36    
	 * 修改备注： 
	 * @param list
	 * @param i
	 * @return  
	 */
	private List<Map> getTreeListByPid(List<Menu> list, int i) {
		List<Map> mapList =new ArrayList<Map>();
		for (Menu map : list) {
			if(map.getPid()==i){
				Map item = new HashMap();
				item.put("id", map.getMenuId());
				item.put("pid", map.getPid());
				item.put("text", map.getMenuName());
				item.put("url", map.getMenuUrl());
				mapList.add(item);
			}
		}
		return mapList;
	}

	/* (non-Javadoc)    
	 * @see org.lv.shop.service.menu.MenuService#getTreeListAll()    
	 */
	@Override
	public List<Map> getTreeListAll(String id) {
		List<Menu> list=menuMapper.getTreeListAll();
		List<Menu> alllist=menuMapper.getTreeListAllByUserId(id);
		List<Map> menuList=getTreeListByPidAll(list,0,alllist);
		for (Map map : menuList) {
			List<Map> children =getTreeChildrenAll(map,list);
			map.put("nodes", children);
		}
		return menuList;
	}

	/** getTreeChildren(这里用一句话描述这个方法的作用)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月27日 下午2:47:28    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月27日 下午2:47:28    
	 * 修改备注： 
	 * @param menuId
	 * @param list
	 * @return  
	 */
	private List<Map> getTreeChildrenAll(Map map, List<Menu> list) {
		List<Map> children = new ArrayList<Map>();
		for (Menu map2 : list) {
			
			if((int)map.get("nodeId")==map2.getPid()){
				Map itemMap = new HashMap();
				itemMap.put("nodeId",map2.getMenuId());
				itemMap.put("pid",map2.getPid());
				itemMap.put("text",map2.getMenuName());
				if(map2.getState()!=null){
					Map state=new HashMap();
					state.put("checked",true);//默认被选中
					state.put("expanded",true);
					itemMap.put("state",state);
				}
				List<Map> treeChildren = getTreeChildrenAll(itemMap,list);
				if(treeChildren.size()>0){
					itemMap.put("nodes",treeChildren);
				}
				children.add(itemMap);
			}
		}
		return children;
	}

	/** getTreeListByPid(这里用一句话描述这个方法的作用)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月27日 下午2:36:36    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月27日 下午2:36:36    
	 * 修改备注： 
	 * @param list
	 * @param i
	 * @return  
	 */
	private List<Map> getTreeListByPidAll(List<Menu> list, int i,List<Menu> alllist) {
		List<Map> mapList =new ArrayList<Map>();
		for (Menu map : list) {
			for (Menu menu : alllist) {
				if(map.getMenuId()==menu.getMenuId()){
					Map state=new HashMap();
					state.put("checked",true);//默认被选中
					state.put("expanded",true);//默认展开节点
					map.setState(state);
				}
			}
			if(map.getPid()==i){
				Map item = new HashMap();
				item.put("nodeId", map.getMenuId());
				item.put("pid", map.getPid());
				item.put("text", map.getMenuName());
				if(map.getState()!=null){
					Map state=new HashMap();
					state.put("checked",true);//默认被选中
					state.put("expanded",true);
					item.put("state",state);
				}
				mapList.add(item);
			}
		}
		return mapList;
	}
	
}
