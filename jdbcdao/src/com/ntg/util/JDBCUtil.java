package com.ntg.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {
	/**
	 * 链接数据库 声明对象
	 */
	protected static Connection conn = null;
	protected static PreparedStatement sm = null;
	protected static ResultSet rs = null;

	/**
	 * 获取链接数据库的链接
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static boolean getConnection() throws ClassNotFoundException,
			SQLException {
		
		try {
			Class.forName(ConfigManager.getInstantiate()
					.getValue("jdbc.driver"));
			conn = DriverManager.getConnection(ConfigManager.getInstantiate()
					.getValue("jdbc.url"), ConfigManager.getInstantiate()
					.getValue("jdbc.userName"), ConfigManager.getInstantiate()
					.getValue("jdbc.password"));
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * 通用的修改方法
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static int myExecuteUpdate(String sql, Object... prem)
			throws ClassNotFoundException, SQLException {
		int rowNum = 0;
		if (getConnection()) {
			sm = conn.prepareStatement(sql);
			for (int i = 0; i < prem.length; i++) {
				sm.setObject(i + 1, prem[i]);
			}
			rowNum = sm.executeUpdate();
		}
		closeAll();
		return rowNum;
	}

	/**
	 * 通用的查询方法
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static ResultSet myExecuteQuery(String sql, Object... prem)
			throws ClassNotFoundException, SQLException {
		if (getConnection()) {
			sm = conn.prepareStatement(sql);
			for (int i = 0; i < prem.length; i++) {
				sm.setObject(i + 1, prem[i]);
			}
			rs = sm.executeQuery();
		}
		return rs;
	}

	/**
	 * 关闭所有资源方法
	 */
	public static void closeAll() {
		try {
			if (rs != null) {
				rs.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (sm != null) {
				sm.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null) {
				conn.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
