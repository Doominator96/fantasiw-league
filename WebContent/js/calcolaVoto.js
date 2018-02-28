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
			var voto;
			$.each(JSON.parse(result),function(idx,obj){
				voto = 6;
				var ruolo = obj.ruolo;
				var costo = obj.costo;
				
				if(ruolo !== "PORTIERE"){
					for(i=0; i < 3; i++){
						var key = calcolaGol(ruolo,costo);
						if(key !== "Niente"){
							obj.put(key,obj.statistiche.get(key) + 1);
							
							switch(key){
								case "Gol":
									voto += 3;
									break;
								case "Rigore":
									voto += 2;
									break;
								case "Rigore Sbagliato":
									voto -= 3;
									break;
							}
						}
					}
					
					var yellow = calcolaGiallo();
					obj.put(yellow,obj.statistiche.get(yellow) + 1);
					if(yellow === "Giallo")
						voto -= 0.5;
				}
				else{
					var keyR = calcolaPortiereRigore(ruolo,costo);
					
					obj.put(keyR,obj.statistiche.get(key) + 1);
					switch(keyR){
					case "Rigore Parato":
						voto += 3;
						break;
					case "Gol Subito":
						voto -= 1;
						break;
					}
					
					var keyT;
					
					for(i=0; i < 3; i++){
						keyT = calcolaPortiereTiri(ruolo,costo);
						obj.put(keyT,obj.statistiche.get(key) + 1);
						
						switch(keyT){
						case "Tiro Parato":
							voto += 0.5;
							break;
						case "Gol Subito":
							voto -= 1;
							break;
						}
						
					}
					
				}
				
				//print voto;
				
			})
		}
	});
}

function calcolaGiallo(){
	var yellowCard = Math.floor((Math.random() * 100) + 0);
	
	if(yellowCard >= 0 && yellowCard <= 30)
		return "Giallo";
	
	return "Niente";
}

function calcolaGol(ruolo,costo){
	
	var probVal = 0;
	if(ruolo === "ATTACCANTE")
		probVal = 1.9;
	else if(ruolo === "CENTROCAMPISTA")
		probVal = 1.4;
	else if(ruolo === "DIFENSORE")
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
	if(ruolo === "CENTROCAMPISTA")
		probVal = 2.8;
	else if(ruolo === "DIFENSORE")
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
	return "Niente";
}

function calcolaPortiereTiri(costo){
	
	var tiri = Math.floor((Math.random() * 7) + 0);
	var block = costo * 6;
	
		
		var rand = Math.floor((Math.random() * 100) + 1);
		if(rand >= 0 && rand <= block){
			return "Tiro Parato";
		}
		else if (rand >= block){
			return "Gol subito";
		}
}
