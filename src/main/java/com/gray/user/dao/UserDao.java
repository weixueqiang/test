package com.gray.user.dao;

import org.apache.ibatis.annotations.Param;

import com.gray.user.entity.User;
public interface UserDao {

	User login(User user);
	
	void save(User user);
	
	User withRoleUser(User user);
	
	User withRoleAndMenu(@Param("username") String username);
}
