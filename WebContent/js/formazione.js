var countDownDate;
$(document).ready(function(){
	$.ajax({
		type: 'GET',
		url:'formazione2',

		success:function(data){
			count(data);
			window.setInterval(countDown, 1000,countDownDate);
			 $("#").select2();
		}
	});
});

var time;

function count(data) {
	var date=data.split(",")
	var myRegexp = /\w*\s(\w+)\s(\d+).*T\s(\d+)/;
	var match = myRegexp.exec(date[1]);
	
	// Set the date we're counting down to
    countDownDate = new Date();
	countDownDate= Date.parse(match[1]+" "+match[2]+" "+match[3]);
	// Update the count down every 1 second
countDown(countDownDate);
}
function countDown(countDownDate) {
	// Get todays date and time
	var now = new Date().getTime();

	// Find the distance between now an the count down date
	var distance = countDownDate - now;

	// Time calculations for days, hours, minutes and seconds
	var days = Math.floor(distance / (1000 * 60 * 60 * 24));
	var hours = Math.floor((distance % (1000 * 60 * 60 * 24))
			/ (1000 * 60 * 60));
	var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
	var seconds = Math.floor((distance % (1000 * 60)) / 1000);

	// Display the result in the element with id="demo"
	document.getElementById("demo").innerHTML = days + "d " + hours + "h "
			+ minutes + "m " + seconds + "s ";

	// If the count down is finished, write some text
//	if (distance < 0) {
	//		}
}