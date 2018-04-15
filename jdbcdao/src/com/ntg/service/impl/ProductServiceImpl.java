package com.ntg.service.impl;

import java.io.Serializable;
import java.util.List;

import net.spy.memcached.MemcachedClient;

import com.ntg.bean.News;
import com.ntg.bean.Product;
import com.ntg.bean.Product_category;
import com.ntg.dao.ProductDao;
import com.ntg.dao.impl.ProductDaoImpl;
import com.ntg.service.ProductService;
import com.ntg.util.MemcachedUtil;

public class ProductServiceImpl implements ProductService {
	ProductDao pd = new ProductDaoImpl();

	@Override
	public void save(Product t) {
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
	public void update(Product t) {
		int rowNum = pd.update(t);
		if (rowNum > 0) {
			System.out.println("修改成功");
		} else {
			System.out.println("修改失败");
		}
	}

	MemcachedClient client = MemcachedUtil.getInstantiation();

	@Override
	public List<Product> query() {
		if (client.get("pd") != null) {
			System.out.println("进入缓存中查询");
			List<Product> list = (List<Product>) client.get("pd");
			client.shutdown();
			return list;
		} else {
			System.out.println("进入数据库中查询");
			List<Product> list = pd.query();
			client.set("pd", 90, list);
			return list;
		}
	}

	@Override
	public Product findById(Serializable t) {
		if (client.get("pd" + t) != null) {
			System.out.println("进入缓存中查询");
			Product pd = (Product) client.get("pd" + t);
			client.shutdown();
			return pd;
		} else {
			System.out.println("进入数据库中查询");
			Product id = pd.findById(t);
			client.set("pd" + t, 90, id);
			return id;
		}
	}

}
