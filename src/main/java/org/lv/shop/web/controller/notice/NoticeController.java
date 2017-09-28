/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:Notic.java 
 * 包名:org.lv.shop.web.controller.notice 
 * 创建日期:2017年5月28日上午11:35:06 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.web.controller.notice;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.lv.shop.entity.notice.Notice;
import org.lv.shop.service.notice.NoticeService;
import org.lv.shop.util.JsonUtil;
import org.lv.shop.util.OutFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：Notic    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年5月28日 上午11:35:06    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年5月28日 上午11:35:06    
 * 修改备注：       
 * @version   
 */
@Controller
@RequestMapping("notice")
public class NoticeController{
	@Autowired
	private NoticeService noticeService;
	/**
	 * getNoticePage(跳转公告查询页面)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月28日 上午11:37:32    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月28日 上午11:37:32    
	 * 修改备注： 
	 * @return
	 */
	@RequestMapping("getNoticePage")
	public String getNoticePage(){
		return "notice/notice_list_page";
	}
	/**
	 * toNoticeAllPage(根据公告Id查询公告内容,并跳转页面)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月28日 下午1:31:26    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月28日 下午1:31:26    
	 * 修改备注： 
	 * @param notice
	 * @return
	 */
	@RequestMapping("toNoticeAllPage")
	public String toNoticeAllPage(Notice notice,ModelMap map){
		Notice nt=noticeService.toNoticePageById(notice.getNoticeId());
		map.put("notice", nt);
		return "notice/notice_page";
	}
	/**
	 * getNoticeList(查询公告集合)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月28日 下午1:56:58    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月28日 下午1:56:58    
	 * 修改备注： 
	 * @param notice
	 * @param response
	 */
	@RequestMapping("getNoticeList")
	public void getNoticeList(Notice notice, HttpServletResponse response){
		List<Notice> list=noticeService.getNoticeList(notice);
		int noticeCount=noticeService.getNoticeCount(notice);
		Map map=new HashMap();
		map.put("total", noticeCount);
		map.put("rows", list);
		JsonUtil.outJson(map, response);
	}
	/**
	 * getAddNoticePage(跳转增加公告页面)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月28日 下午2:04:23    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月28日 下午2:04:23    
	 * 修改备注： 
	 * @return
	 */
	@RequestMapping("getAddNoticePage")
	public String getAddNoticePage(){
		return "notice/add_notice_page";
	}
	/**
	 * addNotice(公告的增加方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月28日 下午2:24:07    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月28日 下午2:24:07    
	 * 修改备注： 
	 * @return
	 */
	@RequestMapping("addNotice")
	public String addNotice(Notice notice){
		noticeService.insertNotice(notice);
		return "redirect:/notice/getNoticePage.gang";
	}
	/**
	 * toupdateNotice(跳转公告编辑页面)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月30日 下午6:16:50    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月30日 下午6:16:50    
	 * 修改备注： 
	 * @return
	 */
	@RequestMapping("toupdateNotice")
	public String toupdateNotice(Notice notice,ModelMap map){
		Notice nt=noticeService.toNoticePageById(notice.getNoticeId());
		map.put("notice", nt);
		return "notice/update_notice_page";
	}
	/**
	 * updateNotice(保存修改后的公告)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月30日 下午6:24:20    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月30日 下午6:24:20    
	 * 修改备注： 
	 * @return
	 */
	@RequestMapping("updateNotice")
	public String  updateNotice(Notice notice){
		noticeService.updateNotice(notice);
		return "redirect:/notice/getNoticePage.gang";
	}
	/**
	 * updateNoticeYes(通过公告)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月30日 下午6:47:29    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月30日 下午6:47:29    
	 * 修改备注：
	 * @param response 
	 */
	@RequestMapping("updateNoticeYes")
	public void updateNoticeYes(Notice notice, HttpServletResponse response){
		noticeService.updateNoticeYes(notice);
	}
	/**
	 * updateNoticeNo(公告审核未通过)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月30日 下午6:58:21    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月30日 下午6:58:21    
	 * 修改备注：
	 */
	@RequestMapping("updateNoticeNo")
	public void updateNoticeNo(Notice notice,HttpServletResponse response){
		noticeService.updateNoticeNo(notice);
	}
	/**
	 * updateNoticeStatus(公告强制停用)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月30日 下午7:13:02    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月30日 下午7:13:02    
	 * 修改备注：
	 * @param response 
	 */
	@RequestMapping("updateNoticeStatus")
	public void updateNoticeStatus(Notice notice, HttpServletResponse response){
		noticeService.updateNoticeStatus(notice);
	}
	/**
	 * deleteNoticeAll(公告的批量删除方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年5月30日 下午7:33:01    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年5月30日 下午7:33:01    
	 * 修改备注： 
	 * @param ids
	 * @param response 
	 */
	@RequestMapping("deleteNoticeAll")
	public void deleteNoticeAll(String ids, HttpServletResponse response){
		noticeService.deleteNoticeAll(ids);
	}
	/**
	 * exportXml(导出excel)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月5日 下午8:40:06    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月5日 下午8:40:06    
	 * 修改备注：
	 */
	@RequestMapping("exportXml")
	public void exportXml(HttpServletResponse response,Notice notice){
		try {
			List<Notice> noticeLsit=noticeService.getNoticeList(notice);
			Document document=DocumentHelper.createDocument();
			Element noticeListElement = document.addElement("noticeList");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			for (Notice noticeInfo : noticeLsit) {
				Element noticeElement = noticeListElement.addElement("notice");
				Element nElement=noticeElement.addElement("notice");
				nElement.addAttribute("id",noticeInfo.getNoticeId());
				Element createTimeElement = noticeElement.addElement("createTime");
				createTimeElement.addText(sdf.format(noticeInfo.getNoticeCreateTime()));
				Element noticeStatusElement = noticeElement.addElement("noticeStatus");
				if(noticeInfo.getNoticeStatus()==1){
					noticeStatusElement.addText("正常");
				}
				if(noticeInfo.getNoticeStatus()==0){
					noticeStatusElement.addText("停用");
				}
				Element noticeValidatorStatusElement = noticeElement.addElement("noticeValidatorStatus");
				if(noticeInfo.getNoticeValidatorStatus()==0){
					noticeValidatorStatusElement.addText("待审核");
				}else if(noticeInfo.getNoticeValidatorStatus()==1){
					noticeValidatorStatusElement.addText("审核通过");
				}else if(noticeInfo.getNoticeValidatorStatus()==2){
					noticeValidatorStatusElement.addText("审核未通过");
				}
			}
			OutFile.outXml(response, document, "notice.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
