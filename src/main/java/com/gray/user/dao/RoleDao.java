package com.gray.user.dao;

import java.util.List;

import com.gray.user.entity.Role;

public interface RoleDao {

	void save(Role role);
	
	List<Role> listByUserId(Integer userId);
}
