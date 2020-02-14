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
</head>
<body>
 <div style="height:100%;height:100%; background-color: #f1f2f6">
	<%@include file="../common/header.jspf"%>
	<div style="display:flex;flex-direction: row;width:100%;height:90%">
		<div class="col-md-2 nav-main">
			<ul class="text-center">
	    		<li style="border:1px solid red;"><a href="http://localhost:9999/EngineerHub/back/getCandidates.action?page=1&&status=0"><span>查看往期荣誉</span></a></li>
	    		<li style="border:1px solid red;"><a href="http://localhost:9999/EngineerHub/back/getCandidates.action?page=1&&status=1"><span>荣誉修改</span></a></li>
	    	</ul>
		</div>
		<div  class="col-md-9" style="flex-grow: 0.8; margin-top:10px;margin-left:10px;border-radius: 10px;height:70%;background-color: #ffffff;padding-top:10px;">
			<div class="panel panel-primary">
			     <div class="panel-heading">荣誉管理</div>
			     <div class="panel-body">
			         <div class="row my-table-toolbar" style="margin-bottom: 10px;">
			             <div class="col-xs-4">
			                 <div class="input-group">
			                     <input type="text" class="form-control" placeholder="Search for...">
			                     <span class="input-group-btn">
			                         <button class="btn btn-default" type="button">搜索</button>
			                     </span>
			                 </div>
			             </div>
			             <div class="col-xs-2 pull-right">
			                 <button class="btn btn-success pull-right" data-toggle="modal" data-target="#famedemo">添加</button>
			             </div>
			         </div>
			         <table class="table table-hover table-bordered text-center">
			             <thead>
			             <tr>
			                 <th class="text-center">荣誉编号</th>
			                 <th class="text-center">姓名</th>
			                 <th class="text-center">荣誉名称</th>
			                 <th class="text-center">荣誉等级</th>
			                 <th class="text-center">操作</th>
			             </tr>
			             </thead>
			             <tbody>
			             	<c:forEach items="${famesCustom}" var="item">
			             		<tr>
					                 <th scope="row" class="text-center">${item.fameId}</th>
					                 <td>${item.engineerName}</td>
					                 <td>${item.fameName}</td>
					                 <td>${item.fameLevel}</td>
					                 <td>
					                     <button class="btn btn-primary"><span class="glyphicon">编辑</span></button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					                     <button class="btn btn-danger"><span class="glyphicon"></span>删除</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					                     <button class="btn btn-info"><span class="glyphicon"></span>详细信息</button>
					                 </td>
			            		 </tr>
			             	</c:forEach>
			             </tbody>
			         </table>
			         <div class="pull-right">
			             <nav aria-label="Page navigation">
			                 <ul class="pagination">
			                     <li>
			                         <a href="#" aria-label="Previous">
			                             <span aria-hidden="true">&laquo;</span>
			                         </a>
			                     </li>
			                     <li><a href="#">1</a></li>
			                     <li><a href="#">2</a></li>
			                     <li><a href="#">3</a></li>
			                     <li><a href="#">4</a></li>
			                     <li><a href="#">5</a></li>
			                     <li>
			                         <a href="#" aria-label="Next">
			                             <span aria-hidden="true">&raquo;</span>
			                         </a>
			                     </li>
			                 </ul>
			             </nav>
			         </div>
			     </div>
			 </div>
		</div>
	</div>
 <!-- 荣誉管理的模态框 -->
<div id="famedemo" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">添加荣誉</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="famer_id" class="col-sm-2 control-label">荣誉编号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="famer_id" placeholder="荣誉编号">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="enjinner_name" class="col-sm-2 control-label">姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="enjinner_name" placeholder="姓名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="famer_name" class="col-sm-2 control-label">荣誉名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="famer_name" placeholder="荣誉名称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="famer_level" class="col-sm-2 control-label">荣誉等级</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="famer_level" placeholder="荣誉等级">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary">保存</button>
            </div>
        </div>
    </div>
</div>
</div>
<script src="${pageContext.request.contextPath}/staticfile/js/jquery-3.2.1.js"></script>
<script src="${pageContext.request.contextPath}/staticfile/js/bootstrap.js"></script>
</body>
</html>