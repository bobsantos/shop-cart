Ext.define('App.view.home.Home',{
	extend: 'Ext.panel.Panel',
	alias: 'widget.home',
	initComponent: function(){
		var my = this;
		
		this.sidebar = Ext.create('App.view.home.Sidebar',{});
		
		Ext.apply(this,{
			layout: 'border',
			items: [{
				xtype: 'panel',
				region: 'west',
				layout: 'fit',
				border: false,
				width: 300,
				items: [my.sidebar]
			}]
		});
		
		this.callParent(arguments);
	}
});