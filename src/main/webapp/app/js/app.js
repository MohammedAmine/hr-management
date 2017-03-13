Ext.application({
	name : 'HR-Management Application',
	launch : function() {
		Ext.create('Ext.panel.Panel', {
			title : 'HR-Management',
			width : 300,
			height : 300,
			bodyPadding : 10,
			renderTo : 'app',
			html : '<h1>Hello Boss</h1>'
		});
	}
});