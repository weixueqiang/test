package com.gray.base.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.AuthenticatingRealm;

import com.gray.base.util.Utils;

import redis.clients.jedis.Jedis;

public class RedisRealm extends AuthenticatingRealm{

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upt=(UsernamePasswordToken)token;
		String username = upt.getUsername();
		Jedis jedis = Utils.getJedis();
		String pwd = jedis.get(username);
		
		if(pwd==null || pwd.trim().isEmpty()) {
			System.out.println("IIII\n");
			throw new RuntimeException("redis中无此人");
		}
		return new  SimpleAuthenticationInfo(username,pwd,this.getName());
	}

	
	
	
	
}
