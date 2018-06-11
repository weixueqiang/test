
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
 <script src="/copyshi/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
</head>
<body style="margin: 0px;">
	<div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'north'" style="height: 60px;">
			<div class="top" style="paddding-right:100px">
				<div class="top_right">
					<!-- <img src="/images/logo.jpg" /> -->
				</div>
				<div class="top_right">
					<p>
						欢迎您：${username} <a href="${base}/logout.do">退出</a>
					</p>
				</div>
			</div>
		</div>
		<div data-options="region:'west',split:'true',title:'导航'"
			style="width: 220px">
			<div class="easyui-accordion" data-options="fit:true,border:false">


				<div title="系统管理">

					<a href="javascript:run('/user/view.htm', '用户管理')"
						class="easyui-linkbutton"
						data-options="plain:true,iconCls:'icon-blank'"
						style="width: 100%; text-align: left;">用户管理</a>

				</div>

			</div>
		</div>
		<div data-options="region:'center'"
			style="width: 100%; height: 100px;">
			<div id="tabs" class="easyui-tabs"
				data-options="fit:true,border:false">
				<!--  
            <div title="首页"></div> 
         -->
			</div>
		</div>
		<div class="easyui-panel" title="管理平台欢迎您"
			data-options="region:'south',collapsible:false"></div>
	</div>

	<script type="text/javascript">
		function run(url, title) {
			if (url.substring(0, 4) != 'http') {
				url = 'http://localhost/' + url;
			}

			if ($("#tb").tabs("getTab", title)) {
				$("#tb").tabs("select", title);
			} else {
				if (url.substring(0, 4) != 'http') {
					//第一种打开页面方式  
					$('#tb').tabs('add', {
						title : title,
						href : url,
						closable : true
					});
				} else {
					//第二种打开页面方式  
					$("#tb")
							.tabs(
									'add',
									{
										title : title,
										content : "<iframe id='"
												+ title
												+ "' frameborder=0 style='width:100%;height:100%'></iframe>",
										closable : true
									});
					$("#" + title)[0].src = url;
				}
			}
		}
	</script>
</body>
</html>