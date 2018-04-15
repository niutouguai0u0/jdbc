package com.ntg.dao.impl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ntg.bean.News;
import com.ntg.bean.Product;
import com.ntg.bean.User_address;
import com.ntg.dao.User_addressDao;
import com.ntg.util.JDBCUtil;
import com.ntg.util.ResultSetUtil;

public class User_addressDaoImpl extends JDBCUtil implements User_addressDao {

	@Override
	public int save(User_address t) {
		String sql = "insert into easybuy_user_address(userId,address,isDefault,remark) values(?,?,?,?)";
		Object[] prem = { t.getUserId(), t.getAddress(), t.getIsDefault(),
				t.getRemark() };
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
		String sql = "delete from easybuy_user_address where id=?";
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
	public int update(User_address t) {
		String sql = "update easybuy_user_address set userId=?,address=?,isDefault=?,remark=? where id=?";
		Object[] prem = { t.getUserId(), t.getAddress(), t.getIsDefault(),
				t.getRemark(), t.getId() };
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
	public List<User_address> query() {
		List<User_address> list = null;
		String sql = "select * from easybuy_user_address";
		try {
			ResultSet rs = myExecuteQuery(sql);
			list = ResultSetUtil.findAll(rs, User_address.class);
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
	public User_address findById(Serializable t) {
		String sql = "select * from easybuy_user_address where id=?";
		User_address news = null;
		try {
			ResultSet rs = myExecuteQuery(sql, t);
			news = ResultSetUtil.findById(rs, User_address.class);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return news;
	}

}
