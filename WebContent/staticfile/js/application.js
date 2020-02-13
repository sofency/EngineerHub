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