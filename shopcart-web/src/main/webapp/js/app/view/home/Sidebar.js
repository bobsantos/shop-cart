Ext.define('App.view.home.Sidebar',{
	extend: 'Ext.panel.Panel',
	alias: 'widget.sidebar',
	initComponent: function(){
		var my = this;
		
		this.accordion = Ext.create('Ext.panel.Panel',{
			layout:'accordion',
			width: 300,
			flex: 3,
			border: false,
			items: [{
				xtype: 'panel',
				title: 'User Management',
				border: false,
				items: [{
					xtype: 'panel',
					html: 'User Management Links',
					border: false
				}]
			},{
				xtype: 'panel',
				title: 'Employee Management',
				border: false,
				items: [{
					xtype: 'panel',
					html: 'Employee Management Links',
					border: false
				}]
			}]
		});
		
		Ext.apply(this,{
			layout:'vbox',
			items: [my.accordion,{
				xtype: 'box',
				flex: 1,
				autoEl: {
					tag: 'a',
					href: '/logout.html',
					html: 'Logout'
				}
			}]
		});
		
		this.callParent(arguments);
	}
});