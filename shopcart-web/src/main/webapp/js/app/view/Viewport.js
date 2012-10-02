Ext.define('Mycrotyx.view.Viewport',{
	extend: 'Ext.container.Viewport',
	alias: 'widget.viewport',
	layout: 'card',
	border: false,
	initComponent: function(){
		Ext.apply(this,{
			items: [{
				xtype: 'login'
			},{
				xtype: 'home'
			}]
		});
		
		this.showCorrectView();
		this.callParent(arguments);
	},
	
	showCorrectView: function(){
		var my = this;
		
		Ext.Ajax.request({
			url: '/auth.html',
			success: function(response, opts){
				var obj = Ext.decode(response.responseText);
				if(obj.success && obj.success == true){
					my.getLayout().setActiveItem(1);
				}
			},
			failure: function(response, opts){
				var obj = Ext.decode(response.responseText);
				if(obj.error){
					my.getLayout().setActiveItem(0);
				}
			}
		});
	}
});