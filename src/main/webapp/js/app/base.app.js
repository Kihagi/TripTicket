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
			}else
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
	loadForm : function(id){
		var me = this;
		
		me.ajaxRequest.call({
			httpMethod: me.httpMethod,
			httpUrl: me.formUrl + '/load?id=' + id,
			responseTarget: me.responseTarget,
			updateTarget: function(resp){
				me.form();
				var result = JSON.parse(resp);
				me.fromFields.forEach(function(el){
					Object.keys(result).forEach(function(k){
						if(el.name == k){
							console.log(el.id + '=' + result[k]);
							me.getEl(el.id).value = result[k];
						}
					  })
				})
			}
		});
		
	},
	tableStore: '',
	table: function(tableUrl){
		var me = this;
		
		me.ajaxRequest.call({
			httpMethod: 'GET',
			httpUrl: tableUrl,
			responseTarget: me.responseTarget,
			updateTarget: function(resp){
				/*var table = '<table class="table">';
				table += '<tr>';
				
				me.fromFields.forEach(function(model){
					table += '<th>' + model.label + '</th>';
				});
				table += '</tr>';
				
				JSON.parse(resp).forEach(function(el){
					table += '<tr>';
						me.fromFields.forEach(function(model){
							table += '<td>' + el[model.name] + '</td>';
						});
					table += '</tr>';
				});
				
				table += '</table>';*/
				
				var table = "<div class=\"text-right\">";
				table += "<a class=\"btn btn-success\"  onclick=\"company.form()\">Add</a>";
				table += "</div>";
		
				JSON.parse(resp).forEach(function(el){
					table += "<hr>";
			    	table += "<div class=\"row\">";
			    	table += "<div class=\"col-md-12\">";
			    	table += "<span class=\"glyphicon glyphicon-star\"></span>";
			    	table += "<span class=\"glyphicon glyphicon-star\"></span>";
			    	table += "<span class=\"glyphicon glyphicon-star\"></span>";
			    	table += " <span class=\"glyphicon glyphicon-star\"></span>";
			    	table += "<span class=\"glyphicon glyphicon-star-empty\"></span>";
			    	table += el.name + " : " + el.regNo;
			    	table += "<span class=\"pull-right\">10 days ago</span>";
			    	table += "<p>This trip was great in terms of services. I would definitely recomend it to someone else.</p>";
			    	table += "</div>";
			    	table += "</div>";
			    	
			    	table += "<div class=\"text-right\">";
			    	table += "<a class=\"btn btn-primary\"  onclick=\"company.loadForm(" + el.id + ")\">Edit</a>";
			    	table += "<a class=\"btn btn-danger\"  onclick=\"company.remove(" + el.id + ")\">Delete</a>";
			        table += "<a class=\"btn btn-success\"  onclick=\"tripLocation.list()\">location</a>";
			        table += "</div>";
				});
				
				me.getEl(me.responseTarget).innerHTML = table;
			}
		});
	},
	init: function(){
		this.table("./company");
	}
};