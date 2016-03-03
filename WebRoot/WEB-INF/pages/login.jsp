<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <link rel="stylesheet" type="text/css" href="css/login.css">
  <body>
	    <div class="page">
		<div class="inner">
			<div class="left"></div>
			<div class="right">
				<div class="border">
					<form method="post" action="Action?key=LoginModel" onsubmit="return valid()">
						<!-- 错误信息提示  -->
						<c:choose>
							<c:when test="${ empty error }">
								<div class="error"></div>
							</c:when>
							<c:otherwise>
								<div class="error" style=" visibility: visible;">${error }</div>
							</c:otherwise>
						</c:choose>
						
						<!-- 输入用户名 -->
						<div class="input_div username">
							<i></i>
							<input class="username_input" type="text" name="username" id="username" value="" placeholder="请输入用户名">
						</div>
						<!-- 输入密码 -->
						<div class="input_div pwd">
							<i></i>
							<input class="pwd_input" type="text" name="pwd" id="pwd" value="" placeholder="请输入密码">
						</div>
						<!-- 输入验证码 -->
						<div class="authcode_div">
							<div class="input_div authcode">
								<input type="text" name="" value="" placeholder="请输入验证码">
							</div>
							<div class="auth_img">
								<img src="http://localhost:8088/Graduate/Action?key=GenerateCode&v=1000">
							</div>
						</div>
						<div class="clearfix"></div>
						<!-- 是否自动登录 -->
						<div class="autologin_div">
							<input type="checkbox" id="checkbox" name="checkbox">
							<label for="autologin">七天内自动登录</label>
						</div>
						<!-- 登录按钮 -->
						<input class="loginBtn" type="submit" value="登录" id="submit" />
					</form>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/login.js"></script>
	<script type="text/javascript">
	var validCode="";
	var error=$(".error");
	var username=$(".username");
	var pwd=$(".pwd");
	var authcode=$(".authcode");
	
	//通过ajax更换validCode的值
	function generateCode()
	{
		$.ajax({
			url:"http://localhost:8088/Graduate/Action?key=VerifyCode",
			type:"post",
			dataType:"text",
			async:false,
			success:function(data){
				validCode=data;
			}
		});
	}
	
	var version=1000;
	generateCode();
	
	$(".auth_img").click(function(){
		changeAuth();
	});
	
	var auth_img=$(".auth_img");
	
	//更换图片并更新validCode的值
	function changeAuth()
	{
		version+=3;
		auth_img.children("img").attr("src","http://localhost:8088/Graduate/Action?key=GenerateCode&v="+version);
		generateCode();
	}
	
	$(".input_div").children("input").focus(function(){
		$(this).parent(".input_div").addClass("focus");
		error.css("visibility","hidden");
	});

	$(".input_div").children("input").blur(function(){
		$(this).parent(".input_div").removeClass("focus");
	});
	function valid()
	{
		var inputCode=$(".authcode input").val();
		if($("#username").val()=="")
		{
			error.css("visibility","visible");
			error.html("请输入用户名");
			//username.addClass("error");
			return false;
		}
		if($("#pwd").val()=="")
		{
			error.css("visibility","visible");
			error.html("请输入密码");
			//pwd.addClass("error");
			return false;
		}
		if(inputCode=="")
		{
			error.css("visibility","visible");
			error.html("请输入验证码");
			//authcode.addClass("error");
			return false;
		}
		if(inputCode!=validCode)
		{
			error.css("visibility","visible");
			error.html("验证码错误");
			//authcode.addClass("error");
			changeAuth();
			return false;
		}
	}
	</script>
  </body>
</html>
