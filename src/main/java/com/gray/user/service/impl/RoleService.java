package com.gray.user.service.impl;

import java.util.List;

import com.gray.user.entity.Role;

public interface RoleService {

	List<Role> listByUserId(Integer userId);
}
