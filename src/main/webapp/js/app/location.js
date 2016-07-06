var triplocation = App.extend(App.Cmp, {
	formId: 'location',
	formUrl: './location',
	loadUrl: './location/?id=',
	responseTarget: 'ajax-content',
	fromFields: [{
		id: 'loc_Id',
		label: 'Location Number',
		name: 'locNo',
		type: 'text',
	},{
		id: 'loc_Name',
		label: 'Location Name',
		name: 'name',
		type: 'text',
	},{
		id: 'loc_Descr',
		label: 'Description',
		name: 'Descr',
		type: 'text',
	}]
});
		