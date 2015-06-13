package com.ecjtu.kyhelper.model;

import java.io.Serializable;

import cn.bmob.v3.BmobObject;

/**
 * TODO : 各科目知识点细分的实体类， 实现序列化, Activity之间实现传递
 * 序列化就是一种用来处理对象流的机制，所谓对象流也就是将对象的内容进行流化
 * 。可以对流化后的对象进行读写操作，也可将流化后的对象传输于网络之间。序列化是为了解决在对对象流进行读写操作时所引发的问题。
 * 
 * @author ECJTU IsayesHu
 * @date 2015年4月3日
 */
public class Subject extends BmobObject implements Serializable {

	
	private static final long serialVersionUID = -8796635595320697255L;

	private String type;// 类型11代表第一个GridView中的第一个
	private String name;
	private String summary;
	private String content;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
