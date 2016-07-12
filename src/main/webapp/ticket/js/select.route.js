var selectRoute = Ticket.extend(Ticket.Tck, {
	modelId: 'select-route',
	httpUrl: './selecttrip',
	responseTarget: 'select-route',
	
	model:[{
		id: 'date',
		label: 'Date of Travel',
		name: 'date',
		type: 'text',
		required: 'required'
	},{
		id: 'route',
		label: 'Route',
		name: 'route',
		type: 'select',
		options: [],
		required: 'required'
	},{
		id: 'route-id',
		label: '',
		name: 'id',
		type: 'hidden'
	}],
	removeRecord: true
	
});

(function(){
	selectRoute.ajaxRequest.call({
		httpMethod : 'GET',
		httpUrl : './../route',
		updateTarget : function(resp) {
			var options = [];
			console.log(resp);
			JSON.parse(resp).forEach(function(el){
				options.push({
					label: el.from +' TO '+el.to,
					value: el.id
				});
			});
			
			selectRoute.model[1].options = options;
		}
	})
})();	

(function(){
	selectRoute.RouteForm();
})();