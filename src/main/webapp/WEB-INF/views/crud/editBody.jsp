<%@page language="java" contentType="text/html; charset=utf8"
        pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<script type="text/javascript">
	$(function(){
		$('input[java-type]').first().focus();
	});
</script>

<c:if test="${!empty customFragment}">
	<jsp:include page="/WEB-INF/views/${customFragment}.jsp"/>
</c:if>

<form:errors path="*" cssClass="help-inline"/>
<form:form method="post" action="${crud}save" id="crud-form"
           commandName="object" class="form-horizontal">
	<form:hidden path="id"/>

	<c:forEach var="current" items="${columns}">
		<div class="control-group">
			<label class="control-label" ><spring:message
					code="${path}.column.${current.name}"/>:</label>
			<div class="controls">
				<c:choose>
					<c:when test="${current.type == 'simple'}">
						<form:input path="${current.name}" java-type="${current.clazz.name}" cssClass="${current.cssClass}"/>
						<form:errors path="${current.name}" cssClass="field-error help-inline"/>
					</c:when>
					<c:when test="${current.type == 'many-to-one'}">
						<form:select path="${current.name}.id"
						             data-placeholder="Select ..."
						             cssClass="chzn-select ${current.cssClass}">
							<form:options items="${current.variants}" itemValue="id"/>
						</form:select>
					</c:when>
					<c:when test="${current.type == 'many-to-many'}">
						<div class="many-to-many span7">
							<form:checkboxes path="${current.name}Id" items="${current.variants}" itemValue="id" element="div" ></form:checkboxes>
						</div>
					</c:when>
					<c:otherwise>
						Internal error
					</c:otherwise>
			</c:choose>
			</div>

		</div>
	</c:forEach>

	<hr/>
	<div style="width: 100%;" class="text-right">
		<input type="submit"
		       hotkey="ctrl+s"
		       rel="tooltip" title="Ctrl + S"
		       value="<spring:message code="crud.edit.save"/>"
		       class="btn btn-primary uppercase "/>
	</div>
</form:form>
