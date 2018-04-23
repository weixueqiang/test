package com.gray.user.dao;

import com.gray.user.entity.User;
public interface UserDao {

	User login(User user);
	
	void save(User user);
	
}
