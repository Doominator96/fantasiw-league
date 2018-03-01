function calcolaCrediti() {
	var sum = 0;
	var players = 0;
	var gk = 0;
	var df = 0;
	var md = 0;
	var st = 0;

	var div = document.getElementById('rosaG');
	for (i = 0; i < div.childNodes.length; i++) {
		var currentPl = "#" + div.childNodes[i].id;
		var gioc=div.childNodes[i].id;
		if ($(currentPl).hasClass("por"))
			gk++;
		else if ($(currentPl).hasClass("dif"))
			df++;
		else if ($(currentPl).hasClass("cen"))
			md++;
		else if ($(currentPl).hasClass("att"))
			st++;
   
		players++;
		var arr = div.childNodes[i].innerHTML.split(" ");
		var costo = Number(arr[arr.length - 2])
		sum += costo;
		
	}
	var portier=document.getElementById('gk');
	var difensor=document.getElementById('def');
	var centrocampist=document.getElementById('mid');
	var attaccant=document.getElementById('str');
	var budgetAttuale = 180 - sum;
	$('#budget').html("Budget: " + budgetAttuale + " CR");
	$('#giocatoriTot').html("Totale: " + players + " / 25 ");
	$('#portieri').html("Portieri: " + gk + " / 3");
	$('#difensori').html("Difensori: " + df + " / 8");
	$('#centrocampisti').html("Centrocampisti: " + md + " / 8");
	$('#attaccanti').html("Attaccanti: " + st + " / 6");
	
	if(budgetAttuale>=0 && players == 25){
		document.getElementById('conferma').disabled=false;
		document.getElementById('conferma').style.background='#2BB673';
	}

	
	
	if(gk==3){
		        document.getElementById("tab_1").style.display = "none";
		        document.getElementById("p").style.display = "none";

	}
	if(df==8){
        document.getElementById("tab_2").style.display = "none";
        document.getElementById("d").style.display = "none";

}
	if(md==8){
        document.getElementById("tab_3").style.display = "none";
        document.getElementById("c").style.display = "none";

}
	if(st==6){
        document.getElementById("tab_4").style.display = "none";
        document.getElementById("a").style.display = "none";

}

}
function conferma(){
	document.getElementById("conferma").disabled=true;
	var div = document.getElementById('rosaG');
	var ids="";
	for (i = 0; i < div.childNodes.length; i++){
		var gioc=div.childNodes[i].id;
		ids+=gioc+",";
	}
	$.ajax({
	    url:"creaAfferiscono",
	    type:"POST",
	    data:{
	    	id:ids
	    },
	    success:function(data){
	    	swal({
	    		  title: 'Rosa Creata Con Successo',
	    		  type: 'success',
	    		  showCancelButton: false,
	    		  confirmButtonColor: '#3085d6',
	    		  confirmButtonText: 'OK'
	    		}).then((result) => {
	    		  if (result.value) {
	    			  document.location.href="home.jsp";
	    		  }
	    		  else
	    			  document.location.href="home.jsp";
	    		})
	    	
	    },
	});
}
