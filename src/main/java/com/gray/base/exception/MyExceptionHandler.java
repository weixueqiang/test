package com.gray.base.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

public class MyExceptionHandler extends ExceptionHandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest req, HttpServletResponse response, Object handler,
			Exception e) {
		ModelAndView model=new ModelAndView();
		if (e instanceof IncorrectCredentialsException) {
			String msg = e.getMessage();
			req.setAttribute("error", msg);
		} else if (e instanceof UnknownAccountException) {
			String msg = e.getMessage();
			req.setAttribute("error", msg);
		}else if(e instanceof UnauthorizedException) {
			model.setViewName("refuse");
			return model;
		}else {
			req.setAttribute("error", "异常" + e.getMessage());
		}
		model.setViewName("error");
		return model;
	}
	
}
