<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>工作室简介</title>
<%--    <link rel="stylesheet" href="/EngineerHub/staticfile/css/bootstrap.min.css">--%>
    <link rel="stylesheet" href="/EngineerHub/staticfile/css/bootstrap.css">

    <link rel="stylesheet" href="/EngineerHub/staticfile/css/index.css">
    <link rel="stylesheet" href="/EngineerHub/staticfile/css/style1.css">
    <link rel="stylesheet" href="/EngineerHub/staticfile/font-awesome-4.7.0/css/font-awesome.min.css">
    <script src="/EngineerHub/staticfile/js/jquery-3.2.1.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        .jumbotron{
            background-color: transparent;
        }
    </style>
</head>
<body>
<%@include file="../common/headerindex.jspf"%>
<div role="main">
  <div id="myCarousel" class="carousel slide" data-ride="carousel" style="margin-bottom: 10px;">
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img width="100%" height="100%" src="/EngineerHub/staticfile/img/room3.jpg"/>
        <div class="carousel-caption">
            <div class="jumbotron">
                <h1>我没时间加班</h1>
                <p>的确，晚上和周末我们都要工作，哪还有时间加班呢?</p>
                <p><a class="btn btn-lg btn-primary" href="#" role="button">Sign up today</a></p>
            </div>
        </div>
      </div>
      <div class="item">
		<img width="100%" height="100%" src="/EngineerHub/staticfile/img/room4.jpg"/>
		<div class="carousel-caption">
            <div class="jumbotron">
                <h1>开发名言警句</h1>
                <p>征服畏惧、建立自信的最快最确实的方法，就是去做你害怕的事，直到你获得成功的经验</p>
                <p><a class="btn btn-lg btn-primary" href="#" role="button">Learn more</a></p>
            </div>
        </div>
      </div>
      <div class="item">
		<img width="100%" height="100%" src="/EngineerHub/staticfile/img/room5.jpg"/>
        <div class="carousel-caption">
            <div class="jumbotron">
                <h1>新人啊，快点来吧。</h1>
                <p>我们对新人的渴求如引强烈，是因为我们无知地以为增加人手会降低我们的劳动强度。 </p>
                <p><a class="btn btn-lg btn-primary" href="#" role="button">Browse gallery</a></p>
            </div>
        </div>
      </div>
    </div>
    <a class="left carousel-control" href="#myCarousel"  data-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel"  data-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>

  <div class="container marketing">
  	<h3 class="text-center" style="margin-bottom: 20px;">镇站大佬</h3>
  	<hr>
    <div class="row">
        <c:forEach items="${engineersGod}" var="engineer">

            <div class="single-member effect-3">
                <div class="member-image">
                    <img src="${engineer.engineerImgPath}" alt="Member">
                </div>
                <div class="member-info">
                    <h3>${engineer.engineerName}</h3>
                    <h5>
                        <span>${engineer.instName}</span>
                        <span>${engineer.majorName}</span>
                    </h5>
                    <p>${engineer.engineerMotto}.</p>
                    <div class="social-touch">
                        <a href="${engineer.engineerEmail}" title="email"><i class="fa fa-envelope-o" aria-hidden="true" style="font-size: 1.5em;color: white"></i></a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <!-- START THE FEATURETTES -->
    <hr class="featurette-divider">

    <div class="row featurette">
      <div class="col-md-7">
        <h2 class="featurette-heading">JAVA后端技术如何修炼</h2>
        <p class="lead">后端主要是用来处理前端业务的请求，并且做出响应的一种技术栈。后端考验一个程序员的内在功力吗，不是简单的crud那么简单，而且随着技术的革新，要学习的动力越来越多。那么我们到底要学哪些知识哪。<a href="${pageContext.request.contextPath}/indexPage/learn.jsp">学习规划链接</a></p>
      </div>
      <div class="col-md-5">
        <img class="bd-placeholder-img bd-placeholder-img-lg featurette-image img-fluid mx-auto rounded-circle" src="${pageContext.request.contextPath}/staticfile/img/java.jpg"" width="500" height="500" />
      </div>
    </div>

    <hr class="featurette-divider">

    <div class="row featurette">
      <div class="col-md-7 order-md-2">
       <blockquote class="blockquote">
		  <h2 class="mb-0">python为何如此之火</h2>
		  <footer class="blockquote-footer">Write less Do More</footer>
		</blockquote>
        <p class="lead">听说爬虫很好玩是真的吗?<br/>听说python可以是一种很容易上手的语言是真的吗?<br/> 听说python的主流框架Django让开发网站变得非常简单是真的吗?<br/><a href="${pageContext.request.contextPath}/indexPage/learn.jsp">点击链接了解学习内容</a></p>
      </div>
      <div class="col-md-5 order-md-1">
        <img class="bd-placeholder-img bd-placeholder-img-lg featurette-image img-fluid mx-auto rounded-circle" src="${pageContext.request.contextPath}/staticfile/img/python.jpg"" width="500" height="500" />
      </div>
    </div>
    <hr class="featurette-divider">
  </div>
</div>
<!-- FOOTER -->
<div class="container clearfix" style="background-color: #f5f6f5">
      <div style=" margin-left: 300px; float: left; margin-top: 20px; border-right:1px solid white; padding-right: 40px">
          <p style="color: black">版权所有：斜杠青年工作室</p>
          <p style="color: black">地址：西安工程大学7号教学楼224B</p>
      </div>
      <div style="margin-left: 40px; float: left; margin-top: 20px">
          <p style="color: black">联系方式：18892069575</p>
          <p style="color: black">邮箱：1432085874@qq.com</p>
      </div>
</div>
<script src="/EngineerHub/staticfile/js/jquery-3.2.1.js"></script>
<script src="/EngineerHub/staticfile/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
  function showshadow(obj){
	  $(obj).children("div.shadow").slideDown(100,"linear");
  }
  function hiddenshadow(obj){
	  $(obj).children("div.shadow").slideUp(100,"linear");
  }
</script>
</body>
</html>