//function checkLogin(){
//	$.ajax({
//		url: 'login',
//		data:{
//			username: document.getElementById("login_username").value,
//			password: document.getElementById("login_password").value
//		},
//		success : function(responseText){
//			alert(responseText);
//				if(responseText == "wuser")
//					swal();
//				else if(responseText == "wpass")
//					swal();
//				else if(responseText=="true")
//					document.location.href = "home.html";
//				
//		},
//		error : function(responseText){
//			alert("error");
//		},
//		type : 'GET'
//	});
//};
function checkLogin(){

 $.ajax({
  
  url : 'login',
  data : {
   username : $('#login_username').val(),
   password : $('#login_password').val(),
  },
  success : function(response) {
   
   if(response == "password"){
    swal("password errata!", "password errata!", "warning")
     .then(() => {
      document.location = "index.html";
     });
   }
   else if(response == "user"){
	   alert();
    
    swal("l'utente non è stato trovato!","l'utente non è stato trovato!", "warning")
     .then(() => {
      document.location = "index.html";
     });
   }
   
   else document.location.href = "home.jsp";

  },
  type : 'GET',

 });
 
 
}