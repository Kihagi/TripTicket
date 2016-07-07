var parcel = App.extend(App.Cmp, {
		formId:'parcel',
		formUrl:'./parcel',
		responseTarget:'ajax-content',
		fromFields:[{
			id:'parcel-to',
			label:'Parcel To',
			name:'parcelTo',
			type:'text',
			
		},{
			id:'parcel-from',
			label:'Parcel From',
			name:'parcelFrom',
			type:'text'
		},{
			id:'parcel-description',
			label:'Parcel Description',
			name:'parcelDescription',
			type:'text'
		},{
			id: 'parcel-route',
			label: 'Parcel Route',
			name: 'route',
			type: 'select',
			options: [
			    {label: 'Nairobi-Mombasa', value:'NAI-MBSA'}, 
		        {label: 'Nairobi-Kisumu', value:'NAI-KIS'}, 
		        {label: 'Nairobi-Nakuru', value:'NAI-NKR'},
		        {label: 'Nairobi-Machakos', value:'NAI-MCHKS'}
		     ]
		},{
			id:'parcel-cost',
			label:'Parcel Cost',
			name:'parcelCost',
			type:'number'
		},{
			id:'parcel-id',
			label:'',
			name:'id',
			hidden:'true',
			type:'hidden'
		}],
			aftersubmit: function(){
				var me = this;
				me.table("./parcel");
			},
			
			
		
	});

	/*(function(){
		parcel.init();
	})();*/
		

/*afterRemove: function(){
var me = this;
me.table("./parcel");
},*/
	
	/*list: function(){
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

*/