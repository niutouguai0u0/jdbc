package com.ntg.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
	/**
	 * 增加方法
	 */
	int save(T t);

	/**
	 * 删除方法
	 */
	int delete(Serializable t);

	/**
	 * 修改方法
	 */
	int update(T t);

	/**
	 * 查找方法
	 */
	List<T> query();
	/**
	 * 
	 */
	T findById(Serializable t);
}
