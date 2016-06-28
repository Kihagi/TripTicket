var route = App.extend(App.Cmp, {
	formId: 'route-save',
	formUrl: './route/action/add',
	responseTarget: 'ajax-content',
	fromFields:[{
			id: 'from-location',
			label: 'routeFrom',
			name: 'fromLocationId',
			type: 'number'
		},{
			id: 'to-location',
			label: 'routeTo',
			name: 'toLocationId',
			type: 'number'
		},{
			id: 'route-distance',
			label: 'routeDistance',
			name: 'distance',
			type: 'number'
		},{
			id: 'route-time',
			label: 'routeTme',
			name: 'ApproxTime',
			type: 'number'
		},{
			id: 'route-company',
			label: 'routeCompany',
			name: 'companyId',
			type: 'number'
		}]
		
});