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

function calcolaGol(obj){
	
	var probVal = 0;
	if(obj.ruolo = "ATTACCANTE")
		probVal = 2.2;
	else if(obj.ruolo = "CENTROCAMPISTA")
		probVal = 1.9;
	else if(obj.ruolo = "DIFENSORE")
		probVal = 1.4;
	
	var probability = obj.costo * probVal;
	var score = Math.floor((Math.random() * 100) + 1);
	
	if(score >= 1 && score <= probability){
		var penaltyProb = Math.floor((Math.random() * 100) + 0);
		
		if(penaltyProb >= 0 && penaltyProb <= 20){
			var penaltyScore = Math.floor((Math.random() * 100) + 1);
			if(penaltyScore >= 0 && penaltyScore <= 70){
				return 2.5; //RIGORE SEGNATO
			}
			else{
				return -2.5; //RIGORE SBAGLIATO
			}
		}
		
		//calcolaAssist(obj);
		return 4; //GOL SEGNATO
		
	}
}

function calcolaAssist(obj){
	var probVal = 0;
	if(obj.ruolo = "CENTROCAMPISTA")
		probVal = 2.8;
	else if(obj.ruolo = "DIFENSORE")
		probVal = 2.8;
	
	var probability = obj.costo * probVal;
	var assist = Math.floor((Math.random() * 100) + 1);
	
	if(assist >= 0 && assist <= probability){
		return 1.5;
	}
}

function calcolaPortiereRigore(obj){
	//Prova rigore
	var probRig = Math.floor((Math.random() * 100) + 0);
	if(probRig >= 60 && probRig <= 100){
		var block = obj.costo * 2.2;
		var rand = Math.floor((Math.random() * 100) + 1)
		
		if(rand >= 0 && rand <= block){ //PARA
			return 3;
		}
		return -1;	//SUBISCE
	}
}

function calcolaPortiereTiri(obj){
	
	var tiri = Math.floor((Math.random() * 7) + 0);
	var block = obj.costo * 6;
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
