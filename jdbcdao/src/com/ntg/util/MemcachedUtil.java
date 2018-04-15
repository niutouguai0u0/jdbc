package com.ntg.util;

import java.io.IOException;
import java.net.InetSocketAddress;

import net.spy.memcached.MemcachedClient;

public class MemcachedUtil {
	// 私有化本类对象
	private static MemcachedUtil util = null;
	private static MemcachedClient client = null;

	static {
		util = new MemcachedUtil();
		try {
			client = new MemcachedClient(new InetSocketAddress("127.0.0.7",
					11211));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 私有化构造
	private MemcachedUtil() {

	}

	// 返回对象
	public static MemcachedClient getInstantiation() {
		return client;
	}

}
