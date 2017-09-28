/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:ArticleService.java 
 * 包名:org.lv.shop.service.article 
 * 创建日期:2017年6月1日下午6:43:18 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.service.article;

import org.lv.shop.entity.article.Article;
import org.lv.shop.util.Page;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：ArticleService    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年6月1日 下午6:43:18    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年6月1日 下午6:43:18    
 * 修改备注：       
 * @version   
 */
public interface ArticleService {

	/** getArticleList(文章查询集合方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月1日 下午7:04:45    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月1日 下午7:04:45    
	 * 修改备注： 
	 * @param page  
	 */
	void getArticleList(Page page);

	/** insertArticle(文章的增加方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月1日 下午7:25:17    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月1日 下午7:25:17    
	 * 修改备注： 
	 * @param article  
	 */
	void insertArticle(Article article);

	/** deleteArticleById(根据id删除文章)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月1日 下午8:29:43    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月1日 下午8:29:43    
	 * 修改备注： 
	 * @param article  
	 */
	void deleteArticleById(Article article);

	/** toupdateArticleById(查询要修改的文章)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月1日 下午8:35:24    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月1日 下午8:35:24    
	 * 修改备注： 
	 * @param articleId
	 * @return  
	 */
	Article toupdateArticleById(String articleId);

	/** updateArticleById(修改后的保存)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月1日 下午9:03:38    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月1日 下午9:03:38    
	 * 修改备注： 
	 * @param article  
	 */
	void updateArticleById(Article article);

	/** deleteArticleByArray(批量删除方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月1日 下午9:21:15    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月1日 下午9:21:15    
	 * 修改备注： 
	 * @param ids  
	 */
	void deleteArticleByArray(String ids);

	/** toArticle(查询文章内容)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月1日 下午9:34:41    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月1日 下午9:34:41    
	 * 修改备注： 
	 * @param id
	 * @return  
	 */
	Article toArticle(String id);

	/** articleDraft(将文章保存为曹告)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月6日 上午12:23:09    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月6日 上午12:23:09    
	 * 修改备注： 
	 * @param article  
	 */
	void articleDraft(Article article);

	/** draftArticle(查询草稿内容)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月6日 上午12:45:30    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月6日 上午12:45:30    
	 * 修改备注： 
	 * @param article
	 * @return  
	 */
	Article draftArticle(Article article);

}
