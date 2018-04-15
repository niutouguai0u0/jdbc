package com.ntg.service;

import com.ntg.bean.User;

public interface UserService extends BaseService<User> {
	User login(String loginName,String password);
}
