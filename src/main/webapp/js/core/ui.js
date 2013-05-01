var ui = {
	alert : bootbox.alert,

	// http://nijikokun.github.com/bootstrap-notify/
	notify: function (text, option) {
		if (!option) {
			option = {};
		}
		if (!option.message) {
			option.message = {};
		}
		option.message.text = text;

		$('.top-right').notify(option).show();
	},

	hotkey: function (mask, handler, enableInInput) {
		var selector = 'body';
		if(enableInInput == undefined || enableInInput) {
			selector += ',input';
		}
		$(selector).bind('keydown', mask, function(){
			var result = handler();
			if(result == undefined){
				return false;
			} else {
				return result;
			}
		});

//		if(enableInInput == undefined) {
//			enableInInput = true;
//		}
//		$.Shortcuts.add({
//			enableInInput: enableInInput,
//			mask         : mask,
//			handler      : handler
//		});
	}
}
