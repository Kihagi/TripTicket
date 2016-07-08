
var trip = App.extend(App.Cmp, {
	modelId: 'trip',
	httpUrl: './trip',
	responseTarget: 'ajax-content',
	columnModel : ['arrivalTime','depatureTime','route','price'],
	columnSeparator: ' ** ',
	model:[{
		id: 'arrivalTime',
		label: 'Arrival Time',
		name: 'arrivalTime',
		type: 'text',
		required : 'required'
	},{
		id: 'depatureTime',
		label: 'Depature Time',
		name: 'depatureTime',
		type: 'text',
		required : 'required'
	},{
		id: 'route',
		label: 'Route',
		name: 'route',
		type: 'select',
		options: []
//				{label: 'MOMBASA - NAIROBI', value:'MOMBASA-NAIROBI'}, 
//				{label: 'NAIROBI - CAMPALA', value:'NAIROBI-CAMPALA'}, 
//				{label: 'ARUSHA - NAIROBI', value:'ARUSHA-NAIROBI'},
//				{label: 'ARUSHA - MOMBASA', value:'ARUSHA-MOMBASA'}
	},{
		id: 'price',
		label: 'Price',
		name: 'price',
		type: 'number',
		required : 'required'
	},{
		id: 'id',
		label: '',
		name: 'id',
		hidden: true,
		type: 'hidden',
		
	}],
	aftersubmit: function(){
		var me = this;
		trip.init();
	},
	removeRecord: true
	

});

(function(){
	route.ajaxRequest.call({
		httpMethod : 'GET',
		httpUrl : './route',
		updateTarget : function(resp) {
			var options = [];
			console.log(resp);
			JSON.parse(resp).forEach(function(el){
				options.push({
					label: el.name,
					value: el.id
				});
			});
			
			route.model[0].options = options;
		}
	})
})();	