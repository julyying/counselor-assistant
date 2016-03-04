$("document").ready(function(){
	alert("123");
	$.ajax({
		type : "post",
		contentType : "application/x-www-form-urlencoded;charset=UTF-8",
		url : '/sixthgroup/userController/selectUserById.do',
		async : false,
		data : {
			id:1
		},
		dataType : 'json',
		success : function(msg) {
			if(msg.result ==true){						
				alert("success");
			}else{
				alert("error");
			}
		},error: function(msg){
		    alert("time out");
		}
	});
})