package com.gray.user.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gray.user.controller.UserService;
import com.gray.user.entity.User;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource
	private UserDao userDao;
	
	public User doUserLogin(User user) {
		User u = userDao.login(user);
		System.err.println("u--\n"+u);
		 return u;
	}

}
