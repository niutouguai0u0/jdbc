package com.ntg.service.impl;

import java.io.Serializable;
import java.util.List;

import net.spy.memcached.MemcachedClient;

import com.ntg.bean.News;
import com.ntg.bean.Order_detail;
import com.ntg.dao.Order_detailDao;
import com.ntg.dao.impl.Order_detailDaoImpl;
import com.ntg.service.Order_detailService;
import com.ntg.util.MemcachedUtil;

public class Order_detailServiceImpl implements Order_detailService {
	Order_detailDao od = new Order_detailDaoImpl();

	@Override
	public void save(Order_detail t) {
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
	public void update(Order_detail t) {
		int rowNum = od.update(t);
		if (rowNum > 0) {
			System.out.println("修改成功");
		} else {
			System.out.println("修改失败");
		}
	}

	MemcachedClient client = MemcachedUtil.getInstantiation();

	@Override
	public List<Order_detail> query() {

		if (client.get("O_DAll") != null) {
			System.out.println("进入缓存中查找");
			List<Order_detail> list = (List<Order_detail>) client.get("O_DAll");
			client.shutdown();
			return list;
		} else {
			System.out.println("进入数据库查询");
			List<Order_detail> list = od.query();
			client.set("O_DAll", 90, list);
			
			return list;
		}
	}

	@Override
	public Order_detail findById(Serializable t) {
		if (client.get("o_d" + t) != null) {
			System.out.println("进入缓存中查找");
			Order_detail o_d = (Order_detail) client.get("o_d" + t);
			client.shutdown();
			return o_d;
		} else {
			System.out.println("进入数据库中查找");
			Order_detail o_d = od.findById(t);
			client.set("o_d" + t, 90, o_d);
			
			return o_d;
		}
	}

}
