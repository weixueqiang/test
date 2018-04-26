package com.gray.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gray.user.entity.Role;

public interface RoleDao {

	void save(Role role);
	
	List<Role> listByUserId(@Param("userId") Integer userId);
}
