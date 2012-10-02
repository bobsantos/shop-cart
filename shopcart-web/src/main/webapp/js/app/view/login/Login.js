Ext.define('Mycrotyx.view.login.Login',{
	extend: 'Ext.panel.Panel',
	alias: 'widget.login',
	border: false,
	layout: {
		type: 'vbox',
		align: 'center',
		pack: 'center'
	},
	initComponent: function(){
		var my = this;
		
		this.loginPanel = Ext.create('Ext.form.Panel',{
			title: 'Sign in',
			defaults: {
				margin: '5px',
				border: false
			},
			items: [{
				xtype: 'textfield',
				fieldLabel: 'Email',
				name: 'email',
				allowBlank: false
			},{
				xtype: 'textfield',
				inputType: 'password',
				fieldLabel: 'Password',
				name: 'password',
				allowBlank: false
			},{
				xtype: 'displayfield',
				hideLabel: true,
				name: 'loginFailed',
				value: '',
				baseCls: 'app-login-failed'
			}],
			buttons: [{
				text: 'Sign in',
				formBind: true,
				action: 'signIn'
			}]
		});
		
		this.register = Ext.create('Mycrotyx.component.LinkButton',{
			text: 'Register',
			action: 'register'
		});
		
		this.forgotPassword = Ext.create('Mycrotyx.component.LinkButton',{
			text: 'Forgot password?',
			action: 'forgotPassword'
		});
		
		Ext.apply(this,{
			items: [{
				xtype: 'panel',
				layout: 'vbox',
				border: false,
				items: [my.loginPanel, my.register, my.forgotPassword]
			}],
			style: {
				marginLeft: 'auto',
				marginRight: 'auto'
			}
		});
		
		this.callParent(arguments);
	}
});