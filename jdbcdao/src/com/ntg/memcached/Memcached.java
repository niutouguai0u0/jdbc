package com.ntg.memcached;

import java.io.IOException;
import java.net.InetSocketAddress;

import net.spy.memcached.MemcachedClient;

/**
 * memcached缓存技术
 */
public class Memcached {
	public static void main(String[] args) {
		//本地链接 memcached服务
		try {
			MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
			System.out.println("连接成功");
			
			//关闭链接
			mcc.shutdown();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
