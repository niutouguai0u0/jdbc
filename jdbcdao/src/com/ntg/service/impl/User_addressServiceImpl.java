package com.ntg.service.impl;

import java.io.Serializable;
import java.util.List;

import net.spy.memcached.MemcachedClient;

import com.ntg.bean.News;
import com.ntg.bean.Product;
import com.ntg.bean.User_address;
import com.ntg.dao.User_addressDao;
import com.ntg.dao.impl.User_addressDaoImpl;
import com.ntg.service.User_addressService;
import com.ntg.util.MemcachedUtil;

public class User_addressServiceImpl implements User_addressService {
	User_addressDao ud = new User_addressDaoImpl();

	@Override
	public void save(User_address t) {
		int rowNum = ud.save(t);
		if (rowNum > 0) {
			System.out.println("新增成功");
		} else {
			System.out.println("新增失败");
		}
	}

	@Override
	public void delete(Serializable t) {
		int rowNum = ud.delete(t);
		if (rowNum > 0) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
	}

	@Override
	public void update(User_address t) {
		int rowNum = ud.update(t);
		if (rowNum > 0) {
			System.out.println("修改成功");
		} else {
			System.out.println("修改失败");
		}
	}

	MemcachedClient client = MemcachedUtil.getInstantiation();

	@Override
	public List<User_address> query() {

		if (client.get("ud") != null) {
			System.out.println("进入缓存中查询");
			List<User_address> list = (List<User_address>) client.get("ud");
			client.shutdown();
			return list;
		} else {
			System.out.println("进入数据库中查询");
			List<User_address> list = ud.query();
			client.set("ud", 90, list);
			return list;
		}
	}

	@Override
	public User_address findById(Serializable t) {
		if (client.get("ud" + t) != null) {
			System.out.println("进入缓存中查询");
			User_address pd = (User_address) client.get("ud" + t);
			client.shutdown();
			return pd;
		} else {
			System.out.println("进入数据库中查询");
			User_address id = ud.findById(t);
			client.set("ud" + t, 90, id);
			return id;
		}
	}

}
