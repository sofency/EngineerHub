<%--
  Created by IntelliJ IDEA.
  User: sofency
  Date: 2020/4/2
  Time: 8:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>消息详情</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/font-awesome.min.css">
    <link rel="stylesheet" href="/css/editormd.preview.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="/js/editormd.js"></script>
    <script src="/js/lib/marked.min.js"></script>
    <script src="/js/lib/prettify.min.js"></script>
    <style>
        .container{
            text-align: center;
        }
        .container .message-body{
            margin-top: 20px;
        }
    </style>
</head>
<body>
<%@include file="../common/headerindex.jspf"%>
<div class="container">
    <h3>${messageDetail.msgHeader}</h3>
    <div class="view" style="font-size: 10px;color: #c0c0c0">
        浏览人数<span class="viewCount" style="margin-right: 10px">&nbsp;${messageDetail.msgVisited}</span>
        发布时间<span>&nbsp;${messageDetail.msgTime}</span>
    </div>
    <div id="test-markdown-view" class="message-body">
        <textarea style="display: none;">${messageDetail.msgContent}</textarea>
    </div>
    <script type="text/javascript">
        $(function () {
            const testView =editormd.markdownToHTML("test-markdown-view",{})
        })
    </script>
</div>

</body>
</html>
