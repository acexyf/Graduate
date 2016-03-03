$(function() {
	
	var validCode="";
	var error=$(".error");
	var username=$(".username");
	var pwd=$(".pwd");
	var authcode=$(".authcode");
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
	//通过ajax更换validCode的值
	function generateCode()
	{
		$.ajax({
			url:"http://localhost:8088/Graduate/Action?key=VerifyCode",
			type:"post",
			dataType:"text",
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
});
