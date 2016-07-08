var triplocation = App.extend(App.Cmp, {
	modelId: 'location',
	httpUrl: './location',
	responseTarget: 'ajax-content',
	columnModel: ['name'],
	model: [{
		id: 'location-no',
		label: 'Location #',
		name: 'locNo',
		type: 'text',
		required: 'required'
	},{
		id: 'location-name',
		label: 'Location Name',
		name: 'name',
		type: 'text',
		required: 'required'
	},{
		id: 'location-descr',
		label: 'Description',
		name: 'descr',
		type: 'text',
		required: 'required'
	}],
	removeRecord: true
});
		