<%@page language="java" contentType="text/html; charset=utf8"
        pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<spring:url var="base" value="/" />

<ul class="breadcrumb">
	<li><a href="${base}"><spring:message code="project.name"/></a> <span class="divider">/</span></li>
	<li class="active"><spring:message code="navigation.report.customers-by-films"/></li>
</ul>

<table class="table table-striped table-bordered table-hover">
	<thead>
		<th>
			<spring:message code="report.customers-by-films.film"/>
		</th>
		<th>
			<spring:message code="report.customers-by-films.customerCount"/>
		</th>
		<th>
			<spring:message code="report.customers-by-films.income"/>
		</th>
	</thead>
	<tbody>
		<c:forEach var="row" items="${data}">
			<tr>
				<td><c:out value="${row[0]}"/></td>
				<td><c:out value="${row[1]}"/></td>
				<td><c:out value="${row[2]}"/></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
