/*App.Cmp.form.validate = function(el){
	var validEmailformat = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/;
	
	var submitButton = document.getElementById("myBtn").disabled;
	submitButton = true;
	
	if(el.required == true && el.value == null || el.value == ""){
		this.displayWarning(el.id, el.value.parentNode.id, "Required");	
	},
	if(el.type == 'email' && el.value != validEmailformat){
		this.displayWarning(el.id, el.value.parentNode.id, "invalid email format");	
	},
	
	if(el.type == 'number'){
		var regular=/^\s*(\+|-)?\d+\s*$/;
		var number = document.getElementById(el.id).value
		var validNumber = regular.test(number);
		if(validNumber == false)
			this.displayWarning(el.id, el.value.parentNode.id, "enter a number");	
	},
			
	if(el.type == 'password' && el.value.length <= 7){
		this.displayWarning(el.id, el.value.parentNode.id, "must be 8 or more characters");	
	} else{
		var password = document.getElementById(password).value;
		var confirmpassword	= document.getElementById(confirm_password).value;
			if(password != confirmpassword)
				this.displayWarning(checkbox, check_boxId.parentNode.id, "password mismatch");		
			}
	
	submitButton = false;
				
	}

App.Cmp.form.displayWarning = function(field_id, parent_div, message){
	var x = document.getElementById(parent_div).querySelectorAll(".error_msg").length; //gets the number of p elements(with class 'error_msg') that are already present in the parent element
	if(x == 0)
	{
		var paragraph = document.createElement("p");
		paragraph.setAttribute('class', 'error_msg');
		
		var error_msg = document.createTextNode(message);
		paragraph.appendChild(error_msg);
		
		var parentDiv = document.getElementById(parent_div);
		parentDiv.appendChild(paragraph);
		
		var field_id = document.getElementById(field_id);
		field_id.className += " warning_brd"; 
	
	}
}*/

validate: function(el){
	var validEmailformat = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/;
	
	var submitButton = document.getElementById( "' + me.modelId+ '-save").disabled;
	submitButton = true;
	
	if(el.required == true && el.value == null || el.value == ""){
		this.displayWarning(el.id, el.value.parentNode.id, "Required");	
	}
	if(el.type == 'email' && el.value != validEmailformat){
		this.displayWarning(el.id, el.value.parentNode.id, "invalid email format");	
	}
	
	if(el.type == 'number'){
		var regular=/^\s*(\+|-)?\d+\s*$/;
		var number = document.getElementById(el.id).value
		var validNumber = regular.test(number);
		if(validNumber == false)
			this.displayWarning(el.id, el.value.parentNode.id, "enter a number");	
	}
			
	if(el.type == 'password' && el.value.length <= 7){
		this.displayWarning(el.id, el.value.parentNode.id, "must be 8 or more characters");	
	} else{
		var password = document.getElementById(password).value;
		var confirmpassword	= document.getElementById(confirm_password).value;
			if(password != confirmpassword)
				this.displayWarning(el.id, el.value.parentNode.id, "password mismatch");		
			}
	
	submitButton = false;
				
	},

displayWarning: function(field_id, parent_div, message){
	var x = document.getElementById(parent_div).querySelectorAll(".error_msg").length; //gets the number of p elements(with class 'error_msg') that are already present in the parent element
	if(x == 0)
	{
		var paragraph = document.createElement("p");
		paragraph.setAttribute('class', 'error_msg');
		
		var error_msg = document.createTextNode(message);
		paragraph.appendChild(error_msg);
		
		var parentDiv = document.getElementById(parent_div);
		parentDiv.appendChild(paragraph);
		
		var field_id = document.getElementById(field_id);
		field_id.className += " warning_brd"; 
	
	}
},

