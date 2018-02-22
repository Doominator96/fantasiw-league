$(document).ready(function(){
	$('#rosaG').attr("onchange",calcolaCrediti());
});

function calcolaCrediti(){
	//alert($('#rosaG').contents().html().split(" "));
	var arr=$('#rosaG').contents().html().split(" ");
	alert(arr[3]);

	
}