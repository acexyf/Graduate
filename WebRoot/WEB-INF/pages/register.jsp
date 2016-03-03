<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/register.css">
  </head>
  
  <body>
	<div class="page">
		<div class="register_wrapper">
			<p class="register_line">
				<label for="" class="label">
					<span class="requred_symbol">*</span>登&nbsp;录&nbsp;名
				</label>
				<input type="text" name="username" class="username_input">
				<span class="invalidMsg usernameMsg"></span>
			</p>
			<p class="register_line">
				<label for="" class="label">
					<span class="requred_symbol">*</span>登录密码
				</label>
				<input type="password" name="pwd" class="pwd_input">
				<span class="invalidMsg pwdMsg"></span>
			</p>
			<p class="register_line">
				<label for="" class="label">
					<span class="requred_symbol">*</span>确认密码
				</label>
				<input type="password" name="repwd" class="repwd_input">
				<span class="invalidMsg repwdMsg"></span>
			</p>
			<p class="register_line">
				<label for="" class="label">
					<span class="requred_symbol">*</span>手机号码
				</label>
				<input type="text" name="phone" class="phone_input">
				<span class="invalidMsg phoneMsg"></span>
			</p>
			<p class="register_line">
				<label for="" class="label">
					<span class="requred_symbol">*</span>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱
				</label>
				<input type="text" name="email" class="email_input">
				<span class="invalidMsg emailMsg"></span>
			</p>
			<p class="register_line">
				<label for="" class="label">
					<span class="requred_symbol">*</span>验&nbsp;证&nbsp;码
				</label>
				<input type="text" name="authcode" class="authcode_input">
				<img class="auth_img" src="http://localhost:8088/Graduate/Action?key=GenerateCode&v=1000">
				<span class="invalidMsg authcodeMsg"></span>
			</p>
			<p class="register_line">
				<a href="javascript:;" class="submitBtn">同意服务条款并注册</a>
			</p>
		</div>
	</div>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src=""></script>
<script type="text/javascript">
//用户名
	var username="";
	//登陆密码
	var pwd="";
	//确认密码
	var repwd="";
	//手机号码
	var phone="";
	//邮箱
	var email="";
	//验证码
	var validCode="";
	//错误提示框
	var usernameMsg=$(".usernameMsg");
	var pwdMsg=$(".pwdMsg");
	var repwdMsg=$(".repwdMsg");
	var phoneMsg=$(".phoneMsg");
	var emailMsg=$(".emailMsg");
	var authcodeMsg=$(".authcodeMsg");
	//输入框
	var username_input=$(".username_input");
	var pwd_input=$(".pwd_input");
	var repwd_input=$(".repwd_input");
	var phone_input=$(".phone_input");
	var email_input=$(".email_input");
	var authcode_input=$(".authcode_input");

	//验证码图片
	var auth_img=$(".auth_img");
	//是否可以提交
	var isSubmit=false;

	//正则表达式
	var usernameReg=/^[a-zA-Z][a-zA-Z0-9_]{3,15}$/;//4-16字符
	var pwdReg=/^[a-zA-Z][a-zA-Z0-9_]{5,17}$/;//6-18位
	var phoneReg=/^1(\d){10}$/;
	var emailReg=/^[a-zA-Z]+([-_.][a-zA-Z0-9]+)*@([a-zA-Z0-9]+[-.])+[a-zA-Z]{2,5}$/;

	generateCode();
	var version=1000;
	//通过ajax更换validCode的值
	function generateCode()
	{
		$.ajax({
			url:"http://localhost:8088/Graduate/Action?key=VerifyCode",
			type:"post",
			dataType:"text",
			success:function(data){
				validCode=data;
				//console.log(validCode);
			}
		});
	}

	//用户名
	$(".username_input").focus(function(){
		username_input.removeClass("error");
		usernameMsg.css("display","none");
	});

	$(".username_input").blur(function(){
		checkUsername();
	});

	//密码
	$(".pwd_input").focus(function(){
		pwd_input.removeClass("error");
		pwdMsg.css("display","none");
	});

	$(".pwd_input").blur(function(){
		chenckPwd();	
	});

	//确认密码
	$(".repwd_input").focus(function(){
		repwd_input.removeClass("error");
		repwdMsg.css("display","none");
	});

	$(".repwd_input").blur(function(){
		checkRepwd();
	});

	//手机号码
	$(".phone_input").focus(function(){
		phone_input.removeClass("error");
		phoneMsg.css("display","none");
	});

	$(".phone_input").blur(function(){
		checkPhone();
	});

	//邮箱验证
	$(".email_input").focus(function(){
		email_input.removeClass("error");
		emailMsg.css("display","none");
	});

	$(".email_input").blur(function(){
		checkMail();
	});

	//验证码
	$(".authcode_input").focus(function(){
		authcode_input.removeClass("error");
		authcodeMsg.css("display","none");
	});

	$(".authcode_input").blur(function(){
		checkAuthcode();
	});

	$(".auth_img").click(function(){
		authcode_input.removeClass("error");
		authcodeMsg.css("display","none");
		changeAuth();
	});

	$(".submitBtn").click(function(){
		checkUsername();
		chenckPwd();
		checkRepwd();
		checkPhone();
		checkMail();
		checkAuthcode();
		if(isSubmit)
		{
			submit();
		}
	});

	function submit()
	{
		$.ajax({
			url:"http://localhost:8088/Graduate/Action?key=RegisterModel",
			type:"post",
			async:false,
			data:{
				username:username,
				pwd:pwd,
				phone:phone,
				email:email
			},
			success:function(data){
				console.log(data);
				if("repeat"==data)
				{
					username_input.addClass("error");
					usernameMsg.html("该用户已存在");
					usernameMsg.css("display","inline-block");
					isSubmit=false;
				}
				else if("ok"==data)
				{
					location.href="http://localhost:8088/Graduate/Action?key=initHome";
				}
			}
		});
	}

	//更换图片并更新validCode的值
	function changeAuth()
	{
		version+=3;
		auth_img.attr("src","http://localhost:8088/Graduate/Action?key=GenerateCode&v="+version);
		generateCode();
	}

	//验证用户名
	function checkUsername()
	{
		username=username_input.val();
		if(""==username)
		{
			username_input.addClass("error");
			usernameMsg.html("请输入用户名");
			usernameMsg.css("display","inline-block");
			isSubmit=false;
		}
		else if(!usernameReg.exec(username))
		{
			username_input.addClass("error");
			usernameMsg.html("请输入4-16位的用户名，字母开头");
			usernameMsg.css("display","inline-block");
			isSubmit=false;
		}
		else
		{
			isSubmit=true;
		}
	}

	//验证密码
	function chenckPwd()
	{
		pwd=pwd_input.val();
		if(""==pwd)
		{
			pwd_input.addClass("error");
			pwdMsg.html("请输入登录密码");
			pwdMsg.css("display","inline-block");
			isSubmit=false;
		}
		else if(!pwdReg.exec(pwd))
		{
			pwd_input.addClass("error");
			pwdMsg.html("请输入6-18位的登录密码，字母开头");
			pwdMsg.css("display","inline-block");
			isSubmit=false;
		}
		else
		{
			isSubmit=true;
		}
	}

	//验证确认密码
	function checkRepwd()
	{
		repwd=repwd_input.val();
		pwd=pwd_input.val();
		if(""==repwd)
		{
			repwd_input.addClass("error");
			repwdMsg.html("请输入确认密码");
			repwdMsg.css("display","inline-block");
			isSubmit=false;
		}
		else if(pwd!=repwd)
		{
			repwd_input.addClass("error");
			repwdMsg.html("确认密码和登录密码不一致!");
			repwdMsg.css("display","inline-block");
			isSubmit=false;
		}
		else
		{
			isSubmit=true;
		}
	}

	//验证手机号码
	function checkPhone()
	{
		phone=phone_input.val();
		if(""==phone)
		{
			phone_input.addClass("error");
			phoneMsg.html("请输入确认密码");
			phoneMsg.css("display","inline-block");
			isSubmit=false;
		}
		else if(!phoneReg.exec(phone))
		{
			phone_input.addClass("error");
			phoneMsg.html("请输入正确格式的手机号码");
			phoneMsg.css("display","inline-block");
			isSubmit=false;
		}
		else
		{
			isSubmit=true;
		}
	}

	//验证邮箱
	function checkMail()
	{
		email=email_input.val();
		if(""==email)
		{
			email_input.addClass("error");
			emailMsg.html("请输入邮箱地址");
			emailMsg.css("display","inline-block");
			isSubmit=false;
		}
		else if(!emailReg.exec(email))
		{
			email_input.addClass("error");
			emailMsg.html("请输入正确格式的邮箱地址");
			emailMsg.css("display","inline-block");
			isSubmit=false;
		}
	}

	//验证验证码
	function checkAuthcode()
	{
		authcode=authcode_input.val();
		if(""==authcode)
		{
			authcode_input.addClass("error");
			authcodeMsg.html("请输入验证码");
			authcodeMsg.css("display","inline-block");
			isSubmit=false;
		}
		else if(authcode!=validCode)
		{
			authcode_input.addClass("error");
			authcodeMsg.html("验证码错误");
			authcodeMsg.css("display","inline-block");
			isSubmit=false;
			changeAuth();
		}
		else
		{
			isSubmit=true;
		}
	}
</script>
  </body>
</html>
