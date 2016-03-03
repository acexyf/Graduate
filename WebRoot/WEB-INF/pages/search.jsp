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
    
    <title>My JSP 'search.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <link rel="stylesheet" type="text/css" href="css/search.css">
  <body>
    <div class="searchbox">
	<div class="searchbg">
		<div class="search">
			<input type="text" class="searchTxt" placeholder="请输入关键字">
			<input type="button" class="searchBtn" value="搜索">
		</div>
	</div>
</div>
<div class="page">
	<div class="guide">
		
	</div>
	<div class="searchmenu">
		<ul>
			<li class="locates">
				<span>区域：</span>
				<a class="active" href="javascript:;" data-locateid="0">不限</a>
				<c:forEach var="locate" items="${locates }">
					<a href="javascript:;" data-locateid="${locate.locateid }">${locate.locatename }</a>
				</c:forEach>
				<!--  
				<a href="">常熟</a>
				<a href="">昆山</a>
				<a href="">太仓</a>
				<a href="">吴江</a>
				<a href="">吴中</a>
				<a href="">相城</a>
				<a href="">新区</a>
				<a href="">园区</a>
				<a href="">张家港</a>
				<a href="">姑苏</a>
				-->
			</li>
			<li class="prices">
				<span>租金：</span>
				<a class="active" href="javascript:;" data-price="0">不限</a>
				<a href="javascript:;" data-price="1">500元以下</a>
				<a href="javascript:;" data-price="2">500-1000元</a>
				<a href="javascript:;" data-price="3">1000-1500元</a>
				<a href="javascript:;" data-price="4">1500-3000元</a>
				<a href="javascript:;" data-price="5">3000元以上</a>
			</li>
			<li class="layouts">
				<span>户型：</span>
				<a class="active" href="javascript:;" data-layout="0">不限</a>
				<a href="javascript:;" data-layout="1">一居</a>
				<a href="javascript:;" data-layout="2">二居</a>
				<a href="javascript:;" data-layout="3">三居</a>
				<a href="javascript:;" data-layout="4">四居</a>
				<a href="javascript:;" data-layout="5">四居以上</a>
			</li>
			<li class="ways">
				<span>租住方式：</span>
				<a class="active" href="javascript:;" data-ways="0">不限</a>
				<a href="javascript:;" data-ways="整租">整租</a>
				<a href="javascript:;" data-ways="合租">合租</a>
			</li>
		</ul>

		<div class="condition">
			<span>更多找房条件：</span>
			<div class="select_box">
				<div class="tag_select">装修</div>
				<ul class="decorates">
					<li data-decorate="0">不限</li>
					<li data-decorate="毛坯">毛坯</li>
					<li data-decorate="简装修">简装修</li>
					<li data-decorate="中等装修">中等装修</li>
					<li data-decorate="精装修">精装修</li>
					<li data-decorate="豪华装修">豪华装修</li>
				</ul>
			</div>
			<div class="select_box">
				<div class="tag_select">朝向</div>
				<ul class="orients">
					<li data-orient="0">不限</li>
					<li data-orient="南北">南北通透</li>
					<li data-orient="东西">东西朝向</li>
					<li data-orient="东">朝东</li>
					<li data-orient="西">朝西</li>
					<li data-orient="南">朝南</li>
					<li data-orient="北">朝北</li>
				</ul>
			</div>
			<div class="select_box">
				<div class="tag_select">楼层</div>
				<ul class="floors">
					<li data-floor="0">不限</li>
					<li data-floor="1">6层以下</li>
					<li data-floor="2">6-12层</li>
					<li data-floor="3">12层以上</li>
				</ul>
			</div>
			<!-- <div class="select_box">
				<div class="tag_select">配套</div>
			</div> -->
		</div>
		
<!-- 		<div class="condition current">
			<span>当前找房条件：</span>
		</div> -->
	</div>
	<div class="result_div">
		<div class="left">
			
			<!-- 遍历开始 -->
			
			<c:forEach var="house" items="${houses }">
				<div class="house" data-houseid="${house.houseid }">
					<div class="img">
						<img src="${house.image }">
					</div>
					<div class="detail">
						<p class="title">${house.title }</p>
						<p class="locate">${house.region.locatename }-${house.resident }<span>${house.locations }</span></p>
						<p class="brief">${house.ways }<span>|</span>${house.area }平方米<span>|</span>${house.decorate }<span>|</span>${house.floor }层/${house.floors }层<span>|</span>朝${house.orient }</p>
						<div class="moreInfo">
							<p class="price"><span>${house.price }</span>元/月</p>
							<p class="layout" data-layout="${house.layout }"></p>
						</div>
					</div>
				</div>
			</c:forEach>
			
			<!-- 遍历结束 -->



		</div>
		<!-- 广告div -->
		<div class="right"></div>
		<div class="clearfix"></div>
		<!-- 页码div -->
		<div class="pageNum">
			<div id="pageGro" class="cb">
				<div class="pageUp">上一页</div>
			    <div class="pageList">
			        <ul>
			            <li>1</li>
			            <li>2</li>
			            <li>3</li>
			            <li>4</li>
			            <li>5</li>
			        </ul>
			    </div>
			    <div class="pageDown">下一页</div>
				<div id="skip">共<span id="pageCount">${pageNum }</span>页&nbsp;&nbsp;跳转到第<input id="jumpnumber" type="number" max="${pageNum }" min="1" />页<a href="javascript:;" onclick="JumpTo()">GO</a></div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	
	$('.layout').each(function(){
		var temp=$(this).data('layout').toString();
		$(this).html(temp.charAt(0)+'室'+temp.charAt(1)+'厅'+temp.charAt(2)+'卫');
	});
	
	$('.house').click(function(){
		var houseid=$(this).data("houseid");
		window.location.replace("Action?key=initHouse&&houseid="+houseid);
	});
	
	var locateid="0",
		price="0",
		layout="0",
		ways="0",
		decorate="0",
		orient="0",
		floor="0";
	
	$(".searchmenu a").click(function(e){
		e.preventDefault();
		$(this).parent("li").children("a.active").removeClass("active");
		$(this).addClass("active");
	});
	$(".select_box").mouseover(function(){
		$(this).children("ul").css({"display":"block"});
	});
	$(".select_box").mouseout(function(){
		$(this).children("ul").css({"display":"none"});
	});
	
	
	$(".locates a").click(function(){
		locateid=$(this).data("locateid");
		//console.log(locateid);
		loadXMLDoc();
	});
	
	$(".prices a").click(function(){
		price=$(this).data("price");
		//console.log(price);
		loadXMLDoc();
	});
	
	$(".layouts a").click(function(){
		layout=$(this).data("layout");
		//console.log(layout);
		loadXMLDoc();
	});
	
	$(".ways a").click(function(){
		ways=$(this).data("ways");
		//console.log(ways);
		loadXMLDoc();
	});
	
	$(".decorates li").click(function(){
		decorate=$(this).data("decorate");
		//console.log(decorate);
		loadXMLDoc();
	});
	
	$(".orients li").click(function(){
		orient=$(this).data("orient");
		//console.log(orient);
		loadXMLDoc();
	});
	
	$(".floors li").click(function(){
		floor=$(this).data("floor");
		//console.log(floor);
		loadXMLDoc();
	});
	
	//分页
	var priceBegin=<%=request.getAttribute("priceBegin")==null?0:request.getAttribute("priceBegin")%>;
	var priceEnd=<%=request.getAttribute("priceEnd")==null?0:request.getAttribute("priceEnd")%>;
	var currentPage=1;//当前页
	var pageCount = parseInt(document.getElementById("pageCount").innerHTML);//总的页数
	
	$(function(){
	if(pageCount>5){
		page_icon(1,5,0);
	}else{
		page_icon(1,pageCount,0);
	}
	
	$("#pageGro li").live("click",function(){
		if(pageCount > 5){
			var pageNum = parseInt($(this).html());
			pageGroup(pageNum,pageCount);
		}else{
			$(this).addClass("on");
			$(this).siblings("li").removeClass("on");
		}
		currentPage=parseInt($(this).text());
		loadXMLDoc();
		//alert($(this).text());
	});
	
	$("#pageGro .pageUp").click(function(){
		if(pageCount > 5){
			var pageNum = parseInt($("#pageGro li.on").html());
			pageUp(pageNum,pageCount);
		}else{
			var index = $("#pageGro ul li.on").index();
			if(index > 0){
				$("#pageGro li").removeClass("on");
				$("#pageGro ul li").eq(index-1).addClass("on");
			}
		}
		if(currentPage!=1)
			currentPage--;
		loadXMLDoc();
	});
	
	$("#pageGro .pageDown").click(function(){
		if(pageCount > 5){
			var pageNum = parseInt($("#pageGro li.on").html());
			pageDown(pageNum,pageCount);
		}else{
			var index = $("#pageGro ul li.on").index();
			if(index+1 < pageCount){
				$("#pageGro li").removeClass("on");
				$("#pageGro ul li").eq(index+1).addClass("on");
			}
		}
		if(currentPage!=pageCount)
			currentPage++;
		loadXMLDoc();
	});
});

function pageGroup(pageNum,pageCount){
	switch(pageNum){
		case 1:
			page_icon(1,5,0);
		break;
		case 2:
			page_icon(1,5,1);
		break;
		case pageCount-1:
			page_icon(pageCount-4,pageCount,3);
		break;
		case pageCount:
			page_icon(pageCount-4,pageCount,4);
		break;
		default:
			page_icon(pageNum-2,pageNum+2,2);
		break;
	}
}

function page_icon(page,count,eq){
	var ul_html = "";
	for(var i=page; i<=count; i++){
		ul_html += "<li>"+i+"</li>";
	}
	$("#pageGro ul").html(ul_html);
	$("#pageGro ul li").eq(eq).addClass("on");
}

function pageUp(pageNum,pageCount){
	switch(pageNum){
		case 1:
		break;
		case 2:
			page_icon(1,5,0);
		break;
		case pageCount-1:
			page_icon(pageCount-4,pageCount,2);
		break;
		case pageCount:
			page_icon(pageCount-4,pageCount,3);
		break;
		default:
			page_icon(pageNum-2,pageNum+2,1);
		break;
	}
}

function pageDown(pageNum,pageCount){
	switch(pageNum){
		case 1:
			page_icon(1,5,1);
		break;
		case 2:
			page_icon(1,5,2);
		break;
		case pageCount-1:
			page_icon(pageCount-4,pageCount,4);
		break;
		case pageCount:
		break;
		default:
			page_icon(pageNum-2,pageNum+2,3);
		break;
	}
}

//AJAX异步刷新pointshop_body
/*
function loadXMLDoc()
{
	var xmlhttp;
	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
	    	$(".left").innerHTML=xmlhttp.responseText;
	    }
	  }
	xmlhttp.open("POST","Action",true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send("key=SearchAjax&currentPage="+currentPage+"&locateid="+locateid+"&price="+price+"&layout="+layout+"&ways="+ways+"&decorate="+decorate+"&orient="+orient+"&floor="+floor);
}*/
function loadXMLDoc()
{
	$.ajax({
			url:"http://localhost:8088/Graduate/Action",
			type:"post",
			async:true,
			dataType:"json",
			data:{
				key:"SearchAjax",
				currentPage:currentPage,
				locateid:locateid,
				price:price,
				layout:layout,
				ways:ways,
				decorate:decorate,
				orient:orient,
				floor:floor
			},
			success:function(data){
				console.log(data);
				console.log(data.sumPage);
			}
		});
}




function JumpTo()
{
	if(document.getElementById("jumpnumber").value=="")
	{
		alert("错误页码");
	}
	else
	{
		var jumpnumber=parseInt(document.getElementById("jumpnumber").value);
		if(jumpnumber>pageCount||jumpnumber<=0)
		{
			alert("页码超出范围");
		}
		else
		{
			currentPage=jumpnumber;
			loadXMLDoc();
			if(pageCount>=5)
			{
				pageGroup(currentPage,pageCount);
			}
			else
			{
				page_icon(1,pageCount,currentPage-1);
			}
		}
	}
}

/*
function goSearch()
{
	var keyWord=$("#headline_search1_d2").val();
	if(keyWord=="请输入商品名称、地址等"||keyWord=="")
	{
		window.location.replace("Action?key=initSearch");
	}
	else
	{
		window.location.replace("Action?key=initSearch&searchMethod=5&keyWord="+keyWord);
	}
}*/

</script>
  </body>
</html>
