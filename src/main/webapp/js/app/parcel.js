var parcel = {
		list: function(){
	    	var ajax = new XMLHttpRequest();
	    	
	    	ajax.onreadystatechange = function(){
	    		
	    		if(ajax.readyState == 4){
	    			if(ajax.status == 200){
	    				document.getElementById('ajax-content').innerHTML = ajax.responseText;
	    			}
	    		}
	    	}
	    	
	    	ajax.open("GET", "./parcel/action", true);
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
	    	
	    	ajax.open("GET", "./parcel/addParcel.jsp", true);
	    	ajax.send();
		},
		
		save: function(){
			var me = this;
	    	var ajax = new XMLHttpRequest();
	    	
	    	var parcTo = document.getElementById('parcel-to').value;
	    	var parcFrom = document.getElementById('parcel-from').value;
	    	var parcDescription = document.getElementById('parcel-description').value;
	    	var parcRoute = document.getElementById('parcel-route').value;
	    	var parcCost = document.getElementById('parcel-cost').value;
	    	
	    	var params = 'parcelTo=' + encodeURIComponent(parcTo) 
	    		+ '&parcelFrom=' + encodeURIComponent(parcFrom)
	    		+ '&parcelDescription=' + encodeURIComponent(parcDescription)
	    		+ '&parcelRoute=' + encodeURIComponent(parcRoute)
	    		+ '&parcelCost=' + encodeURIComponent(parcCost);
	    		
	    	
	     console.log(params);
	    	
	    	ajax.onreadystatechange = function(){
	    		
	    		if(ajax.readyState == 4){
	    			if(ajax.status == 200){
	    				me.list();
	    			}
	    		}
	    	}
	    	
	    	ajax.open("POST", "./parcel/action/add", true);
	    	ajax.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	    	ajax.send(params);
		},
		remove: function(){
			console.log("this removes parcel");
		}



}

