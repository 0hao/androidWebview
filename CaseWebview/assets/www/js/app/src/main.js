define(function(require, exports, module) {

	require('zepto');
	require('backbone');

	$('#button').html(GlobalCase.getBtnTxt()).show().tap(function(){
		bs.promptColor();
	});

	var BgSetter = Backbone.Model.extend({
		promptColor: function() {
			var cssColor = prompt("输入一个CSS颜色值：");
			this.set({
				color: cssColor
			});
		}
	});

	window.bs = new BgSetter;

	bs.bind('change:color', function(model, color) {
		$('body').css({
			background: color
		});
	});

});