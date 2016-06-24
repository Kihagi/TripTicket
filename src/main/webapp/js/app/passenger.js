var passenger = {
		ajaxCommon: function(){
			var ajax=new XMLHttpRequest();
			ajax.onreadystatechange=function(){
				if (ajax.readyState==4 && ajax.status==200){
					
				}
			}
			
		},
	list : function() {

		ajaxCommon.open("GET", "./passengers/action", true);
		ajaxCommon.send();
	},

	add : function() {
		
		ajaxCommon.open("GET", "./passengers/addpassengers.jsp", true);
		ajaxCommon.send();
	},
	

	submit : function() {
		var refresh = this;
		var ajax = new XMLHttpRequest();

		var lastName = document.getElementById('lname').value;
		var firstName = document.getElementById('fname').value;
	 	var params = 'lastname=' + encodeURIComponent(lastName) 
		+ 'firstname=' + encodeURIComponent(firstName);
	
	console.log(params);

		ajax.onreadystatechange = function() {

			if (ajax.readyState == 4) {
				if (ajax.status == 200) {
					refresh.list();
				}
			}
		}

		ajax.open("POST", "./passengers/action/add", true);
		ajax.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		ajax.send(params);
	}
}