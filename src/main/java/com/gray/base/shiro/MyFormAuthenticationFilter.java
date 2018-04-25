package com.gray.base.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public class MyFormAuthenticationFilter extends FormAuthenticationFilter{

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpSession session = req.getSession();
		String code= (String) session.getAttribute("code");
		String param = req.getParameter("code");
		String rememberMe = req.getParameter("rememberMe");
		System.out.println("rememberMe"+rememberMe);
//		if(param!=null  && code!=null && !param.equals(code)) {
//			req.setAttribute("shiroLoginFailure", "code worong!");
//			return true;
//		}
		return super.onAccessDenied(request, response);
	}
}
