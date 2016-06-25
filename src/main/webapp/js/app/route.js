var route = {
		list: function(){
	    	var ajax = new XMLHttpRequest();
	    	
	    	ajax.onreadystatechange = function(){
	    		
	    		if(ajax.readyState == 4){
	    			if(ajax.status == 200){
	    				document.getElementById('ajax-content').innerHTML = ajax.responseText;
	    			}
	    		}
	    	}
	    	
	    	ajax.open("GET", "./route/action", true);
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
	    	
	    	ajax.open("GET", "./route/addRoute.jsp", true);
	    	ajax.send();
		},
		save: function(){
			var me = this;
	    	var ajax = new XMLHttpRequest();
	    	
	    	var routeTime = document.getElementById('route-time').value;
	    	var routeCompany = document.getElementById('route-company').value;
	    	var routeDistance = document.getElementById('route-distance').value;
	    	var routeFrom  = document.getElementById('from-location').value;
	    	var routeTo     = document.getElementById('to-location').value;
	    	
	    	var params = 'ApproxTime=' + encodeURIComponent(routeTime)
	    				+ '&companyId=' + encodeURIComponent(routeCompany)
	    				+ '&distance=' + encodeURIComponent(routeDistance)
	    				+ '&fromLocationId=' + encodeURIComponent(routeFrom)
	    				+ '&toLocationId=' + encodeURIComponent(routeTo);
	    	
	    	console.log(params);
	    	
	    	ajax.onreadystatechange = function(){
	    		
	    		if(ajax.readyState == 4){
	    			if(ajax.status == 200){
	    				me.list();
	    			}
	    		}
	    	}
	    	
	    	ajax.open("POST", "./route/action/add", true);
	    	ajax.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	    	ajax.send(params);
		}
		
}


