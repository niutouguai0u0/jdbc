package com.ntg.bean;

import java.io.*;
import java.util.Date;

/**
 * 订单 实体类
 * 
 * @author niutouguai0u0
 */

public class Order implements Serializable {

	private int id;
	private int userId;
	private String loginName;
	private String userAddress;
	private Date createTime;
	private float cost;
	private String serialNumber;

	public Order() {
		super();
	}

	public Order(int id, int userId, String loginName, String userAddress,
			float cost, String serialNumber) {
		super();
		this.id = id;
		this.userId = userId;
		this.loginName = loginName;
		this.userAddress = userAddress;
		this.createTime = createTime;
		this.cost = cost;
		this.serialNumber = serialNumber;
	}

	public Order(int userId, String loginName, String userAddress, float cost,
			String serialNumber) {
		super();

		this.userId = userId;
		this.loginName = loginName;
		this.userAddress = userAddress;

		this.cost = cost;
		this.serialNumber = serialNumber;
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

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public float getCost() {
		return cost;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	@Override
	public String toString() {
		return "Easybuy_order [id=" + id + ", userId=" + userId
				+ ", loginName=" + loginName + ", userAddress=" + userAddress
				+ ", createTime=" + createTime + ", cost=" + cost
				+ ", serialNumber=" + serialNumber + "]";
	}

}
