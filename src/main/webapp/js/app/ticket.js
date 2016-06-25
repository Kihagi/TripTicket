var ticketGet = {
		generalFunction: function(uri){
	    	var ajax = new XMLHttpRequest();
	    	
	    	ajax.onreadystatechange = function(){
	    		
	    		if(ajax.readyState == 4){
	    			if(ajax.status == 200){
	    				document.getElementById('ajax-content').innerHTML = ajax.responseText;
	    			}
	    		}
	    	}
	    	
	    	ajax.open("GET", uri, true);
	    	ajax.send();
		}
		
}


function ticketCompanies(){
	ticketGet.generalFunction("./ticket");
}

function proceedToTrips(){
	ticketGet.generalFunction("./viewtrips");
}

function ticketBookVehicle(tripId){
	ticketGet.generalFunction("./ticket/book.jsp?trip="+tripId);
}


//POSTING
var ticketPost = {
		generalFunction: function(params, uri, successMethod){
			var me = this;
			var ajax = new XMLHttpRequest();
			
			ajax.onreadystatechange = function(){
				if(ajax.readyState == 4){
					if(ajax.status == 200){
						return successMethod;
					}
				}
			}
			ajax.open("POST", uri, true);
			ajax.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
			ajax.send(params);
		}
}

function completeBooking(){
	
	var idNumber = document.getElementById('idNumber').value;
	var name = document.getElementById('name').value;
	var phone = document.getElementById('phone').value;
	var seat = document.getElementById('seat').value;
	var tripId = document.getElementById('tripId').value;
	
	var params = 'idNumber=' + encodeURIComponent(idNumber) + '&name=' + encodeURIComponent(name) + '&phone=' + encodeURIComponent(phone) + '&seat=' + encodeURIComponent(seat) + '&tripId=' + encodeURIComponent(tripId);
	
	ticketPost.generalFunction(params, "./ticket/action/*", successBooking());
}

function successBooking(){
	ticketGet.generalFunction("./ticket/action/*");
}


var ticket = {
		details: [{
			id: 'idNumber',
			label: 'Id Number',
			name: 'idNumber',
			placeholder: 'Id Number',
			type: 'text'
		},{
			id: 'name',
			label: 'Full Name',
			name: 'name',
			placeholder: 'Full Name',
			type: 'text'
		},{
			id: 'phone',
			label: 'Cell Phone',
			name: 'phone',
			placeholder: 'Cell Phone',
			type: 'text'
		},{
			id: 'seat',
			label: 'Seat Number',
			name: 'seat',
			placeholder: 'Seat',
			type: 'text'
		},{
			id: 'tripId',
			label: 'Trip Id',
			name: 'tripId',
			value: '1004',
			placeholder: 'Trip Id',
			type: 'text'
		}],
		
		book: function(){
			var me = this;
			var form = '<form>';
			
			me.details.forEach(function(el){
				form += '<div class="form-group">'
					  + '  <label>' + el.label + '</label>'
					  + '  <input type="' + el.type + '" name="' + el.name + '" class="form-control" id="' + el.id + '" placeholder="' + el.placeholder + '" value="' + el.value + '">'
					  + ' </div>';
			})
			
		  form +=  '</form>'
		  + '<a class="btn btn-success"  onclick="completeBooking()">Complete Booking</a>';
				
		  document.getElementById('ajax-content').innerHTML = form;
		  
		}
		
}