/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:NoticeServiceImpl.java 
 * 包名:org.lv.shop.service.notice 
 * 创建日期:2017年5月28日上午11:39:15 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.service.notice;

import java.util.List;
import java.util.UUID;

import org.lv.shop.entity.notice.Notice;
import org.lv.shop.mapper.notice.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：NoticeServiceImpl    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年5月28日 上午11:39:15    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年5月28日 上午11:39:15    
 * 修改备注：       
 * @version   
 */
@Service
public class NoticeServiceImpl implements NoticeService{
	@Autowired
	private NoticeMapper noticeMapper;

	/* (non-Javadoc)    
	 * @see org.lv.shop.service.notice.NoticeService#toNoticePageById(java.lang.String)    
	 */
	@Override
	public Notice toNoticePageById(String noticeId) {
		
		return noticeMapper.toNoticePageById(noticeId);
	}

	/* (non-Javadoc)    
	 * @see org.lv.shop.service.notice.NoticeService#getNoticeList(org.lv.shop.entity.notice.Notice)    
	 */
	@Override
	public List<Notice> getNoticeList(Notice notice) {
		return noticeMapper.getNoticeList(notice);
	}

	/* (non-Javadoc)    
	 * @see org.lv.shop.service.notice.NoticeService#getNoticeCount(org.lv.shop.entity.notice.Notice)    
	 */
	@Override
	public int getNoticeCount(Notice notice) {
		return noticeMapper.getNoticeCount(notice);
	}

	/* (non-Javadoc)    
	 * @see org.lv.shop.service.notice.NoticeService#insertNotice(org.lv.shop.entity.notice.Notice)    
	 */
	@Override
	public void insertNotice(Notice notice) {
		notice.setNoticeId(UUID.randomUUID().toString());
		notice.setNoticeStatus(1);
		notice.setNoticeValidatorStatus(0);
		noticeMapper.insertNotice(notice);
	}

	/* (non-Javadoc)    
	 * @see org.lv.shop.service.notice.NoticeService#updateNotice(org.lv.shop.entity.notice.Notice)    
	 */
	@Override
	public void updateNotice(Notice notice) {
		notice.setNoticeStatus(1);
		notice.setNoticeValidatorStatus(0);
		noticeMapper.updateNotice(notice);
	}

	/* (non-Javadoc)    
	 * @see org.lv.shop.service.notice.NoticeService#updateNoticeYes(org.lv.shop.entity.notice.Notice)    
	 */
	@Override
	public void updateNoticeYes(Notice notice) {
		notice.setNoticeValidatorStatus(1);
		notice.setNoticeStatus(1);
		noticeMapper.updateNoticeYes(notice);
	}

	/* (non-Javadoc)    
	 * @see org.lv.shop.service.notice.NoticeService#updateNoticeNo(org.lv.shop.entity.notice.Notice)    
	 */
	@Override
	public void updateNoticeNo(Notice notice) {
		notice.setNoticeValidatorStatus(2);
		noticeMapper.updateNoticeNo(notice);
	}

	/* (non-Javadoc)    
	 * @see org.lv.shop.service.notice.NoticeService#updateNoticeStatus(org.lv.shop.entity.notice.Notice)    
	 */
	@Override
	public void updateNoticeStatus(Notice notice) {
		notice.setNoticeStatus(0);
		noticeMapper.updateNoticeStatus(notice);
	}

	/* (non-Javadoc)    
	 * @see org.lv.shop.service.notice.NoticeService#deleteNoticeAll(java.lang.String)    
	 */
	@Override
	public void deleteNoticeAll(String ids) {
		String[] id=ids.split(",");
		noticeMapper.deleteNoticeAll(id);
	}
}
