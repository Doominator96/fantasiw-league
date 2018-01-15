function checkLogin(){
	$.ajax({
		url: 'login',
		data:{
			username: document.getElementById("login_username"),
			password: document.getElementById("login_password")
		},
		success : function(response){
				if(response == "true")
					document.location.href = "home.html";
				/*else if(response == "wuser")
					swal();
				else if(response == "wpass")
					swal();*/
		},
		type : 'GET'
	});
};