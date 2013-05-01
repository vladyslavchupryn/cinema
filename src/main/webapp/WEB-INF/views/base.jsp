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
		<tiles:getAsString name="title"/>
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
	      href="<spring:url value="/css/awesome/css/font-awesome.min.css" />"/>

	<!-- Custom ---------------------------------------------------->
	<script type="text/javascript"
	        src="<spring:url value="/js/core/ui.js" />"></script>
	<script type="text/javascript"
	        src="<spring:url value="/js/core/net.js" />"></script>
	<script type="text/javascript"
	        src="<spring:url value="/js/core/validation.js" />"></script>
	<script type="text/javascript">
		$(function () {
			peekValidators();
			$(".chzn-select").chosen();
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
