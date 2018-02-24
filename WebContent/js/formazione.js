function data(){
	$.ajax({
		url:'formazione2',
		success:function(response){
			alert(response);
			document.location.href="formazione2.jsp";
		},
		type: 'GET'
	})
}