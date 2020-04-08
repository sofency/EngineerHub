<%--
  Created by IntelliJ IDEA.
  User: sofency
  Date: 2020/4/1
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/manager.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.js"></script>
    <link rel="stylesheet" href="/css/font-awesome.min.css">
    <link rel="stylesheet" href="/css/editormd.css" />
    <script src="/js/editormd.js"></script>
</head>
<body>
<div style="height:100%;height:100%; background-color: #f1f2f6">
    <%@include file="../common/header.jspf"%>
    <div class="container col-lg-11" >
            <div class="col-md-3 nav-main" style="background-color: transparent">
                <ul class="text-center">
                    <li>
                        <a href="/EngineerHub/message" class="anniu">
                            <i class="fa fa-bell" aria-hidden="true" style="font-size: 1em;margin-right: 10px;"></i>
                            <span>我要发布</span>
                        </a>
                    </li>
                    <li>
                        <a href="/EngineerHub/messages" class="anniu">
                            <i class="fa fa-check" aria-hidden="true"  style="font-size: 1em;margin-right: 10px;"></i>
                            <span>我的发布</span>
                        </a>
                    </li>
                </ul>
            </div>
        <form class="form-horizontal col-md-9"  id="form" action="/EngineerHub/sendMsg" method="post" onsubmit="return checkContent()">
            <div class="form-group">
                <label for="msgHeader" class="control-label" >标题</label><br>
                <div class="col-sm-10"   style=" padding-left: 0;margin-top: 20px;">
                    <input type="text" class="form-control" id="msgHeader" placeholder="Email" name="msgHeader">
                </div>
            </div>
            <div class="form-group">
                <label for="content" class="ccontrol-label" style="margin-bottom: 10px">内容</label>
                <div id="test-editor"  class="col-sm-10" >
                    <textarea  id="content" name="msgContent" style="display:none;"></textarea>
                </div>
            </div>
            <div class="form-group">
                <div class=" col-sm-10"  style=" padding-left: 0;margin-top: 20px">
                    <button type="submit" class="btn btn-default">发布</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript">
    $(function() {
        const editor = editormd("test-editor", {
            width  : "100%",
            height : "400px",
            path   : "/js/lib/",
            delay  : 0,
            saveHTMLToTextarea: true,
            imageUpload : true,
            imageFormats : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
            imageUploadURL : "/upload",
            saveHTMLToTextarea : true
        });
        $("#form").ajaxForm(function (data) {//接收form表单的返回值
            console.log(data);
        })
    });
    function checkContent(){
        const  length = $("#msgHeader").val().length;
        if(length<6){
            alert("请输入详细的描述再进行提交")
            return false;
        }else{
            return true;
        }
    }
</script>
</body>
</html>
