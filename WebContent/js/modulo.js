function check() {
	if (document.getElementById('433').checked) {
		move433();
	}

	if (document.getElementById('442').checked) {
		move442();
	}

	if (document.getElementById('343').checked) {
		move343();
	}
	if (document.getElementById('352').checked) {
		move352();
	}
};

function move433() {
	$("#portieri").val([]);
	$("#difensori").val([]);
	$("#centrocampisti").val([]);
	$("#attaccanti").val([]);
	
	$("#difensori").select2({ width: '80%',maximumSelectionLength: '4' });
	$("#centrocampisti").select2({ width: '80%',maximumSelectionLength: '3' });
	$("#attaccanti").select2({ width: '80%',maximumSelectionLength: '3' });
	$( ".g2" ).css( "margin", "90px 51px" );
	$( ".g3" ).css( "margin", "90px 122px" );
	$( ".g4" ).css( "margin", "90px 184px" );
	$( ".g5" ).css( "margin", "90px 255px" );
	$( ".gioc5" ).attr("id","d");
	$( ".g6" ).css( "margin", "175px 76px" );
	$( ".g7" ).css( "margin", "175px 152px" );
	$( ".g8" ).css( "margin", "175px 232px" );
	$( ".g9" ).css( "margin", "295px 76px" );
	$( ".gioc9" ).attr("id","a");
	$( ".g10" ).css( "margin", "295px 152px");
	$( ".g11" ).css( "margin", "295px 229px");
}

function move442() {
	$("#portieri").val([]);
	$("#difensori").val([]);
	$("#centrocampisti").val([]);
	$("#attaccanti").val([]);
	
	$("#difensori").select2({ width: '80%',maximumSelectionLength: '4' });
	$("#centrocampisti").select2({ width: '80%',maximumSelectionLength: '4' });
	$("#attaccanti").select2({ width: '80%',maximumSelectionLength: '2' });

	$( ".g2" ).css( "margin", "90px 51px" );
	$( ".g3" ).css( "margin", "90px 122px" );
	$( ".g4" ).css( "margin", "90px 184px" );
	$( ".g5" ).css( "margin", "90px 255px" );
	$( ".gioc5" ).attr("id","d");
	$( ".g6" ).css( "margin", "175px 51px" );
	$( ".g7" ).css( "margin", "175px 122px" );
	$( ".g8" ).css( "margin", "175px 184px" );
	$( ".g9" ).css( "margin", "175px 255px" );
	$( ".gioc9" ).attr("id","c");
	$( ".g10" ).css( "margin", "295px 102px");
	$( ".g11" ).css( "margin", "295px 204px");
}
function move352() {
	$("#portieri").val([]);
	$("#difensori").val([]);
	$("#centrocampisti").val([]);
	$("#attaccanti").val([]);
	
	$("#difensori").select2({ width: '80%',maximumSelectionLength: '3' });
	$("#centrocampisti").select2({ width: '80%',maximumSelectionLength: '5' });
	$("#attaccanti").select2({ width: '80%',maximumSelectionLength: '2' });


	$( ".g2" ).css( "margin", "90px 76px" );
	$( ".g3" ).css( "margin", "90px 152px" );
	$( ".g4" ).css( "margin", "90px 232px" );
	$( ".g5" ).css( "margin", "175px 36px" );
	$( ".gioc5" ).attr("id","c");
	$( ".g6" ).css( "margin", "175px 92px" );
	$( ".g7" ).css( "margin", "175px 152px" );
	$( ".g8" ).css( "margin", "175px 214px" );
	$( ".g9" ).css( "margin", "175px 270px" );
	$( ".gioc9" ).attr("id","c");
	$( ".g10" ).css( "margin", "295px 102px");
	$( ".g11" ).css( "margin", "295px 204px");

}
function move343() {
	$("#portieri").val([]);
	$("#difensori").val([]);
	$("#centrocampisti").val([]);
	$("#attaccanti").val([]);
	
	$("#difensori").select2({ width: '80%',maximumSelectionLength: '3' });
	$("#centrocampisti").select2({ width: '80%',maximumSelectionLength: '4' });
	$("#attaccanti").select2({ width: '80%',maximumSelectionLength: '3' });


	$( ".g2" ).css( "margin", "90px 76px" );
	$( ".g3" ).css( "margin", "90px 152px" );
	$( ".g4" ).css( "margin", "90px 232px" );
	$( ".g5" ).css( "margin", "175px 51px" );
	$( ".gioc5" ).attr("id","c");
	$( ".g6" ).css( "margin", "175px 122px" );
	$( ".g7" ).css( "margin", "175px 184px" );
	$( ".g8" ).css( "margin", "175px 255px" );
	$( ".g9" ).css( "margin", "295px 76px" );
	$( ".gioc9" ).attr("id","a");
	$( ".g10" ).css( "margin", "295px 152px");
	$( ".g11" ).css( "margin", "295px 229px");

}
