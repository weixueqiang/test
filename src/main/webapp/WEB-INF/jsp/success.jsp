<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="r" uri="http://shiro.apache.org/tags" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:set var="base" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>??</title>        
 </head>
 <body>
 <h1>welcome:${username}</h1>
 <p>what</p>
 <p>base:${base}</p>
 <r:hasRole name="eat"><a href="${base}/eat.do">eat</a></r:hasRole>
 <r:hasRole name="sleep"><a href="${base}/sleep.do">sleep</a></r:hasRole>
 <r:hasRole name="run"><p>run</p></r:hasRole>
 
 
 <p><a href="${base}/logout.do">tuiiut</a></p>
 </body>
</html>