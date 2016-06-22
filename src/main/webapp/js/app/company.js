var company = {
		list: function(){
	    	var ajax = new XMLHttpRequest();
	    	
	    	ajax.onreadystatechange = function(){
	    		
	    		if(ajax.readyState == 4){
	    			if(ajax.status == 200){
	    				document.getElementById('ajax-content').innerHTML = ajax.responseText;
	    			}
	    		}
	    	}
	    	
	    	ajax.open("GET", "./company", true);
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
	    	
	    	ajax.open("GET", "./company/add.jsp", true);
	    	ajax.send();
		},
		save: function(){
	    	var ajax = new XMLHttpRequest();
	    	
	    	var companyName = document.getElementById('company-name').value;
	    	var companyRegNo = document.getElementById('company-regno').value;
	    	
	    	var params = 'name=' + companyName + '&regNo=' + companyRegNo;
	    	
	    	ajax.onreadystatechange = function(){
	    		
	    		if(ajax.readyState == 4){
	    			if(ajax.status == 200){
	    				document.getElementById('ajax-content').innerHTML = ajax.responseText;
	    			}
	    		}
	    	}
	    	
	    	ajax.open("POST", "./company/add", true);
	    	ajax.send(params);
		},
		remove: function(){
			console.log("this removes company");
		}
}

function listRoutes(){
	document.getElementById('ajax-content').innerHTML = 'We will load routes here!';
}


(function init(){
	company.list();
})();