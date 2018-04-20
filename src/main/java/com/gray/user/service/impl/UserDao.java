package com.gray.user.service.impl;

import org.springframework.stereotype.Component;

import com.gray.user.entity.User;

@Component("userDao")
public interface UserDao {

	User login(User user);
	
}
