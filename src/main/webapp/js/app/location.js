var tripLocation = {
		
		loc: [{
			id: 'loc_Id',
			label: 'Location Number',
			name: 'locNo',
			type: 'text',
		},{
			id: 'loc_Name',
			label: 'Location Name',
			name: 'name',
			type: 'text',
		},{
			id: 'loc_Descr',
			label: 'Description',
			name: 'Descr',
			type: 'text',
		}],
		
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
						
			var me = this;
			var form = '<form>';
			
			me.loc.forEach(function(el){
				form += '<div class="form-group">'
					  + '  <label>' + el.label + '</label>'
					  + '  <input type="' + el.type + '" name="' + el.name + '" class="form-control" id="' + el.id + '">'
					  + ' </div>';
			})
			
		  form +=  '</form>'
		  + '<button class="btn btn-large btn-success" id="submit"  onclick="tripLocation.save()">Submit</button>';
				
		  document.getElementById('ajax-content').innerHTML = form;
		  
		},
		submitForm: true,
		save: function(){
			var me = this;
	    	var ajax = new XMLHttpRequest();
	    	me.submitForm = true;
	    	
	    	var params = '';
	    	me.loc.forEach(function(el){
	    		var val = document.getElementById(el.id).value;
	    		if(!val)
	    			me.submitForm = false;
	    			
	    		params += el.name +'=' + encodeURIComponent(val) + '&';
	    	});
	    	
	    	
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
		remove: function(id){
			var me = this;
	    	var ajax = new XMLHttpRequest();
	    	
	    	ajax.onreadystatechange = function(){
	    		
	    		if(ajax.readyState == 4){
	    			if(ajax.status == 200){
	    				me.list();
	    			}
	    		}
	    	}
	    	
	    	ajax.open("DELETE", "./location/?id="+id, true);
	    	ajax.send();
		}
}
