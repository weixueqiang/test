package com.gray.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gray.user.dao.PermissionDao;
import com.gray.user.entity.Permission;
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService{

	@Resource
	private PermissionDao permissionDao;
	
	@Override
	public void save(Permission permission) {
		permissionDao.save(permission);
	}

	@Override
	public List<Permission> listByRoleId(Integer roleId) {
		if(roleId==null) {
			return null;
		}
		return permissionDao.listByRoleId(roleId);
	}

	@Override
	public List<Permission> listPermissionByRoleId(Integer roleId) {
		if(roleId==null) {
			return null;
		}
		return permissionDao.listPermissionByRoleId(roleId);
	}

}
