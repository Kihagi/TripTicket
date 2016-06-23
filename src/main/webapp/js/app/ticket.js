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
		
		proceedToTrips: function(){
			var ajax = new XMLHttpRequest();
			
			ajax.onreadystatechange = function(){
				if(ajax.readyState ==4 ){
					if(ajax.status == 200){
						document.getElementById('ajax-content').innerHTML = ajax.responseText;
					}
				}
			}
			ajax.open("GET", "./viewtrips", true);
			ajax.send();
		},
		bookVehicle: function(tripId){
			var ajax = new XMLHttpRequest();
			
			ajax.onreadystatechange = function(){
				if(ajax.readyState ==4 ){
					if(ajax.status == 200){
						document.getElementById('ajax-content').innerHTML = ajax.responseText;
					}
				}
			}
			ajax.open("GET", "./book.jsp?trip="+tripId, true);
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

function ticketBookVehicle(tripId){
	ticket.bookVehicle(tripId);
}

function completeBooking(){
	ticket.complete();
}
