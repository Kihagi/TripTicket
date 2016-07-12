//BOOKING
var booking = Ticket.extend(Ticket.Tck, {
	modelId: 'booking',
	httpUrl: './../booking',
	responseTarget: 'ticket-content',
	model:[{
		id: 'idNumber',
		label: 'Id Number',
		name: 'idNumber',
		placeholder: 'Id Number',
		type: 'text',
		required: 'required'
	},{
		id: 'fullname',
		label: 'Full Name',
		name: 'fullname',
		placeholder: 'Full Name',
		type: 'text',
		required: 'required'
	},{
		id: 'phone',
		label: 'Cell Phone',
		name: 'phone',
		placeholder: 'Cell Phone',
		type: 'number',
		required: 'required'
	},{
		id: 'seat',
		label: 'Seat Number',
		name: 'seat',
		required: 'required',
		type: 'select',
		options: [
		    {label: '1', value:'1'}, 
	        {label: '2', value:'2'}, 
	        {label: '3', value:'3'},
	        {label: '4', value:'4'},
	        {label: '5', value:'5'},
	        {label: '6', value:'6'},
	        {label: '7', value:'7'},
	        {label: '8', value:'8'},
	        {label: '9', value:'9'},
	        {label: '10', value:'10'}
	     ]
	},{
		id: 'tripId',
		label: 'Trip Id',
		name: 'tripId',
		placeholder: 'Trip Id',
		type: 'text',
		required: 'required'
	}],
	removeRecord: true
	
});