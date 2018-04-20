<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="r" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>??</title>        
 </head>
 <body>
 <h1>welcome:${username}</h1>
 <p>what</p>
 <p>base:${base}</p>
 <r:hasRole name="eat"><a href="/pratice/eat.do">eat</a></r:hasRole>
 <r:hasRole name="sleep"><a href="/pratice/sleep.do">sleep</a></r:hasRole>
 <r:hasRole name="run"><p>run</p></r:hasRole>
 
 
 <p><a href="/pratice/logout.do">tuiiut</a></p>
 </body>
</html>