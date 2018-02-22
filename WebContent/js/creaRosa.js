$(document).ready(function(){
	$('#rosaG').attr("onchange",calcolaCrediti());
});

function calcolaCrediti(){
	alert($('#rosaG').children().html());
}