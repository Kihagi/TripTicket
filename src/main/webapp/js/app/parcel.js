var parcel = App.extend(App.Cmp, {
		modelId:'parcel',
		httpUrl: './parcel',
		responseTarget: 'ajax-content',
		columnModel: ['parcelTo', 'parcelFrom'],
		columnSeperator: ' To ',
		model:[{
			id:'parcel-sender',
			label:'Sender',
			name:'parcelTo',
			type:'text',
			required:'required'
			
		},{
			id:'parcel-recipient ',
			label:'Recipient ',
			name:'parcelFrom',
			type:'text',
			required:'required'
		},{
			id:'parcel-description',
			label:'Parcel Description',
			name:'parcelDescription',
			type:'text',
			required:'required'
		}, /*{
			id: 'parcel-from',
			label: 'From',
			name: 'fromId',
			type: 'select',
			options:[],
			required: 'required'
		},{
			id: 'parcel-to',
			label: 'To',
			name: 'toId',
			type: 'select',
			options: [],
			required: 'required'
		},*/{
			id : 'parcel-route',
			label : 'Parcel Route',
			name : 'route',
			type : 'select',
			options : [ {
				label : 'Nairobi-Mombasa',
				value : 'NAI-MBSA'
			}, {
				label : 'Nairobi-Kisumu',
				value : 'NAI-KIS'
			}, {
				label : 'Nairobi-Nakuru',
				value : 'NAI-NKR'
			}, {
				label : 'Nairobi-Machakos',
				value : 'NAI-MCHKS'
			} ]
		}, {
		id : 'parcel-cost',
		label : 'Parcel Cost',
		name : 'parcelCost',
		type : 'number',
		required : 'required'
	}, {
			id:'parcel-id',
			label:'',
			name:'id',
			hidden:'true',
			type:'hidden',
			
		}],
		removeRecord: true	
	});

(function(){
	
	parcel.ajaxRequest.call({
		httpMethod : 'GET',
		httpUrl : './location',
		updateTarget : function(resp) {
			var options = [];
			console.log(resp);
			JSON.parse(resp).forEach(function(el){
				options.push({
					label: el.name,
					value: el.id
				});
			});
			
			parcel.model[0].options = options;
			parcel.model[1].options = options;
			
			
			
		}
	})
})();