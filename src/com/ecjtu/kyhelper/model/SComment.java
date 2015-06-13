package com.ecjtu.kyhelper.model;

import cn.bmob.v3.BmobObject;

/**
 * TODO : 评论实体类
 * 
 * @author ECJTU IsayesHu
 * @date 2015年4月3日
 */
public class SComment extends BmobObject {

	private String userID;
	private String userName;
	private String content;

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
