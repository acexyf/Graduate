$(function(){
	//�û���
	var username="";
	//��½����
	var pwd="";
	//ȷ������
	var repwd="";
	//�ֻ�����
	var phone="";
	//����
	var email="";
	//��֤��
	var validCode="";
	//������ʾ��
	var usernameMsg=$(".usernameMsg");
	var pwdMsg=$(".pwdMsg");
	var repwdMsg=$(".repwdMsg");
	var phoneMsg=$(".phoneMsg");
	var emailMsg=$(".emailMsg");
	var authcodeMsg=$(".authcodeMsg");
	//�����
	var username_input=$(".username_input");
	var pwd_input=$(".pwd_input");
	var repwd_input=$(".repwd_input");
	var phone_input=$(".phone_input");
	var email_input=$(".email_input");
	var authcode_input=$(".authcode_input");

	//��֤��ͼƬ
	var auth_img=$(".auth_img");
	//�Ƿ�����ύ
	var isSubmit=false;

	//������ʽ
	var usernameReg=/^[a-zA-Z][a-zA-Z0-9_]{3,15}$/;//4-16�ַ�
	var pwdReg=/^[a-zA-Z][a-zA-Z0-9_]{5,17}$/;//6-18λ
	var phoneReg=/^(\d){11}$/;
	var emailReg=/^(\w)$/;

	generateCode();
	var version=1000;
	//ͨ��ajax����validCode��ֵ
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

	//�û���
	$(".username_input").focus(function(){
		username_input.removeClass("error");
		usernameMsg.css("display","none");
	});

	$(".username_input").blur(function(){
		checkUsername();
	});

	//����
	$(".pwd_input").focus(function(){
		pwd_input.removeClass("error");
		pwdMsg.css("display","none");
	});

	$(".pwd_input").blur(function(){
		chenckPwd();	
	});

	//ȷ������
	$(".repwd_input").focus(function(){
		repwd_input.removeClass("error");
		repwdMsg.css("display","none");
	});

	$(".repwd_input").blur(function(){
		checkRepwd();
	});

	//�ֻ�����
	$(".phone_input").focus(function(){
		phone_input.removeClass("error");
		phoneMsg.css("display","none");
	});

	$(".phone_input").blur(function(){
		checkPhone();
	});

	//������֤
	$(".email_input").focus(function(){
		email_input.removeClass("error");
		emailMsg.css("display","none");
	});

	$(".email_input").blur(function(){
		checkMail();
	});

	//��֤��
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
			}
		});
	}

	//����ͼƬ������validCode��ֵ
	function changeAuth()
	{
		version+=3;
		auth_img.attr("src","http://localhost:8088/Graduate/Action?key=GenerateCode&v="+version);
		generateCode();
	}

	//��֤�û���
	function checkUsername()
	{
		username=username_input.val();
		if(""==username)
		{
			username_input.addClass("error");
			usernameMsg.html("�������û���");
			usernameMsg.css("display","inline-block");
			isSubmit=false;
		}
		else if(!usernameReg.exec(username))
		{
			username_input.addClass("error");
			usernameMsg.html("������4-16λ���û�������ĸ��ͷ");
			usernameMsg.css("display","inline-block");
			isSubmit=false;
		}
		else
		{
			isSubmit=true;
		}
	}

	//��֤����
	function chenckPwd()
	{
		pwd=pwd_input.val();
		if(""==pwd)
		{
			pwd_input.addClass("error");
			pwdMsg.html("�������¼����");
			pwdMsg.css("display","inline-block");
			isSubmit=false;
		}
		else if(!pwdReg.exec(pwd))
		{
			pwd_input.addClass("error");
			pwdMsg.html("������6-18λ�ĵ�¼���룬��ĸ��ͷ");
			pwdMsg.css("display","inline-block");
			isSubmit=false;
		}
		else
		{
			isSubmit=true;
		}
	}

	//��֤ȷ������
	function checkRepwd()
	{
		repwd=repwd_input.val();
		pwd=pwd_input.val();
		if(""==repwd)
		{
			repwd_input.addClass("error");
			repwdMsg.html("������ȷ������");
			repwdMsg.css("display","inline-block");
			isSubmit=false;
		}
		else if(pwd!=repwd)
		{
			repwd_input.addClass("error");
			repwdMsg.html("ȷ������͵�¼���벻һ��!");
			repwdMsg.css("display","inline-block");
			isSubmit=false;
		}
		else
		{
			isSubmit=true;
		}
	}

	//��֤�ֻ�����
	function checkPhone()
	{
		phone=phone_input.val();
		if(""==phone)
		{
			phone_input.addClass("error");
			phoneMsg.html("������ȷ������");
			phoneMsg.css("display","inline-block");
			isSubmit=false;
		}
		else if(!phoneReg.exec(phone))
		{
			phone_input.addClass("error");
			phoneMsg.html("��������ȷ��ʽ���ֻ�����");
			phoneMsg.css("display","inline-block");
			isSubmit=false;
		}
		else
		{
			isSubmit=true;
		}
	}

	//��֤����
	function checkMail()
	{
		email=email_input.val();
		if(""==email)
		{
			email_input.addClass("error");
			emailMsg.html("�����������ַ");
			emailMsg.css("display","inline-block");
			isSubmit=false;
		}
		else if(!emailReg.exec(email))
		{
			email_input.addClass("error");
			emailMsg.html("��������ȷ��ʽ�������ַ");
			emailMsg.css("display","inline-block");
			isSubmit=false;
		}
	}

	//��֤��֤��
	function checkAuthcode()
	{
		authcode=authcode_input.val();
		if(""==authcode)
		{
			authcode_input.addClass("error");
			authcodeMsg.html("��������֤��");
			authcodeMsg.css("display","inline-block");
			isSubmit=false;
		}
		else if(authcode!=validCode)
		{
			authcode_input.addClass("error");
			authcodeMsg.html("��֤�����");
			authcodeMsg.css("display","inline-block");
			isSubmit=false;
			changeAuth();
		}
		else
		{
			isSubmit=true;
		}
	}
});