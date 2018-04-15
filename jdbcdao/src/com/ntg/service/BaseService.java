package com.ntg.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T> {
	/**
	 * 增加方法
	 */
	void save(T t);

	/**
	 * 删除方法
	 */
	void delete(Serializable t);

	/**
	 * 修改方法
	 */
	void update(T t);

	/**
	 * 查看全部方法
	 */
	List<T> query();
	/**
	 * 返回单条
	 */
	T findById(Serializable t);
}
