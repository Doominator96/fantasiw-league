$(document).ready(function(){
	$.ajax({
		url: 'legaServlet',
		type : 'GET',
		success : function(json){
			var myJ = JSON.parse(json);
			drawMenu(myJ);
		}
	});
});

function drawMenu(data){
	for (var i = 0;i<data.length;i++){
		drawDropDownMenu(data[i]);
	}
}
function drawDropDownMenu(rowData){
	var row = $("<option />");
	$("#menu").append(row);
	row.append($("<option>"+rowData.nome+"</option>"));
}