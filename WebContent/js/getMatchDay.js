$("button").click(function(e) {

});}
function sendAjaxRequest(element,urlToSend) {
    var clickedButton = element;
    $.ajax({
    	  url: 'http://api.football-data.org/v1/competitions/456/leagueTable',
    	  dataType: 'json',
    	  type: 'GET',
    	}).done(function(response) {
    	  var regex =new RegExp("matchday=(\d+)");
    	  var res = regex.exec(response.fixtures[0]._links.awayTeam.href);
    	  var teamId = res[1];
    	  console.log(teamId);
    });
}

$(document).ready(function(){
 $("#button_1").click(function(e){
     e.preventDefault();
     sendAjaxRequest($(this),'/pages/test/');
 });

 $("#button_2").click(function(e){
     e.preventDefault();
     sendAjaxRequest($(this),'/pages/test/');
 });
});