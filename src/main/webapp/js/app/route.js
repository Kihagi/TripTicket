var route = App.extend(App.Cmp, {
	modelId: 'route-save',
	httpUrl: './route',
	responseTarget: 'ajax-content',
	model:[{
		id: 'route-from',
		label: 'From',
		name: 'fromId',
		type: 'number'
	},{
		id: 'route-to',
		label: 'To',
		name: 'toId',
		type: 'number'
	},{
		id: 'route-distance',
		label: 'Distance (KM)',
		name: 'distance',
		type: 'number'
	},{
		id: 'route-time',
		label: 'Approx. Time',
		name: 'approxTime',
		type: 'number'
	},{
		id: 'route-id',
		label: '',
		name: 'id',
		type: 'hidden'
	}],
	removeRec: true
	
});
		