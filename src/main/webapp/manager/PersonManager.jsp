<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/bootstrap.css">
<link rel="stylesheet" href="/css/manager.css">
<link rel="stylesheet" href="/css/font-awesome.min.css">
</head>
<body>
<div style="height:100%;height:100%; background-color: #f1f2f6">
	<%@include file="../common/header.jspf"%>
	<div class="row">
	<div class="col-md-8 col-md-offset-2" style="flex-grow: 0.8; margin-top:10px;border-radius: 10px;height:60%;background-color: #ffffff;padding:10px;">
		 <div class="panel panel-primary" style="height:100%">
		     <div class="panel-heading">人员管理</div>
		     <div class="panel-body">
		         <div class="row my-table-toolbar" style="margin-bottom: 10px;height:100%">
		             <div class="col-xs-4">
		                 <div class="input-group">
		                     <input type="text" class="form-control" placeholder="Search for name" id="searchName" onchange="fullEngineerInfo()">
		                     <span class="input-group-btn"><a class="btn btn-default" href="javascript:void(0)" onclick="searchname()">搜索</a></span>
		                 </div>
		             </div>
		             <div class="col-xs-2 pull-right">
		                 <button class="btn btn-success pull-right" data-toggle="modal" data-target="#chooseIndex" id="addInfo">添加</button>
		             </div>
		         </div>
		         <table class="table table-striped table-bordered text-center">
		             <thead>
		             <tr>
		                 <th class="text-center">姓名</th>
		                 <th class="text-center">性别</th>
		                 <th class="text-center">邮箱</th>
		                 <th class="text-center">操作</th>
		             </tr>
		             </thead>
		             <tbody id="personManage">
						<c:forEach items="${EngineerCustom}" var="item">
							<tr>
				                 <td>${item.engineerName}</td>
				                 <td>${item.engineerSex>"1"?"女":"男"}</td>
				                 <td>${item.engineerEmail}</td>
				                 <td>
				                     <button class="btn btn-primary" onclick="edit(${item.engineerId})" id="editInfo" data-toggle="modal" data-target="#chooseIndex"><span>编辑</span></button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				                     <button class="btn btn-danger" onclick="deleteInfo(${item.engineerId})">删除</button>
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
		                        <a class="page-link" href="/EngineerHub/back/engineers/${pages.prePage }"  id="prev" aria-label="Previous">
		                            <span aria-hidden="true">&laquo;</span>
		                        </a>
		                    </li>
		                   <li class="page-item"><a class="page-link" href="javascript:void(0)">${pages.prePage+1}</a></li>
		                    <li class="page-item">
		                        <a class="page-link" href="/EngineerHub/back/engineers/${pages.nextPage}" id="next" aria-label="Next">
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
                 <form id="engineerForm"  class="form-horizontal" action="/EngineerHub/back/insertEngineer" method="post" enctype="multipart/form-data">
                     <input type="hidden"  id="engineer_id" placeholder="编号" name="engineerId">
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
								<input type="radio" name="engineerSex" id="inlineRadio1" value="1"> 男
								</label>
								<label class="radio-inline">
								  <input type="radio" name="engineerSex" id="inlineRadio2" value="2"> 女
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
                     <div class="form-group">
                         <label for="engineer_git" class="col-sm-2 control-label">GitHub</label>
                         <div class="col-sm-10">
                             <input type="text" class="form-control" id="engineer_git" placeholder="github" name="engineerGit">
                         </div>
                     </div>
                     <div class="form-group">
			            <label for="institute" class="col-sm-2 control-label">院系</label>
			             <div class="col-sm-10">
					            <select class="form-control d-block w-100 col-sm-8" id="institute" required="required" name="instId" onchange="getmajor()">
					            	<option value="-1" id="-1">请选择院系</option>
					                <c:forEach items="${institutes}" var="item">
								    	  <option value="${item.instId}" id="${item.instId}">${item.instName}</option>
								    </c:forEach>
					            </select>
			              </div>
			         </div>
			         <div class="form-group">
			            	<label for="engineerMajor" class="col-sm-2 control-label">专业</label>
			            	<div class="col-sm-10">
			            	 	<select class="form-control d-block w-100 col-sm-8" id="engineerMajor" required="required" name="majorId">
					              <option id="-2">请选择专业</option>
					            </select>
			            	</div>
			          </div>
                     <div class="form-group">
                         <label for="engineer_imgPath" class="col-sm-2 control-label">照片</label>
                         <div class="col-sm-10">
                             <input type="file" class="form-control-file" id="engineer_imgPath" name="file" onchange="changePic(this)">
                             <img src="" width="100" height="100"id="imgSrc">
                         </div>
                     </div>
                     <div class="form-group">
                         <label for="engineer_motto" class="col-sm-2 control-label">格言</label>
                         <div class="col-sm-10">
                             <input type="text" class="form-control" id="engineer_motto"  placeholder="格言" name="engineerMotto">
                         </div>
                     </div>
					 <div class="modal-footer">
						 <input type="submit" class="btn btn-primary pull-right" id="formBtn"  value="提交">
						 <input type="reset" class="btn btn-primary pull-right" value="重置">
					 </div>
				</form>
             </div>
         </div>
     </div>
 </div>
<script src="/js/jquery-3.2.1.js"></script>
<script src="/js/jquery.validate.min.js"></script>
<script src="/js/bootstrap.js"></script>
<script src="/js/getmajor.js"></script>
<script src="/js/searchname.js"></script>
<script src="/js/jquery-form.js"></script>
<script type="text/javascript">
	$(function () {
		$("#engineerForm").ajaxForm(function (data) {
			console.log(data);
			console.log("str:" + JSON.stringify(data));
			if(data.code=="200") {
				setTimeout(function () {
					$(".close").click();
				}, 2000)
			}
		})
	})
	//添加信息
	$("#addInfo").click(function(){
		$(".modal-title").html("添加人员信息");
		$("#engineerForm").resetForm();
		$("#engineerForm").attr("action","/EngineerHub/back/insertEngineer");
		$("#formBtn").attr("value","添加");
	})
	//预览图片
	function changePic(obj){
		const reads= new FileReader();
		const file = document.getElementById('engineer_imgPath').files[0];
		reads.readAsDataURL(file);
		reads.onload=function (e) {
			document.getElementById('imgSrc').src=this.result;
		};
	}
	//编辑
	function edit(id){
		//替换标题
		$(".modal-title").html("编辑人员信息");
		$.get("/EngineerHub/back/GetInfo/"+id,function(data){
			console.log(data)
			$("#engineerForm").attr("action","/EngineerHub/back/save");
			$("#engineer_name").val(data.engineerName);
			if(data.engineerSex==1){
				$("#inlineRadio1").attr("checked","checked");
			}else if(data.engineerSex==2){
				$("#inlineRadio2").attr("checked","checked");
			}
			$("#engineer_id").val(data.engineerId);
			$("#engineer_tel").val(data.engineerTel);
			$("#engineer_email").val(data.engineerEmail);
			$("#engineer_git").val(data.engineerGit);
			//选择专业和院系
			$("#institute option[id="+data.instId+"]").attr("selected",true);
			$.ajaxSettings.async = false;
			getmajor();
			$.ajaxSettings.async = true;
			$("#engineerMajor option[id="+data.majorId+"]").attr("selected",true);
			$("#imgSrc").attr("src",data.engineerImgPath);
			$("#engineer_motto").val(data.engineerMotto);
			$("#formBtn").attr("value","修改");
		})
	}
	function deleteInfo(id) {
		$.ajax({
			url: "/EngineerHub/back/delete/" + id,
			type: "POST",
			data: {
				_method: "DELETE",
				"id": id
			},
			success: function (data) {
				if (data == "true") {
					alert("删除成功");
					window.location.reload();
				}
			}
		})
	}
</script>
</body>
</html>