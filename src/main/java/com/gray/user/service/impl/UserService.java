package com.gray.user.service.impl;

import com.gray.user.entity.User;

public interface UserService {

	User doUserLogin(User User);
	
	void save(User User);
}
