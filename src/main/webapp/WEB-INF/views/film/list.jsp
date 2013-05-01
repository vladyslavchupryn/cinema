<%@page language="java" contentType="text/html; charset=utf8"
        pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<h2 class="text-center">Films</h2>

<a class="btn btn-primary" href="<spring:url value="/film/create" />">CREATE</a>
<br/>
<table class="table table-striped table-bordered">
	<thead>
	<th>#</th>
	<th>NAME</th>
	<th>AUTHOR</th>
	<th>GENRE</th>
	<th>COUNTRY</th>
	<th>YEAR</th>
	<th>DURATION</th>
	<th class="list-icon-cell"></th>
	</thead>
	<tbody>
	<c:choose>
		<c:when test="${!empty list}">
			<c:forEach items="${list}" var="current">
				<tr>
					<td>1</td>
					<td>${current.name}</td>
					<td>${current.author}</td>
					<td>${current.genre}</td>
					<td>${current.country}</td>
					<td>${current.year}</td>
					<td>${current.duration}</td>
					<td>
						<a href="<spring:url value="/film/view" />/${current.id}" class="list-icon icon-eye-open"></a>
						<a href="<spring:url value="/film/edit" />/${current.id}" class="list-icon icon-edit"></a>
						<a href="<spring:url value="/film/delete" />/${current.id}" class="list-icon icon-remove"></a>
					</td>
				</tr>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<tr>
				<td colspan="8" style = "text-align: center;">Films not exists</td>
			</tr>
		</c:otherwise>
	</c:choose>
	</tbody>
</table>
<a class="btn btn-primary" class = "text-right" href="<spring:url value="/film/create" />">CREATE</a>
