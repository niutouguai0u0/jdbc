package com.ntg.bean;

import java.io.Serializable;

public class User implements Serializable {
	/**
	 * 
	 */
	private int id;// 用户id
	private String loginName;// 用户名
	private String userName;// 用户真实姓名
	private String password;// 密码
	private int sex;// 性别 1是男 0是女
	private String identityCode;// 身份证
	private String email;// 邮箱
	private String mobile;// 手机
	private int type;// 类型 1是管理员 0是会员

	public User(int id, String loginName, String userName, String password,
			int sex, String identityCode, String email, String mobile, int type) {
		super();
		this.id = id;
		this.type = type;
		this.loginName = loginName;
		this.userName = userName;
		this.password = password;
		this.sex = sex;
		this.identityCode = identityCode;
		this.email = email;
		this.mobile = mobile;

	}

	public User(String loginName, String userName, String password, int sex,
			String identityCode, String email, String mobile, int type) {
		super();
		this.type = type;
		this.loginName = loginName;
		this.userName = userName;
		this.password = password;
		this.sex = sex;
		this.identityCode = identityCode;
		this.email = email;
		this.mobile = mobile;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getIdentityCode() {
		return identityCode;
	}

	public void setIdentityCode(String identityCode) {
		this.identityCode = identityCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public User() {
		super();
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", loginName=" + loginName + ", userName="
				+ userName + ", password=" + password + ", sex=" + sex
				+ ", identityCode=" + identityCode + ", email=" + email
				+ ", mobile=" + mobile + ", type=" + type + "]";
	}

}
