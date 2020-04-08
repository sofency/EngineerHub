<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>工作室简介</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/index.css">
    <script src="/js/jquery-3.2.1.js"></script>
</head>
<body>
<%@include file="common/headerindex.jspf"%>
<div class="container">
        <c:choose>
            <c:when test="${flag== 0 }">
                ${message}<br/>
                <span class="swapToIndex"></span> 秒后跳转到<a href="/EngineerHub/index/toIndex">首页</a>
                <script>
                    $(function () {
                        var time = 5;
                        var timer= setInterval(function () {
                            $(".swapToIndex")[0].innerText=time;
                            time=time-1;
                        },1000);
                        setTimeout(function () {
                            clearInterval(timer)
                            window.location.href="/EngineerHub/index/toIndex"
                        },5000)
                    })
                </script>
            </c:when>
            <c:otherwise>
                <span>访问异常了</span>
            </c:otherwise>
        </c:choose>


</div>
</body>
</html>