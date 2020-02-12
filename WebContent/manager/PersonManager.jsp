<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/staticfile/css/bootstrap.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/staticfile/css/manager.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/staticfile/css/back.css">
</head>
<body>
	<!-- 公共头部 -->
	<%@include file="../common/header.jspf"%>
	<div style="display:flex;flex-direction: row;width:100%">
		<%@include file="../common/sidebar.jspf"%>
		<div style="width:200px;"></div>
		<div style="flex-grow: 0.8;">
			 <div class="panel panel-primary">
			     <div class="panel-heading">人员管理</div>
			     <div class="panel-body">
			         <div class="row my-table-toolbar" style="margin-bottom: 10px;">
			             <div class="col-xs-4">
			                 <div class="input-group">
			                     <input type="text" class="form-control" placeholder="Search for name" id="searchName" onchange="fullEngineerInfo()">
			                     <span class="input-group-btn"><a class="btn btn-default" href="javascript:void(0)" onclick="searchname()">搜索</a></span>
			                 </div><!-- /input-group -->
			             </div>
			             <div class="col-xs-2 pull-right">
			                 <button class="btn btn-success pull-right" data-toggle="modal" data-target="#chooseIndex">添加</button>
			             </div>
			         </div>
			         <table class="table table-striped table-bordered text-center">
			             <thead>
			             <tr>
			                 <th class="text-center">人员编号</th>
			                 <th class="text-center">姓名</th>
			                 <th class="text-center">性别</th>
			                 <th class="text-center">邮箱</th>
			                 <th class="text-center">操作</th>
			             </tr>
			             </thead>
			             <tbody id="personManage">
							<c:forEach items="${EngineerCustom}" var="item">
								<tr>
					                 <th scope="row" class="text-center">${item.engineerId}</th>
					                 <td>${item.engineerName}</td>
					                 <td>${item.engineerSex>1?"女":"男"}</td>
					                 <td>${item.engineerEmail}</td>
					                 <td>
					                     <button class="btn btn-primary"><span>编辑</span></button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					                     <button class="btn btn-danger">删除</button>
					                 </td>
					             </tr>
							</c:forEach>
			             </tbody>
			           </table>
			       <div class="pull-right">
			            <nav aria-label="Page navigation">
			                <ul class="pagination">
								<li>
							         <a id="prevPerson" href="javascript:void(0)" onclick="prevPersonPage(${currentPage-1},${pages})" aria-label="Previous">
			                            <span aria-hidden="true">&laquo;</span>
			                        </a>
			                    </li>
							      <li>
						            <a id="nextPerson" href="javascript:void(0)" onclick="nextPersonPage(${currentPage+1},${pages})" aria-label="Next">
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
 <!-- 人员管理的模态框 -->
<div id="chooseIndex" class="modal fade" tabindex="-1" role="dialog">
     <div class="modal-dialog" role="document">
         <div class="modal-content">
             <div class="modal-header">
                 <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                         aria-hidden="true">&times;</span>
                 </button>
                 <h4 class="modal-title">添加人员信息</h4>
             </div>
             <div class="modal-body">
                 <form id="engineerform" class="form-horizontal" action="${pageContext.request.contextPath}/back/insertEngineer.action" method="post" enctype="multipart/form-data">
                     <div class="form-group">
                         <label for="engineer_name" class="col-sm-2 control-label">姓名</label>
                         <div class="col-sm-10">
                             <input type="text" class="form-control" id="engineer_name" placeholder="姓名" name="engineerName">
                         </div>
                     </div>
                      <div class="form-group">
						   <label  class="col-sm-2 control-label">性别:</label>
						   <div class="col-sm-10">
						  	   	<label class="radio-inline">
								<input type="radio" name="candidateSex" id="inlineRadio1" value="1"> 男
								</label>
								<label class="radio-inline">
								  <input type="radio" name="candidateSex" id="inlineRadio2" value="2"> 女
								</label>
						   </div> 
					  </div>
                     <div class="form-group">
                         <label for="engineer_tel" class="col-sm-2 control-label">电话</label>
                         <div class="col-sm-10">
                             <input type="text" class="form-control" id="engineer_tel" placeholder="电话" name="engineerTel">
                         </div>
                     </div>
                     <div class="form-group">
                         <label for="engineer_email" class="col-sm-2 control-label">邮箱</label>
                         <div class="col-sm-10">
                             <input type="email" class="form-control" id="engineer_email" placeholder="邮箱" name="engineerEmail">
                         </div>
                     </div>
                    
                   <div class="form-group" >
			            <label for="institude" class="col-sm-2 control-label">院系</label>
			             <div class="col-sm-10">
					            <select class="form-control d-block w-100 col-sm-8" id="institude" required="required" name="instid" onchange="getmajor()">
					            	<option value="-1" id="-1">请选择院系</option>
					                <c:forEach items="${institudes}" var="item">
								    	  <option value="${item.instid}" id="${item.instid}">${item.instname}</option>
								    </c:forEach>
					            </select>
			              </div>
			        </div>
			         <div class="form-group" >
			            	<label for="candidateMajor" class="col-sm-2 control-label">专业</label>
			            	<div class="col-sm-10">
			            	 	<select class="form-control d-block w-100 col-sm-8" id="candidateMajor" required="required" name="majorid">
					              <option id="-2">请选择专业</option>
					            </select>
			            	</div>
			          </div>
			        <!-- - -->
                     <div class="form-group">
                         <label for="engineer_imgPath" class="col-sm-2 control-label">照片</label>
                         <div class="col-sm-10">
                             <input type="file" class="form-control-file" id="engineer_imgPath" name="file">
                         </div>
                     </div>
                     <div class="form-group">
                         <label for="engineer_motte" class="col-sm-2 control-label">格言</label>
                         <div class="col-sm-10">
                             <input type="text" class="form-control" id="engineer_motto" placeholder="格言" name="engineerMotto">
                         </div>
                     </div>
                 </form>
             </div>
             <div class="modal-footer">
             	<span>${flag}</span>
                 <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                 <input type="button" class="btn btn-primary" id="submitForm" onclick="add_info()"value="提交"></input>
             </div>
         </div>
     </div>
 </div>
<script src="${pageContext.request.contextPath}/staticfile/js/jquery-3.2.1.js"></script>
<script src="${pageContext.request.contextPath}/staticfile/js/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/staticfile/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/staticfile/js/getmajor.js"></script>
<script src="${pageContext.request.contextPath}/staticfile/js/searchname.js"></script>
<script src="${pageContext.request.contextPath}/staticfile/js/personManage.js"></script>
<script src="${pageContext.request.contextPath}/staticfile/js/back.js"></script>
<script type="text/javascript">
function add_info(){
	var form = $("#engineerform");
	form.submit();
}
</script>
</body>
</html>