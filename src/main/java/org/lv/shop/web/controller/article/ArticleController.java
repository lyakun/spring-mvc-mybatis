/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:ArticleController.java 
 * 包名:org.lv.shop.web.controller.Article 
 * 创建日期:2017年6月1日下午6:42:26 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.web.controller.article;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.lv.shop.entity.article.Article;
import org.lv.shop.service.article.ArticleService;
import org.lv.shop.util.JsonUtil;
import org.lv.shop.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：ArticleController    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年6月1日 下午6:42:26    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年6月1日 下午6:42:26    
 * 修改备注：       
 * @version   
 */
@Controller
@RequestMapping("article")
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	private Page page=new Page();
	
	/**
	 * getArticlePage(跳转文章展示页面)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月1日 下午6:50:18    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月1日 下午6:50:18    
	 * 修改备注： 
	 * @return
	 */
	@RequestMapping("getArticlePage")
	public String getArticlePage(){
		return "article/article_list_page";
	}
	/**
	 * getArticleList(文章的集合查询方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月1日 下午6:57:44    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月1日 下午6:57:44    
	 * 修改备注：
	 * @param response 
	 */
	@RequestMapping("getArticleList")
	public void getArticleList(Article article,Integer offset,Integer limit, HttpServletResponse response){
			page.setObj(article);
			page.setStrat(offset);
			page.setPagecount(limit);
			articleService.getArticleList(page);
			Map map=new HashMap();
			map.put("total", page.getPagesumcount());
			map.put("rows",page.getList());
			String str = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd HH:mm:ss");
			JsonUtil.outJson(str, response);
	}
	/**
	 * addArticlePage(跳转文章增加页面)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月1日 下午7:13:55    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月1日 下午7:13:55    
	 * 修改备注： 
	 * @return
	 */
	@RequestMapping("addArticlePage")
	public String addArticlePage(){
		return "article/add_article_page";
	}
	/**
	 * addArticle(文章的增加方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月1日 下午7:55:11    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月1日 下午7:55:11    
	 * 修改备注： 
	 * @param article
	 * @return
	 */
	@RequestMapping("addArticle")
	public String addArticle(Article article){
			articleService.insertArticle(article);
		return "redirect:/article/getArticlePage.gang";
	}
	/**
	 * deleteArticleById(根据文章id的删除方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月1日 下午8:27:35    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月1日 下午8:27:35    
	 * 修改备注：
	 * @param response 
	 */
	@RequestMapping("deleteArticleById")
	public void deleteArticleById(Article article, HttpServletResponse response){
			articleService.deleteArticleById(article);
			JsonUtil.outJson("1", response);
	}
	/**
	 * toupdateArticleById(跳转文章修改页面并携带要修改的数据)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月1日 下午8:32:40    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月1日 下午8:32:40    
	 * 修改备注： 
	 * @return
	 */
	@RequestMapping("toupdateArticleById")
	public String toupdateArticleById(ModelMap map,Article article){
			Article art=articleService.toupdateArticleById(article.getArticleId());
			map.put("article", art);
		return "article/update_article_page";
	}
	@RequestMapping("updateArticleById")
	public String updateArticleById(Article article){
			articleService.updateArticleById(article);
		return "redirect:/article/getArticlePage.gang";
	}
	/**
	 * deleteArticleByArray(批量删除方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月1日 下午9:19:32    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月1日 下午9:19:32    
	 * 修改备注：
	 * @param response 
	 */
	@RequestMapping("deleteArticleByArray")
	public void deleteArticleByArray(String ids, HttpServletResponse response){
			articleService.deleteArticleByArray(ids);
			JsonUtil.outJson("1", response);
	}
	/**
	 * toArticle(查看文章内容)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月1日 下午9:31:07    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月1日 下午9:31:07    
	 * 修改备注： 
	 * @return
	 */
	@RequestMapping("toArticle")
	public String toArticle(Article art,ModelMap map){
			Article article=articleService.toArticle(art.getArticleId());
			map.put("article", article);
		return "article/article_context_page";
	}
	/**
	 * articleDraft(把文章存为草稿方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月6日 上午12:21:39    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月6日 上午12:21:39    
	 * 修改备注：
	 */
	@RequestMapping("articleDraft")
	public void articleDraft(Article article){
			articleService.articleDraft(article);
	}
	/**
	 * draftArticle(跳转草稿内容页面)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月6日 上午12:41:32    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月6日 上午12:41:32    
	 * 修改备注： 
	 * @return
	 */
	@RequestMapping("draftArticle")
	public String draftArticle(Article article,ModelMap map){
			Article art=articleService.draftArticle(article);
			map.put("article", art);
		return "article/article_draft_page";
	}
	
	/**------------------------------------------------------------------*/
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	
}
