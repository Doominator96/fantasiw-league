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
	var budgetAttuale = 250 - sum;
	$('#budget').html("Budget: " + budgetAttuale + " CR");
	$('#giocatoriTot').html("Totale: " + players + " / 25 ");
	$('#portieri').html("Portieri: " + gk + " / 3");
	$('#difensori').html("Difensori: " + df + " / 8");
	$('#centrocampisti').html("Centrocampisti: " + md + " / 8");
	$('#attaccanti').html("Attaccanti: " + st + " / 6");
	
	

	
	
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
//	if(players==2){
//		swal({
//			  title: 'Vuoi Salvare la tua rosa?',
//			  text: "Non sara' possibile modificarla successivamente",
//			  type: 'warning',
//			  showCancelButton: true,
//			  confirmButtonColor: '#3085d6',
//			  cancelButtonColor: '#d33',
//			  confirmButtonText: 'Salva la Rosa!',
//			  cancelButtonText: 'Azzera la Rosa!',
//			  confirmButtonClass: 'btn btn-success',
//			  cancelButtonClass: 'btn btn-danger',
//			  buttonsStyling: false,
//			  reverseButtons: true
//			}).then((result) => {
//			  if (result.value) {
//				  $.ajax({
//					  type: 'GET',
//					  url:'listaGiocatori'
//						  
//					});
////			    swal(
////			    		
////			      'Deleted!',
////			      'Your file has been deleted.',
////			      'success'
////			    )
//			  } else if (
//			    // Read more about handling dismissals
//			    result.dismiss === swal.DismissReason.cancel
//			  ) {
//				  $.ajax({
//					  type: 'POST',
//					  url:'listaGiocatori'
//					});
//			  }
//			})}
	for (j = 0; j < portier.childNodes.length; j++) {
		var cPor =portier.childNodes[j].id;
		var pors = portier.childNodes[j].innerHTML.split(" ");
		var costoP = Number(pors[pors.length - 2])
		alert(costoP);
		if(costoP>budgetAttuale)
			document.getElementById(cPor).style.display = "none";
	}
	
}
