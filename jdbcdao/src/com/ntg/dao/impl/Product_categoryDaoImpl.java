package com.ntg.dao.impl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ntg.bean.News;
import com.ntg.bean.Order;
import com.ntg.bean.Product_category;
import com.ntg.dao.Product_categoryDao;
import com.ntg.util.JDBCUtil;
import com.ntg.util.ResultSetUtil;

public class Product_categoryDaoImpl extends JDBCUtil implements
		Product_categoryDao {

	@Override
	public int save(Product_category t) {
		String sql = "insert into easybuy_product_category(name,parentId,type) values(?,?,?)";
		Object[] prem = { t.getName(), t.getParentId(), t.getType() };
		int rowNum = 0;
		try {
			rowNum = myExecuteUpdate(sql, prem);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rowNum;
	}

	@Override
	public int delete(Serializable t) {
		int rowNum = 0;
		String sql = "delete from easybuy_product_category where id=?";
		Object[] prem = { t };
		try {
			rowNum = myExecuteUpdate(sql, prem);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowNum;
	}

	@Override
	public int update(Product_category t) {
		String sql = "update easybuy_product_category set name=?,parentId=?,type=? where id=?";
		Object[] prem = { t.getName(), t.getParentId(), t.getType(), t.getId() };
		int rowNum = 0;
		try {
			rowNum = myExecuteUpdate(sql, prem);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rowNum;
	}

	@Override
	public List<Product_category> query() {
		List<Product_category> list = null;
		String sql = "select * from easybuy_product_category";
		try {
			ResultSet rs = myExecuteQuery(sql);
			list = ResultSetUtil.findAll(rs, Product_category.class);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}

		return list;
	}



	@Override
	public Product_category findById(Serializable t) {
		String sql = "select * from easybuy_product_category where id=?";
		Product_category news = null;
		try {
			ResultSet rs = myExecuteQuery(sql, t);
			news = ResultSetUtil.findById(rs, Product_category.class);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return news;
	}

}
