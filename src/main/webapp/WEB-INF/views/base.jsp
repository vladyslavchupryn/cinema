<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>
		<spring:message code="project.name"/>
	</title>

	<!-- JQuery --------------------------------------------------------------->
	<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
	<link rel="stylesheet"
	      href="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css"/>
	<script src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script>
	<script type="text/javascript"
	        src="<spring:url value="/js/jquery/jquery.numeric.js" />"></script>
	<!-- http://www.linkexchanger.su/2008/45.html -->
	<script type="text/javascript"
	        src="<spring:url value="/js/jquery/jquery.form.js" />"></script>
	<!-- http://www.stepanreznikov.com/js-shortcuts/ -->
	<script type="text/javascript"
	        src="<spring:url value="/js/jquery/jquery.hotkeys.js" />"></script>
	<script type="text/javascript"
	        src="<spring:url value="/js/jquery/jquery.cookie.js" />"></script>
	<!-- http://harvesthq.github.com/chosen/ -->
	<script type="text/javascript"
	        src="<spring:url value="/js/jquery/chosen/chosen.jquery.min.js" />"></script>
	<link rel="stylesheet"
	      href="<spring:url value="/js/jquery/chosen/chosen.css" />"/>

	<!-- Twitter Bootstrap ---------------------------------------------------->
	<link rel="stylesheet"
	      href="<spring:url value="/css/bootstrap/css/bootstrap.min.css" />"/>
	<link rel="stylesheet"
	      href="<spring:url value="/css/bootstrap/css/bootstrap-responsive.min.css" />"/>
	<script type="text/javascript"
	        src="<spring:url value="/css/bootstrap/js/bootstrap.min.js" />"></script>
	<!-- Custom alert -->
	<script type="text/javascript"
	        src="<spring:url value="/js/bootstrap/bootbox.min.js" />"></script>
	<!-- Popups -->
	<script type="text/javascript"
	        src="<spring:url value="/js/bootstrap/notify/js/bootstrap-notify.js" />"></script>
	<link rel="stylesheet"
	      href="<spring:url value="/js/bootstrap/notify/css/bootstrap-notify.css" />"/>
	<script type="text/javascript"
	        src="<spring:url value="/js/bootstrap/notify/js/bootstrap-notify.js" />"></script>
	<link rel="stylesheet"
	      href="<spring:url value="/js/bootstrap/switch/bootstrapSwitch.css" />"/>
	<script type="text/javascript"
	        src="<spring:url value="/js/bootstrap/switch/bootstrapSwitch.js" />"></script>
	<link rel="stylesheet"
	      href="<spring:url value="/js/bootstrap/date-time-picker/datetimepicker.css" />"/>
	<script type="text/javascript"
	        src="<spring:url value="/js/bootstrap/date-time-picker/bootstrap-datetimepicker.min.js" />"></script>
	<script type="text/javascript"
	        src="<spring:url value="/js/bootstrap/date-time-picker/locale/bootstrap-datetimepicker.${pageContext.response.locale.language}.js" />"></script>
	<link rel="stylesheet"
	      href="<spring:url value="/js/bootstrap/slider/css/slider.css" />"/>
	<script type="text/javascript"
	        src="<spring:url value="/js/bootstrap/slider/js/bootstrap-slider.js" />"></script>

	<link rel="stylesheet"
	      href="<spring:url value="/css/awesome/css/font-awesome.min.css" />"/>

	<!-- Custom ---------------------------------------------------->
	<script type="text/javascript"
	        src="<spring:url value="/js/core/ui.js" />"></script>
	<script type="text/javascript"
	        src="<spring:url value="/js/core/net.js" />"></script>
	<script type="text/javascript"
	        src="<spring:url value="/js/core/validation.js" />"></script>

	<script type="text/javascript"
	        src="<spring:url value="/js/core/pagination.js" />"></script>

	<script type="text/javascript">
		$(function () {
			peekValidators('${pageContext.response.locale.language}');

			$(".chzn-select").chosen();
			$("[rel='tooltip']").tooltip();

			$("[hotkey]").each(function () {
				var key = $(this).attr('hotkey');
				var that=this;
				ui.hotkey(key, function () {
					if($(that).prop("tagName") == 'A'){
						window.location=$(that).attr('href');
					} else {
						$(that).click();
					}
				});
			});

			$('.many-to-many input:checkbox').addClass('checkbox');

			$('.field-error').parents('.control-group').addClass('error');
		});


		var BASE_URL = "<spring:url value="/" />";
	</script>
	<link rel="stylesheet"
	      href="<spring:url value="/css/bootstrap-fixes.css" />"/>
	<style type="text/css">
		#ui-datepicker-div {
			font-size: 11px;
		}

		body {
			padding-top: 60px;
		}

		.list-icon-cell {
			width:70px;
		}

		.list-icon {
			font-size: 1.5em;
		}

		dt, dd {
			margin-bottom: 10px;
		}

		.uppercase {
			text-transform: uppercase;
		}

		.link-button, .link-button:hover {
			text-decoration: none;
			color: #000000;
		}

		.inline {
			display:inline;
		}

		.many-to-many label {
			display:inline;
			margin-left: 10px;
		}
	</style>
</head>
<body>

<!--SPIKE
плагин нотификаций требует налиция этих элементов на странице
(если какие-то позиции однозначно не нужны их можно удалить)
-->
<div class='notifications bottom-right'></div>
<div class='notifications top-right'></div>

<tiles:insertAttribute name="header"/>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span3">
			<tiles:insertAttribute name="navigation"/>
		</div><!--/span-->
		<div class="span9">
			<tiles:insertAttribute name="content"/>
		</div><!--/span-->
	</div><!--/row-->
	<hr>
	<footer>
		<tiles:insertAttribute name="footer"/>
	</footer>
</div>

</body>
</html>
