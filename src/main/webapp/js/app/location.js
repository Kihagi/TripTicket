var tripLocation = {
		list: function(){
	    	var ajax = new XMLHttpRequest();
	    	
	    	ajax.onreadystatechange = function(){
	    		
	    		if(ajax.readyState == 4){
	    			if(ajax.status == 200){
	    				document.getElementById('ajax-content').innerHTML = ajax.responseText;
	    			}
	    		}
	    	}
	    	
	    	ajax.open("GET", "./location/*", true);
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
	    	
	    	ajax.open("GET", "./offices/addlocation.jsp", true);
	    	ajax.send();
			
		},
		
		save: function(){
			var me = this;
	    	var ajax = new XMLHttpRequest();
	    	
	    	var locationName = document.getElementById('loc_Name').value;
	    	var locationNum = document.getElementById('loc_Id').value;
	    	var locationDescr = document.getElementById('loc_Descr').value;
	    	
	    	var params = 'name=' + encodeURIComponent(locationName) 
	    		+ '&number=' + encodeURIComponent(locationNum) + '&Description=' + encodeURIComponent(locationDescr);
	    	
	    	console.log(params);
	    	
	    	ajax.onreadystatechange = function(){
	    		
	    		if(ajax.readyState == 4){
	    			if(ajax.status == 200){
	    				me.list();
	    			}
	    		}
	    	}
	    	
	    	ajax.open("POST", "./location/add", true);
	    	ajax.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	    	ajax.send(params);
		},
		remove: function(){
			console.log("this removes company");
		}
}
