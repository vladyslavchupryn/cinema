<%@page language="java" contentType="text/html; charset=utf8"
        pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<script type="text/javascript">
	var orderParameters = {};

	orderParameters['place'] = {};
	<c:forEach var="place" items="${columns[3].variants}">
	orderParameters['place'][${place.id}] = ${place.category.price};
	</c:forEach>

	orderParameters['session'] = {};
	<c:forEach var="session" items="${columns[4].variants}">
	orderParameters['session'][${session.id}] = ${session.percent};
	</c:forEach>

	orderParameters['correlation'] = {};
	<c:forEach var="correlation" items="${columns[5].variants}">
	orderParameters['correlation'][${correlation.id}] = ${correlation.percent};
	</c:forEach>
</script>

<script type="text/javascript">
	function orderUpdatePrice() {
		if(!$('#update-price').prop("checked")) {
			return;
		}

		var placeId = $('.ua_pp_chuprin_web100_cinema_domain_Order-place option:selected').val();
		var sessionId = $('.ua_pp_chuprin_web100_cinema_domain_Order-session option:selected').val();
		var correlations = new Array();
		var index=0;
		$('.many-to-many input:checkbox:checked').each(function(){
			correlations[index] = $(this).attr('value');
			index++;
		});

		var placePrice = orderParameters['place'][placeId];
		var sessionPercent = orderParameters['session'][sessionId];
		var correlationPercent = 0;
		for(var correlationId in correlations) {
			correlationPercent += orderParameters['correlation'][correlations[correlationId]];
		}

		var percentDiff = sessionPercent + correlationPercent;
		var moneyDiff = placePrice * (percentDiff / 100.0);

		var finalPrice = placePrice + moneyDiff;
		if(finalPrice < 0) {
			finalPrice = 0.00;
		}

		$('.ua_pp_chuprin_web100_cinema_domain_Order-price').val(finalPrice);
	}


	$(function(){
		$('.ua_pp_chuprin_web100_cinema_domain_Order-price').css('width','80px');
		$('.ua_pp_chuprin_web100_cinema_domain_Order-price').after($('.switch'));


		$('.many-to-many input:checkbox').click(orderUpdatePrice);
		$('.ua_pp_chuprin_web100_cinema_domain_Order-place').change(orderUpdatePrice);
		$('.ua_pp_chuprin_web100_cinema_domain_Order-session').change(orderUpdatePrice);

		$('#update-price').change(orderUpdatePrice);
	});
</script>

<div class="switch" style="width: 120px;"
     data-on-label="<spring:message code="${path}.edit.update"/>"
     data-off-label="<spring:message code="${path}.edit.static"/>">
	<input type="checkbox" id="update-price" checked="checked">
</div>
