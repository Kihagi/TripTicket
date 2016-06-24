var company = {
		ajax: function(){
			
		},
		cmp: [{
			id: 'company-name',
			label: 'Company Name',
			name: 'name',
			type: 'text'
		},{
			id: 'company-regno',
			label: 'Registration #',
			name: 'regNo',
			type: 'text'
		},{
			id: 'company-phone_no',
			label: 'Phone #',
			name: 'phoneNo',
			type: 'email'
		},{
			id: 'company-email',
			label: 'Email #',
			name: 'email',
			type: 'email'
		},{
			id: 'company-town',
			label: 'Town',
			name: 'town',
			type: 'text'
		},{
			id: 'company-country',
			label: 'Country',
			name: 'country',
			type: 'text'
		},{
			id: 'company-box',
			label: 'P.O BOX',
			name: 'box',
			type: 'text'
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
	    	
	    	ajax.open("GET", "./company/action", true);
	    	ajax.send();
	    	
			//this.ajax.get('./company/action').update('ajax-content');
		},
		add: function(){
			var me = this;
			var form = '<form>';
			
			me.cmp.forEach(function(el){
				form += '<div class="form-group">'
					  + '  <label>' + el.label + '</label>'
					  + '  <input type="' + el.type + '" name="' + el.name + '" class="form-control" id="' + el.id + '">'
					  + ' </div>';
			})
			
		  form +=  '</form>'
		  + '<a class="btn btn-success"  onclick="company.save()">Save</a>';
				
		  document.getElementById('ajax-content').innerHTML = form;
		  
		},
		submit: true,
		save: function(){
			var me = this;
	    	var ajax = new XMLHttpRequest();
	    	me.submit = true;
	    	
	    	var params = '';
	    	me.cmp.forEach(function(el){
	    		var val = document.getElementById(el.id).value;
	    		if(!val)
	    			me.submit = false;
	    			
	    		params += el.name +'=' + encodeURIComponent(val) + '&';
	    	});
	    	
	    	ajax.onreadystatechange = function(){
	    		
	    		if(ajax.readyState == 4){
	    			if(ajax.status == 200){
	    				me.list();
	    			}
	    		}
	    	}
	    	
	    	ajax.open("POST", "./company/action/add", true);
	    	ajax.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	    	
	    	console.log('About to submit ' + me.submit);
	    	
	    	if(me.submit)
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