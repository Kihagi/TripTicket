var App = App || {};

App.extend = function(proto, literal){
	  var newLiteral = Object.create(proto);
	  Object.keys(literal).forEach(function(k){
		  newLiteral[k] = literal[k];
	  })
	  
	  return newLiteral;
};

App.Cmp = {
		responseTarget: '',
		httpMethod: 'GET',
		async: true,
		httpUrl: '',
		requestParams: '',
		getEl: function(elId){
			return document.getElementById(elId);
		},
		updateTarget: function(resp){
			var me = this;
			me.getEl(me.responseTarget).innerHTML = resp;
		},
		ajaxRequest: function(){
			var me = this;
	    	var xhr = new XMLHttpRequest();
	    	
	    	xhr.onreadystatechange = function(){
	    		
	    		if(xhr.readyState == 4){
	    			if(xhr.status == 200){
	    				me.updateTarget(xhr.responseText);
	    			}
	    		}
	    	}
	    	
	    	xhr.open(me.httpMethod, me.httpUrl, me.async);
	    	if(me.requestParams){
	    		xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	    		xhr.send(me.requestParams);
<<<<<<< HEAD
			}else
=======
	    	}
	    	else
>>>>>>> f03e1ca4f5ef513f2d9072b51f0f9be0376e4c09
	    		xhr.send();
		},
		fromFields: [],
		form:  function(){
			var me = this;
			var form = '<form>';
			
			me.fromFields.forEach(function(el){
				form += '<div class="form-group">'
					+ '<div class="input-group">'
					+ '<div class="input-group-addon">' + el.label + '</div>';
				
				if(el.type == 'select' && el.options){
					form += '<select class="form-control">';
						el.options.forEach(function(opt){
							form += '<option value='+ opt.value + '>' + opt.label + '</option>'
						});
					form += '</select>';
				}else
					form += '  <input type="' + el.type + '" name="' 
						+ el.name + '" class="form-control" id="' + el.id + '">'
					 
			    form += '</div></div>';
			})
			
		  form +=  '</form><a class="btn btn-success" id="' + me.formId+ '-save">Save</a>';
				
		  me.updateTarget(form);
		  
		  me.getEl(me.formId+ '-save').addEventListener("click", function(){
			  me.submitForm();
		  });
	},
	formId: '',
	formUrl: '',
	submitForm: function(){
		var me = this;
		
		var formValues = me.fromFields.filter(function(el){
			var formEl = me.getEl(el.id);
			if(formEl && formEl.value)
				return el;
			
		}).map(function(el){
			var formEl = me.getEl(el.id);
			return encodeURIComponent(el.name) + '=' 
				+ encodeURIComponent(formEl.value);
			
		}).join('&');
		
		me.ajaxRequest.call({
			httpMethod: 'POST',
			httpUrl: me.formUrl,
			requestParams: formValues,
			responseTarget: me.responseTarget,
			updateTarget: function(resp){
				if(me.aftersubmit)
					me.aftersubmit();
			}
		});
		
	},
	tableStore: '',
	table: function(tableUrl){
		var me = this;
<<<<<<< HEAD
		
		me.ajaxRequest.call({
			httpMethod: 'GET',
			httpUrl: tableUrl,
			responseTarget: me.responseTarget,
			updateTarget: function(resp){
				JSON.parse(resp).forEach(function(el){
					console.log(el.name);
				})
			}
		});
=======
		me.responseTarget = 'ajax-content';
		me.httpUrl = tableUrl;
		me.ajaxRequest();
	},
	deleteEntry : function(id){
		var me = this;
		me.ajaxRequest.call({
			httpMethod : 'DELETE',
			httpUrl : "./bookings?id="+id,
			responseTarget : function(resp){
				document.getElementById(me.responseTarget).innerHTML = resp;
			}
		});
		
>>>>>>> f03e1ca4f5ef513f2d9072b51f0f9be0376e4c09
	}
};

(function(){
	App.Cmp.table("./company/action/*");
})();


var list = {
		company: function (){
			App.Cmp.table("./company/action");
		}, 
		route : function (){
			App.Cmp.table("./route/action");
		}
		}
