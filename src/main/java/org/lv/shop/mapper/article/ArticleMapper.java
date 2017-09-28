/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:ArticleMapper.java 
 * 包名:org.lv.shop.mapper.article 
 * 创建日期:2017年6月1日下午6:43:59 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.mapper.article;

import java.util.List;

import org.lv.shop.entity.article.Article;
import org.lv.shop.util.Page;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：ArticleMapper    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年6月1日 下午6:43:59    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年6月1日 下午6:43:59    
 * 修改备注：       
 * @version   
 */
public interface ArticleMapper {

	/** getArticleList(查询文章集合)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月1日 下午7:06:17    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月1日 下午7:06:17    
	 * 修改备注： 
	 * @param page
	 * @return  
	 */
	List<Article> getArticleList(Page page);

	/** getArticleListCount(查询文章总条数)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月1日 下午7:06:21    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月1日 下午7:06:21    
	 * 修改备注： 
	 * @param page
	 * @return  
	 */
	int getArticleListCount(Page page);

	/** insertArticle(文章的增加方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月1日 下午7:26:17    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月1日 下午7:26:17    
	 * 修改备注： 
	 * @param article  
	 */
	void insertArticle(Article article);

	/** deleteArticleById(根据id删除文章)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月1日 下午8:30:25    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月1日 下午8:30:25    
	 * 修改备注： 
	 * @param article  
	 */
	void deleteArticleById(Article article);

	/** toupdateArticleById(查询要修改的文章)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月1日 下午8:36:19    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月1日 下午8:36:19    
	 * 修改备注： 
	 * @param articleId
	 * @return  
	 */
	Article toupdateArticleById(String articleId);

	/** updateArticleById(修改后的保存)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月1日 下午9:04:23    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月1日 下午9:04:23    
	 * 修改备注： 
	 * @param article  
	 */
	void updateArticleById(Article article);

	/** deleteArticleByArray(批量删除方法)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月1日 下午9:22:16    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月1日 下午9:22:16    
	 * 修改备注： 
	 * @param id  
	 */
	void deleteArticleByArray(String[] id);

	/** toArticle(查询文章内容)   
	 * 创建人：吕金刚 lvjghappy@163.com    
	 * 创建时间：2017年6月1日 下午9:35:19    
	 * 修改人：吕金刚 lvjghappy@163.com     
	 * 修改时间：2017年6月1日 下午9:35:19    
	 * 修改备注： 
	 * @param id
	 * @return  
	 */
	Article toArticle(String id);

}
