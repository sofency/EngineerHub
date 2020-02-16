function searchname(){
	console.log("21212")
	var searchName = $("#searchName").val();//获取搜索的人名
	var obj = $("#personManage");
	if(searchName == null){
		alert("请输入搜索的人名")
	}else{
		$.ajax({
			url:"http://localhost:9999/EngineerHub/back/engineerhub/"+searchName,
			method:"GET",
			async:true,
			datatype:"json",
			data:{
				"searchName":searchName
			},
			success:function(data){
				console.log(data)
				if(data==null){
					alert("无此人");
				}else{
					var html;
					$.each(data,function(index,item){
						var sex = item.engineerSex>1?'女':'男';
						var content = "<tr><th scope='row' class='text-center'>"+item.engineerId+"</th>"+
		                 "<td>"+item.engineerName+"</td>"+
		                 "<td>"+sex+"</td>"+
		                 "<td>+"+item.engineerEmail+"</td>"+
		                 "<td><button class='btn btn-primary'>编辑</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
		                 "<button class='btn btn-danger'>删除</button></td></tr>";
		                 html+=content;
					})
	           		obj.html(html);     
				}
				
			}
		})
	}
}