var route = App.extend(App.Cmp, {
	modelId: 'route-save',
	httpUrl: './route',
	responseTarget: 'ajax-content',
	columnModel: ['from', 'to'],
	columnSeperator: ' To ',
	model:[{
		id: 'route-from',
		label: 'From',
		name: 'fromId',
		type: 'select',
		options:[],
		required: 'required'
	},{
		id: 'route-to',
		label: 'To',
		name: 'toId',
		type: 'select',
		options: [],
		required: 'required'
	},{
		id: 'route-distance',
		label: 'Distance (KM)',
		name: 'distance',
		type: 'number',
		required: 'required'
	},{
		id: 'route-time',
		label: 'Approx. Time',
		name: 'approxTime',
		type: 'number',
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
	route.ajaxRequest.call({
		httpMethod : 'GET',
		httpUrl : './location',
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
			route.model[1].options = options;
		}
	})
})();	