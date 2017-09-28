/** 
 * 项目名称:spring-mvc-mybatis 
 * 文件名称:ArticleServiceImpl.java 
 * 包名:org.lv.shop.service.article 
 * 创建日期:2017年6月1日下午6:43:27 
 * Copyright (c) 2017, lvjghappy@163.com All Rights Reserved.</pre> 
 */  
package org.lv.shop.service.article;

import java.util.List;
import java.util.UUID;

import org.lv.shop.entity.article.Article;
import org.lv.shop.mapper.article.ArticleMapper;
import org.lv.shop.util.Page;
import org.lv.shop.util.SerializeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;

/** 
 * 项目名称：spring-mvc-mybatis    
 * 类名称：ArticleServiceImpl    
 * 类描述：    
 * 创建人：吕金刚 lvjghappy@163.com    
 * 创建时间：2017年6月1日 下午6:43:27    
 * 修改人：吕金刚 lvjghappy@163.com     
 * 修改时间：2017年6月1日 下午6:43:27    
 * 修改备注：       
 * @version   
 */
@Service
public class ArticleServiceImpl implements ArticleService{
	@Autowired
	private ArticleMapper articleMapper;
	//初始化jedis链接
	private static Jedis jedis=new Jedis("127.0.0.1",6379);

	/* (non-Javadoc)    
	 * @see org.lv.shop.service.article.ArticleService#getArticleList(org.lv.shop.util.Page)    
	 */
	@Override
	public void getArticleList(Page page) {
		List<Article> list=articleMapper.getArticleList(page);
		int count=articleMapper.getArticleListCount(page);
		page.setList(list);
		page.setPagesumcount(count);
	}

	/* (non-Javadoc)    
	 * @see org.lv.shop.service.article.ArticleService#insertArticle(org.lv.shop.entity.article.Article)    
	 */
	@Override
	public void insertArticle(Article article) {
		article.setArticleId(UUID.randomUUID().toString());
		articleMapper.insertArticle(article);
	}

	/* (non-Javadoc)    
	 * @see org.lv.shop.service.article.ArticleService#deleteArticleById(org.lv.shop.entity.article.Article)    
	 */
	@Override
	public void deleteArticleById(Article article) {
		articleMapper.deleteArticleById(article);
	}

	/* (non-Javadoc)    
	 * @see org.lv.shop.service.article.ArticleService#toupdateArticleById(java.lang.String)    
	 */
	@Override
	public Article toupdateArticleById(String articleId) {
		return articleMapper.toupdateArticleById(articleId);
	}

	/* (non-Javadoc)    
	 * @see org.lv.shop.service.article.ArticleService#updateArticleById(org.lv.shop.entity.article.Article)    
	 */
	@Override
	public void updateArticleById(Article article) {
		articleMapper.updateArticleById(article);
	}

	/* (non-Javadoc)    
	 * @see org.lv.shop.service.article.ArticleService#deleteArticleByArray(java.lang.String)    
	 */
	@Override
	public void deleteArticleByArray(String ids) {
		String[] id = ids.split(",");
		articleMapper.deleteArticleByArray(id);
	}

	/* (non-Javadoc)    
	 * @see org.lv.shop.service.article.ArticleService#toArticle(java.lang.String)    
	 */
	@Override
	public Article toArticle(String id) {
		return articleMapper.toArticle(id);
	}

	/* (non-Javadoc)    
	 * @see org.lv.shop.service.article.ArticleService#articleDraft(org.lv.shop.entity.article.Article)    
	 */
	@Override
	public void articleDraft(Article article) {
		//将对象序列化
		byte[] serialize = SerializeUtil.serialize(article);
		//将序列化后的对象存入redis中,
		jedis.set(article.getArticleId().getBytes(), serialize);
		//关闭链接
		jedis.close();
	}

	/* (non-Javadoc)    
	 * @see org.lv.shop.service.article.ArticleService#draftArticle(org.lv.shop.entity.article.Article)    
	 */
	@Override
	public Article draftArticle(Article article) {
		//根据id从redis中取出序列化的对象
		byte[] bs = jedis.get(article.getArticleId().getBytes());
		Article art = (Article)SerializeUtil.unserialize(bs);
		//关闭链接
		jedis.close();
		return art;
	}
}
