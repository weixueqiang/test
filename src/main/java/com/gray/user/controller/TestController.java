package com.gray.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.mgt.SessionsSecurityManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gray.base.shiro.ShiroDbRealm;
import com.gray.user.entity.Result;
import com.gray.user.entity.User;
@RequestMapping("test1")
@Controller
public class TestController {

	@RequestMapping("admin.do")
	@RequiresPermissions("user:info")
	@ResponseBody
	public Result admin(){
		Map<String,Object> map=new HashMap<String,Object>();
		Result result = new Result();
		User user = (User)SecurityUtils.getSubject().getSession().getAttribute(ShiroDbRealm.SESSION_USER_KEY);
		result.setObj(user);
		System.out.println("haha====\n");
		return result;
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Result handlerException() {
		Result result = new Result();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("msg", "没有权限!");
		result.setObj(map);
		return result;
	}
	
}
