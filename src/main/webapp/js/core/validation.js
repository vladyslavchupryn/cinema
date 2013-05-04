function peekValidators(language) {
	$('input[java-type="java.sql.Timestamp"]').datetimepicker({
		format: 'yyyy-mm-dd hh:ii:ss',
		autoclose: true,
		language : language
	});

	$(".decimal")
		.add('input[java-type="java.lang.Float"]')
		.add('input[java-type="java.lang.Double"]').numeric();
	$(".positive-decimal").numeric({
		negative: false
	});

	$(".integer")
		.add('input[java-type="java.lang.Integer"]')
		.add('input[java-type="java.lang.Short"]').numeric();
	$(".positive-integer").numeric({
		decimal : false,
		negative: false
	});
}
