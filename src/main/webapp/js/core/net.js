var net = {
	fragment : function(url,fragment) {
		return $.ajax({
			url: BASE_URL + url+  "?fragments=" + fragment,
			beforeSend: function (req) {
				req.setRequestHeader("Accept", "text/html;type=ajax");
			}
		});

	}
}
