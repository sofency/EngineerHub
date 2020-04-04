function getmajor(){
		const code = $("#institute option:selected").attr("id");//得到第一个下拉列表的值
		 if(-1!= code){  
             //通过ajax传入后台，把orderTypeName数据传到后端
	         $.post("/EngineerHub/getMajor.action",{code:code},function(data){
	                 let option;
	                 option="<option>"+"请选择你的专业"+"</option>" ; 
	                 $.each(data,function(i,major){//循环，i为下标从0开始，n为集合中对应的第i个对象  
	                     option += "<option id='"+major.majorId+"' value='"+major.majorId+"'>"+major.majorName+"</option>"
	                 });  
	                 $("#engineerMajor").html(option);//将循环拼接的字符串插入第二个下拉列表
	                 $("#engineerMajor").show();//把第二个下拉列表展示
	         });  
         }
	}