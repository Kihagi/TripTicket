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
					+ '<div class="input-group" id="'+ el.id +'_div">'
					+ '<div class="input-group-addon">' + el.label + '</div>';
				console.log(el.id);
				var fun = "shshs";
				if(el.type == 'select' && el.options){
					form += '<select class="form-control" name="' + el.name + '" id="' + el.id + '" onkeyup="CheckEmpty(\''+el.id+'\')">';
						el.options.forEach(function(opt){
							form += '<option value='+ opt.value + '>' + opt.label + '</option>'
						});
					form += '</select>';
				}else
					form += '  <input type="' + el.type + '" name="' + el.name + '" class="form-control" id="' + el.id + '" onkeyup="CheckEmpty(\''+el.id+'\')">';
					 
			    form += '</div></div>';
			})
			
		  form +=  '</form><a class="btn btn-success" name="submit" id="' + me.formId+ '-save">Save</a>';
				
		  me.updateTarget(form);
		  
		  me.getEl(me.formId+ '-save').addEventListener("click", function(){
			  me.submitForm();
		  });
			
			/*
			var formDiv = document.createElement('div');
			
			var form = document.createElement('form');
			
			formDiv.appendChild(form);
			
			
			me.fromFields.forEach(function(el){
				
				var formGroup = document.createElement('div');
				formGroup.setAttribute('class', 'form-group');
				form.appendChild(formGroup);
				
				var inputGroup = document.createElement('div');
				inputGroup.setAttribute('class', 'input-group');
				formGroup.appendChild(inputGroup);
				
				var inputGroupAddon = document.createElement('div');
				inputGroupAddon.setAttribute('class', 'input-group-addon');
				inputGroup.appendChild(inputGroupAddon);
				
				var inputLabel = document.createElement('label');
				inputLabel.innerHTML = el.label;
				inputGroupAddon.appendChild(inputLabel);
				
				if(el.type == 'select' && el.options){
					
					var selectEl = document.createElement('input');
					selectEl.setAttribute('class', 'form-control');
					selectEl.setAttribute('id', el.id);
					selectEl.setAttribute('name', el.name);
					inputGroupAddon.appendChild(selectEl);
					
						el.options.forEach(function(opt){
							var selectOption = document.createElement('input');
							selectOption.setAttribute('value', opt.value);
							selectEl.appendChild(selectOption);
							
							var optionLabel = document.createElement('label');
							optionLabel.innerHTML = opt.value;
							selectOption.appendChild(optionLabel);
						});
					
					var spanError = document.createElement('span');
					spanError.setAttribute('class', 'text-right');
					spanError.setAttribute('style', 'color:red');
					spanError.setAttribute('id', el.id+'vError');
					inputGroupAddon.appendChild(spanError);
					
				}else{
					var inputField = document.createElement('input');
					inputField.setAttribute('type', el.type);
					inputField.setAttribute('name', el.name);
					inputField.setAttribute('id', el.id);
					inputGroupAddon.appendChild(inputField);
					
					
					var spanError = document.createElement('span');
					spanError.setAttribute('class', 'text-right');
					spanError.setAttribute('style', 'color:red');
					spanError.setAttribute('id', el.id+'vError');
					inputGroupAddon.appendChild(spanError);
				}
					
			 
			});
			
			var btnSave = document.createElement('a');
			btnSave.setAttribute('class', 'btn btn-success');
			btnSave.setAttribute('id', me.formId+ '-save');
			
			var saveLabel = document.createElement('label');
			saveLabel.innerHTML = "Save";
			btnSave.appendChild(saveLabel);
			
			form.appendChild(btnSave);
			
			
			me.getEl(me.responseTarget).appendChild(formDiv);
		 
		  me.getEl(me.formId+ '-save').addEventListener("click", function(){
			  
			  /*validation
			  var error = 0;
			   
			  me.fromFields.forEach(function(el){
			    	
				  var input = document.getElementById(el.id).value;
			    	
			    	if (input.length == 0) {
				    
				        document.getElementById('' + el.id + 'vError').innerHTML = el.label+" is required";
				        error++;
				    } else {
				     
				        document.getElementById('' + el.id + 'vError').innerHTML = '';
				    }
			    	
			    
			    });
			  /*end of validation
			    if(error==0)			  
			    	me.submitForm();
			    else
			    	return false;
			  
			  
		  });
		  */  
		  
	},
	formId: '',
	formUrl: '',
	submitForm: function(){
		var me = this;
		
		var formValues = me.fromFields.filter(function(el){
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
				
				var dataDiv = document.createElement('div');
				
				var addDiv = document.createElement('div');
				addDiv.setAttribute('class', 'text-right');
				dataDiv.appendChild(addDiv);
				
				var addButton = document.createElement('a');
				addButton.setAttribute('class', 'btn btn-success');
				addButton.setAttribute('onclick', 'company.form()');
				
				var addLabel = document.createElement('label');
				addLabel.innerHTML = "Add";
				addButton.appendChild(addLabel);
				
				addDiv.appendChild(addButton);
				
				var table = document.createElement('table');
				table.setAttribute('class', 'table table-striped responsive-utilities jambo_table');
				dataDiv.appendChild(table);
				
				var tHead = document.createElement('thead');
				table.appendChild(tHead);
				
				var tHeadRow = document.createElement('tr');
				tHeadRow.setAttribute('class', 'headings');
				tHead.appendChild(tHeadRow);
				
				me.fromFields.forEach(function(model){
					var headers = document.createElement('th');
					tHeadRow.appendChild(headers);
					
					var headerData = model.label;
					
					headers.innerHTML = headerData;
				
				});
								
				var tbody = document.createElement('tbody');
				tbody.setAttribute('style', "font-size:12px");
				table.appendChild(tbody);
				
				
				JSON.parse(resp).forEach(function(el){
					var dataRow = document.createElement('tr');
					tbody.appendChild(dataRow);
					
						me.fromFields.forEach(function(model){
							var data = el[model.name];
							
							var td = document.createElement('td');
							td.innerHTML = data;
							dataRow.appendChild(td);
											
							
							
						});
						
						var td = document.createElement('td');
						dataRow.appendChild(td);
						
						var edit = document.createElement('a');
						edit.setAttribute('class', 'btn btn-primary btn-xs');
						edit.setAttribute('onclick', 'company.loadForm('+el.id+')');
						
						var editLabel = document.createElement('label');
						editLabel.innerHTML = "Edit";
						edit.appendChild(editLabel);
						
						var space = document.createElement('label');
						space.innerHTML = "  ";
												
						var remove = document.createElement('a');
						remove.setAttribute('class', 'btn btn-danger btn-xs');
						remove.setAttribute('onclick', 'company.remove('+el.id+')');
						
						var removeLabel = document.createElement('label');
						removeLabel.innerHTML = "Delete";
						remove.appendChild(removeLabel);
						
						td.appendChild(edit);
						td.appendChild(space);
						td.appendChild(remove);
					
				});
				me.getEl(me.responseTarget).appendChild(dataDiv);
				
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
				
				table += '</table>';
				
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
				*/
			}
		});
	},
	init: function(){
		this.table("./company");
	}
};


//function for displaying warnings
function displayWarning(field_id, parent_div, message){
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
function removeWarning(field_id, parent_div){
	var error_element = document.getElementById(parent_div).querySelectorAll(".error_msg");
	if(error_element.length > 0){
		error_element[0].parentNode.removeChild(error_element[0]);
		document.getElementById(field_id).classList.remove("error_msg");
		
	}
	document.getElementById(field_id).className += " success_brd";
	
	var submitButton = document.getElementById(btn);
	submitButton.disabled=false;
	
}


function CheckEmpty(field_id){
	var MyFieldId = document.getElementById(field_id);
	if(MyFieldId.value == "" || MyFieldId.value == null){
		displayWarning(field_id, MyFieldId.parentNode.id, "Required");	 
	}
	else{
		removeWarning(field_id, MyFieldId.parentNode.id);
	}
}

//email
function ValidateEmail(email){
	var MyEmailId = document.getElementById(email);
	var format = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/;
	
	if(!MyEmailId.value.match(format)){
		displayWarning(email, MyEmailId.parentNode.id, "You have a fucked up email!");	 
	}
	else{
		removeWarning(email, MyEmailId.parentNode.id);
	}
}

//password
function ValidatePassword(password){
	var MyPasswordId = document.getElementById(password);
	var format = /(?=^.{8,}$)(?=.*\d)(?=.*[!@#$%^&*]+)(?![.\n])(?=.*[A-Z])(?=.*[A-Z]).*$/;	
	if(!MyPasswordId.value.match(format)){
		displayWarning(password, MyPasswordId.parentNode.id, "The password must have uppercase, lowercase, numeric and special characters and at least 8 characters long");
	}
	else{
		removeWarning(password, MyPasswordId.parentNode.id);
	}
}

//confirm password
function ConfirmPassword(password, confirm_password){
	var MyPassword = document.getElementById(password).value;
	var confirmpasswordId	= document.getElementById(confirm_password);
	
	if(confirmpasswordId.value != MyPassword){
		displayWarning(confirm_password, confirmpasswordId.parentNode.id, "Password and Confirm Password must match bitch!!");
		
	}
	else{
		removeWarning(confirm_password, confirmpasswordId.parentNode.id);
	}
}

//checkboxes
function ValidateCheckbox(checkbox){
	var check_boxId = document.getElementById(checkbox);
	if(check_boxId.checked == false){
		displayWarning(checkbox, check_boxId.parentNode.id, "Required");	
	}
	else{
		removeWarning(checkbox, check_boxId.parentNode.id);
	}
}

//validate selects
function ValidateSelect(selected){
	var selectedId = document.getElementById(selected);
	if(selectedId.selectedIndex == 0){
		displayWarning(selected, selectedId.parentNode.id, "Required");	
			
	}
	else{
		removeWarning(selected, selectedId.parentNode.id);
	}
	
}
