<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="frm" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>${house.title }</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/house.css">

  </head>
  
  <body>
	<div class="page">
		<div class="top">
			<div class="top_inner">
				<div class="left">
					<a href="#">苏州</a>
					<b>&gt;</b>
					<a href="#">苏州房屋</a>
					<b>&gt;</b>
					<a href="#">苏州房屋出租</a>
					<b>&gt;</b>
				</div>
				<a class="right" href="">免费发布房屋出租信息</a>
			</div>
		</div>
		<div class="content clearfix">
			<div class="left">
				<h1 class="title">${house.title }</h1>
				<span class="release">发布时间：<frm:formatDate value="${house.release }" type="date" pattern="yyyy年MM月dd日"></frm:formatDate></span>
				<div class="intro clearfix">
					<img src="${house.image }">
					<ul>
						<li>
							<label>价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;格：</label><span>${house.price }</span>元/月[押一付三]
						</li>
						<li>
							<label>小&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;区：</label>
							${house.resident }
						</li>
						<li>
							<label>楼&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;层：</label>${house.floor }/${house.floors }层
						</li>
						<li>
							<label>出租方式：</label>
							${house.ways }
						</li>
						<li>
							<label>房屋概况：</label>
							${house.area }平米 - ${house.decorate } - <b class="layout" data-layout="${house.layout }"></b>
						</li>
						<li class="phone">
							<img src="images/phoneBg.png">
							<span>${house.userid.phone }</span>
						</li>
					</ul>
				</div>
				<div class="headline">
					<span>基本信息</span>
				</div>
				<ul class="details">
					<li>
						<div class="name">物业类型：</div>
						<div class="value">${house.genre }</div>
					</li>
					<li>
						<div class="name">小区：</div>
						<div class="value" title="${house.resident }">${house.resident }</div>
					</li>
					<li>
						<div class="name">地址：</div>
						<div class="value" title="${house.locations }">${house.locations }</div>
					</li>
					<li>
						<div class="name">户型：</div>
						<div class="value"><b class="layout" data-layout="${house.layout }"></b></div>
					</li>
					<li>
						<div class="name">建筑面积：</div>
						<div class="value">${house.area }平米</div>
					</li>
					<li>
						<div class="name">朝向：</div>
						<div class="value">${house.orient }</div>
					</li>
					<li>
						<div class="name">楼层</div>
						<div class="value">${house.floor }/${house.floors }层</div>
					</li>
					<li>
						<div class="name">装修：</div>
						<div class="value">${house.decorate }</div>
					</li>
				</ul>
				<div class="headline">
					<span>详细介绍</span>
				</div>
				<div class="depict">
					<c:choose>
						<c:when test="${house.depict=='' }">
						该用户尚未填写详细介绍
						</c:when>
						<c:otherwise>
						${house.depict }
						</c:otherwise>
					</c:choose>
				</div>
				<div class="images clearfix">
					<img src="${house.image }">
				</div>
				<div class="headline">
					<span>地图定位</span>
				</div>
				<div id="map"></div> 
			</div>
			<div class="right"></div>
		</div>
	</div>
	<script src="js/jquery.js"></script>
	<script>
	$('.layout').each(function(){
		var temp=$(this).data('layout').toString();
		$(this).html(temp.charAt(0)+'室'+temp.charAt(1)+'厅'+temp.charAt(2)+'卫');
	});
	</script>
  </body>
</html>
