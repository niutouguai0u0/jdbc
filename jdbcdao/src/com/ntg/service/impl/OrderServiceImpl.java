package com.ntg.service.impl;

import java.io.Serializable;
import java.util.List;

import net.spy.memcached.MemcachedClient;

import com.ntg.bean.News;
import com.ntg.bean.Order;
import com.ntg.bean.Order_detail;
import com.ntg.dao.OrderDao;
import com.ntg.dao.impl.OrderDaoImpl;
import com.ntg.service.OrderService;
import com.ntg.util.MemcachedUtil;

public class OrderServiceImpl implements OrderService {
	OrderDao od = new OrderDaoImpl();

	@Override
	public void save(Order t) {
		int rowNum = od.save(t);
		if (rowNum > 0) {
			System.out.println("新增成功");
		} else {
			System.out.println("新增失败");
		}
	}

	@Override
	public void delete(Serializable t) {
		int rowNum = od.delete(t);
		if (rowNum > 0) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
	}

	@Override
	public void update(Order t) {
		int rowNum = od.update(t);
		if (rowNum > 0) {
			System.out.println("修改成功");
		} else {
			System.out.println("修改失败");
		}
	}

	MemcachedClient client = MemcachedUtil.getInstantiation();

	@Override
	public List<Order> query() {

		if (client.get("OrderAll") != null) {
			System.out.println("进入缓存中查找");
			List<Order> list = (List<Order>) client.get("OrderAll");
			client.shutdown();
			return list;
		} else {
			System.out.println("进入数据库查询");
			List<Order> list = od.query();
			client.set("OrderAll", 90, list);
			
			return list;
		}
	}

	@Override
	public Order findById(Serializable t) {
		if (client.get("Order"+t) != null) {
			System.out.println("进入缓存中查找");
			Order list = (Order) client.get("Order"+t);
			client.shutdown();
			return list;
		} else {
			System.out.println("进入数据库查询");
			Order list = od.findById(t);
			client.set("Order"+t, 90, list);
			
			return list;
		}
	}

}
