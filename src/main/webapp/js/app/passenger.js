function ajaxAll(method, url, boolean, content, encoder, params) {
	
	this.method = method;
	this.url = url;
	this.boolean = boolean;
	this.params=params;
	this.content = 'Content-Type';
	this.encoder = 'application/x-www-form-urlencoded';

	var ajax = new XMLHttpRequest();

	ajax.onreadystatechange = function() {

		if (ajax.readyState == 4) {
			if (ajax.status == 200) {
				document.getElementById('ajax-content').innerHTML = ajax.responseText;
			}
		}
	}
	ajax.open(method, url, boolean);
		ajax.setRequestHeader(content, encoder);
	
	ajax.send(params);
};



var passenger = {
	components : [ {
		id : 'fname',
		name : 'firstname',
		placeholder : 'Enter your first name here',
		type : 'text',
		required : 'required'
	}, {
		id : 'lname',
		name : 'lastname',
		placeholder : 'Enter your last name here',
		type : 'text',
		required : 'required'

	} ],

	list : function() {
		return url = new ajaxAll("GET", "./passengers/action/", true);
	
	},
	add : function() {
		var context = this;
		var form = '<form>';

		context.components.forEach(function(el) {
			form += '<fieldset class="form-group">' + ' <input type="'
					+ el.type + '" class="form-control" id="' + el.id
					+ '"  name="' + el.name + '" placeholder="'
					+ el.placeholder + '" required>' + '</fieldset>';

		})
		form += '</form>'
				+ '<a class="btn btn-success"  onclick="passenger.save()">Submit</a>';
		document.getElementById('ajax-content').innerHTML = form;

	},

	// submitForm: true,
	save : function() {
		var me = this;
		// me.submitForm = true;

		var params = '';
		me.components.forEach(function(el) {
			var val = document.getElementById(el.id).value;
			if (val)
				// me.submitForm = false
				params += el.name + '=' + encodeURIComponent(val) + '&';
		});
		content = 'Content-Type';
		encoder = 'application/x-www-form-urlencoded';
		return url = new ajaxAll("POST", "./passengers/action/add", true, content, encoder, params);

		
		

	}
}
