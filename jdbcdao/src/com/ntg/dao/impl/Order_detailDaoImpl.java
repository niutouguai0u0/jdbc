package com.ntg.dao.impl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ntg.bean.News;
import com.ntg.bean.Order_detail;
import com.ntg.dao.Order_detailDao;
import com.ntg.util.JDBCUtil;
import com.ntg.util.ResultSetUtil;

public class Order_detailDaoImpl extends JDBCUtil implements Order_detailDao {

	@Override
	public int save(Order_detail t) {
		int rowNum = 0;
		String sql = "insert into easybuy_order_detail(orderId,productId,quantity,cost) values(?,?,?,?)";
		Object[] prem = { t.getOrderId(), t.getProductId(), t.getQuantity(),
				t.getCost() };
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
		String sql = "delete from easybuy_order_detail where id=?";
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
	public int update(Order_detail t) {
		String sql = "update easybuy_order_detail set orderId=?,productId=?,quantity=?,cost=? where id=?";
		Object[] prem = { t.getOrderId(), t.getProductId(), t.getQuantity(),
				t.getCost(), t.getId() };
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
	public List<Order_detail> query() {
		List<Order_detail> list = null;
		String sql = "select * from easybuy_order_detail";
		try {
			ResultSet rs = myExecuteQuery(sql);
			list = ResultSetUtil.findAll(rs, Order_detail.class);
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
	public Order_detail findById(Serializable t) {
		String sql = "select * from easybuy_order_detail where id=?";
		Order_detail news = null;
		try {
			ResultSet rs = myExecuteQuery(sql, t);
			news = ResultSetUtil.findById(rs, Order_detail.class);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return news;
	}

}
