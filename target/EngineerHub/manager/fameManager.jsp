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
	<link rel="stylesheet" href="/css/font-awesome.min.css">
	<style type="text/css">
		.form-group label{
			text-indent: 3px;
			text-align: left !important;
			margin-bottom: 10px !important;
		}
	</style>
</head>
<body>
 <div style="height:100%;height:100%; background-color: #f1f2f6">
	<%@include file="../common/header.jspf"%>
    <div class="row">
	<div class="col-md-8 col-md-offset-2" style="flex-grow: 0.8; margin-top:10px;border-radius: 10px;height:60%;background-color: #ffffff;padding:10px;">
			<div class="panel panel-primary" style="height: 100%;">
			     <div class="panel-heading">荣誉管理</div>
			     <div class="panel-body" style="height: 100%;">
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
			                 <button class="btn btn-success pull-right" data-toggle="modal" data-target="#fameDemo" id="addInfo">添加</button>
			             </div>
			         </div>
			         <table class="table table-hover table-bordered text-center">
			             <thead>
			             <tr>
			                 <th class="text-center">姓名</th>
			                 <th class="text-center">荣誉名称</th>
			                 <th class="text-center">荣誉等级</th>
			                 <th class="text-center">获取时间</th>
			                 <th class="text-center">操作</th>
			             </tr>
			             </thead>
			             <tbody>
			             	<c:forEach items="${fameCustom}" var="item">
			             		<tr>
					                 <td>${item.engineerName}</td>
					                 <td>${item.fameName}</td>
					                 <td>${item.fameLevel}</td>
									 <td>${item.getTime}</td>
					                 <td>
					                     <button class="btn btn-primary" onclick="showInfo(${item.fameId},${item.engineerId})"  data-toggle="modal" data-target="#fameDemo"><span class="glyphicon">查看详情</span></button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					                 </td>
			            		 </tr>
			             	</c:forEach>
			             </tbody>
			         </table>
			         <p class="text-center">共${pages.pages}页</p>
			          <div class="pull-right">
			            <nav aria-label="Page navigation">
			                <ul class="pagination">
			                    <li class="page-item">
			                        <a class="page-link" href="/EngineerHub/back/fame/${pages.prePage}"  id="prev" aria-label="Previous">
			                            <span aria-hidden="true">&laquo;</span>
			                        </a>
			                    </li>
			                   <li class="page-item"><a class="page-link" href="javascript:void(0)">${pages.prePage+1}</a></li>
			                    <li class="page-item">
			                        <a class="page-link" href="/EngineerHub/back/fame/${pages.nextPage}" id="next" aria-label="Next">
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
<div id="fameDemo" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">添加荣誉</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="fame" action="/EngineerHub/back/insertFame" method="post">
					<input type="hidden" name="fameId" id="fameId" >
                    <div class="form-group">
                        <label for="fame_name" class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label ">荣誉名称</label>
                        <div class="col-lg-9 col-md-9 col-sm-12 col-xs-12">
                            <input type="text" class="form-control" id="fame_name" name="fameName" placeholder="荣誉名称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="fame_level" class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label ">荣誉等级</label>
                        <div class="col-lg-9 col-md-9 col-sm-12 col-xs-12">
                            <input type="text" class="form-control" id="fame_level" name="fameLevel" placeholder="荣誉等级">
                        </div>
                    </div>
					<div class="form-group">
						<label for="fame_description" class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label ">荣誉描述</label>
						<div class="col-lg-9 col-md-9 col-sm-12 col-xs-12">
							<textarea type="text" class="form-control" id="fame_description" name="fameDescription" placeholder="荣誉描述" rows="3"></textarea>
						</div>
					</div>
					<div class="form-group">
						<label for="fame_get_time" class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label ">荣誉获取时间</label>
						<div class="col-lg-9 col-md-9 col-sm-12 col-xs-12">
							<input type="date" class="form-control" id="fame_get_time" name="getTime" placeholder="荣誉获取时间">
						</div>
					</div>
					<div class="form-group">
						<label for="engineer_id" class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">获取者编号</label>
						<div class="col-lg-9 col-md-9 col-sm-12 col-xs-12">
							<input type="text" class="form-control" id="engineer_id" name="engineerId" placeholder="获取者编号">
						</div>
					</div>
					<div class="form-group">
						<label for="engineerName" class="col-lg-3 col-md-3 col-sm-12 col-xs-12 control-label">获取者姓名</label>
						<div class="col-lg-9 col-md-9 col-sm-12 col-xs-12">
							<input type="text" class="form-control" id="engineerName" name="engineerName" placeholder="获取者姓名">
						</div>
					</div>
					<div class="modal-footer">
						<input type="reset" class="btn btn-default">
						<input type="submit"  id="submitFame" class="btn btn-primary" value="添加">
					</div>
                </form>
            </div>
        </div>
    </div>
</div>
</div>
 <script src="/js/jquery-3.2.1.js"></script>
 <script src="/js/bootstrap.js"></script>
 <script src="/js/jquery-form.js"></script>

 <script type="application/javascript">
	 $(function () {
		 $("#fame").ajaxForm(function (data) {
			 console.log(data);
			 if(data=="true") {
				 setTimeout(function () {
					 $(".close").click();
				 }, 2000)
			 }else{
			 	alert("添加失败");
			 }
		 })
	 });
	 $("#addInfo").click(function () {
		 $(".modal-title").html("添加信息");
		 $("#fame").resetForm();//重置表单的数据
		 //显示提交的按钮
		 $(".form-group").eq(5).css("display","none");
		 $(".modal-footer").css("display","block");
		 //设置所有的input可以输入
		 $("#fame input[type='text'],textarea,input[type='date']").removeAttr("readonly");//删除只读标签
	 });
	 function showInfo(fameId,engineerId) {
	 	$(".modal-title").html("详细信息");
		$(".form-group").eq(5).css("display","block");
	 	$(".modal-footer").css("display","none");
		 $("#fame input[type='text'],textarea,input[type='date']").attr("readonly","readonly");//删除只读标签
		$.ajax({
			url:"/EngineerHub/back/getInfoById",
			type:'post',
			data:{
				"fameId":fameId,
				"engineerId":engineerId
			},
			success:function (data) {
				console.log(data);
				$("#fame_name").val(data.fameName);
				$("#fame_level").val(data.fameLevel);
				$("#fame_description").val(data.fameDescription);
				$("#fame_get_time").val(data.getTime.substring(0,10));
				$("#engineer_id").val(data.engineerId);
				$("#fameId").val(data.fameId);//荣誉编号
				$("#engineerName").val(data.engineerName);
			}
		})
	 }
 </script>
</body>
</html>