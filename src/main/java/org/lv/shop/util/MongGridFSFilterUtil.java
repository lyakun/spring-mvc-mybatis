/** 
 * 项目名称:book-manager-lvjingang 
 * 文件名称:MongGridFsUtil.java 
 * 包名:com.dangdang.bookshop.util 
 * 创建日期:2017年6月12日下午7:54:40 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.util;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.types.ObjectId;
import org.springframework.web.multipart.MultipartFile;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;

/** 
 * 项目名称：book-manager-lvjingang    
 * 类名称：MongGridFsUtil    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年6月12日 下午7:54:40    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年6月12日 下午7:54:40    
 * 修改备注：       
 * @version   
 */
public class MongGridFSFilterUtil {
	private static final MongoClient CLIENT=new MongoClient("127.0.0.1:27017");
	/**
	 * saveFile(把文件保存在mongo)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月12日 下午8:01:45    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月12日 下午8:01:45    
	 * 修改备注： 
	 * @param imgfile
	 * @param request
	 * @return
	 * @throws IOException 
	 */
	public static String saveFile(MultipartFile imgfile,HttpServletRequest request,String dbName) throws IOException{
		DB db=CLIENT.getDB(dbName);
		GridFS gridFS = new GridFS(db);  
	    GridFSInputFile gridFSInputFile = gridFS.createFile(imgfile.getInputStream()); 
	    gridFSInputFile.setFilename(imgfile.getOriginalFilename());
	    gridFSInputFile.save();  
		return gridFSInputFile.getId().toString();
	}
	/**
	 * findOne(根据Id查询文件)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月12日 下午8:05:14    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月12日 下午8:05:14    
	 * 修改备注：
	 */
	public static void findOne(String id,HttpServletResponse response,String dbName){
		DB db = CLIENT.getDB(dbName);
		GridFS gridFS = new GridFS(db);
		GridFSDBFile fsdbFile=gridFS.findOne(new ObjectId(id));
		try { 
			OutputStream sos = response.getOutputStream();   
	        fsdbFile.writeTo(sos);
	        sos.flush();
	        sos.close();
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    }  
	}
	/**
	 * remove(根据id删除mongo中的文件)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月13日 下午12:26:57    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月13日 下午12:26:57    
	 * 修改备注： 
	 * @param id
	 * @param dbName
	 */
	public static void remove(String id,String dbName){
		DB db = CLIENT.getDB(dbName);
		GridFS gridFS = new GridFS(db);
		gridFS.remove(new ObjectId(id));
	}
}
