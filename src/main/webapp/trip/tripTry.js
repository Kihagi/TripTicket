var trip ={
		ajax : function(){
			
			var ajax = new XMLHttpRequest();

			ajax.onreadystatechange = function() {

				if (ajax.readyState == 4) {
					if (ajax.status == 200) {
						document.getElementById('ajax-content').innerHTML = ajax.responseText;
					}
				}
			}
			
			list : function(){
				
				ajax.open("GET", "./trips/action", true);
				ajax.send();
				
			}
			
		}
		
		
}