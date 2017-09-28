/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:RedisUtil.java 
 * 包名:org.lv.shop.util 
 * 创建日期:2017年6月8日下午5:05:21 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.util;

import java.io.IOException;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：RedisUtil    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年6月8日 下午5:05:21    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年6月8日 下午5:05:21    
 * 修改备注：       
 * @version   
 */
public class RedisUtil {
	public static final JedisCluster jedis=new JedisCluster(new HostAndPort("192.168.5.128",6379));
	
	public static void closeRedis(JedisCluster jedis){
		try {
			jedis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
