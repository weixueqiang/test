package com.gray.user.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gray.user.entity.User;


@Controller
public class LoginController {

	@RequestMapping("login.do")
	public String login(HttpServletRequest req) {
		String shiroLoginFailure = (String) req.getAttribute("shiroLoginFailure");
		System.out.println(shiroLoginFailure);
		if (shiroLoginFailure != null) {
			if (IncorrectCredentialsException.class.getName().equals(shiroLoginFailure)) {
				throw new IncorrectCredentialsException("密码错误!");
			} else if (UnknownAccountException.class.getName().equals(shiroLoginFailure)) {
				throw new UnknownAccountException("帐号不存在!");
			}else if("code worong!".equals(shiroLoginFailure)) {
				throw new RuntimeException("code wrong!");
			}

		}

		return "index";
	}

	@RequestMapping("log.do")
	public String log(HttpServletRequest req) {
		String shiroLoginFailure = (String) req.getAttribute("shiroLoginFailure");
		System.out.println(shiroLoginFailure);
		if (shiroLoginFailure == null) {
			Object principal = SecurityUtils.getSubject().getPrincipal();
			req.setAttribute("username", principal);
			return "success";
		}

		return "fail";
	}

	@RequestMapping("success.do")
	public String success(HttpServletRequest req) {
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		req.setAttribute("username", user.getUsername());
		System.out.println("code:" + req.getSession().getAttribute("code"));
		return "success";
	}

	@RequestMapping("eat.do")
	@RequiresPermissions("eat:apple")
	public String eat(HttpServletRequest req) {
		req.setAttribute("msg", "eat.....");
		return "eat";
	}

	@RequestMapping("sleep.do")
	@RequiresPermissions("sleep:bed")
	public String sleep(HttpServletRequest req) {
		req.setAttribute("msg", "sleep.....");
		return "sleep";
	}

	@RequestMapping("getCode.do")
	@ResponseBody
	public String getCode() {
		Random rand = new Random();

		return "123" + rand.nextInt(100);

	}

	/*@ExceptionHandler(value = Exception.class)
	public String error(HttpServletRequest req, Exception e) {
		if (e instanceof IncorrectCredentialsException) {
			String msg = e.getMessage();
			req.setAttribute("error", msg);
		} else if (e instanceof UnknownAccountException) {
			String msg = e.getMessage();
			req.setAttribute("error", msg);
		} else {
			req.setAttribute("error", "异常" + e.getMessage());
		}
		return "error";
	}*/

}
