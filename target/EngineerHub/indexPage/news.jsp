<%--
  Created by IntelliJ IDEA.
  User: sofency
  Date: 2020/4/1
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>最新消息</title>
    <link rel="stylesheet" href="/EngineerHub/staticfile/css/bootstrap.css">
    <link rel="stylesheet" href="/EngineerHub/staticfile/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="/EngineerHub/staticfile/css/style.css">
    <style>
        .news{
            margin-top: 20px;
            border-left: 1px solid;
            padding-left: 13px;
        }
        .news li{
            margin-bottom: 30px;
            position: relative;
        }
        .news li .panel{
            border: 1px solid;
            border-radius: 10px;
            padding: 10px;
        }
        .news li .panel .header{
            position: absolute;
            margin-left: 20px;
            margin-top: -25px;
            background: white;
            padding: 0px 10px;
        }
        .news li .view{
            margin-top: 9px;
        }
        .panel .panel-body{
            display: -webkit-box;
            -webkit-box-orient: vertical;
            -webkit-line-clamp: 3;
            overflow: hidden;
            text-indent: 2em;
            font-size: 12px;
            argin-top: 5px;
            letter-spacing: 1px
        }
        .panel a{
            color: red;
            cursor: pointer;
        }
    </style>
</head>
<body>
<%@include file="../common/headerindex.jspf"%>
<div class="container" style="z-index: 999">
    <ul class="news">
        <c:forEach items="${messages}" var="message">
        <li >
            <div class="panel panel-default">
                <a href="/EngineerHub/index/messageDetail/${message.msgId}"><span class="header" title="查看详情">${message.msgHeader}</span></a>
                <p class="panel-body" >
                    ${message.msgContent}
                </p>
                <div class="view" style="font-size: 10px;color: #c0c0c0">
                    浏览人数<span class="viewCount" style="margin-right: 10px">&nbsp;${message.msgVisited}</span>
                    发布时间<span>&nbsp;${message.msgTime}</span>
                </div>
            </div>
        </li>
        </c:forEach>
    </ul>
</div>
<div class="demo" style="margin-left: 124px;z-index: -100">
    <div class="butterfly" >
        <div class="wing">
            <div class="bit"></div>
            <div class="bit"></div>
        </div>
        <div class="wing">
            <div class="bit"></div>
            <div class="bit"></div>
        </div>
    </div>
    <div class="shadow"></div>
</div>
<script src="/EngineerHub/staticfile/js/jquery-3.2.1.js"></script>
<script src="/EngineerHub/staticfile/js/bootstrap.js"></script>
<script src="/EngineerHub/staticfile/js/dot.js"></script>
</body>
</html>
