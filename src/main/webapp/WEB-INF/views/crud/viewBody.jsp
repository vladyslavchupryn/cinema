<%@page language="java" contentType="text/html; charset=utf8"
        pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<spring:url var="base" value="/"/>
<c:set var="crud" scope="request" value="${base}${path}/"/>

<dl class="dl-horizontal">
	<c:forEach var="current" items="${columns}">
		<dt><spring:message code="${path}.column.${current.name}"/>:</dt>
		<dd>
			<c:choose>
				<c:when test="${current.type == 'simple'}">
					<c:out value="${object[current.name]}"/>
				</c:when>
				<c:when test="${current.type == 'many-to-one'}">
					<a href="${base}${current.name}/view/${object[current.name].id}">
						<c:out value="${object[current.name]}"/>
					</a>
				</c:when>
				<c:when test="${current.type == 'many-to-many'}">
					<c:out value="${object[current.name]}"/>
				</c:when>
				<c:otherwise>
					Internal error
				</c:otherwise>
			</c:choose>
		</dd>
		<c:set var="entityId" value=''/>
	</c:forEach>
</dl>

<hr/>
<div style="width: 100%;" class="text-right">
	<a class="btn btn-primary uppercase" href="${crud}edit/${object.id}"
	   hotkey="alt+e" rel="tooltip" title="Alt + E"><spring:message
			code="crud.view.edit"/></a>
</div>


