package com.gray.base.shiro;

import java.util.ArrayList;
import java.util.List;

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


public class CustomRealm extends AuthorizingRealm{

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pri) {
		User user=(User)pri.getPrimaryPrincipal();
		List<String> menus=new ArrayList<String>();
		List<String> permissions=new ArrayList<String>();
		menus.add("eat");
		menus.add("sleep");
		permissions.add("eat:apple");
//		permissions.add("sleep:bed");
		user.setMenus(menus);
		user.setPermissions(permissions);
		SimpleAuthorizationInfo saf = new SimpleAuthorizationInfo();
		saf.addRoles(menus);
		saf.addStringPermissions(permissions);
		return saf;
	}

	
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//		UsernamePasswordToken upt=(UsernamePasswordToken)token;
		User user = new User("zhangsan", "zs123");
//		if(user==null) {
//			return null;
//		}
		String password="zs123";
//		return new SimpleAuthenticationInfo(user, password, ByteSource.Util.bytes("seat"), this.getName());
		return new SimpleAuthenticationInfo(user, password, this.getName());
	}
 
	
}
