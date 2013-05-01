<%@page language="java" contentType="text/html; charset=utf8"
        pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<script type="text/javascript">
	$(function () {
		ui.hotkey('ctrl+s',function(){
			$("#film-form").submit();
		});
	});
</script>

<spring:url var="saveAction" value='/film/save'/>
<form:form method="post" action="${saveAction}" id="film-form"
           commandName="film" class="form-horizontal" >
	<form:hidden path="id"/>
	<div class="control-group">
		<label class="control-label">Name:</label>
		<div class="controls">
			<form:input path="name" />
		</div>
	</div>
 	<div class="control-group">
		<label class="control-label">Author:</label>
		<div class="controls">
			<form:input path="author" />
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">Genre:</label>
		<div class="controls">
			<form:input path="genre" />
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">Country:</label>
		<div class="controls">
			<form:input path="country" />
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">Year:</label>
		<div class="controls">
			<form:input path="year" />
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">Duration:</label>
		<div class="controls">
			<form:input path="duration" />
		</div>
	</div>

	<hr/>
	<div style="width: 100%;" class="text-right">
		<input type="submit" value="SAVE (Ctrl+S)" class="btn"/>
	</div>
</form:form>
