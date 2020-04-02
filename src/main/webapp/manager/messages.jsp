<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/staticfile/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/staticfile/css/manager.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/staticfile/font-awesome-4.7.0/css/font-awesome.min.css">
    <style>
        blockquote{
            background-color: #dfe6e9;
            border-radius: 10px;
        }
    </style>
</head>
<body>
<div style="height:100%;height:100%; background-color: #f1f2f6">
    <%@include file="../common/header.jspf"%>
    <div class="container col-lg-11" >
        <div class="col-md-3 nav-main" style="background-color: transparent">
            <ul class="text-center">
                <li>
                    <a href="http://localhost:9999/EngineerHub/message" class="anniu">
                        <i class="fa fa-bell" aria-hidden="true" style="font-size: 1em;margin-right: 10px;"></i>
                        <span>我要发布</span>
                    </a>
                </li>
                <li>
                    <a href="http://localhost:9999/EngineerHub/messages" class="anniu">
                        <i class="fa fa-check" aria-hidden="true"  style="font-size: 1em;margin-right: 10px;"></i>
                        <span>我的发布</span>
                    </a>
                </li>
            </ul>
        </div>
        <div class="col-md-9">
            <c:choose>
                <c:when test="${msg != null }">
                    <blockquote style="position: relative;">
                        <p>暂无消息</p>
                    </blockquote>
                </c:when>
                <c:otherwise>
                    <ul>
                        <c:forEach items="${messages}" var="message">
                            <li onmouseover="show(this)" onmouseout="hide(this)">
                                <blockquote style="position: relative;">
                                    <p>${message.msgHeader}</p>
                                    <footer>发布于 <cite title="Source Title">${message.msgTime}</cite></footer>
                                    <button style="display: none; position: absolute;top: 8px;right: 11px;" onclick="deleteInfo(${message.msgId})" class="close" title="删除">X</button>
                                </blockquote>
                            </li>
                        </c:forEach>
                    </ul>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
    <script>
        function show(obj) {
            $(obj).children().children(".close").css("display","block")
        }
        function hide(obj) {
            $(obj).children().children(".close").css("display","none")
        }
        function deleteInfo(msgId) {
            $.ajax({
                url:"http://localhost:9999/EngineerHub/deleteMsg",
                type:'get',
                data:{
                    "msgId":msgId
                },
                success:function (data) {
                    if(data=="true"){
                        alert("删除成功");
                        window.location.reload();
                    }else{
                        alert("删除失败");
                    }
                }
            })
        }
    </script>
</div>