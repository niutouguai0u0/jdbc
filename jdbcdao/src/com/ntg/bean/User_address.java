package com.ntg.bean;

import java.io.*;
import java.util.Date;

/**
 * 用户地址 实体类
 * 
 * @author niutouguai0u0
 */

public class User_address implements Serializable {

	private int id;
	private int userId;
	private String address;
	private Date createTime;
	private int isDefault;
	private String remark;

	public User_address() {
		super();
	}

	public User_address(int userId, String address, int isDefault, String remark) {
		super();

		this.userId = userId;
		this.address = address;

		this.isDefault = isDefault;
		this.remark = remark;
	}

	public User_address(int id, int userId, String address, int isDefault,
			String remark2) {
		super();

		this.userId = userId;
		this.address = address;
		this.id = id;
		this.isDefault = isDefault;
		this.remark = remark;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setIsDefault(int isDefault) {
		this.isDefault = isDefault;
	}

	public int getIsDefault() {
		return isDefault;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}

	@Override
	public String toString() {
		return "Easybuy_user_address [id=" + id + ", userId=" + userId
				+ ", address=" + address + ", createTime=" + createTime
				+ ", isDefault=" + isDefault + ", remark=" + remark + "]";
	}

}
