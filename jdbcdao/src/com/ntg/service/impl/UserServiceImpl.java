package com.ntg.service.impl;

import java.io.Serializable;
import java.util.List;

import net.spy.memcached.MemcachedClient;

import com.ntg.bean.User;
import com.ntg.bean.User_address;
import com.ntg.dao.UserDao;
import com.ntg.dao.impl.UserDaoImpl;
import com.ntg.service.UserService;
import com.ntg.util.MemcachedUtil;

public class UserServiceImpl implements UserService {
	UserDao userDao = new UserDaoImpl();

	@Override
	public void save(User t) {
		int rowNum = userDao.save(t);
		if (rowNum > 0) {
			System.out.println("新增成功");
		} else {
			System.out.println("新增失败");
		}
	}

	@Override
	public void delete(Serializable t) {
		int rowNum = userDao.delete(t);
		if (rowNum > 0) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
	}

	@Override
	public void update(User t) {
		int rowNum = userDao.update(t);
		if (rowNum > 0) {
			System.out.println("修改成功");
		} else {
			System.out.println("修改失败");
		}
	}

	MemcachedClient client = MemcachedUtil.getInstantiation();

	@Override
	public List<User> query() {

		if (client.get("userDao") != null) {
			System.out.println("进入缓存中查询");
			List<User> list = (List<User>) client.get("userDao");
			client.shutdown();
			return list;
		} else {
			System.out.println("进入数据库中查询");
			List<User> list = userDao.query();
			client.set("userDao", 90, list);
			return list;
		}
	}

	@Override
	public User login(String loginName, String password) {
		User login = userDao.login(loginName, password);
		if (login != null) {
			System.out.println("登录成功");
			return login;
		}
		return null;
	}

	@Override
	public User findById(Serializable t) {
		if (client.get("userDao" + t) != null) {
			System.out.println("进入缓存中查询");
			User pd = (User) client.get("userDao" + t);
			client.shutdown();
			return pd;
		} else {
			System.out.println("进入数据库中查询");
			User id = userDao.findById(t);
			client.set("userDao" + t, 90, id);
			return id;
		}
	}

}
