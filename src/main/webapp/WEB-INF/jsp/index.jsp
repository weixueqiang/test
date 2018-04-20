<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:set var="base" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>??</title>        
 </head>
 <body>
 	<form action="${base}/login.do" method="post">
 		<input type="text" name="username"/>
 		<input type="text" name="password"/>
 		<input type="submit" value="tijiao"/>
 	<p><input type="text"  name="code" value="abc"/>
 	<input type="text" id="input" ><input type="button" value="f5" onclick="getCode()"></p>
 	</form>
 	
 	<p><a href="${base}/success.do">success.jsp</a></p>
 </body>
 <script type="text/javascript" src="${base}/js/jquery.js"></script>
 <script type="text/javascript">
 
 $(function(){
	getCode(); 
 });
 
 function getCode(){
	 $.ajax({
		 "url":"${base}/getCode.jsp",
		 "data":new Date(),
		 "datatype":"json",
		 "type":"get",
		 "success":function(obj){
			 console.log(obj);
			 if(obj){
				 $("#input").val(obj);
			 }
		 }
	 });
 }
 
 
 </script>
</html>