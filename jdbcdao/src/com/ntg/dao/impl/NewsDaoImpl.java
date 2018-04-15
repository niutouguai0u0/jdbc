package com.ntg.dao.impl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.ntg.bean.News;
import com.ntg.dao.NewsDao;
import com.ntg.util.JDBCUtil;
import com.ntg.util.ResultSetUtil;

/**
 */
public class NewsDaoImpl extends JDBCUtil implements NewsDao {
	/**
	 * 新闻的增加方法
	 */
	@Override
	public int save(News t) {
		String sql = "insert into easybuy_news(title,content) values(?,?)";
		Object[] prem = { t.getTitle(), t.getContent() };
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
	 * 新闻删除方法
	 */
	@Override
	public int delete(Serializable t) {
		int rowNum = 0;
		String str = null;
		if (t instanceof String) {
			str = "title";
		}
		if (t instanceof Integer) {
			str = "id";
		}
		String sql = "delete from easybuy_news where " + str + "=?";
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

	/**
	 * 新闻修改方法
	 */
	@Override
	public int update(News t) {
		String sql = "update easybuy_news set title=?,content=? where id=?";
		Object[] prem = { t.getTitle(), t.getContent(), t.getId() };
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
	 * 查询所有方法
	 */
	@Override
	public List<News> query() {
		List<News> list = null;
		String sql = "select id,title,content,createTime from easybuy_news";
		try {
			ResultSet rs = myExecuteQuery(sql);
			list = ResultSetUtil.findAll(rs, News.class);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}

		return list;
	}

	/**
	 * 根据id查询
	 */
	@Override
	public News findById(Serializable t) {
		String sql = "select * from easybuy_news where id=?";
		News news = null;
		try {
			ResultSet rs = myExecuteQuery(sql, t);
			news = ResultSetUtil.findById(rs, News.class);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return news;
	}

}
