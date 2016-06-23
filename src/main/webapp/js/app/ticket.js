var ticket = {
		listCompanies: function(){
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
		
		successbooking: function(){
	    	var ajax = new XMLHttpRequest();
	    	
	    	ajax.onreadystatechange = function(){
	    		
	    		if(ajax.readyState == 4){
	    			if(ajax.status == 200){
	    				document.getElementById('ajax-content').innerHTML = ajax.responseText;
	    			}
	    		}
	    	}
	    	
	    	ajax.open("GET", "./ticket/action/*", true);
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
			ajax.open("GET", "./ticket/book.jsp?trip="+tripId, true);
			ajax.send();
		},
		complete: function(){
			var me = this;
	    	var ajax = new XMLHttpRequest();
	    	
	    	var idNumber = document.getElementById('idNumber').value;
	    	var name = document.getElementById('name').value;
	    	var phone = document.getElementById('phone').value;
	    	var seat = document.getElementById('seat').value;
	    	var tripId = document.getElementById('tripId').value;
	    	
	    	var params = 'idNumber=' + encodeURIComponent(idNumber) + '&name=' + encodeURIComponent(name) + '&phone=' + encodeURIComponent(phone) + '&seat=' + encodeURIComponent(seat) + '&tripId=' + encodeURIComponent(tripId);
	    	
	    	console.log(params);
	    	
	    	ajax.onreadystatechange = function(){
	    		
	    		if(ajax.readyState == 4){
	    			if(ajax.status == 200){
	    				me.successbooking();
	    			}
	    		}
	    	}
	    	
	    	ajax.open("POST", "./ticket/action/*", true);
	    	ajax.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	    	ajax.send(params);
		}
		
}

function ticketCompanies(){
	ticket.listCompanies();
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
