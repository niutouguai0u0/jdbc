package com.ntg.dao.impl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ntg.bean.News;
import com.ntg.bean.Product;
import com.ntg.bean.Product_category;
import com.ntg.dao.ProductDao;
import com.ntg.util.JDBCUtil;
import com.ntg.util.ResultSetUtil;

public class ProductDaoImpl extends JDBCUtil implements ProductDao {

	@Override
	public int save(Product t) {
		String sql = "insert into easybuy_product(name,description,price,stock,categoryLevel1Id,categoryLevel2Id,categoryLevel3Id,fileName,isDelete) values(?,?,?,?,?,?,?,?,?)";
		Object[] prem = { t.getName(), t.getDescription(), t.getPrice(),
				t.getStock(), t.getCategoryLevel1Id(), t.getCategoryLevel2Id(),
				t.getCategoryLevel3Id(), t.getFileName(), t.getIsDelete() };
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
		String sql = "delete from easybuy_product where id=?";
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
	public int update(Product t) {
		String sql = "update easybuy_product set name=?,description=?,price=?,stock=?,categoryLevel1Id=?,categoryLevel2Id=?,categoryLevel3Id=?,fileName=?,isDelete=? where id=?";
		Object[] prem = { t.getName(), t.getDescription(), t.getPrice(),
				t.getStock(), t.getCategoryLevel1Id(), t.getCategoryLevel2Id(),
				t.getCategoryLevel3Id(), t.getFileName(), t.getIsDelete(),
				t.getId() };
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
	public List<Product> query() {
		List<Product> list = null;
		String sql = "select * from easybuy_product";
		try {
			ResultSet rs = myExecuteQuery(sql);
			list = ResultSetUtil.findAll(rs, Product.class);
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
	public Product findById(Serializable t) {
		String sql = "select * from easybuy_product where id=?";
		Product news = null;
		try {
			ResultSet rs = myExecuteQuery(sql, t);
			news = ResultSetUtil.findById(rs, Product.class);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return news;
	}

}
