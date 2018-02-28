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
				var ruolo = obj.ruolo;
				var costo = obj.costo;
				
				for(i=0; i < 3; i++){
					var key = calcolaGol(ruolo,costo);
					if(key != "Niente")
						obj.put(key,obj.statistiche.get(key) + 1);
				}
				
				
			})
		}
	});
}

function calcolaGol(ruolo,costo){
	
	var probVal = 0;
	if(ruolo = "ATTACCANTE")
		probVal = 1.9;
	else if(ruolo = "CENTROCAMPISTA")
		probVal = 1.4;
	else if(ruolo = "DIFENSORE")
		probVal = 1.2;
	
	var probability = costo * probVal;
	var score = Math.floor((Math.random() * 100) + 1);
	
	if(score >= 1 && score <= probability){
		var penaltyProb = Math.floor((Math.random() * 100) + 0);
		
		if(penaltyProb >= 0 && penaltyProb <= 20){
			var penaltyScore = Math.floor((Math.random() * 100) + 0);
			if(penaltyScore >= 0 && penaltyScore <= 70){
				return "Rigore"; //RIGORE SEGNATO
			}
			else{
				return "Rigore Sbagliato"; //RIGORE SBAGLIATO
			}
		}
		
		return "Gol"; //GOL SEGNATO
		
	}
	
	return "Niente";
}

function calcolaAssist(ruolo, costo){
	var probVal = 0;
	if(ruolo = "CENTROCAMPISTA")
		probVal = 2.8;
	else if(ruolo = "DIFENSORE")
		probVal = 2.8;
	
	var probability = costo * probVal;
	var assist = Math.floor((Math.random() * 100) + 1);
	
	if(assist >= 0 && assist <= probability){
		return "Assist";
	}
}

function calcolaPortiereRigore(costo){
	//Prova rigore
	var probRig = Math.floor((Math.random() * 100) + 0);
	if(probRig >= 60 && probRig <= 100){
		var block = costo * 2.2;
		var rand = Math.floor((Math.random() * 100) + 1)
		
		if(rand >= 0 && rand <= block){ //PARA
			return "Rigore Parato";
		}
		return "Gol Subito";	//SUBISCE
	}
}

function calcolaPortiereTiri(costo){
	
	var tiri = Math.floor((Math.random() * 7) + 0);
	var block = costo * 6;
	var bonus = 0;
	
	for (i = 0; i < tiri; i++){ //PROVE
		
		var rand = Math.floor((Math.random() * 100) + 1);
		if(rand >= 0 && rand <= block && bonus <= 2){
			bonus += 0.5;
		}
		else if (rand >= block && bonus > -3){
			bonus -= 1;
		}
	}
	
	return bonus;
}
