package com.gray.user.entity;

import java.io.Serializable;

public class Role implements Serializable{

	private String id;
	private String rolename;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
}
