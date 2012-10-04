Ext.define('App.view.Viewport',{
	extend: 'Ext.container.Viewport',
	alias: 'widget.viewport',
	layout: 'border',
	border: false,
	initComponent: function(){
		var my = this;
		
		this.home = Ext.create('App.view.home.Home',{region: 'center'});
		
		Ext.apply(this,{
			items: [my.home]
		});
		
		this.callParent(arguments);
	}
});