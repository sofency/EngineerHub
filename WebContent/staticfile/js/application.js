//获取详情
function getDetails(id){
	$.ajax({
		url:"http://localhost:9999/EngineerHub/back/candidate/"+id,
		data:{
			"candidateId":id
		},
		type:"GET",
		async:true,
		contentType:"application/json;charset=utf-8",
		dataType:"json",
		success:function(data){
			$("#username").html(data.candidateName)
			var sex ="男"
			if(data.candidateSex==2){
				sex="女"
			}
			console.log("后端传进来的数据"+data.candidateId)
			$("#candidateId").val(""+data.candidateId+"")
			$("#sex").html(sex)
			$("#instname").html(data.instname)
			$("#majorname").html(data.majorname)
			$("#telephone").html(data.candidateTel)
			$("#email").html(data.candidateEmail)
			$("#fames").html(data.candidateFame)
			$("#introduce").html(data.candidateIntroduce)
			/*显示模态框  */
			$('#myModalDetail').modal('show');
			console.log(data)
		}
	})
}

//上一页数据
function prevPage(currentPage,pages){
	if(currentPage<=-1){
		$("#prev").removeAttr("onclick").attr("onclick","prevPage("+0+","+pages+")");//去掉点击的按钮
	}else{
		common(currentPage,pages);
	}
}
//下一页数据
function nextPage(currentPage,pages){
	if(currentPage>=pages){
		$("#next").removeAttr("onclick").attr("onclick","nextPage("+pages+","+pages+")");//去掉点击的按钮
	}else{
		common(currentPage,pages);
	}
}
 //公共部分
function common(currentPage,pages){
	$.ajax({
		url:"http://localhost:9999/EngineerHub/back/candidatesByJson/"+currentPage,
		data:{
			"page":currentPage
		},
		type:"GET",
		async:true,
		dataType:"json",//返回类型为json    
		success:function(data){
			console.log(data)
			$("#tablesManage").children().remove();//删除里面的所有元素
			$.each(data.list, function(index, item){//遍历json中每一个单元，随即为“tbody”添加元素
				$("tbody").append(         //添加新元素（具体内容不重要）
					"<tr><td>"+item.candidateId+"</td><td>"+item.candidateName+"</td>"+
					"<td>"+item.candidateSex+"</td><td>"+item.candidateTel+"</td>"+
					"<td>"+item.candidateEmail+"</td><td><a class='btn btn-primary' href='javascript:void(0)' onclick='getDetails("+item.candidateId+")'>查看详情</a></td>"+
					"</tr>");
			});
			var prevp=currentPage-1;//前一页
			var nextp = currentPage+1;//下一页
			//修改函数的参数
			$("#prev").removeAttr("onclick").attr("onclick","prevPage("+prevp+","+pages+")");
			$("#next").removeAttr("onclick").attr("onclick","nextPage("+nextp+","+pages+")");
		},
		fail:function(){
			alert("获取失败");
		}
	})
}
