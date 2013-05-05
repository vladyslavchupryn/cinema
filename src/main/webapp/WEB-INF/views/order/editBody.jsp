<%@page language="java" contentType="text/html; charset=utf8"
        pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<spring:url var="base" value="/"/>
<c:set var="crud" scope="request" value="${base}${path}/"/>

<form:form method="post" action="${crud}save" id="crud-form"
           commandName="object" class="form-horizontal">
	<form:hidden path="id"/>
		<div class="control-group">
			<label class="control-label"><spring:message
					code="${path}.column.customerName"/>:</label>
			<div class="controls">
				<form:input path="customerName"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label"><spring:message
					code="${path}.column.price"/>:</label>
			<div class="controls">
				<form:input path="price" cssStyle="width: 80px"/>
				<div class="switch" style="width: 120px;"
				     data-on-label="<spring:message code="${path}.edit.update"/>"
				     data-off-label="<spring:message code="${path}.edit.static"/>">
					<input type="checkbox" id="update-price" checked="checked">
				</div>
			</div>
		</div>
		<div class="control-group">

			<label class="control-label"><spring:message
					code="${path}.column.place"/>:</label>
			<div class="controls many-to-many">
				<form:select path="place.id"
				             data-placeholder="Select ..."
				             cssClass="chzn-select place-id">
					<form:options items="${columns[0]}" itemValue="id" />
				</form:select>
			</div>
		</div>
	<div class="control-group">

		<label class="control-label"><spring:message
				code="${path}.column.correlations"/>:</label>
		<div class="controls many-to-many">
			<form:checkboxes path="correlationIds" items="${columns[2]}" itemValue="id" element="div" ></form:checkboxes>
		</div>
	</div>
		<div class="control-group">

			<label class="control-label"><spring:message
					code="${path}.column.session"/>:</label>
			<div class="controls">
				<form:select path="session.id"
				             data-placeholder="Select ..."
				             cssClass="chzn-select session-id">
					<form:options items="${columns[1]}" itemValue="id"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label"><spring:message
					code="${path}.column.comment"/>:</label>
			<div class="controls">
				<form:input path="comment"/>
			</div>
		</div>
	<hr/>
	<div style="width: 100%;" class="text-right">
		<input type="submit"
		       hotkey="ctrl+s"
		       rel="tooltip" title="Ctrl + S"
		       value="<spring:message code="crud.edit.save"/>"
		       class="btn"/>
	</div>
</form:form>
