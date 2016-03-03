<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员登陆</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/adminLogin.css">

  </head>
  
  <body>
	<div class="wrapper">
	
		<div class="container">
			<h1>Welcome</h1>
			<div class="form">
				<input class="username" type="text" placeholder="用户名">
				<input class="pwd" type="password" placeholder="密码">
				<button type="submit" id="login-button">登录</button>
				<div class="nameError">
					用户名为空<b></b>
				</div>
				<div class="pwdError">
					密码为空<b></b>
				</div>
			</div>
		</div>
		
		
		
		<ul class="bg-bubbles">
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
		</ul>
		
	</div>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript">
	var nameError=$('.nameError');
	var pwdError=$('.pwdError');
	var isSubmit=false;
	
	$('#login-button').click(function(event){
		event.preventDefault();
		validName();
		validPwd();
	
		if(isSubmit)
		{
			$.ajax({
				url:"http://localhost:8088/Graduate/Action",
				type:"post",
				async:true,
				dataType:"json",
				data:{
					key:"ADLoginModel",
					name:$('.username').val(),
					pwd:$('.pwd').val()
				},
				success:function(data){
					if('error'==data.status)
					{
						if(data.type==1)
						{
							nameShow("用户名错误");
						}
						else if(data.type==2)
						{
							pwdShow("密码错误");
						}
					}
					else if('ok'==data.status)
					{
						$('.form').fadeOut(500);
						$('.wrapper').addClass('form-success');
						window.location.replace="http://localhost:8088/Graduate/Action?key=initHome";
					}
				}
			});
		}
	});

	$('.username').focus(function(){
		nameHide();
	});
	$('.username').blur(function(){
		validName();
	});
	$('.pwd').focus(function(){
		pwdHide();
	});
	$('.pwd').blur(function(){
		validPwd();
	});
	//验证用户名
	function validName(){
		var name=$('.username').val();
		isSubmit=true;
		if(''==name){
			isSubmit=false;
			nameShow('用户名为空');
		}
	}
	//验证密码
	function validPwd(){
		var pwd=$('.pwd').val();
		isSubmit=true;
		if(''==pwd){
			isSubmit=false;
			pwdShow('密码为空');
		}
	
	}
	
	function nameShow(text){
		nameError.html(text+'<b></b>');
		nameError.addClass('show');
	}
	
	function pwdShow(text){
		pwdError.html(text+'<b></b>');
		pwdError.addClass('show');
	}
	function nameHide(){
		nameError.removeClass('show');
	}
	function pwdHide(){
		pwdError.removeClass('show');
	}
	</script>
  </body>
</html>
