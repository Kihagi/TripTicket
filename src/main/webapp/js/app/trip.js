
var trip = App.extend(App.Cmp, {
	modelId: 'trip',
	httpUrl: './trip',
	responseTarget: 'ajax-content',
	model:[{
		id: 'arrivalTime',
		label: 'Arrival Time',
		name: 'arrivalTime',
		type: 'text',
		required : 'required'
	},{
		id: 'depatureTime',
		label: 'Depature Time',
		name: 'depatureTime',
		type: 'text',
		required : 'required'
	},{
		id: 'vehicle',
		label: 'Vehicle',
		name: 'vehicle',
		type: 'select',
		options: [
		    {label: 'KBS 999H', value:'KBS-999H'}, 
	        {label: 'KBB 343T', value:'KBB-343T'}, 
	        {label: 'KBD 342H', value:'KBD-342H'}
	     ]
	},{
		id: 'route',
		label: 'Route',
		name: 'route',
		type: 'select',
		options: [
		    {label: 'MOMBASA - NAIROBI', value:'MOMBASA-NAIROBI'}, 
	        {label: 'NAIROBI - CAMPALA', value:'NAIROBI-CAMPALA'}, 
	        {label: 'ARUSHA - NAIROBI', value:'ARUSHA-NAIROBI'},
	        {label: 'ARUSHA - MOMBASA', value:'ARUSHA-MOMBASA'}
	     ]
	},{
		id: 'price',
		label: 'Price',
		name: 'price',
		type: 'number',
		required : 'required'
	},{
		id: 'id',
		label: '',
		name: 'id',
		hidden: true,
		type: 'hidden',
		required: 'required'
	}],
	aftersubmit: function(){
		var me = this;
		trip.init();
	},
	

});

//(function(){
//	trip.init();
//})();

//
//
//var trip = {
//		list: function(){
//	    	var ajax = new XMLHttpRequest();
//	    	
//	    	ajax.onreadystatechange = function(){
//	    		
//	    		if(ajax.readyState == 4){
//	    			if(ajax.status == 200){
//	    				document.getElementById('ajax-content').innerHTML = ajax.responseText;
//	    			}
//	    		}
//	    	}
//	    	
//	    	ajax.open("GET", "./trips/action", true);
//	    	ajax.send();
//		},
//		add: function(){
//	    	var ajax = new XMLHttpRequest();
//	    	
//	    	ajax.onreadystatechange = function(){
//	    		
//	    		if(ajax.readyState == 4){
//	    			if(ajax.status == 200){
//	    				document.getElementById('ajax-content').innerHTML = ajax.responseText;
//	    			}
//	    		}
//	    	}
//	    	
//	    	ajax.open("GET", "./trip/addTrip.jsp", true);
//	    	ajax.send();
//		},
//		save: function(){
//			var me = this;
//	    	var ajax = new XMLHttpRequest();
//	    	
//	    	var depatureDate = document.getElementById('depatureDate').value;
//	    	var arrivalDate = document.getElementById('arrivalDate').value;
//	    	var route = document.getElementById('route').value;
//	    	var vehicle = document.getElementById('vehicle').value;
//	    	var price = document.getElementById('price').value;
//	    	
//	    	var params = 'depatureDate=' + encodeURIComponent(depatureDate) 
//	    		+ '&arrivalDate=' + encodeURIComponent(arrivalDate)
//	    		+ '&route=' + encodeURIComponent(route)
//	    		+ '&vehicle=' + encodeURIComponent(vehicle)
//	    		+ '&price=' + encodeURIComponent(price);
//	    	
//	    	console.log(params);
//	    	
//	    	ajax.onreadystatechange = function(){
//	    		
//	    		if(ajax.readyState == 4){
//	    			if(ajax.status == 200){
//	    				me.list();
//	    			}
//	    		}
//	    	}
//	    	
//	    	ajax.open("POST", "./trips/action/add", true);
//	    	ajax.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
//	    	ajax.send(params);
//		}
//		
//}


//(function() {
//	App.Cmp.table("./company/action");
//})();
//
//var company = {
//		list : function() {
//			App.Cmp.table("./company/action");
//		}
//	}
//var trips = {
//	list : function() {
//		App.Cmp.table("./trips/action");
//	}
//}




//var trip = {
//		list: function(){
//	    	var ajax = new XMLHttpRequest();
//	    	
//	    	ajax.onreadystatechange = function(){
//	    		
//	    		if(ajax.readyState == 4){
//	    			if(ajax.status == 200){
//	    				document.getElementById('ajax-content').innerHTML = ajax.responseText;
//	    			}
//	    		}
//	    	}
//	    	
//	    	ajax.open("GET", "./trips/action", true);
//	    	ajax.send();
//		},
//		add: function(){
//	    	var ajax = new XMLHttpRequest();
//	    	
//	    	ajax.onreadystatechange = function(){
//	    		
//	    		if(ajax.readyState == 4){
//	    			if(ajax.status == 200){
//	    				document.getElementById('ajax-content').innerHTML = ajax.responseText;
//	    			}
//	    		}
//	    	}
//	    	
//	    	ajax.open("GET", "./trip/addTrip.jsp", true);
//	    	ajax.send();
//		},
//		save: function(){
//			var me = this;
//	    	var ajax = new XMLHttpRequest();
//	    	
//	    	var depatureDate = document.getElementById('depatureDate').value;
//	    	var arrivalDate = document.getElementById('arrivalDate').value;
//	    	var route = document.getElementById('route').value;
//	    	var vehicle = document.getElementById('vehicle').value;
//	    	var price = document.getElementById('price').value;
//	    	
//	    	var params = 'depatureDate=' + encodeURIComponent(depatureDate) 
//	    		+ '&arrivalDate=' + encodeURIComponent(arrivalDate)
//	    		+ '&route=' + encodeURIComponent(route)
//	    		+ '&vehicle=' + encodeURIComponent(vehicle)
//	    		+ '&price=' + encodeURIComponent(price);
//	    	
//	    	console.log(params);
//	    	
//	    	ajax.onreadystatechange = function(){
//	    		
//	    		if(ajax.readyState == 4){
//	    			if(ajax.status == 200){
//	    				me.list();
//	    			}
//	    		}
//	    	}
//	    	
//	    	ajax.open("POST", "./trips/action/add", true);
//	    	ajax.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
//	    	ajax.send(params);
//		}
//		
//}
//
//




//var trip = {
//		list: function(){
//	    	var ajax = new XMLHttpRequest();
//	    	
//	    	ajax.onreadystatechange = function(){
//	    		
//	    		if(ajax.readyState == 4){
//	    			if(ajax.status == 200){
//	    				document.getElementById('ajax-content').innerHTML = ajax.responseText;
//	    			}
//	    		}
//	    	}
//	    	
//	    	ajax.open("GET", "./trips/action", true);
//	    	ajax.send();
//		},
//		add: function(){
//	    	var ajax = new XMLHttpRequest();
//	    	
//	    	ajax.onreadystatechange = function(){
//	    		
//	    		if(ajax.readyState == 4){
//	    			if(ajax.status == 200){
//	    				document.getElementById('ajax-content').innerHTML = ajax.responseText;
//	    			}
//	    		}
//	    	}
//	    	
//	    	ajax.open("GET", "./trip/addTrip.jsp", true);
//	    	ajax.send();
//		},
//		save: function(){
//			var me = this;
//	    	var ajax = new XMLHttpRequest();
//	    	
//	    	var depatureDate = document.getElementById('depatureDate').value;
//	    	var arrivalDate = document.getElementById('arrivalDate').value;
//	    	var route = document.getElementById('route').value;
//	    	var vehicle = document.getElementById('vehicle').value;
//	    	var price = document.getElementById('price').value;
//	    	
//	    	var params = 'depatureDate=' + encodeURIComponent(depatureDate) 
//	    		+ '&arrivalDate=' + encodeURIComponent(arrivalDate)
//	    		+ '&route=' + encodeURIComponent(route)
//	    		+ '&vehicle=' + encodeURIComponent(vehicle)
//	    		+ '&price=' + encodeURIComponent(price);
//	    	
//	    	console.log(params);
//	    	
//	    	ajax.onreadystatechange = function(){
//	    		
//	    		if(ajax.readyState == 4){
//	    			if(ajax.status == 200){
//	    				me.list();
//	    			}
//	    		}
//	    	}
//	    	
//	    	ajax.open("POST", "./trips/action/add", true);
//	    	ajax.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
//	    	ajax.send(params);
//		}
//		
//}


