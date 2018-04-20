package com.gray.base.shiro;



import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class User implements Serializable{

	/**
	 * @date 2018年4月17日 下午12:55:51
	 * @author 魏雪强
	 */
	private static final long serialVersionUID = 5950026285509393133L;
	private String username;
	private String password;
	
	private List<String> menus;
	private List<String> permissions;
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<String> getMenus() {
		return menus;
	}
	public void setMenus(List<String> menus) {
		this.menus = menus;
	}
	public List<String> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<String> permissions) {
		this.permissions = permissions;
	}
	
	
}
