<%@page import="java.io.OutputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Random" %>
<% 
	Random rand = new Random();
	String code="abc"+rand.nextInt(100);
	session.setAttribute("code", code);
	response.setContentType("text/html");
	OutputStream write=response.getOutputStream();
	write.write(code.getBytes());
	write.close();
	out.clear();
%>