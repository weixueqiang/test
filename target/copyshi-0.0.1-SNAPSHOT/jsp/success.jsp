<%@ page language="java" pageEncoding="utf-8"%> 
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>  
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:set var="base" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<title></title>  
</head>  
<body>  
${successMsg } Welcome!  <shiro:principal/>  
    <br><br>  
      
    <shiro:hasAnyRoles name="user">  
        <a href="${base}/jsp/user.jsp">User Page</a>  
    </shiro:hasAnyRoles>  
      
      <shiro:hasPermission name="go:user">
      <a href="${base}/jsp/user.jsp">User Page</a> go
      </shiro:hasPermission>
    <br><br>  
      
    <shiro:hasAnyRoles name="admin">  
        <a href="${base}/jsp/admin.jsp">Admin Page</a>  
    </shiro:hasAnyRoles>  
       
      <shiro:hasPermission name="go:admin">
       <a href="${base}/jsp/admin.jsp">Admin Page</a>go
      </shiro:hasPermission>
      
      
    <br><br>  
    <a href="${base}/test/logout.do">Logout</a>  
</body>  
</html>