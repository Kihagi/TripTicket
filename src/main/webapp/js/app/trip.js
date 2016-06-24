var trip = {
		list: function(){
	    	var ajax = new XMLHttpRequest();
	    	
	    	ajax.onreadystatechange = function(){
	    		
	    		if(ajax.readyState == 4){
	    			if(ajax.status == 200){
	    				document.getElementById('ajax-content').innerHTML = ajax.responseText;
	    			}
	    		}
	    	}
	    	
	    	ajax.open("GET", "./trips/action", true);
	    	ajax.send();
		},
		add: function(){
	    	var ajax = new XMLHttpRequest();
	    	
	    	ajax.onreadystatechange = function(){
	    		
	    		if(ajax.readyState == 4){
	    			if(ajax.status == 200){
	    				document.getElementById('ajax-content').innerHTML = ajax.responseText;
	    			}
	    		}
	    	}
	    	
	    	ajax.open("GET", "./trip/addTrip.jsp", true);
	    	ajax.send();
		},
		save: function(){
			var me = this;
	    	var ajax = new XMLHttpRequest();
	    	
	    	var depatureDate = document.getElementById('depatureDate').value;
	    	var arrivalDate = document.getElementById('arrivalDate').value;
	    	var route = document.getElementById('route').value;
	    	var vehicle = document.getElementById('vehicle').value;
	    	var price = document.getElementById('price').value;
	    	
	    	var params = 'depatureDate=' + encodeURIComponent(depatureDate) 
	    		+ '&arrivalDate=' + encodeURIComponent(arrivalDate)
	    		+ '&route=' + encodeURIComponent(route)
	    		+ '&vehicle=' + encodeURIComponent(vehicle)
	    		+ '&price=' + encodeURIComponent(price);
	    	
	    	console.log(params);
	    	
	    	ajax.onreadystatechange = function(){
	    		
	    		if(ajax.readyState == 4){
	    			if(ajax.status == 200){
	    				me.list();
	    			}
	    		}
	    	}
	    	
	    	ajax.open("POST", "./trips/action/add", true);
	    	ajax.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	    	ajax.send(params);
		}
		
}


