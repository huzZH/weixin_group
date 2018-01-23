package com.weixin.web.bean.message.response;

import java.util.List;

/**
 * ClassName  NewsMessage
 * @Description  ��ͼ����Ϣ
 * @author ������
 *
 */
public class NewsMessage extends BaseMessage{
	//ͼ����Ϣ����
	private Integer ArticleCount;
	// ����ͼ����Ϣ��Ϣ��Ĭ�ϵ�һ��itemΪ��ͼ   
	private List<Article> Articles;
	public Integer getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(Integer articleCount) {
		ArticleCount = articleCount;
	}
	public List<Article> getArticles() {
		return Articles;
	}
	public void setArticles(List<Article> articles) {
		Articles = articles;
	}
	
}
