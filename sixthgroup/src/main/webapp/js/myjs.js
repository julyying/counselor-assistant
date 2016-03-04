/**
* 添加一条操作日志
*/
function insertOperationLog (userId,content){
	$.ajax({ 
		type: "post", 
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url: '/sixthgroup/operationLogController/insertOne.do',
		data: {
			userId:userId,
			content:content
		},
		dataType: "json",
		async: false,
		success: function(data){
//			if (data.result) { 
//				alert("success");
//			}else{
//				alert("error");
//			}  
		},
		error: function(jqXHR){     
		   alert("发生错误：" + jqXHR.status);  
		},     
	});
}

