package com.ntg.bean;

import java.io.*;

/**
 * 商品详情 实体类
 * 
 * @author niutouguai0u0
 */

public class Product_category implements Serializable {

	private int id;
	private String name;
	private int parentId;
	private int type;
	private String iconClass;

	public Product_category() {
		super();
	}

	public Product_category(String name, int parentId, int type) {
		super();

		this.name = name;
		this.parentId = parentId;
		this.type = type;

	}

	public Product_category(int id, String name, int parentId, int type) {
		super();
		this.id = id;
		this.name = name;
		this.parentId = parentId;
		this.type = type;

	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getParentId() {
		return parentId;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public void setIconClass(String iconClass) {
		this.iconClass = iconClass;
	}

	public String getIconClass() {
		return iconClass;
	}

	@Override
	public String toString() {
		return "Easybuy_product_category [id=" + id + ", name=" + name
				+ ", parentId=" + parentId + ", type=" + type + ", iconClass="
				+ iconClass + "]";
	}

}
