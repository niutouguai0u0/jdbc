package com.ntg.dao.impl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ntg.bean.User;
import com.ntg.bean.User_address;
import com.ntg.dao.BaseDao;
import com.ntg.dao.UserDao;
import com.ntg.util.JDBCUtil;
import com.ntg.util.ResultSetUtil;

public class UserDaoImpl extends JDBCUtil implements UserDao {
	/**
	 * 增加用户方法
	 */
	@Override
	public int save(User t) {
		String sql = "insert into easybuy_user(loginName,userName,password,sex,identityCode,email,mobile) values(?,?,?,?,?,?,?)";
		Object[] prem = { t.getLoginName(), t.getUserName(), t.getPassword(),
				t.getSex(), t.getIdentityCode(), t.getEmail(), t.getMobile(), };
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

	/**
	 * 删除用户方法
	 */
	@Override
	public int delete(Serializable t) {
		String str = null;
		if (t instanceof String) {
			str = "loginName";
		}
		if (t instanceof Integer) {
			str = "id";
		}
		String sql = "delete from easybuy_user where " + str + "=?";
		Object[] prem = { t };
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

	/**
	 * 更改用户方法
	 */
	@Override
	public int update(User t) {
		String sql = "update easybuy_user set loginName=?,userName=?,password=?,sex=?,identityCode=?,email=?,mobile=?,type=? where id=?";
		Object[] prem = { t.getLoginName(), t.getUserName(), t.getPassword(),
				t.getSex(), t.getIdentityCode(), t.getEmail(), t.getMobile(),
				t.getType(), t.getId() };
		int rowNum = 0;
		try {
			rowNum = myExecuteUpdate(sql, prem);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return rowNum;
	}

	/**
	 * 查找所有用户方法
	 */
	@Override
	public List<User> query() {
		String sql = "select id,loginName,userName,password,sex,identityCode,email,mobile,type from easybuy_user";
		List<User> list = null;
		try {
			ResultSet rs = myExecuteQuery(sql);
			list = ResultSetUtil.findAll(rs, User.class);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 用户登录方法
	 */
	@Override
	public User login(String userLoginName, String userpassword) {
		String sql = "select id,loginName,userName,password,sex,identityCode,email,mobile,type from easybuy_user where  (loginName=? OR mobile=? OR email=?) AND password=?";
		Object[] prem = { userLoginName, userLoginName, userLoginName,
				userpassword };
		User user = null;
		try {
			ResultSet rs = myExecuteQuery(sql, prem);
			user = ResultSetUtil.findById(rs, User.class);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return user;
	}

	
	@Override
	public User findById(Serializable t) {
		String sql = "select * from easybuy_user where id=?";
		User news = null;
		try {
			ResultSet rs = myExecuteQuery(sql, t);
			news = ResultSetUtil.findById(rs, User.class);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return news;
	}

}
