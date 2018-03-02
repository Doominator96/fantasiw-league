var countDownDate;
$(document).ready(function() {	
	$.ajax({
		type : 'GET',
		url : 'formazione2',

		success : function(data) {
			var date = data.split(",")
			var myRegexp = /\w*\s(\w+)\s(\d+).*T\s(\d+)/;
			var match = myRegexp.exec(date[0]);
			var matchMax= myRegexp.exec(date[1]);;
			
			// Set the date we're counting down to
			countDownDatemin = new Date();
			countDownDatemin = Date.parse(match[1] + " " + match[2] + " " + match[3]);
			
			countDownDatemax = new Date();
			countDownDatemax = Date.parse(matchMax[1] + " " + matchMax[2] + " " + matchMax[3]);
			
			var tempomax=0;
			// Get todays date and time
			var now = new Date().getTime();

			// Find the distance between now an the count down date
			var distance = countDownDatemin - now;
			var distance2=(countDownDatemax+86400000) - now;
			// Time calculations for days, hours, minutes and seconds
			var days = Math.floor(distance / (1000 * 60 * 60 * 24));
			var hours = Math.floor((distance % (1000 * 60 * 60 * 24))
					/ (1000 * 60 * 60));
			var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
			var seconds = Math.floor((distance % (1000 * 60)) / 1000);
			
			if(distance2 < 0){
				document.getElementById("calcola").disabled=false;
				document.getElementById("calcola").style.background="#2BB673"
			}

			if(distance>0){
			$.ajax({
				type : 'POST',
				url : 'azzeraCalcolato',
			});
		}		

			

		}
	});
});
