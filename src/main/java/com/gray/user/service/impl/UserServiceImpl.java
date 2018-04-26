package com.gray.user.service.impl;


import javax.annotation.Resource;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gray.user.dao.UserDao;
import com.gray.user.entity.User;

@Service("userService")
@Transactional(rollbackFor=Exception.class)
public class UserServiceImpl implements UserService{

	@Resource
	private UserDao userDao;
	
	public User doUserLogin(User user) {
		User u = userDao.login(user);
		System.err.println("u--\n"+u);
		return u;
	}

	@Override
	public void save(User user) {
		userDao.save(user);
		User users =this.doUserLogin(user);
		System.out.println(users);
	}

	@Override
	public User withRoleUser(User user) {
		return userDao.withRoleUser(user);
	}

}
