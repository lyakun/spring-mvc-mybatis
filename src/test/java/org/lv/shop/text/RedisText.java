/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:RedisText.java 
 * 包名:org.lv.shop.text 
 * 创建日期:2017年6月7日下午9:53:01 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.text;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：RedisText    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年6月7日 下午9:53:01    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年6月7日 下午9:53:01    
 * 修改备注：       
 * @version   
 */
public class RedisText {
	/* private static int MAX_ACTIVE = 1024;
	    
	    //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
	    private static int MAX_IDLE = 200;
	    
	    //等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
	    private static long MAX_WAIT = 10000;
	    
	    private static int TIMEOUT = 10000;
	    
	    //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
	    private static boolean TEST_ON_BORROW = true;
	    
	    private static JedisPool jedisPool = null;
	 static{
		JedisPoolConfig config=new JedisPoolConfig();
        config.setMaxIdle(MAX_IDLE);
        config.setMaxWaitMillis(MAX_WAIT);
        config.setTestOnBorrow(TEST_ON_BORROW);
        jedisPool=new JedisPool(config,"192.168.5.128",6379,TIMEOUT,null);
	}
	*/
	 public static void main(String arf[]){
		 JedisCluster jedis=new JedisCluster(new HostAndPort("192.168.5.128",6379));
		 String string = jedis.get("gang");
		 jedis.set("menuList","哈哈哈");
		 System.out.println(string);
		 System.out.println( jedis.get("menuList"));
		
	 }
}
