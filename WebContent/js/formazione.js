var countDownDate;
$(document).ready(function() {	
	$.ajax({
		type : 'GET',
		url : 'formazione2',

		success : function(data) {
			count(data);
			window.setInterval(countDown, 1000, countDownDatemin);
			$("#portieri").select2({ width: '80%',maximumSelectionLength: '1' });
			$("#difensori").select2({ width: '80%',maximumSelectionLength: '4' });
			$("#centrocampisti").select2({ width: '80%',maximumSelectionLength: '3' });
			$("#attaccanti").select2({ width: '80%',maximumSelectionLength: '3' });

		}
	});
	$.ajax({
		type:'GET',
		url: 'roseUtente',
		data:{
			 username: '<%= Session["username"] %>' 
		},
		success: function(data) {
			var options = '';
			$.each(data, function(index, value) {
			    options += '<option value="' + value.abc + '" text="' + value.abc + '" />';
			});

			$('#portieri').append(options);
		}
	});
});

var time;

function count(data) {
	var date = data.split(",")
	var myRegexp = /\w*\s(\w+)\s(\d+).*T\s(\d+)/;
	var match = myRegexp.exec(date[0]);
	var matchMax= myRegexp.exec(date[1]);;
	
	// Set the date we're counting down to
	countDownDatemin = new Date();
	countDownDatemin = Date.parse(match[1] + " " + match[2] + " " + match[3]);
	
	countDownDatemax = new Date();
	countDownDatemax = Date.parse(matchMax[1] + " " + matchMax[2] + " " + matchMax[3]);
	
	// Update the count down every 1 second
	countDown(countDownDatemin);
}
function countDown(countDownDatemin) {
	// Get todays date and time
	var now = new Date().getTime();

	// Find the distance between now an the count down date
	var distance = countDownDatemin - now;

	// Time calculations for days, hours, minutes and seconds
	var days = Math.floor(distance / (1000 * 60 * 60 * 24));
	var hours = Math.floor((distance % (1000 * 60 * 60 * 24))
			/ (1000 * 60 * 60));
	var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
	var seconds = Math.floor((distance % (1000 * 60)) / 1000);

	// Display the result in the element with id="demo"
	document.getElementById("Timer").innerHTML = days + "d " + hours + "h "
			+ minutes + "m " + seconds + "s ";

	
//	if (distance < 0) {
//		
//	}
}