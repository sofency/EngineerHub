<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/EngineerHub/staticfile/css/bootstrap.css">
<link rel="stylesheet" href="/EngineerHub/staticfile/css/header.css">
<link rel="stylesheet" href="https://v4.bootcss.com/docs/examples/product/product.css">
	<style>
		.position-relative{position:relative!important}
		.overflow-hidden{overflow:hidden!important}
		.p-3{padding:1rem!important}
		.p-md-5{padding:3rem!important}
		.m-md-3{margin:1rem!important}
		.bg-light{background-color:#f8f9fa!important}
		.shadow-sm{box-shadow:0 .125rem .25rem rgba(0,0,0,.075)!important}
		.d-none{display:none!important}
		.d-md-block{display:block!important}
		.d-md-flex{display:-ms-flexbox!important;display:flex!important}
		.w-100{width:100%!important}
		.my-md-3{margin-bottom:1rem!important}
		.pl-md-3{padding-left:1rem!important}
		.mr-md-3,.mx-md-3{margin-right:1rem!important}
		.pt-3,.py-3{padding-top:1rem!important}
		.mx-auto{margin-right:auto!important}
		.card-img{width:100%;border-radius:calc(.25rem - 1px)}
		.bg-dark{background-color:#343a40!important}
		.bg-primary{background-color:#007bff!important}
		.text-white{color:#fff!important}
	</style>
</head>
<body>
<%@include file="../common/headerindex.jspf"%>
<div class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-light">
  <div class="jumbotron" style="z-index: 1">
    <h1>斜杠青年</h1>
    <p >我们正等你来</p>
    <a  href="/EngineerHub/index/toJoin">Coming soon</a>
  </div>
  <div class="product-device shadow-sm d-none d-md-block"></div>
  <div class="product-device product-device-2 shadow-sm d-none d-md-block">
  </div>
</div>
<%
	int cnt =0;
%>
<c:forEach items="${fameList}" var="fame">
	<%cnt++; %>
	<% if(cnt%2!=0){%>
	    <div class="d-md-flex flex-md-equal w-100 my-md-3 pl-md-3">
	<%} %>
		<div class="mr-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center overflow-hidden randomcolor" style="position: relative">
		    <div class="my-3 py-3">
		      <h2 class="display-5">${fame.fameName}</h2>
		      <p class="lead">${fame.fameDescription}</p>
		      <p class="card-text"><small class="text-muted">比赛级别:${fame.fameLevel}</small></p>
		    </div>
		    <div class="shadow-sm" style="width: 80%; height: 240px; border-radius: 21px 21px 0 0;">
		    	<img src="${pageContext.request.contextPath}/staticfile/img/fame1.jpg" class="card-img" alt="荣誉1" style="width:70%;height:240px;border-radius: 21px 21px 0 0;position: absolute;left: 0
;right: 0;margin: auto">
		    </div>
		</div>
	<% if(cnt%2==0){%>
     </div>
	<%} %>
</c:forEach>
<script src="/EngineerHub/staticfile/js/jquery-3.2.1.js"></script>
<script src="/EngineerHub/staticfile/js/bootstrap.js"></script>
<script type="text/javascript">
$(function(){
	//随机设置颜色
	const len = $(".pt-md-5").length;//获取要随机颜色的长度
	const arrBg =["bg-dark","bg-light","bg-light","bg-primary"];
	const textCol =["text-white","no","no","text-white"]
	for(let i =0;i<len;i++){
		let obj = $(".pt-md-5:eq("+i+")");
		console.log(obj);
		obj.addClass(arrBg[i%4]).addClass(textCol[i%4])
		console.log($(".pt-md-5")[i%4]);
	}
})
</script>
</body>
</html>