<%@page language="java" contentType="text/html; charset=utf8"
        pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<dl class="dl-horizontal">
	<c:forEach var="current" items="${columns}">
		<dt><spring:message code="${path}.column.${current}"/>:</dt>
		<dd><c:out value="${object[current]}"/></dd>
	</c:forEach>
</dl>
