<%@page language="java" contentType="text/html; charset=utf8"
        pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<script type="text/javascript">
	$(function(){

		var original = $('.ua_pp_chuprin_web100_cinema_domain_Film-duration');
		var hours = $('<div>');
		var minutes = $('<div>');
		var seconds = $('<div>');

		original.hide();
		original.wrap('<div class="span4">');
		original.before(hours);
		original.before('<br/>');
		original.before(minutes);
		original.before('<br/>');
		original.before(seconds);

		var currentSeconds = original.val();

		var hoursCount = currentSeconds / 3600;
		hours.slider({
			min : 0,
			max : 5,
			value : hoursCount,
			formater : function(value) {
				return value + " hours";
			}
		}).on('slideStop',function(event){
			hoursCount = event.value;
			recalc();
		});

		var minutesCount = (currentSeconds % 3600) / 60;
		minutes.slider({
			min : 0,
			max : 60,
			value : minutesCount,
			formater : function(value) {
				return value + " minutes";
			}
		}).on('slideStop',function(event){
			minutesCount = event.value;
			recalc();
		});

		var secondsCount = (currentSeconds % 60);
		seconds.slider({
			min : 0,
			max : 60,
			value : secondsCount,
			formater : function(value) {
				return value + " seconds";
			}
		}).on('slideStop',function(event){
			secondsCount = event.value;
			recalc();
		});

		function recalc() {
			var result = hoursCount * 3600 + minutesCount * 60 + secondsCount;
			original.val(result);
		}
	});
</script>
