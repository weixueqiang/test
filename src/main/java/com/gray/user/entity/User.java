package com.gray.user.entity;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{

	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", salt=" + salt + ", roles="
				+ roles + ", menus=" + menus + ", permissions=" + permissions + "]";
	}
	private static final long serialVersionUID = 4075604124034928464L;
	private Integer id;
	private String username;
	private String password;
	private String salt;
	private List<Role> roles;
	private List<Permission> menus;
	private List<Permission> permissions;
	
	public User(Integer id, String username, String password, String salt) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.salt = salt;
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
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public List<Permission> getMenus() {
		return menus;
	}
	public void setMenus(List<Permission> menus) {
		this.menus = menus;
	}
	public List<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

}
