var company = App.extend(App.Cmp, {
	formId: 'company',
	formUrl: './company/action/*',
	responseTarget: 'ajax-content',
	fromFields:[{
		id: 'company-name',
		label: 'Company Name',
		name: 'name',
		type: 'text'
	},{
		id: 'company-regno',
		label: 'Registration #',
		name: 'regNo',
		type: 'text'
	},{
		id: 'company-phone_no',
		label: 'Phone #',
		name: 'phoneNo',
		type: 'text'
	},{
		id: 'company-email',
		label: 'Email #',
		name: 'email',
		type: 'email'
	},{
		id: 'company-town',
		label: 'Town',
		name: 'town',
		type: 'text'
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
		type: 'text'
	}]

});