package com.gray.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PermissionTestController {

	@RequestMapping("eatApple.do")
	@RequiresPermissions("eat:apple")
	public String eatApple(HttpServletRequest req) {
		req.setAttribute("msg", "eatApple.....");
		return "eat";
	}
	@RequestMapping("eatRice.do")
	@RequiresPermissions("eat:rice")
	public String eatRice(HttpServletRequest req) {
		req.setAttribute("msg", "eatRice.....");
		return "eat";
	}
	@RequestMapping("eatOrange.do")
	@RequiresPermissions("eat:orange")
	public String eatOrange(HttpServletRequest req) {
		req.setAttribute("msg", "eatOrange.....");
		return "eat";
	}
	
	@RequestMapping("sleepBedRoom.do")
	@RequiresPermissions("sleep:bedroom")
	public String sleepBedRoom(HttpServletRequest req) {
		req.setAttribute("msg", "sleepBedRoom.....");
		return "sleep";
	}
	
	@RequestMapping("sleepClassRoom.do")
	@RequiresPermissions("sleep:classroom")
	public String sleepClassRoom(HttpServletRequest req) {
		req.setAttribute("msg", "sleepClassRoom.....");
		return "sleep";
	}
	
	@RequestMapping("sleepVisitRoom.do")
	@RequiresPermissions("sleep:visitroom")
	public String sleepVisitRoom(HttpServletRequest req) {
		req.setAttribute("msg", "sleepVisitRoom.....");
		return "sleep";
	}
	
	
}
