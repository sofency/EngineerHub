<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/staticfile/css/bootstrap.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/staticfile/css/manager.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/staticfile/font-awesome-4.7.0/css/font-awesome.min.css">
</head>
<body>
<div style="height:100%;height:100%; background-color: #f1f2f6">
	<%@include file="../common/header.jspf"%>
	<div style="display:flex;flex-direction: row;width:100%;height:90%">
		<div class="col-md-2 nav-main">
			<ul class="text-center">
	    		<li>
	    			<a href="http://localhost:9999/EngineerHub/back/getCandidates.action?page=1&&status=0" class="anniu">
	    				<i class="fa fa-bell" aria-hidden="true" style="font-size: 1em;margin-right: 10px;"></i>
	    				<span>未处理</span>
	    			</a>
	    		</li>
	    		<li>
	    			<a href="http://localhost:9999/EngineerHub/back/getCandidates.action?page=1&&status=1" class="anniu">
	    				<i class="fa fa-check" aria-hidden="true"  style="font-size: 1em;margin-right: 10px;"></i>
	    				<span>已通过</span>
	    			</a>
	    		</li>
	    		<li>
	    			<a href="http://localhost:9999/EngineerHub/back/getCandidates.action?page=1&&status=-1" class="anniu">
	    				<i class="fa fa-times" aria-hidden="true" style="font-size: 1em;margin-right: 10px;"></i>
	    				<span>已淘汰</span>
	    			</a>
	    		</li>
	    	</ul>
		</div>
		<div  class="col-md-9" style="flex-grow: 0.8; margin-top:10px;margin-left:10px;border-radius: 10px;height:70%;background-color: #ffffff;padding:10px;">
			 <div class="panel panel-primary" style="height:100%">
			     <div class="panel-heading">未处理</div>
			     <div class="panel-body"  style="height:100%">
					  <table class="table table-bordered text-center" style="height: 80%">
			            <thead>
				             <tr>
				                 <th class="text-center">申请号</th>
				                 <th class="text-center">姓名</th>
				                 <th class="text-center">性别</th>
				                 <th class="text-center">电话号码</th>
				                 <th class="text-center">邮箱</th>
				                 <th class="text-center">操作</th>
				             </tr>
			            </thead>
			            <tbody id="tablesManage">
			           		<c:forEach items="${Candidate}" var="item">
								<tr>
								    <td>${item.candidateId}</td>
									<td>${item.candidateName}</td>
									<td>${item.candidateSex}</td>
									<td>${item.candidateTel}</td>
									<td>${item.candidateEmail}</td>
									<td><a class="btn btn-primary" href="javascript:void(0)" onclick="getDetails(${item.candidateId})">查看详情</a></td>
								</tr>
						    </c:forEach>
						 </tbody>
				   	  </table>
				   	 <p class="text-center">共${page.pages}页</p>
			         <div class="pull-right">
			            <nav aria-label="Page navigation">
			                <ul class="pagination">
			                    <li class="page-item">
			                        <a class="page-link" href="http://localhost:9999/EngineerHub/back/getCandidates.action?page=${page.prePage}&&status=0"  id="prev" aria-label="Previous">
			                            <span aria-hidden="true">&laquo;</span>
			                        </a>
			                    </li>
			                   <li class="page-item"><a class="page-link" href="javascript:void(0)">${page.prePage+1}</a></li>
			                    <li class="page-item">
			                        <a class="page-link" href="http://localhost:9999/EngineerHub/back/getCandidates.action?page=${page.nextPage}&&status=0" id="next" aria-label="Next">
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
    <!-- 模态框的显示 -->
<div class="modal fade" id="myModalDetail" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4 class="modal-title" id="myModalLabel">详细信息</h4>
	            </div>
	            <div class="modal-body">
	            	<form class="form-horizontal" role="form">
	            	      <input type="hidden" value="" id="candidateId">
						  <div class="form-group">
						    <label class="col-sm-2 control-label">姓名</label>
						    <div class="col-sm-10">
						      <p class="form-control-static" id="username"></p>
						    </div>
						  </div>
						  <div class="form-group">
						    <label class="col-sm-2 control-label">性别</label>
						    <div class="col-sm-10">
						     <p class="form-control-static" id="sex"></p>
						    </div>
						  </div>
						  <div class="form-group">
						    <label  class="col-sm-2 control-label">学院</label>
						    <div class="col-sm-10">
						         <p class="form-control-static" id="instname"></p>
						    </div>
						  </div>
						  <div class="form-group">
						    <label  class="col-sm-2 control-label">专业</label>
						    <div class="col-sm-10">
						         <p class="form-control-static" id="majorname"></p>
						    </div>
						  </div>
						  <div class="form-group">
						    <label  class="col-sm-2 control-label">联系方式</label>
						    <div class="col-sm-10">
						         <p class="form-control-static" id="telephone"></p>
						    </div>
						  </div>
						   <div class="form-group">
						    <label  class="col-sm-2 control-label">邮箱</label>
						    <div class="col-sm-10">
						         <p class="form-control-static" id="email"></p>
						    </div>
						  </div>
						  <div class="form-group">
						    <label  class="col-sm-2 control-label">所获荣誉</label>
						    <div class="col-sm-10">
						     <p class="form-control-static" id="fames"></p>
						    </div>
						  </div>
						  <div class="form-group">
						    <label  class="col-sm-2 control-label">自我介绍</label>
						    <div class="col-sm-10">
						       <p class="form-control-static" id="introduce"></p>
						    </div>
						  </div>
					</form>     	
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-default" onclick="deal(-1)">淘汰</button>
	                <button type="button" class="btn btn-primary" onclick="deal(1)">通过</button>
	            </div>
	        </div>
	    </div>
	</div>
</div>
<script src="${pageContext.request.contextPath}/staticfile/js/jquery-3.2.1.js"></script>
<script src="${pageContext.request.contextPath}/staticfile/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/staticfile/js/application.js"></script>
<script type="text/javascript">
function deal(num){
	console.log(num)
	//发送该申请人的id 状态为淘汰
	var candidateId = $("#candidateId").val();
	console.log(candidateId);
	$.ajax({
		url:"http://localhost:9999/EngineerHub/back/candidate/"+candidateId+"/"+num,
	    type:"post",
		async:true,
		success:function(data){
			console.log(data)
		}
	})
	$("#myModalDetail").modal('hide')
}
</script>
</body>
</html>