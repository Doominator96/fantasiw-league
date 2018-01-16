function redirectPage(pageUrl){
	$.ajax({
		  
		  url : 'redirectServlet',
		  data : {
			  requestPage: pageUrl,
		  },
		  type : 'GET',

		 });
}