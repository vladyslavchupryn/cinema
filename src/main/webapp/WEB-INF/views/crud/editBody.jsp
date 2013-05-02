<%@page language="java" contentType="text/html; charset=utf8"
        pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<script type="text/javascript">
	$(function () {
		ui.hotkey('ctrl+s',function(){
			$("#crud-form").submit();
		});
	});
</script>

<spring:url var="saveAction" value='/${path}/save'/>
<form:form method="post" action="${saveAction}" id="crud-form"
           commandName="object" class="form-horizontal" >
	<form:hidden path="id"/>

	<c:forEach var="column" items="${editColumns}">
		<div class="control-group">
			<label class="control-label">${column}:</label>
			<div class="controls">
				<form:input path="${column}" />
			</div>
		</div>
	</c:forEach>

	<hr/>
	<div style="width: 100%;" class="text-right">
		<input type="submit" value="SAVE (Ctrl+S)" class="btn"/>
	</div>
</form:form>
