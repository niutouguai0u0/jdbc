package com.ntg.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
	/**
	 * 单例模式,提供properties接口
	 */
	// 私有化本类实例
	private static ConfigManager manager = new ConfigManager();
	// 读取配置文件的类
	private static Properties properties;

	// 私有化构造
	private ConfigManager() {
		properties = new Properties();
		// 读取配置文件
		InputStream is = ConfigManager.class.getClassLoader()
				.getSystemResourceAsStream("jdbc.properties");
		try {
			// 加载配置文件
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 提供数据库访问接口
	public static synchronized ConfigManager getInstantiate() {
		return manager;
	}

	// 用户提供key,返回value
	public static String getValue(String key) {
		return properties.getProperty(key);
	}
}
