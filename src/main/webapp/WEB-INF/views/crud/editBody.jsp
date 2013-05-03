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

	<c:forEach var="current" items="${columns}">
		<div class="control-group">
			<c:choose>
				<c:when test="${current.getClass().name == 'java.lang.String'}">
					<label class="control-label"><spring:message
							code="${path}.column.${current}"/>:</label>

					<div class="controls">
						<form:input path="${current}"/>
					</div>
				</c:when>
				<c:otherwise>

					<label class="control-label"><spring:message
							code="${path}.column.${current[2]}"/>:</label>

					<div class="controls">

						<form:select path="${current[0]}"
						             data-placeholder="Select ..."
						             cssClass="chzn-select">
							<form:options items="${current[1]}" itemValue="id"/>
						</form:select>
					</div>
				</c:otherwise>
			</c:choose>

		</div>
	</c:forEach>

	<hr/>
	<div style="width: 100%;" class="text-right">
		<input type="submit"
		       hotkey="ctrl+s"
		       rel="tooltip" title="Ctrl + S"
		       value="<spring:message code="crud.edit.save"/>"
		       class="btn"/>
	</div>
</form:form>
