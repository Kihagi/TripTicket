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
		model: [],
		form:  function(){
			var me = this;
			var form = '<form>';
			
			me.model.forEach(function(el){
				form += '<div class="form-group">'
					+ '<div class="input-group">'
					+ '<div class="input-group-addon">' + el.label + '</div>';
				
				if(el.type == 'select' && el.options){
					form += '<select class="form-control" name="' + el.name + '" id="' + el.id + '">';
						el.options.forEach(function(opt){
							form += '<option value='+ opt.value + '>' + opt.label + '</option>'
						});
					form += '</select>';
				}else
					form += '  <input type="' + el.type + '" name="' 
						+ el.name + '" class="form-control" id="' + el.id + '">'
					 
			    form += '</div></div>';
			})
			
		  form +=  '</form><a class="btn btn-success" id="' + me.modelId+ '-save">Save</a>';
				
		  if(me.updateTarget(form)){
			  me.model.forEach(function(el){
				  me.getEl(el.id).addEventListener("keyup", function(){
					  me.form.validate(el);
				  });
			  })
		  }
		  
		  me.getEl(me.modelId+ '-save').addEventListener("click", function(){
			  me.submitForm();
		  });
	},
	submitForm: function(){
		var me = this;
		
		var formValues = me.model.filter(function(el){
			var formEl = me.getEl(el.id);
			if(!formEl) return;
			
			if(!formEl.value) return;
			
			el.value = formEl.value;
			
			return el;
			
		}).map(function(el){
			return encodeURIComponent(el.name) + '=' 
				+ encodeURIComponent(el.value);
		}).join('&');
		
		me.ajaxRequest.call({
			httpMethod: 'POST',
			httpUrl: me.httpUrl,
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
			httpUrl: me.httpUrl + '/load?id=' + id,
			responseTarget: me.responseTarget,
			updateTarget: function(resp){
				me.form();
				var result = JSON.parse(resp);
				me.model.forEach(function(el){
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
	removeRec: function(id){
		var me = this;
		
		me.ajaxRequest.call({
			httpMethod: 'DELETE',
			httpUrl: me.httpUrl+'?id=' + id,
			responseTarget: me.responseTarget,
			updateTarget: function(resp){
				me.init();
			}
		});
		
	},
	listView: function(){
		var me = this;
		
		me.ajaxRequest.call({
			httpMethod: me.httpMethod,
			httpUrl: me.httpUrl,
			responseTarget: me.responseTarget,
			updateTarget: function(resp){
					var listView = "<div class=\"text-right\">";
					listView += "<a class=\"btn btn-success\"  onclick=\"company.form()\">Add</a>";
					listView += "</div>";
					
					var jsonRecords = JSON.parse(resp);
			
					jsonRecords.forEach(function(el){
						var editId = me.modelId + "-edit-" + el.id;
						var delId = me.modelId + "-del-" + el.id;
						
						listView += "<hr>";
						listView += "<div class=\"row\">";
						listView += "<div class=\"col-md-12\">";
						listView += "<span class=\"glyphicon glyphicon-star\"></span>";
						listView += "<span class=\"glyphicon glyphicon-star\"></span>";
						listView += "<span class=\"glyphicon glyphicon-star\"></span>";
						listView += " <span class=\"glyphicon glyphicon-star\"></span>";
						listView += "<span class=\"glyphicon glyphicon-star-empty\"></span>";
						listView += el.name + " : " + el.regNo;
						listView += "<span class=\"pull-right\">10 days ago</span>";
						listView += "<p>This trip was great in terms of services. I would definitely recomend it to someone else.</p>";
						listView += "</div>";
						listView += "</div>";
						listView += "<div class=\"text-right\">";
						listView += "<a class=\"btn btn-primary\"  id=\"" + editId + "\">Edit</a>";
						listView += " | <a class=\"btn btn-danger\"  id=\"" + delId + "\">Delete</a>";
						listView += "</div>";
				});
				
				if(me.getEl(me.responseTarget).innerHTML = listView){
						jsonRecords.forEach(function(el){
							var editId = me.modelId + "-edit-" + el.id;
							var delId = me.modelId + "-del-" + el.id;
								
							me.getEl(editId).addEventListener('click', function(){
								me.loadForm(el.id);
							});
							
							me.getEl(delId).addEventListener('click', function(){
								me.removeRec(el.id);
							});
					});
				}
			}
		});
	},
	
	loadUrl:'',
	formUrl:'',
	remove: function (delUrl){
		var me  = this;
		
		me.ajaxRequest.call({
			httpMethod: 'DELETE',
			httpUrl:me.httpUrl + '?id='+delUrl,
			async: true,
			updateTarget: function(resp){
				me.init;
			}			
		});
	},
	
	init: function(){
		this.listView(this.httpUrl);
	}
};


App.Cmp.form.validate = function(el){
	var valid = {
			validEmail: true,
			required: true,
			validSelect: true
	};
	
	if(el.type == 'email'){
		valid.validEmail = ValidateEmail(el.id);
		valid.message = '';
	}
	
	if(el.required == 'required')
		valid.required = CheckEmpty(el.id);
		
	if(el.type == 'select')
		valid.validSelect = ValidateSelect(el.id);
		
	this.displayWarning.call(valid, el);

}

App.Cmp.form.CheckEmpty = function(field_id){
	var MyFieldId = document.getElementById(field_id);
	if(MyFieldId.value == "" || MyFieldId.value == null){
		this.displayWarning(field_id, MyFieldId.parentNode.id, "Required");	 
	}
	else{
		this.removeWarning(field_id, MyFieldId.parentNode.id);
	}
}

//function for displaying warnings
App.Cmp.form.displayWarning = function(field_id, parent_div, message){
	//prevent duplication of error message using if.. It 
	var x = document.getElementById(parent_div).querySelectorAll(".error_msg").length; //gets the number of p elements(with class 'error_msg') that are already present in the parent element
	if(x == 0)
	{
		//
		var paragraph = document.createElement("p");
		paragraph.setAttribute('class', 'error_msg');
		
		var error_msg = document.createTextNode(message);
		paragraph.appendChild(error_msg);
		
		var parentDiv = document.getElementById(parent_div);
		parentDiv.appendChild(paragraph);
		
		//place redborder on input field
		var field_id = document.getElementById(field_id);
		field_id.className += " warning_brd"; //add a new css class to it by preceeding the class name with space " xxx"
		
		//after displaying warning, disable submit button
		
		var submitButton = document.getElementById(btn);
		submitButton.disabled=true;
		
	
	}
}

//remove the warning
App.Cmp.form.removeWarning = function(field_id, parent_div){
	var error_element = document.getElementById(parent_div).querySelectorAll(".error_msg");
	if(error_element.length > 0){
		error_element[0].parentNode.removeChild(error_element[0]);
		document.getElementById(field_id).classList.remove("error_msg");
		
	}
	document.getElementById(field_id).className += " success_brd";
	
	var submitButton = document.getElementById(btn);
	submitButton.disabled=false;
	
}

//email
App.Cmp.form.ValidateEmail = function(email){
	var MyEmailId = document.getElementById(email);
	var format = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/;
	
	if(!MyEmailId.value.match(format)){
		this.displayWarning(email, MyEmailId.parentNode.id, "Invalid email!");	 
	}
	else{
		removeWarning(email, MyEmailId.parentNode.id);
	}
}

//password
App.Cmp.form.ValidatePassword = function(password){
	var MyPasswordId = document.getElementById(password);
	var format = /(?=^.{8,}$)(?=.*\d)(?=.*[!@#$%^&*]+)(?![.\n])(?=.*[A-Z])(?=.*[A-Z]).*$/;	
	if(!MyPasswordId.value.match(format)){
		this.displayWarning(password, MyPasswordId.parentNode.id, "The password must have uppercase, lowercase, numeric and special characters and at least 8 characters long");
	}
	else{
		this.removeWarning(password, MyPasswordId.parentNode.id);
	}
}

//confirm password
App.Cmp.form.ConfirmPassword = function(password, confirm_password){
	var MyPassword = document.getElementById(password).value;
	var confirmpasswordId	= document.getElementById(confirm_password);
	
	if(confirmpasswordId.value != MyPassword){
		this.displayWarning(confirm_password, confirmpasswordId.parentNode.id, "Password and Confirm Password must match");
		
	}
	else{
		this.removeWarning(confirm_password, confirmpasswordId.parentNode.id);
	}
}

//checkboxes
App.Cmp.form.ValidateCheckbox = function(checkbox){
	var check_boxId = document.getElementById(checkbox);
	if(check_boxId.checked == false){
		this.displayWarning(checkbox, check_boxId.parentNode.id, "Required");	
	}
	else{
		this.removeWarning(checkbox, check_boxId.parentNode.id);
	}
}

//validate selects
App.Cmp.form.ValidateSelect = function(selected){
	var selectedId = document.getElementById(selected);
	if(selectedId.selectedIndex == 0){
		this.displayWarning(selected, selectedId.parentNode.id, "Required");	
			
	}
	else{
		this.removeWarning(selected, selectedId.parentNode.id);
	}
	
}
