<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/staticfile/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/staticfile/font-awesome-4.7.0/css/font-awesome.min.css">
</head>
<body>
<%@include file="../common/headerindex.jspf"%>
<div class="container">
	<div class="row text-center mb-1">
	   	<h1 class="col-md-12" style="color:#99DAF3;">OUR TEAM</h1>
	   	<p class="text-muted col-md-12">程序员，年二十有三，头秃，始从文，连考而不中。遂习武，练武场上发一矢，中鼓吏，逐之出。<br>改学IT，自撰一函数，用之，堆栈溢出</p>
	</div>
	
	<c:forEach items="${EngineerSomeInfo}" var="item">
		<div style="height:270px;display:flex;flex-direction: row;width:100%;background-color: rgb(247,248,250);margin-bottom: 20px">
			<div style="margin-left:0;width:270px;">
		      <img height="270" src="${item.engineerImgPath }" class="card-img" alt="暂无图片">
		    </div>
		    <div  style="flex-grow: 1">
		      <div class="card-body">
		      	<div class="row">
			        <blockquote class="blockquote col-md-8">
					  <h4 class="mb-0">${item.engineerName}</h4>
					  <footer style="font-size: 18px">${item.majorName}</footer>
					</blockquote>
					<div class="col-md-4">
						<div class="pull-right">
							<a href="${item.engineerGit}" title="github"><i class="fa fa-github" aria-hidden="true" style="font-size: 1.5em;margin-right: 10px;color:gray;"></i></a>
							<a href="${item.engineerEmail}" title="email"><i class="fa fa-envelope-o" aria-hidden="true" style="font-size: 1.5em;color:gray;"></i></a>
						</div>
					</div>
				</div>
				<hr/>
				<div class="row">
					 <p class="card-text col-md-12">${item.engineerMotto}</p>
				</div>
		      </div>
		    </div>
		</div>
	</c:forEach>
</div>
<script src="${pageContext.request.contextPath}/staticfile/js/jquery-3.2.1.js"></script>
<script src="${pageContext.request.contextPath}/staticfile/js/bootstrap.js"></script>
</body>
</html>