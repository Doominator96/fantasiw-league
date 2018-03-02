
function login(){
	$.ajax({
		url:'login',
		data:{
			login_username:$('#login_username').val(),
			login_password:$('#login_password').val()
		},
	success:function(){
		
	}
	})
}