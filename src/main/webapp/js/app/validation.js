		validateText : function() {
			var me = this;
			
			me.model.forEach(function(el) {
				if (el.type == "text"){
					var me=this;
					var regularText=/^[a-zA-Z ]*$/;
					var text= document.getElementById(el.id).value;
					var validText=regularText.test(text);
				
						if (validText==false) {
							var me = context;
							me.ajaxRequest.call({
										updateTarget : function() {
											context.document.getElementById("tormValidation").innerHTML = "Please insert valid text";
											context.document.getElementById(el.id).style.backgroundColor ="#f5dddd";
											 	
											
										},
										httpMethod : 'POST',
										httpUrl : "./company"
									});
							return false;
						} 
						else if(text.lenth==null || text==""){
							var me = this;
							me.ajaxRequest.call({
										updateTarget : function() {
											me.document.getElementById("textValidation").innerHTML = "Text cannot be null";
										    me.document.getElementById(el.id).style.backgroundColor ="#f5dddd";
											 	
											
										},
										httpMethod : 'POST',
										httpUrl : "./company"
									});
							return false;
							
						}
						else{
							return true;
						}
			} });
				
				return true;
			
		},
		
		validateEmail: function (){
			
			var me = this;
			me.model.forEach(function(el) {
			if (el.type == 'email'){
				 var context = this;
					var regular= /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
					var email = document.getElementById(el.id).value
						var validEmail = regular.test(email);
					if (email.lenght==0 ||email==""){
				    	me.ajaxRequest.call({				
							updateTarget: function(){
								context.document.getElementById('emailValidation').innerHTML="Email cannot be blank";
								},
							httpMethod: 'POST',
							httpUrl:"./company"
						}); 
				    	return false;
				    }	
					else if (validEmail== false){
						    	me.ajaxRequest.call({				
									updateTarget: function(){
										context.document.getElementById('emailValidation').innerHTML="Email format is not correct";
										},
									httpMethod: 'POST',
									httpUrl:"./company"
								}); 
						    	me.isEmail = false;
						    }
						else{
							me.isEmail = true;
						}
					}
		});
			
		},
		
		isNumber=true;
		validateNumber: function(){
			var me = this;
			me.model.forEach(function(el) {
			if (el.type == 'number'){
				 var context = this;
					var regular=/^\s*(\+|-)?\d+\s*$/;
					var number = document.getElementById(el.id).value
						var validNumber = regular.test(number);
				
						if (validNumber== false){
						    	me.ajaxRequest.call({				
									updateTarget: function(){
										context.document.getElementById('formValidation').innerHTML="Enter a number where required";
										context.document.getElementById('formValidation').style.backgroundColor="#f5dddd";
										
										},
									httpMethod: 'POST',
									httpUrl: "./company"
								}); 
						    	me.isNumber = false;
						    }
						else if (validNumber<10 || validNumber >=12){
					    	me.ajaxRequest.call({				
								updateTarget: function(){
									context.document.getElementById('formValidation').innerHTML="Enter the required numbers of a mobile phone";
									
									},
								httpMethod: 'POST',
								httpUrl: "./company"
							}); 
					    	me.isNumber = false;
					    }
						else{
							return true;
						}
					}
		});
		
		return me.isNumber;
	},
	
	isPassword=true;
	validatePassword: function(){
		var me = this;
		me.model.forEach(function(el) {
		if (el.type == 'password'){
			 var context = this;
				var regularPass=/^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
				var password = document.getElementById(el.id).value
					var validPassword = regular.test(password);
			
					if (validPassword== false){
					    	me.ajaxRequest.call({				
								updateTarget: function(){
									context.document.getElementById('PasswordValidation').innerHTML="Please include a number, uppercase, lowercase and a special character for your password to be valid";
									context.document.getElementById('PasswordValidation').style.backgroundColor="#f5dddd";
									
									},
								httpMethod: 'POST',
								httpUrl: "./company"
							}); 
					    	me.isNumber = false;
					    }
					
					else{
						return true;
					}
				}
	});
	
	return me.isNumber;
},

isSelect=true;
validateSelect: function(){
	var me = this;
	me.model.forEach(function(el) {
	if (el.type == 'select'){
		 var context = this;
			
			var select = document.getElementById(el.id).value
		
				if (select.lengh== "" || select.lenght==null){
				    	me.ajaxRequest.call({				
							updateTarget: function(){
								context.document.getElementById('Please Selet an item in the select area";
								context.document.getElementById('SelectValidation').style.backgroundColor="#f5dddd";
								
								},
							httpMethod: 'POST',
							httpUrl: "./company"
						}); 
				    	me.isSelect = false;
				    }
				
				else{
					return true;
				}
			}
});

return me.isSelect;
},

isCheckbox=true;
validateCheckbox: function(){
	var me = this;
	me.model.forEach(function(el) {
	if (el.type == 'select'){
		 var context = this;
			
			var checkbox = document.getElementById(el.id).value
		
				if (checkbox.lengh== "" || select.lenght==null){
				    	me.ajaxRequest.call({				
							updateTarget: function(){
								context.document.getElementById('Please Selet an item in the checkbox";
								context.document.getElementById('CheckboxValidation').style.backgroundColor="#f5dddd";
								
								},
							httpMethod: 'POST',
							httpUrl: "./company"
						}); 
				    	me.isSelect = false;
				    }
				
				else{
					return true;
				}
			}
});

return me.isSelect;
},

isUsername=true;
validateUsername: function (){
	var me = this;
	me.model.forEach(function(el) {
	if (el.type == 'email'){
		 var context = this;
			var username = document.getElementById(el.id).value
			
			if (username.lenght==0 ||email==""){
		    	me.ajaxRequest.call({				
					updateTarget: function(){
						context.document.getElementById('usernameValidation').innerHTML="Username cannot be blank";
						},
					httpMethod: 'POST',
					httpUrl:"./company"
				}); 
		    	return false;
		    }	
			else if (username<6){
				    	me.ajaxRequest.call({				
							updateTarget: function(){
								context.document.getElementById('usernameValidation').innerHTML="Please enter at least six characters";
								},
							httpMethod: 'POST',
							httpUrl:"./company"
						}); 
				    	me.isEmail = false;
				    }
				else{
					me.ajaxRequest.call({				
						updateTarget: function(){
							context.document.getElementById('usernameValidation').innerHTML="Welcome" + username+ "to TripTicket";
							},
						httpMethod: 'POST',
						httpUrl:"./company"
					});
					me.isEmail = true;
				}
			}
});
	
},
		
			
			
		