package com.gray.user.dao;
import org.springframework.stereotype.Component;

import com.gray.user.entity.User;
@Component("userDao")
public interface UserDao {

	User login(User user);
	
}
