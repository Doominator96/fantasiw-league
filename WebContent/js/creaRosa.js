function calcolaCrediti(){
	var sum=0;
	var div = document.getElementById('rosaG');
	for(i=0; i<div.childNodes.length; i++)
	{
		var arr=div.childNodes[i].innerHTML.split(" ");
		var costo=Number(arr[arr.length-2])
		sum+=costo;
	}
	var budgetAttuale =250-sum;
	$('#budget').html("Budget:"+ budgetAttuale+ "CR")
}
