var ticket = {
		list: function(){
	    	var ajax = new XMLHttpRequest();
	    	
	    	ajax.onreadystatechange = function(){
	    		
	    		if(ajax.readyState == 4){
	    			if(ajax.status == 200){
	    				document.getElementById('ajax-content').innerHTML = ajax.responseText;
	    			}
	    		}
	    	}
	    	
	    	ajax.open("GET", "./ticket", true);
	    	ajax.send();
		},
		
		vehicles: function(){
			var ajax = new XMLHttpRequest();
			
			ajax.onreadystatechange = function(){
				if(ajax.readyState ==4 ){
					if(ajax.status == 200){
						document.getElementById('ajax-content').innerHTML = ajax.responseText;
					}
				}
			}
			ajax.open("GET", "./companyvehicles", true);
			ajax.send();
		},
		bookVehicle: function(){
			var ajax = new XMLHttpRequest();
			
			ajax.onreadystatechange = function(){
				if(ajax.readyState ==4 ){
					if(ajax.status == 200){
						document.getElementById('ajax-content').innerHTML = ajax.responseText;
					}
				}
			}
			ajax.open("GET", "./ticket/book.jsp", true);
			ajax.send();
		},
		complete: function(){
			var ajax = new XMLHttpRequest();
			
			ajax.onreadystatechange = function(){
				if(ajax.readyState ==4 ){
					if(ajax.status == 200){
						document.getElementById('ajax-content').innerHTML = ajax.responseText;
					}
				}
			}
			ajax.open("GET", "./completebooking", true);
			ajax.send();
		}
		
}

function ticketCompanies(){
	ticket.list();
}

function ticketselectVehicle(){
	ticket.vehicles();
}

function ticketBookVehicle(){
	ticket.bookVehicle();
}

function completeBooking(){
	ticket.complete();
}
