package com.gray.base.shiro;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.util.CollectionUtils;

import com.gray.user.entity.Permission;
import com.gray.user.entity.Role;
import com.gray.user.entity.User;
import com.gray.user.service.impl.PermissionService;
import com.gray.user.service.impl.RoleService;
import com.gray.user.service.impl.UserService;


public class CustomRealm extends AuthorizingRealm{

	@Resource
	private UserService userService;
	
	@Resource
	private RoleService roleService;
	@Resource
	private PermissionService permissionService;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pri) {
		User user=(User)pri.getPrimaryPrincipal();
		List<Role> roles = roleService.listByUserId(user.getId());
		user.setRoles(roles);
		Set<String> menus=new HashSet<>();
		Set<String> permissions=new HashSet<>();
		if(!CollectionUtils.isEmpty(roles)) {
			List<Permission> listMenus =new ArrayList<>();
			List<Permission> listPermissions =new ArrayList<>();
			for(Role role:roles) {
				listMenus.addAll(permissionService.listByRoleId(role.getId()));
				listPermissions.addAll(permissionService.listPermissionByRoleId(role.getId()));
			}
			for(Permission permission:listMenus) {
				menus.add(permission.getName());
			}
			for(Permission permission:listPermissions) {
				permissions.add(permission.getName());
			}
			
		}
		SimpleAuthorizationInfo saf = new SimpleAuthorizationInfo();
		saf.addRoles(menus);
		saf.addStringPermissions(permissions);
		return saf;
	}

	
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upt=(UsernamePasswordToken)token;
		String username=upt.getUsername();
		User user=new User();
		user.setUsername(username);
		user=userService.doUserLogin(user);
		if(user==null) {
			return null;
		}
		String password=user.getPassword();
		String salt=user.getSalt();
		return new SimpleAuthenticationInfo(user, password, ByteSource.Util.bytes(salt), this.getName());
	}
 
	
}
