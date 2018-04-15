package com.ntg.service.impl;

import java.io.Serializable;
import java.util.List;

import net.spy.memcached.MemcachedClient;

import com.ntg.bean.News;
import com.ntg.bean.Product_category;
import com.ntg.dao.Product_categoryDao;
import com.ntg.dao.impl.Product_categoryDaoImpl;
import com.ntg.service.Product_categoryService;
import com.ntg.util.MemcachedUtil;

public class Product_categoryServiceImpl implements Product_categoryService {
	Product_categoryDao pd = new Product_categoryDaoImpl();

	@Override
	public void save(Product_category t) {
		int rowNum = pd.save(t);
		if (rowNum > 0) {
			System.out.println("新增成功");
		} else {
			System.out.println("新增失败");
		}
	}

	@Override
	public void delete(Serializable t) {
		int rowNum = pd.delete(t);
		if (rowNum > 0) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
	}

	@Override
	public void update(Product_category t) {
		int rowNum = pd.update(t);
		if (rowNum > 0) {
			System.out.println("修改成功");
		} else {
			System.out.println("修改失败");
		}
	}

	MemcachedClient client = MemcachedUtil.getInstantiation();

	@Override
	public List<Product_category> query() {
		if (client.get("p_cList") != null) {
			System.out.println("进入缓存中查询");
			List<Product_category> list = (List<Product_category>) client
					.get("p_cList");
			client.shutdown();
			return list;
		} else {
			System.out.println("进入数据库查询");
			List<Product_category> list = pd.query();
			client.set("p_cList", 90, list);
			return list;
		}

	}

	@Override
	public Product_category findById(Serializable t) {
		if (client.get("pdc" + t) != null) {
			System.out.println("进入缓存中查询");
			Product_category pd = (Product_category) client.get("pdc" + t);
			client.shutdown();
			return pd;
		} else {
			System.out.println("进入数据库中查询");
			Product_category id = pd.findById(t);
			client.set("pdc" + t, 90, id);
			return id;
		}
	}

}
