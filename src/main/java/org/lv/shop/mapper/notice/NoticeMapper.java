/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:NoticeMapper.java 
 * 包名:org.lv.shop.mapper.notice 
 * 创建日期:2017年5月28日上午11:39:43 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.mapper.notice;

import java.util.List;

import org.lv.shop.entity.notice.Notice;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：NoticeMapper    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年5月28日 上午11:39:43    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年5月28日 上午11:39:43    
 * 修改备注：       
 * @version   
 */
public interface NoticeMapper {

	/** toNoticePageById(根据Id查出公告的内容)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月28日 下午1:38:50    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月28日 下午1:38:50    
	 * 修改备注： 
	 * @param noticeId
	 * @return  
	 */
	Notice toNoticePageById(String noticeId);

	/** getNoticeList(查询公告集合)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月28日 下午1:52:51    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月28日 下午1:52:51    
	 * 修改备注： 
	 * @param notice
	 * @return  
	 */
	List<Notice> getNoticeList(Notice notice);

	/** getNoticeCount(查询公告总条数)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月28日 下午1:52:57    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月28日 下午1:52:57    
	 * 修改备注： 
	 * @param notice
	 * @return  
	 */
	int getNoticeCount(Notice notice);

	/** insertNotice(公共的增加方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月28日 下午2:26:37    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月28日 下午2:26:37    
	 * 修改备注： 
	 * @param notice  
	 */
	void insertNotice(Notice notice);

	/** updateNotice(保存修改后的公告)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月30日 下午6:29:18    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月30日 下午6:29:18    
	 * 修改备注： 
	 * @param notice  
	 */
	void updateNotice(Notice notice);

	/** updateNoticeYes(通过公告)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月30日 下午6:53:33    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月30日 下午6:53:33    
	 * 修改备注： 
	 * @param notice  
	 */
	void updateNoticeYes(Notice notice);

	/** updateNoticeNo(审核未通过)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月30日 下午7:01:10    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月30日 下午7:01:10    
	 * 修改备注： 
	 * @param notice  
	 */
	void updateNoticeNo(Notice notice);

	/** updateNoticeStatus(强制停用公告)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月30日 下午7:16:51    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月30日 下午7:16:51    
	 * 修改备注： 
	 * @param notice  
	 */
	void updateNoticeStatus(Notice notice);

	/** deleteNoticeAll(公告的批量删除方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月30日 下午7:35:25    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月30日 下午7:35:25    
	 * 修改备注： 
	 * @param id  
	 */
	void deleteNoticeAll(String[] id);

}
