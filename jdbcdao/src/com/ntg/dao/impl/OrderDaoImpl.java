package com.ntg.dao.impl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ntg.bean.News;
import com.ntg.bean.Order;
import com.ntg.bean.Order_detail;
import com.ntg.dao.OrderDao;
import com.ntg.util.JDBCUtil;
import com.ntg.util.ResultSetUtil;

public class OrderDaoImpl extends JDBCUtil implements OrderDao {

	@Override
	public int save(Order t) {
		String sql = "insert into easybuy_order(userId,loginName,userAddress,cost,serialNumber) values(?,?,?,?,?)";
		Object[] prem = { t.getUserId(), t.getLoginName(), t.getUserAddress(),
				t.getCost(), t.getSerialNumber() };
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
		String sql = "delete from easybuy_order where id=?";
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
	public int update(Order t) {
		String sql = "update easybuy_order set userId=?,loginName=?,userAddress=?,cost=?,serialNumber=? where id=?";
		Object[] prem = { t.getUserId(), t.getLoginName(), t.getUserAddress(),
				t.getCost(), t.getSerialNumber(), t.getId() };
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
	public List<Order> query() {
		List<Order> list = null;
		String sql = "select * from easybuy_order";
		try {
			ResultSet rs = myExecuteQuery(sql);
			list = ResultSetUtil.findAll(rs, Order.class);
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
	public Order findById(Serializable t) {
		String sql = "select * from easybuy_order where id=?";
		Order news = null;
		try {
			ResultSet rs = myExecuteQuery(sql, t);
			news = ResultSetUtil.findById(rs, Order.class);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return news;
	}


}
