package org.lv.shop.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeUtil {
	/**
	 * serialize(对象序列化)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月10日 上午8:29:01    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月10日 上午8:29:01    
	 * 修改备注： 
	 * @param object
	 * @return
	 */
	public static byte[] serialize(Object object) {  
		ObjectOutputStream oos = null;  
		ByteArrayOutputStream baos = null;  
		try {  
		//序列化  
		baos = new ByteArrayOutputStream();  
		oos = new ObjectOutputStream(baos);  
		oos.writeObject(object);  
		byte[] bytes = baos.toByteArray();  
		return bytes;  
		} catch (Exception e) {  
		}  
		return null;  
		}  
	/**
	 * 	  unserialize(反序列化)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月10日 上午8:29:21    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月10日 上午8:29:21    
	 * 修改备注： 
	 * @param bytes
	 * @return
	 */
	public static Object unserialize(byte[] bytes) {  
		ByteArrayInputStream bais = null;  
		try {  
		//反序列化  
		bais = new ByteArrayInputStream(bytes);  
		ObjectInputStream ois = new ObjectInputStream(bais);  
		return ois.readObject();  
		} catch (Exception e) {  
		}  
		return null;  
		}  
		
}
