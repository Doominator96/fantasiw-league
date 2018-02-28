$(document).ready(function() {
    $('.leghe').select2();
    $('.rose').select2();
    alert("dadwad");
});

function cacone(){
	$.ajax({
		url: 'giocatoriRosa',
		type : 'GET',
		success : function(result){
		
			$.each(JSON.parse(result),function(idx,obj){
				
				
			})
		}
	});
}

