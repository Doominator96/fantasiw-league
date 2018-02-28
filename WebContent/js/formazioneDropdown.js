var select = function(s) {
	return document.querySelector(s);
};

var popup = select('.popup'), close = select('#close'), cont = select('.bd');

select('.gioc1').onclick = function() {
			  
			document.getElementById("sel4").style.display = "none";
			document.getElementById("sel2").style.display = "none";  
			document.getElementById("sel3").style.display = "none";  
			document.getElementById("sel1").style.display = "block";

			cont.style.filter = "blur(10px)";
			popup.classList.add("visible");

};

select('.gioc2').onclick = function() {
	document.getElementById("sel4").style.display = "none";
	document.getElementById("sel1").style.display = "none";  
	document.getElementById("sel3").style.display = "none";  
	document.getElementById("sel2").style.display = "block";
	
	cont.style.filter = "blur(10px)";
	select('.popup').classList.add("visible");

};

select('.gioc3').onclick = function() {

	document.getElementById("sel4").style.display = "none";
	document.getElementById("sel1").style.display = "none";  
	document.getElementById("sel3").style.display = "none";  
	document.getElementById("sel2").style.display = "block";
	cont.style.filter = "blur(10px)";
	select('.popup').classList.add("visible");

};

select('.gioc4').onclick = function() {
	document.getElementById("sel4").style.display = "none";
	document.getElementById("sel1").style.display = "none";  
	document.getElementById("sel3").style.display = "none";  
	document.getElementById("sel2").style.display = "block";

	cont.style.filter = "blur(10px)";
	select('.popup').classList.add("visible");

};

select('.gioc5').onclick = function() {
	if($(this).attr('id') == 'd'){
		document.getElementById("sel4").style.display = "none";
		document.getElementById("sel1").style.display = "none";  
		document.getElementById("sel3").style.display = "none";  
		document.getElementById("sel2").style.display = "block";
}
	else if($(this).attr('id') == 'c'){
		document.getElementById("sel4").style.display = "none";
		document.getElementById("sel2").style.display = "none";  
		document.getElementById("sel1").style.display = "none";  
		document.getElementById("sel3").style.display = "block";
	}
	cont.style.filter = "blur(10px)";
	select('.popup').classList.add("visible");

};

select('.gioc6').onclick = function() {

		document.getElementById("sel4").style.display = "none";
		document.getElementById("sel2").style.display = "none";  
		document.getElementById("sel1").style.display = "none";  
		document.getElementById("sel3").style.display = "block";
	
	cont.style.filter = "blur(10px)";
	select('.popup').classList.add("visible");

};

select('.gioc7').onclick = function() {

		document.getElementById("sel4").style.display = "none";
		document.getElementById("sel2").style.display = "none";  
		document.getElementById("sel1").style.display = "none";  
		document.getElementById("sel3").style.display = "block";

	cont.style.filter = "blur(10px)";
	select('.popup').classList.add("visible");

};

select('.gioc8').onclick = function() {

		document.getElementById("sel4").style.display = "none";
		document.getElementById("sel2").style.display = "none";  
		document.getElementById("sel1").style.display = "none";  
		document.getElementById("sel3").style.display = "block";

	cont.style.filter = "blur(10px)";
	select('.popup').classList.add("visible");

};

select('.gioc9').onclick = function() {
	if($(this).attr('id') == 'a'){
		document.getElementById("sel1").style.display = "none";
		document.getElementById("sel2").style.display = "none";  
		document.getElementById("sel3").style.display = "none";  
		document.getElementById("sel4").style.display = "block";
}
	else if($(this).attr('id') == 'c'){
		document.getElementById("sel4").style.display = "none";
		document.getElementById("sel2").style.display = "none";  
		document.getElementById("sel1").style.display = "none";  
		document.getElementById("sel3").style.display = "block";
	
	}
	cont.style.filter = "blur(10px)";
	select('.popup').classList.add("visible"); 	

};
select('.gioc10').onclick = function() {
	cont.style.filter = "blur(10px)";
	select('.popup').classList.add("visible");
	document.getElementById("sel1").style.display = "none";
	document.getElementById("sel2").style.display = "none";  
	document.getElementById("sel3").style.display = "none";  
	document.getElementById("sel4").style.display = "block";
};
select('.gioc11').onclick = function() {
	cont.style.filter = "blur(10px)";
	select('.popup').classList.add("visible");
	document.getElementById("sel1").style.display = "none";
	document.getElementById("sel2").style.display = "none";  
	document.getElementById("sel3").style.display = "none";  
	document.getElementById("sel4").style.display = "block";
};
close.onclick = function() {
		popup.classList.remove("visible");
	cont.style.filter = "none";
};