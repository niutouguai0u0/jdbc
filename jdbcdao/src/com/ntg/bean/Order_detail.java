package com.ntg.bean;

import java.io.*;
    /**
    * 订单详情实体类
    * @author niutouguai0u0  
    */ 

public class Order_detail implements Serializable{

	private int id;
	private int orderId;
	private int productId;
	private int quantity;
	private float cost;

	public Order_detail() {
		super();
	}

	public Order_detail(int id, int orderId, int productId, int quantity, float cost) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.cost = cost;
	}
	public Order_detail( int orderId, int productId, int quantity, float cost) {
		super();
		
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.cost = cost;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getProductId() {
		return productId;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public float getCost() {
		return cost;
	}

	@Override
	public String toString() {
		return "Easybuy_order_detail [id=" + id + ", orderId=" + orderId + ", productId=" + productId + ", quantity=" + quantity + ", cost=" + cost + "]";
	}

}
