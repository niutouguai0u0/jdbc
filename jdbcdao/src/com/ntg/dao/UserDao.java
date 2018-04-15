package com.ntg.dao;

import com.ntg.bean.User;

public interface UserDao extends BaseDao<User>{
	/**
	 * 用户独有的登录方法
	 * @param loginName
	 * @param password
	 * @return
	 */
	User login(String loginName,String password);
}
