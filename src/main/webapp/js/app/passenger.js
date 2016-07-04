var passenger = App.extend (App.Cmp, {
	modelId: 'passenger',
formUrl: './passengers',
	responseTarget: 'ajax-content',
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

	} ],
	aftersubmit: function(){
		var me = this;
	
	},
	removeRecord: true,
	show: function (){
		var me = this;
		me.list("./passengers");
	}
	
});
