package com.ntg.bean;

import java.io.Serializable;
import java.util.Date;

public class News implements Serializable {

	private int id;// 编号
	private String title;// 标题
	private String content;// 内容
	private Date createTime;// 录入时间

	public News() {
		super();
	}

	public News(int id,String title, String content) {
		
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		
	}
	public News(String title, String content) {
		super();
		this.title = title;
		this.content = content;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", content=" + content
				+ ", createTime=" + createTime + "]";
	}

}
