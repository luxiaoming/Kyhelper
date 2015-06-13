package com.ecjtu.kyhelper.model;

import cn.bmob.v3.BmobObject;

/**
 * TODO : 首页研讯发布实体类
 * 
 * @author ECJTU IsayesHu
 * @date 2015年4月3日
 */
public class KyNews extends BmobObject {

	private String type; // 文章类型
	private String title; // 文章标题
	private String author; // 文章作者
	private String content; // 文章内容

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
