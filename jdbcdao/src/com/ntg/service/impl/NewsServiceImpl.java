package com.ntg.service.impl;

import java.io.Serializable;
import java.util.List;

import net.spy.memcached.MemcachedClient;

import com.ntg.bean.News;
import com.ntg.dao.NewsDao;
import com.ntg.dao.impl.NewsDaoImpl;
import com.ntg.service.NewsService;
import com.ntg.util.MemcachedUtil;

public class NewsServiceImpl implements NewsService {
	NewsDao nd = new NewsDaoImpl();

	@Override
	public void save(News t) {
		int rowNum = nd.save(t);
		if (rowNum > 0) {
			System.out.println("新增成功");
		} else {
			System.out.println("新增失败");
		}
	}

	@Override
	public void delete(Serializable t) {
		int rowNum = nd.delete(t);
		if (rowNum > 0) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
	}

	@Override
	public void update(News t) {
		int rowNum = nd.update(t);
		if (rowNum > 0) {
			System.out.println("修改成功");
		} else {
			System.out.println("修改失败");
		}
	}

	MemcachedClient client = MemcachedUtil.getInstantiation();

	@Override
	public List<News> query() {

		if (client.get("NewsAll") != null) {
			System.out.println("进入缓存查询");
			List<News> list = (List<News>) client.get("NewsAll");
			client.shutdown();
			return list;

		} else {
			System.out.println("进入数据库查询");
			List<News> list = nd.query();
			client.set("NewsAll", 30, list);

			return list;
		}

	}

	@Override
	public News findById(Serializable t) {

		if (client.get("findId" + t) != null) {
			System.out.println("进入缓存中查找");
			News news = (News) client.get("findId" + t);
			client.shutdown();
			return news;
		} else {
			System.out.println("进入数据库查询");
			News news = nd.findById(t);
			client.set("findId" + t, 90, news);

			return news;
		}

	}

}
