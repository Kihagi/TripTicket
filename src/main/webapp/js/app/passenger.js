var passenger = App.extend (App.Cmp, {
	modelId: 'passenger',
	httpUrl:  './passengers',
	responseTarget: 'ajax-content',
	columnModel: ['firstname', 'lastname'],
	columnSeperator: ' -: ',
	model: [ {
		id : 'fname',
		name : 'firstname',
		placeholder : 'Enter your first name here',
		type : 'text',
		required : 'required',
		label: 'First Name'
	
	}, {
		id : 'lname',
		name : 'lastname',
		placeholder : 'Enter your last name here',
		type : 'text',
		required : 'required',
		label: 'Last Name'

	},
	 {
		id : 'idNumber',
		name : 'idNumber',
		placeholder : 'Enter your last name here',
		type : 'text',
		required : 'required',
		label: 'Id Number/Passport'

	},
	{
		id : 'email',
		name : 'email',
		placeholder : 'Enter your email',
		type : 'email',
		required : 'required',
		label: 'Email'

	}, {
		id : 'phoneNumber',
		name : 'phoneNumber',
		placeholder : 'Enter your phone number',
		type : 'number',
		required : 'required',
		label: 'Phone Number'

	},{
		id : 'town',
		name : 'town',
		placeholder : 'Enter the name of your town here',
		type : 'text',
		required : 'required',
		label: 'Town'

	},{
		id : 'box',
		name : 'box',
		placeholder : 'Enter your last name here',
		type : 'box',
		required : 'required',
		label: 'P.O BOX:'

	}],
	removeRecord: true,
	
});
