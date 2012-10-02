Ext.define('Mycrotyx.controller.Login',{
	extend: 'Ext.app.Controller',
	views: [
	        'login.Login',
	        'home.Home',
	        'Viewport'
	],
	refs: [{
		ref: 'viewport',
		selector: 'viewport'
	},{
		ref: 'loginForm',
		selector: 'login panel form'
	},{
		ref: 'home',
		selector: 'home'
	}],
	init: function(){
		this.control({
			'login panel form button[action=signIn]': {
				click: this.signIn
			},
			'login panel button[action=register]': {
				click: this.register
			},
			'login panel button[action=forgotPassword]': {
				click: this.forgotPassword
			}
		});
	},
	
	signIn: function(){
		console.log('Login clicked');
		var my = this;
		
		var form = this.getLoginForm().getForm();
		var email = form.findField('email').getValue();
		var password = form.findField('password').getValue();
		var loginFailedEl = form.findField('loginFailed');
		
		var jsonData = {};
		jsonData['email'] = email;
		jsonData['password'] = password;
		
		Ext.Ajax.request({
			url: '/login.html',
			success: function(response, opts){
				var obj = Ext.decode(response.responseText);
				if(obj.id){
					var viewport = my.getViewport();
					viewport.getLayout().setActiveItem(1);
				}
			},
			failure: function(response, opts){
				var obj = Ext.decode(response.responseText);
				if(obj.error){
					loginFailedEl.setValue('*' + obj.error);
				}
			},
			jsonData: jsonData
		});
	},
	
	register: function(){
		console.log('register: not yet implemented');
	},
	
	forgotPassword: function(){
		console.log('forgotPassword: not yet implemented');
	}
});