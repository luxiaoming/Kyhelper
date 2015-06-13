package com.ecjtu.kyhelper.model;

import cn.bmob.v3.BmobUser;

/**
 * TODO : 用户实体类
 * 
 * @author ECJTU IsayesHu
 * @date 2015年4月3日
 */
public class User extends BmobUser {

	// 父类中已经存在的属性
	// private String id;
	// private String username;
	// private String password;
	// private String email;
	// private String regTime;

	private String phone; // 电话

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
