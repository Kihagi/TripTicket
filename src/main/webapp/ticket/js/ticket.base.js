var Ticket = Ticket || {};

Ticket.extend = function(proto, literal) {
	var newLiteral = Object.create(proto);
	Object.keys(literal).forEach(function(k) {
		newLiteral[k] = literal[k];
	})

	return newLiteral;
};

Ticket.Tck = {
	responseTarget : '',
	httpMethod : 'GET',
	async : true,
	httpUrl : '',
	requestParams : '',
	getEl : function(elId) {
		return document.getElementById(elId);
	},
	updateTarget : function(resp) {
		var me = this;
		me.getEl(me.responseTarget).innerHTML = resp;
	},
	ajaxRequest : function() {
		var me = this;
		var xhr = new XMLHttpRequest();

		xhr.onreadystatechange = function() {

			if (xhr.readyState == 4) {
				if (xhr.status == 200) {
					me.updateTarget(xhr.responseText);
				}
			}
		}

		xhr.open(me.httpMethod, me.httpUrl, me.async);
		if (me.requestParams) {
			xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
			xhr.send(me.requestParams);
		} else
			xhr.send();
	},
	validate : function() {

		var me = this;

		me.nullChecker();
		me.numberChecker();
		me.mailChecker();
		me.submitForm();
	},
	number : true,
	numberChecker : function() {
		var me = this;

		me.model.forEach(function(el) {
			var context = this;

			if (el.type == "number") {

				var numberValue = document.getElementById(el.id).value;
				var numberReg = /^\s*(\+|-)?\d+\s*$/;

				var valid = numberReg.test(numberValue);
				var fieldId = document.getElementById(el.id);
				if (valid == false) {

					me.ajaxRequest.call({
						updateTarget : function() {
							me.commonError("Incorrect Number format", el.id, fieldId);

						},
						httpMethod : 'POST',
						httpUrl : me.httpUrl
					});

					me.number = false;

				} else {
					me.commonOkay(el.id);
					me.number = true;

				}

			}

		});
		return me.number;
	},
	email : true,
	mailChecker : function() {
		var me = this;

		me.model.forEach(function(el) {
			var context = this;

			if (el.type == "email") {

				var compare = document.getElementById(el.id).value;

				var reg = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

				var tested = reg.test(compare);
				var fieldId = document.getElementById(el.id);
				if (tested == false) {

					me.ajaxRequest.call({
						updateTarget : function() {
							me.commonError("Incorrect Email format",
									el.id, fieldId);

						},
						httpMethod : 'POST',
						httpUrl: me.httpUrl

					});

					me.email = false;

				} else {
					me.commonOkay(el.id);
					me.email = true;

				}
			}
		});

		return me.email;
	},

	commonError : function(errorMsg, myId, fieldId) {

		var para = document.createElement("p");
		para.setAttribute('style', 'color:red; font-size:11');
		para.setAttribute('id', 'para');

		var errorMsg = document.createTextNode(errorMsg);
		para.appendChild(errorMsg);

		var parentDivId = fieldId.parentNode.id;
		var parentDiv = document.getElementById(parentDivId);

		//var NumberOfchildren = parentDiv.childNodes.length;// gets the number
		// of children

		/*console.log(NumberOfchildren);
		if (NumberOfchildren <= 3)// ensures repetition of multiclick errors
			// is avoided
			parentDiv.appendChild(para);
		*/
		
		document.getElementById(myId).style.backgroundColor = "#f5dddd";
		document.getElementById(myId).style.borderColor = "red";
		document.getElementById(myId).style.color = "red";
	},

	commonOkay : function(myId) {
		/*if (document.getElementById("para") != null) {
			var element = document.getElementById("para");
			element.outerHTML = "";
			delete element;
		}*/

		document.getElementById(myId).style.backgroundColor = "#e1ffdc";
		document.getElementById(myId).style.borderColor = "#1b9506";
		document.getElementById(myId).style.color = "#1b9506";
	},
	Null : true,
	nullChecker : function() {
		var me = this;
		me.model.forEach(function(el) {
			if (el.required) {
				var field = me.getEl(el.id);
				var value = field.value;

				if (value) {
					me.commonOkay(el.id);
					me.Null = false;
				} else 
					me.commonError("required", el.id, field);
			}
		});

		return me.Null;

	},
	model : [],
	RouteForm : function() {
		var me = this;
		
		
		
		var form = '<div class="row">';
		form += '<form>';
	
		me.model.forEach(function(el) {
			if (el.type == 'select' && el.options) {
				
				form += '<div class="col-md-6">'
							+'<div class="row">'
								+'<div class="col-xs-6">'
				
									form += '<select class="cs-select cs-skin-elastic" name="' + el.name
											+ '" id="' + el.id + '">'
												+'<option value="" disabled selected>Route</option>';
									
												el.options.forEach(function(opt) {
													form += '<option value=' + opt.value + '>' + opt.label
												+ '</option>'
												});
												
									form += '</select>'
								+'</div>'
					
							+'</div>'
						+'</div>';
				
				
			} else if(el.type!='hidden'){
				
				form += '<div class="col-md-3 col-xs-6">'
							+'<div class="input-group date mg-check-in">'
								+'<div class="input-group-addon"><i class="fa fa-calendar"></i></div>'
								+'<input type="' + el.type + '" name="' + el.name + '" class="form-control"  id="' + el.id + '" placeholder="Date of Travel" />'
							+'</div>'
						+'</div>'
				
			}
			
		})
	
		form += '</form>';
			
			form += '<div class="col-md-3">'
						+'<a class="btn btn-main btn-block" id="' + me.modelId + '-save">Check Now</a>'
					+'</div>'
			+'</div>';
		
		
		

		me.updateTarget(form);
		me.getEl(me.modelId + '-save').addEventListener("click", function() {
			me.validate();
		});
	},
	
	model : [],
	form : function() {
		var me = this;
		var form = '<form>';

		me.model.forEach(function(el) {
			form += '<div class="form-group">'
					+ '<div class="input-group" id="' + el.id + '_div">'
					+ '<div class="input-group-addon"> ' + el.label + '</div>';

			if (el.type == 'select' && el.options) {
				form += '<select class="form-control" name="' + el.name
						+ '" id="' + el.id + '">';
				el.options.forEach(function(opt) {
					form += '<option value=' + opt.value + '>' + opt.label
							+ '</option>'
				});
				form += '</select>';
			} else
				form += '<div id="errorM"></div><input type="' + el.type
						+ '" name="' + el.name + '" class="form-control" id="'
						+ el.id + '" <label id="messageErr"></label>'

			form += '</div></div>';
		})

		form += '</form><a class="btn btn-success" id="' + me.modelId
				+ '-save">Complete Booking</a>';

		me.updateTarget(form);
		me.getEl(me.modelId + '-save').addEventListener("click", function() {
			me.validate();
		});
	},

	submitForm : function() {
		var me = this;
		if (me.Null == false && me.email == true && me.number == true) {
			var formValues = me.model.filter(function(el) {
				var formEl = me.getEl(el.id);
				if (!formEl)
					return;

				if (!formEl.value)
					return;

				el.value = formEl.value;

				return el;

			}).map(function(el) {
				return encodeURIComponent(el.name) + '=' + encodeURIComponent(el.value);
			}).join('&');

			me.ajaxRequest.call({
				httpMethod : 'POST',
				httpUrl: './../booking',
				requestParams : formValues,
				responseTarget : me.responseTarget,
				updateTarget : function(resp) {
					me.init();
				}
			});
		}
	},
	loadForm : function(id) {
		var me = this;

		me.ajaxRequest.call({
			httpMethod : me.httpMethod,
			httpUrl : me.httpUrl + '/load?id=' + id,
			responseTarget : me.responseTarget,
			updateTarget : function(resp) {
				me.form();
				var result = JSON.parse(resp);
				me.model.forEach(function(el) {
					Object.keys(result).forEach(function(k) {
						if (el.name == k) {
							console.log(el.id + '=' + result[k]);
							me.getEl(el.id).value = result[k];
						}
					})
				})
			}
		});

	},
	removeRec : function(id) {
		var me = this;

		me.ajaxRequest.call({
			httpMethod : 'DELETE',
			httpUrl : me.httpUrl + '?id=' + id,
			responseTarget : me.responseTarget,
			updateTarget : function(resp) {
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
									
					var listView = "<div class=\"mg-sec-title\">" +
										"<h2>Featured Trips</h2>" +
										"<p>These are the highly rated trips by our customers</p>" +
									"</div>" +
									"<div class=\"row\">" +
										"<div>";
					var jsonRecords = JSON.parse(resp);
					jsonRecords.forEach(function(el){
						var bookId = me.modelId + "-book-" + el.id;
						
						listView += "<div class=\"col-sm-4\">";
						listView += "<figure class=\"mg-room\">";
							listView += "<img src=\"images/sponsored2.jpg\" alt=\"img11\" class=\"img-responsive\">";
						listView += "<figcaption>";
						listView += "<h2>"+el.route+el.id+"</h2>";
						
						listView += "<div class=\"mg-room-rating\"><i class=\"fa fa-star\"></i> 5.00</div>";
						listView += "<div class=\"mg-room-price\">$"+el.price+"<sup>.00/One-Way</sup></div>";
						listView += "<p>Departure Time: "+el.depatureTime+", Arrival Time: "+el.arrivalTime+"</p>";
						listView += "<p>"+el.vehicle+"</p>";
						listView += "<a class=\"btn btn-main\" id=\"" + bookId + "\">Book Trip</a>";
						
				
						listView += "</figcaption>";
						listView += "</figure>";
						listView += "</div>";
				});
					listView += "</div>" +
							"</div>";
				
					if (me.getEl(me.responseTarget).innerHTML = listView) {
						jsonRecords.forEach(function(el) {
							var bookId = me.modelId + "-book-" + el.id;
							
							me.getEl(bookId).addEventListener('click', function() {
								me.form();//loadForm(el.id)
							});

						});
						
					}
				
				
			}
		});
	},
	init : function() {
		this.listView(this.httpUrl);
	}
};















/*
var Ticket = Ticket || {};

Ticket.extend = function(proto, literal){
	  var newLiteral = Object.create(proto);
	  Object.keys(literal).forEach(function(k){
		  newLiteral[k] = literal[k];
	  })
	  
	  return newLiteral;
};

Ticket.Tck = {
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
	    		xhr.setRequestHeader('Content-Type', 'Ticketlication/x-www-form-urlencoded');
	    		xhr.send(me.requestParams);
			}else
	    		xhr.send();
		},
		model: [],
		form:  function(){
			var me = this;
			
			var form = '<form>';
			
			me.model.forEach(function(el){
				//Ticket.Cmp.form.validate(el);
				form += '<div class="form-group">'
					+ '<div class="input-group" id="'+ el.id +'_div">'
					+ '<div class="input-group-addon">' + el.label + '</div>';
				
				if(el.type == 'select' && el.options){
					form += '<select class="form-control" name="' + el.name + '" id="' + el.id + '" onchange = "validation(\''+el.id+'\',\''+el.type+'\',\''+el.required+'\')">';
						el.options.forEach(function(opt){
							form += '<option value='+ opt.value + '>' + opt.label + '</option>'
						});
					form += '</select>';
				}else
					form += '  <input type="' + el.type + '" name="' 
					+ el.name + '" class="form-control" id="' + el.id + '" onkeyup="validation(\''+el.id+'\',\''+el.type+'\',\''+el.required+'\')">';
					 
			    form += '</div></div>';
			   
			})
			 form += '<input type="hidden" id="allErrors" value="0" />';
		  form +=  '</form><a class="btn btn-success" id="' + me.modelId+ '-save">Save</a>';
				
		me.updateTarget(form);
		
		/*  if(me.updateTarget(form)){
			  me.model.forEach(function(el){
				  me.getEl(el.id).addEventListener("click", function(){
					  console.log(el);
				  });
			  })
		  }
		  
		  me.getEl(me.modelId+ '-save').addEventListener("click", function(){
			  
			  var allErrors = document.getElementById("allErrors").value;
			  if(allErrors<=0){
				  me.submitForm();
			  }else{
				  
			  }
			  
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
				
					var jsonRecords = JSON.parse(resp);
					var listView = "<div>";
					jsonRecords.forEach(function(el){
						listView += "<div class=\"col-sm-4\">";
						listView += "<figure class=\"mg-room\">";
							listView += "<img src=\"images/sponsored1.jpg\" alt=\"img11\" class=\"img-responsive\">";
						listView += "<figcaption>";
						listView += "<h2>"+el.route+"</h2>";
						
						listView += "<div class=\"mg-room-rating\"><i class=\"fa fa-star\"></i> 5.00</div>";
						listView += "<div class=\"mg-room-price\">$"+el.price+"<sup>.00/One-Way</sup></div>";
						listView += "<p>Departure Time: "+el.depatureTime+", Arrival Time: "+el.arrivalTime+"</p>";
						listView += "<p>"+el.vehicle+"</p>";
						listView += "<a href=\"#\" class=\"btn btn-main\">Book</a>";
						
						
						listView += "</figcaption>";
						listView += "</figure>";
						listView += "</div>";
				});
					listView += "</div>";
				
				me.getEl(me.responseTarget).innerHTML = listView;
				
				
			}
		});
	},
	/*selection: function(){
		var me = this;
		
		me.ajaxRequest.call({
			httpMethod: me.httpMethod,
			httpUrl: me.httpUrl,
			responseTarget: me.responseTarget,
			updateTarget: function(resp){
				
					var jsonRecords = JSON.parse(resp);
					var listView = "<div>";
					jsonRecords.forEach(function(el){
						listView += "<div class=\"col-sm-4\">";
						listView += "<figure class=\"mg-room\">";
							listView += "<img src=\"images/sponsored1.jpg\" alt=\"img11\" class=\"img-responsive\">";
						listView += "<figcaption>";
						listView += "<h2>"+el.route+"</h2>";
						
						listView += "<div class=\"mg-room-rating\"><i class=\"fa fa-star\"></i> 5.00</div>";
						listView += "<div class=\"mg-room-price\">$"+el.price+"<sup>.00/One-Way</sup></div>";
						listView += "<p>Departure Time: "+el.depatureTime+", Arrival Time: "+el.arrivalTime+"</p>";
						listView += "<p>"+el.vehicle+"</p>";
						listView += "<a href=\"#\" class=\"btn btn-main\">Book</a>";
						
						
						listView += "</figcaption>";
						listView += "</figure>";
						listView += "</div>";
				});
					listView += "</div>";
				
				me.getEl(me.responseTarget).innerHTML = listView;
				
				
			}
		});
	},
	init: function(){
		this.listView(this.httpUrl);
	},
	selectRoute: function(){
		this.selection(this.httpUrl);
	}
	
};

*/
