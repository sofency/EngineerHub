<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/staticfile/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/staticfile/css/header.css">
<link rel="stylesheet" href="https://v4.bootcss.com/docs/examples/product/product.css">
</head>
<body>
<%@include file="../common/headerindex.jspf"%>
<div class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-light">
  <div class="col-md-5 p-lg-5 mx-auto my-5">
    <h1 class="display-4 font-weight-normal">斜杠青年</h1>
    <p class="lead font-weight-normal">在完全胜任自己工作的前提下，再选择一份自己喜欢的工作作为第二职业</p>
    <a class="btn btn-outline-secondary" href="#">Coming soon</a>
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
		<div class="mr-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center overflow-hidden randomcolor">
		    <div class="my-3 py-3">
		      <h2 class="display-5">${fame.fameName}</h2>
		      <p class="lead">${fame.fameDescription}</p>
		      <p class="card-text"><small class="text-muted">比赛级别:${fame.fameLevel}</small></p>
		    </div>
		    <div class="shadow-sm mx-auto" style="width: 80%; height: 240px; border-radius: 21px 21px 0 0;">
		    	<img src="${pageContext.request.contextPath}/staticfile/img/fame1.jpg" class="card-img" alt="荣誉1" style="height:240px;border-radius: 21px 21px 0 0;">
		    </div>
		</div>
	<% if(cnt%2==0){%>
     </div>
	<%} %>
</c:forEach>
<script src="${pageContext.request.contextPath}/staticfile/js/jquery-3.2.1.js"></script>
<script src="${pageContext.request.contextPath}/staticfile/js/bootstrap.js"></script>
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