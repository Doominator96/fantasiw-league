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
	$.ajax({
		url:'controllaUtenteFormazione',
		type: 'GET',
		data:{
			rose1:$("#rose").val()
		},
		success : function(result){
			$("#calcola").css("display", result);
		
		}
	});
}
function aggiornaRisultati(){

	$.ajax({
		url:'giocatoriRosa',
		type: 'GET',
		data:{
			rose1:$("#rose").val()
		},
		success : function(result){
			var sum = 0;
			var golFatti=0;
			var golSubiti=0;
			$('#tab').html("");
			$.each(JSON.parse(result), function(key,val){
			$('#tab').append("<tr id=\""+val.id+"\"><td>"+val.cognome+"</td><td>"+val.squadra+"</td><td class='golS'>"+val.statistiche.GolSubito+"</td><td class='golF'>"+val.statistiche.Gol+"</td><td>"+val.statistiche.Rigore+"</td><td>"+val.statistiche.RigoreSbagliato+"</td><td>"+val.statistiche.Assist+"</td><td>"+val.statistiche.Giallo+"</td><td class='points'>"+val.voto+"</td></tr>");
			sum+=parseFloat(val.voto);
			golFatti+=parseInt(val.statistiche.Gol);
			golSubiti+=parseInt(val.statistiche.GolSubito);
			})	
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

function calc(){
	$.ajax({
		url:'calcolaVoti',
		type:'POST',
		data:{
			rose1:$("#rose").val(),
			legaSel:$(" #leghe").val()	
		},
		success:function(result){
			if(result=="calcolata"){
				swal({
						  type: 'error',
						  title: 'I Voti Per La Giornata Corrente Sono Gia\' Stati Calcolati!',
						  confirmButtonText: 'OK'

						})
			}
			else{
			swal({
				  title: 'Calcolando Voti!',
				  text: 'Attendere Qualche Secondo',
				  timer: 5000,
				  onOpen: () => {
				    swal.showLoading()
				  }})
			aggiornaRisultati();
			}
		}
	});
}