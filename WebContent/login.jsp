<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="sofency">
    <meta name="generator" content="Jekyll v3.8.6">
    <title>后台 登录</title>
<%  
   String path = request.getContextPath();  
   String basePath = request.getScheme() + "://"  
           + request.getServerName() + ":" + request.getServerPort()  
           + path;  
%>  

    <!-- Bootstrap core CSS -->
	<link rel="stylesheet" href="<%=basePath%>/staticfile/css/bootstrap.min.css">
	<meta name="theme-color" content="#563d7c">
    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="<%=basePath%>/staticfile/css/signin.css" rel="stylesheet">
  </head>
  <body class="text-center">
	    <form class="form-signin" action="<%=basePath %>/login.action" method="post">
		  <img class="mb-4" src="<%=basePath%>/staticfile/img/font.png" alt="" width="72" height="72">
		  <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
		  <label for="username" class="sr-only">用户名</label>
		  <input type="text"  class="form-control" placeholder="Username" required autofocus name="username">
		  <label for="inputPassword" class="sr-only">Password</label>
		  <input type="password" class="form-control" placeholder="Password" required  name="userpwd">
		  <div class="checkbox mb-3">
		    <label>
		      <input type="checkbox" value="1" name="remember" checked="checked"> Remember me
		    </label>
		  </div>
		  <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
		  <span>${flag}</span>
		  <p class="mt-5 mb-3 text-muted">&copy; 2017-2020</p>
		</form>
   </body>
</html>