package com.gray.user.entity;

import java.io.Serializable;

public class Result implements Serializable{

	/**
	 * @date 2018年3月30日 下午5:19:15
	 * @author 魏雪强
	 */
	private static final long serialVersionUID = -1406417034957323994L;
	private Object obj;

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
	
}
