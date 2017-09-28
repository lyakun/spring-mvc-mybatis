package org.lv.shop.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;
import org.springframework.web.multipart.MultipartFile;
/**
 * 
 * 项目名称：spring-mvc    
 * 类名称：FileUpload    
 * 类描述：    sprimg mvc文件上传工具类
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年4月16日 下午3:48:21    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年4月16日 下午3:48:21    
 * 修改备注：       
 * @version
 */
public class FileUpload {  
  
    /**
     * uploadFile(上传文件到服务器根目录)   
     * 创建人：吕金刚 lvjghappy@163.com    
     * 创建时间：2017年6月11日 下午12:11:58    
     * 修改人：吕金刚 lvjghappy@163.com     
     * 修改时间：2017年6月11日 下午12:11:58    
     * 修改备注： 
     * @param file
     * @param request
     * @return
     * @throws IOException
     */
    public static String uploadFile(MultipartFile file, HttpServletRequest request) throws IOException {  
        String fileName = file.getOriginalFilename();  
        String path=request.getSession().getServletContext().getRealPath("images/");  
        File tempFile = new File(path, new Date().getTime() + String.valueOf(fileName));  
        if (!tempFile.getParentFile().exists()) {  
            tempFile.getParentFile().mkdir();  
        }  
        if (!tempFile.exists()) {  
            tempFile.createNewFile();  
        }  
        file.transferTo(tempFile);  
        return "images/" + tempFile.getName();  
    } 
    /**
     * xiazai(下载单个文件)   
     * 创建人：吕金刚 lvjghappy@163.com    
     * 创建时间：2017年6月11日 下午12:11:40    
     * 修改人：吕金刚 lvjghappy@163.com     
     * 修改时间：2017年6月11日 下午12:11:40    
     * 修改备注： 
     * @param newPath
     * @param request
     * @param response
     */
    public static void downFile(String newPath,HttpServletRequest request,HttpServletResponse response){
		// 2. 实例化 文件对象  
		File f = new File(newPath);
		// 3. 获得文件名
		String fileName = f.getName();
		// 4. 定义输入输出流
		BufferedInputStream br=null;
		BufferedOutputStream bw=null;
		try {
			// 5. 获得输入流
			br = new BufferedInputStream(new FileInputStream(f));
			bw = new BufferedOutputStream(response.getOutputStream());
			File file=new File(newPath);
			if(!file.exists()){
				file.mkdir();
			}
			 if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0) {
		        	fileName = new String(fileName.getBytes("GB2312"),"ISO-8859-1");
		        } else {
		        	// 对文件名进行编码处理中文问题
		        	fileName = java.net.URLEncoder.encode(fileName, "UTF-8");// 处理中文文件名的问题
		        	fileName = new String(fileName.getBytes("UTF-8"), "GBK");// 处理中文文件名的问题
		        }
		        response.reset();
		        response.setContentType("application/x-msdownload");// 不同类型的文件对应不同的MIME类型
			     // inline在浏览器中直接显示，不提示用户下载
			        // attachment弹出对话框，提示用户进行下载保存本地
			        // 默认为inline方式
		        response.setHeader("Content-Disposition", "attachment;filename="+fileName);
		        byte[] b = new byte[20480];
			while(br.read(b)!=-1){
				bw.write(b);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(bw!=null){
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}if(br!=null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
    /**
     * downFileZip(文件进行打包下载)   
     * 创建人：吕金刚 lvjghappy@163.com    
     * 创建时间：2017年6月11日 下午12:14:52    
     * 修改人：吕金刚 lvjghappy@163.com     
     * 修改时间：2017年6月11日 下午12:14:52    
     * 修改备注：
     */
    public static void downZipFile(HttpServletRequest request,HttpServletResponse response,List<String> fileUrlList,String downloadName){
		
		try{
			downloadName = URLEncoder.encode(downloadName, "UTF-8");//转换中文否则可能会产生乱码
	        response.setContentType("application/octet-stream");// 指明response的返回对象是文件流 
	        response.setHeader("Content-Disposition", "attachment;filename=" + downloadName);// 设置在下载框默认显示的文件名
	        ZipOutputStream zos = new ZipOutputStream(response.getOutputStream());
	        for (int i=0;i<fileUrlList.size();i++) {
	        	   String newPath = request.getRealPath(fileUrlList.get(i));
	        	   //实例化文件对象
	        	   File f = new File(newPath);
	        	   //获取文本的名称
	        	   String fileName=f.getName();
		           zos.putNextEntry(new ZipEntry(fileName));
		           InputStream fis =new FileInputStream(newPath);
		           byte[] buffer = new byte[10240];     
		           int r = 0;     
		           while ((r = fis.read(buffer)) != -1) {     
		               zos.write(buffer, 0, r);     
		           }     
		           fis.close();   
		     }  
	        zos.flush();     
	        zos.close();
	    } catch (UnsupportedEncodingException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
			e.printStackTrace();
		}  
	}
  
} 