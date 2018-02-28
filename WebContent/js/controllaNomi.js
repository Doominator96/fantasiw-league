function controlloNomeLega(){
	$.ajax({
		url: 'nomeLega',
		data:{
			nome: nome
		},
		type : 'GET',
		success : function(result){
			if(result == "Exist"){
				swal();
			}
		}
	});
}

function controlloNomeRosa(){
	$.ajax({
		url: 'nomeRosa',
		data:{
			nomeRosa: nomeRosa
		},
		type : 'GET',
		success : function(result){
			document.getElementById("nomeRosa").style.background = "red";
		}
	});
}