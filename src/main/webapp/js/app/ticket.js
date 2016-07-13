var ticket =  App.extend(App.Cmp, {
		modelId: 'booking',
		httpUrl: './booking',
		responseTarget: 'ajax-content',
		columnModel: ['fullname', 'idNumber'],
		columnSeperator: ' - Id Number #: ',
	
		fromFields:[{
			id: 'idNumber',
			label: 'Id Number',
			name: 'idNumber',
			placeholder: 'Id Number',
			type: 'text'
		},{
			id: 'name',
			label: 'Full Name',
			name: 'name',
			placeholder: 'Full Name',
			type: 'text'
		},{
			id: 'phone',
			label: 'Cell Phone',
			name: 'phone',
			placeholder: 'Cell Phone',
			type: 'text'
		},{
			id: 'seat',
			label: 'Seat Number',
			name: 'seat',
			placeholder: 'Seat',
			type: 'text'
		},{
			id: 'tripId',
			label: 'Trip Id',
			name: 'tripId',
			placeholder: 'Trip Id',
			type: 'text'
		},{
			id: 'id',
			label: '',
			name: 'id',
			hidden: true,
			type: 'hidden'
		}],
		removeRecord: true

});

	(function(){
		ticket.init();
	})();