<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'error.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/error.css">


  </head>
  
  <body>
	<div class="page">
		<img src="images/404error.jpg">
		<div class="txt">
			<h1>啊哦，你所访问的页面不存在哟</h1>
			<p>可能的原因</p>
			<p>1、在地址栏中输入的错误的地址。</p>
			<p>2、你点击的某个链接已过期</p>
			<p><a href="">返回上一级页面&gt;</a></p>
			<p><a href="">返回网站首页&gt;</a></p>
		</div>
	</div>
  </body>
</html>
