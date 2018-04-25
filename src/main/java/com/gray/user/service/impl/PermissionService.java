package com.gray.user.service.impl;

import java.util.List;

import com.gray.user.entity.Permission;

public interface PermissionService {

	void save(Permission permission);
	
	List<Permission> listByRoleId(Integer roleId);
	
	List<Permission> listPermissionByRoleId(Integer roleId);
}
