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
			error.html("�������û���");
			//username.addClass("error");
			return false;
		}
		if($("#pwd").val()=="")
		{
			error.css("visibility","visible");
			error.html("����������");
			//pwd.addClass("error");
			return false;
		}
		if(inputCode=="")
		{
			error.css("visibility","visible");
			error.html("��������֤��");
			//authcode.addClass("error");
			return false;
		}
		if(inputCode!=validCode)
		{
			error.css("visibility","visible");
			error.html("��֤�����");
			//authcode.addClass("error");
			changeAuth();
			return false;
		}
	}
	//ͨ��ajax����validCode��ֵ
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
	
	//����ͼƬ������validCode��ֵ
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
