package com.gray.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.gray.user.dao.RoleDao;
import com.gray.user.entity.Role;

@Service("roleService")
@Transactional(rollbackFor=Exception.class)
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleDao roleDao;
	
	@Override
	public List<Role> listByUserId(Integer userId) {
		if(userId==null) {
			return null;
		}
		return roleDao.listByUserId(userId);
	}

}
