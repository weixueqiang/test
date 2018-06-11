
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="base" scope="request"
	value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>first</title>
<c:import url="/js/basic.jsp"></c:import>
</head>
<body>
	<div id="login" class="easyui-window"
		style="padding-top: 5px; padding-left: 15px">
		<form id="loginForm" action="${base}/login.do" method="post">
			<table>
				<tr>
					<td>
						<table>
							<tr>
								<td>用户名</td>
								<td><input class="easyui-validatebox" id="username"
									name="username" type="text" /></td>
								<td></td>
							</tr>
							<tr>
								<td>密 码</td>
								<td><input class="easyui-validatebox" id="password"
									name="password" type="password"></td>
								<td></td>
							</tr>
							<tr>
								<td>验证码</td>
								<td><input class="easyui-validatebox" id="code" name="code"
									type="text" /></td>
								<td><img id="code" src="${base}/getCode.jsp" onclick="this.src='${base}/getCode.jsp?d='+Math.random()"/></td>
							</tr>
							<tr>
								<td>记住我</td>
								<td>
									<input type="checkbox" id="rememberMe" name="rememberMe"/>
								</td>
							</tr>
							<div style="text-align: center; color: red;" id="showMsg"></div>
						</table>
					</td>
					 <td><img src="images/head.png" /></td> 
				</tr>

			</table>
		</form>
	</div>
	<script type="text/javascript">
		$(function() {
			/* flush(); */
			$("#login").dialog({
				title : '登录',
				backcolor : '#00f',
				iconCls : 'icon-lock',
				width : '450',
				height : '260',
				closable : false,
				minimizable : false,
				maximizable : false,
				resizable : false,
				modal : true,
				buttons : [ {
					text : '登录',
					iconCls : 'icon-ok',
					handler : function() {
						doLogin();
					}
				}, {
					text : '清空',
					iconCls : 'icon-ok',
					handler : function() {
						doReset();
					}
				} ]
			});
		});
		function doLogin() {
			if ($("input[name='username']").val() == ""
					|| $("input[name='password']").val() == "") {
				$("#showMsg").html("用户名或密码为空，请输入");
				$("input[name='login']").focus();
			} else {
				$("#login").dialog("close");
				$("#loginForm").get(0).submit();
			}
		}
		function doReset() {
			$("#loginForm").get(0).reset();
		}
	</script>
</body>
</html>