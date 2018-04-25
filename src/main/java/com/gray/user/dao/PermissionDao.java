package com.gray.user.dao;

import java.util.List;

import com.gray.user.entity.Permission;

public interface PermissionDao {

	void save(Permission permission);
	
	List<Permission> listByRoleId(Integer roleId);
	
	List<Permission> listPermissionByRoleId(Integer roleId);
}
