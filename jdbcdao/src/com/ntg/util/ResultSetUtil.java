package com.ntg.util;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 用反射机制动态获取
 * 
 */
public class ResultSetUtil {
	/**
	 * 根据ID查询
	 */
	public static <T> T findById(ResultSet rs, Class<T> clazz) {
		T object = null; // 不确定类型所以是T
		try {
			if (rs.next()) {
				object = clazz.newInstance();
				Field[] fields = clazz.getDeclaredFields(); // 获取所有字段,如果不加Declared不能获取私有字段
				for (Field field : fields) {
					field.setAccessible(true);// 打开权限,默认不获取私有的
					field.set(object, rs.getObject(field.getName()));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		return object;
	}
	/**
	 * 查询所有
	 * @param rs
	 * @param clazz
	 * @return
	 */
	public static <T> List<T> findAll(ResultSet rs, Class<T> clazz) {
		T object = null; // 不确定类型所以是T
		List<T> list = new ArrayList<T>();
		try {
			while (rs.next()) {
				object = clazz.newInstance();
				Field[] fields = clazz.getDeclaredFields(); // 获取所有字段,如果不加Declared不能获取私有字段
				for (Field field : fields) {
					field.setAccessible(true);// 打开权限,默认不获取私有的
					field.set(object, rs.getObject(field.getName()));
				}
				list.add(object);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		return list;
	}
}
