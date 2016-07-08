var vehicle = App.extend(App.Cmp, {
	modelId: 'vehicle',
	httpUrl: './vehicle',
	responseTarget: 'ajax-content',
	model:[{
		id: 'vehicle-type',
		label: 'Type',
		name: 'type',
		type: 'select',
		options: [
	            {label: 'BUS', value:'BS'}, 
    	        {label: 'NISSAN', value:'NS'},
    	   ]
	},{
		id: 'vehicle-regno',
		label: 'Number',
		name: 'regNo',
		type: 'text',
		required : 'required'
	},{
		id: 'vehicle-size',
		label: 'Size',
		name: 'size',
		type: 'select',
		options: [
	          	{label: '14 Seater', value:'14'},	
	            {label: '14 Seater', value:'14'}, 
		        {label: '32 Seater', value:'32'},
		        {label: '45 Seater', value:'45'},
		        {label: '52 Seater', value:'52'},
    	   ]
	},{
		id: 'id',
		name: 'id',
		hidden: true,
		type: 'hidden',
		required: 'required'
	}],
	aftersubmit: function(){
		var me = this;
		trip.init();
	},
	

});


