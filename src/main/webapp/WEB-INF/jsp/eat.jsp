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
 	<p>信息:${msg}</p>
 	<a href="${base}/eatApple.do">sleep</a>
 	<a href="${base}/eatRice.do">sleep</a>
 	<a href="${base}/eatOrange.do">sleep</a>
 </body>
</html>