<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title> 
	<link rel="stylesheet" href="/css/bootstrap.css">
	<script src="/js/jquery-3.2.1.js"></script>
	<script src="/js/bootstrap.js"></script>
<style>
	body{
		background-color: #f8f9fa;
	}
	.invalid-feedback{
		display:none;
		width:100%;
		margin-top:.25rem;
		font-size:80%;
		color:#dc3545;
	}
</style>
</head>
<body>
<%@include file="../common/headerindex.jspf"%>
<div class="container">
<form class="form-horizontal"  action="/EngineerHub/index/insertApply.action" method="post">
	   <div class="form-group" style="margin-top: 30px">
         <label for="candidateName" class="col-sm-2 control-label">用户名</label>
         <div class=" col-sm-10">
           <input type="text" class="form-control" id="candidateName" placeholder="用户名" name="candidateName" required="required">
           <div class="invalid-feedback" style="width: 100%;">
             Your username is required.
           </div>
         </div>
       </div>

	  <div class="form-group">
		   <label  class="col-sm-2 control-label">性别:</label>
		   <div class="col-sm-10">
		  	   	<label class="radio-inline">
				<input type="radio" name="candidateSex" id="inlineRadio1" value="1"> 男
				</label>
				<label class="radio-inline">
				  <input type="radio" name="candidateSex" id="inlineRadio2" value="2"> 女
				</label>
		   </div> 
	  </div>
	  
	  <div class="form-group">
	    <label for="candidateTel" class="col-sm-2 control-label">电话:</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="candidateTel" placeholder="请输入电话" name="candidateTel" required="required">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="candidateEmail" class="col-sm-2 control-label">邮箱:</label>
	    <div class="col-sm-10">
	      <input type="email" class="form-control" id="candidateEmail" placeholder="请输入邮箱" name="candidateEmail" required="required">
	    </div>
	  </div>
          <div class="form-group">
            <label for="institute" class="col-sm-2 col-md-2 col-xs-2 col-lg-2 control-label">院系</label>
			  <div class="col-sm-10 col-lg-10 col-xs-10 col-md-10">
				  <select class="form-control" id="institute" required="required" name="instId" onchange="getmajor()">
					  <option value="-1" id="-1">请选择院系</option>
					  <c:forEach items="${institutes}" var="item">
						  <option value="${item.instId}" id="${item.instId}">${item.instName}</option>
					  </c:forEach>
				  </select>
				  <div class="invalid-feedback">
					  Please select a valid country.
				  </div>
			  </div>
          </div>

          <div class="form-group">
            <label for="engineerMajor" class="col-sm-2 col-md-2 col-xs-2 col-lg-2 control-label">专业</label>
			  <div class="col-sm-10 col-lg-10 col-xs-10 col-md-10">
				  <select class="form-control " id="engineerMajor" required="required" name="majorId">
					  <option id="-2">请选择专业</option>
				  </select>
				  <div class="invalid-feedback">
					  Please provide a valid state.
				  </div>
			  </div>
          </div>
	  <div class="form-group">
	    <label for="candidateIntroduce" class="col-sm-2 control-label">自我介绍:</label>
	    <div class="col-sm-10">
	      <textarea class="form-control" id="candidateIntroduce" name="candidateIntroduce" placeholder="自我介绍" rows="3"></textarea>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="candidateFame" class="col-sm-2 control-label">所获荣誉介绍:</label>
	    <div class="col-sm-10">
	      <textarea class="form-control" id="candidateFame" name="candidateFame" placeholder="所获荣誉介绍" rows="3"></textarea>
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <button type="submit" class="btn btn-primary">提交</button><span>${flag}</span>
	    </div>
	  </div>
   </form>
</div>
<!-- 获取自定义的js文件 -->
<script type="text/javascript" src="/js/getmajor.js"></script>
</body>
</html>