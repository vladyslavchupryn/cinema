<%@page language="java" contentType="text/html; charset=utf8"
        pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<spring:url var="base" value="/"/>
<c:set var="crud" scope="request" value="${base}${path}/"/>

<dl class="dl-horizontal">
	<c:forEach var="current" items="${columns}">
		<dt><spring:message code="${path}.column.${current}"/>:</dt>
		<c:catch>
			<c:set var="entityId" value='${object[current].id}'/>
		</c:catch>
		<dd>
		<c:choose>
			<c:when test="${empty entityId}">
				<c:out value="${object[current]}"/>
			</c:when>
			<c:otherwise>
				<a href="${base}${current}/view/${entityId}">
					<c:out value="${object[current]}"/>
				</a>

			</c:otherwise>
		</c:choose>
		</dd>
		<c:set var="entityId" value=''/>
	</c:forEach>
</dl>

<hr/>
<div style="width: 100%;" class="text-right">
	<a class="btn btn-primary uppercase" href="${crud}edit/${object.id}" hotkey="alt+e" rel="tooltip" title="Alt + E"><spring:message code="crud.view.edit"/></a>
</div>


