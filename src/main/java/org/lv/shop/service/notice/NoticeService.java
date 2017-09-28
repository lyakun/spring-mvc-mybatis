/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:NoticeService.java 
 * 包名:org.lv.shop.service.notice 
 * 创建日期:2017年5月28日上午11:39:02 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.service.notice;

import java.util.List;

import org.lv.shop.entity.notice.Notice;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：NoticeService    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年5月28日 上午11:39:02    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年5月28日 上午11:39:02    
 * 修改备注：       
 * @version   
 */
public interface NoticeService {

	/** toNoticePageById(根据Id查出告内容)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月28日 下午1:37:24    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月28日 下午1:37:24    
	 * 修改备注： 
	 * @param noticeId
	 * @return  
	 */
	Notice toNoticePageById(String noticeId);

	/** getNoticeList(查询公告集合)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月28日 下午1:51:46    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月28日 下午1:51:46    
	 * 修改备注： 
	 * @param notice
	 * @return  
	 */
	List<Notice> getNoticeList(Notice notice);

	/** getNoticeCount(查询公告总条数)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月28日 下午1:51:51    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月28日 下午1:51:51    
	 * 修改备注： 
	 * @param notice
	 * @return  
	 */
	int getNoticeCount(Notice notice);

	/** insertNotice(公告的增加方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月28日 下午2:26:03    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月28日 下午2:26:03    
	 * 修改备注： 
	 * @param notice  
	 */
	void insertNotice(Notice notice);

	/** updateNotice(保存修改的公告)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月30日 下午6:26:39    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月30日 下午6:26:39    
	 * 修改备注： 
	 * @param notice  
	 */
	void updateNotice(Notice notice);

	/** updateNoticeYes(通过公告)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月30日 下午6:51:52    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月30日 下午6:51:52    
	 * 修改备注： 
	 * @param notice  
	 */
	void updateNoticeYes(Notice notice);

	/** updateNoticeNo(公告审核未通过)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月30日 下午7:00:30    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月30日 下午7:00:30    
	 * 修改备注： 
	 * @param notice  
	 */
	void updateNoticeNo(Notice notice);

	/** updateNoticeStatus(公告强制停用)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月30日 下午7:15:44    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月30日 下午7:15:44    
	 * 修改备注： 
	 * @param notice  
	 */
	void updateNoticeStatus(Notice notice);

	/** deleteNoticeAll(公告的批量删除方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月30日 下午7:34:27    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月30日 下午7:34:27    
	 * 修改备注： 
	 * @param ids  
	 */
	void deleteNoticeAll(String ids);

}
