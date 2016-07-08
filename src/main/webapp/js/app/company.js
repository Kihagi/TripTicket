var company = App.extend(App.Cmp, {
	modelId: 'company',
	httpUrl: './company',
	responseTarget: 'ajax-content',
	columnModel: ['name', 'regNo'],
	columnSeperator: ' - Registration #: ',
	model:[{
		id: 'company-name',
		label: 'Company Name',
		name: 'name',
		type: 'text',
		required: 'required'
	},{
		id: 'company-regno',
		label: 'Registration #',
		name: 'regNo',
		type: 'text',
		required: 'required'
	},{
		id: 'company-phone_no',
		label: 'Phone #',
		name: 'phoneNo',
		type: 'number',
		required: 'required'
	},{
		id: 'company-email',
		label: 'Email #',
		name: 'email',
		type: 'email',
		required: 'required'
	},{
		id: 'company-town',
		label: 'Town',
		name: 'town',
		type: 'text',
		required: 'required'
	},{
		id: 'company-country',
		label: 'Country',
		name: 'country',
		type: 'select',
		options: [
		    {label: 'Kenya', value:'KEN'}, 
	        {label: 'Uganda', value:'UG'}, 
	        {label: 'Tanzania', value:'TZ'}
	     ]
	},{
		id: 'company-box',
		label: 'P.O BOX',
		name: 'box',
		type: 'text',
		required: 'required'
	},{
		id: 'company-id',
		label: '',
		name: 'id',
		hidden: true,
		type: 'hidden'
		//required: 'required'
	}],
	removeRecord: true

});

(function(){
	company.init();
})();