function commonfunction(currentPage,pages){
	$.ajax({
		url:"http://localhost:9999/EngineerHub/back/engineersByJson/"+currentPage,
		type:"GET",
		async:true,
		dataType:"json",//返回类型为json    
		success:function(data){
			console.log(data)
			$("#personManage").children().remove();//删除里面的所有元素
			$.each(data.list, function(index, item){//遍历json中每一个单元，随即为“tbody”添加元素
				$("#personManage").append("<tr><td>"+item.engineerId+"</td>"+
	                 "<td>"+item.engineerName+"</td><td>"+item.engineerSex+"</td>"+
	                 "<td>"+item.engineerEmail+"</td><td>"+
	                  "<button class='btn btn-primary'><span class='glyphicon'>编辑</span></button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
	                   "<button class='btn btn-danger'><span class='glyphicon'></span>删除</button>"+
	                 "</td></tr>");
			});
			var prevp=currentPage-1;//前一页
			var nextp = currentPage+1;//下一页
			//修改函数的参数
			$("#prevPerson").removeAttr("onclick").attr("onclick","prevPersonPage("+prevp+","+pages+")");
			$("#nextPerson").removeAttr("onclick").attr("onclick","nextPersonPage("+nextp+","+pages+")");
			//设置院系获取的json
			$("#institude").append('<option value="-1" id="-1">请选择院系</option>');
			$.each(data.institudes, function(index, item){//遍历json中每一个单元，随即为“tbody”添加元素
				$("#institude").append("<option value='"+item.instid +"' id='"+item.instid+"'>"+item.instname+"</option>");
			});
		},
		fail:function(){
			alert("获取失败");
		}
	})
}

function prevPersonPage(currentPage,pages){
	if(currentPage<=-1){
		$("#prevPerson").removeAttr("onclick").attr("onclick","prevPersonPage("+0+","+pages+")");//去掉点击的按钮
	}else{
		 commonfunction(currentPage,pages);
	}
}
//下一页数据
function nextPersonPage(currentPage,pages){
	if(currentPage>=pages){
		$("#nextPerson").removeAttr("onclick").attr("onclick","nextPersonPage("+pages+","+pages+")");//去掉点击的按钮
	}else{
		 commonfunction(currentPage,pages);
	}
}