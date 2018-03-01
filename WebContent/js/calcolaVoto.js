$(document).ready(function() {
    $('#leghe').select2({width:'100%'});
    $('#rose').select2({width:'100%'});
	stampaRose();
});
function stampaRose(){
	$.ajax({
		url: 'roseCalcolaFormazione',
		type : 'POST',
		data:{
			legaSel:$("#leghe").val()	
		},
		success : function(result){
			$('#rose').html("");
			 $.each(JSON.parse(result), function(key, val){
			 $('#rose').append("<option value=\"" + val.id + "\">" + val.nome + "</option>");
			 stampaGiocatori();
			 })
		}
	});
}
function stampaGiocatori(){
	$.ajax({
		url:'giocatoriRosa',
		type: 'GET',
		data:{
			rose1:$("#rose").val()
		},
		success : function(result){
			$('#tab').html("");
			$.each(JSON.parse(result), function(key,val){
			$('#tab').append("<tr id=\""+val.id+"\"><td>"+val.cognome+"</td><td>"+val.squadra+"</td><td class='golS'>"+val.statistiche.GolSubito+"</td><td class='golF'>"+val.statistiche.Gol+"</td><td>"+val.statistiche.Rigore+"</td><td>"+val.statistiche.RigoreSbagliato+"</td><td>"+val.statistiche.Assist+"</td><td>"+val.statistiche.Giallo+"</td><td class='points'>"+val.voto+"</td></tr>");
			})
		}
	}); 
}

function calc(){
	$.ajax({
		url:'calcolaVoti',
		type:'POST',
		data:{
			legaSel:$(" #leghe").val()	
		},
		success:function(result){
			location.href="legheCalcolaFormazione";
			var sum = 0;
			var golFatti=0;
			var golSubiti=0;
			// iterate through each td based on class and add the values
			$(".points").each(function() {

			    var value = $(this).text();
			    // add only if the value is number
			    if(!isNaN(value) && value.length != 0) {
			        sum += parseFloat(value);
			    }
			});
			$(".golF").each(function() {

			    var value = $(this).text();
			    // add only if the value is number
			    if(!isNaN(value) && value.length != 0) {
			        golFatti += parseFloat(value);
			    }
			});
			$(".golS").each(function() {

			    var value = $(this).text();
			    // add only if the value is number
			    if(!isNaN(value) && value.length != 0) {
			        golSubiti += parseFloat(value);
			    }
			});
			$.ajax({
				url:'aggiornaClassifica',
				type:'POST',
				data:{
					punti:sum,
					golF:golFatti,
					golS:golSubiti,
					rose1:$("#rose").val()
				},
			});
		}
	});
}