var route = App.extend(App.Cmp, {
	formId: 'route-save',
	formUrl: './route',
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
		},
		{
			id: 'route-id',
			label: '',
			name: 'id',
			type: 'hidden'
		}],
		aftersubmit: function(){
			var me = this;
			me.table("./route");
		},
		removeRec: true
	
});
		