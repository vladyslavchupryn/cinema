<%@page language="java" contentType="text/html; charset=utf8"
        pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<h2 class="text-center">Films</h2>

<a class="btn btn-primary" href="${crud}create">CREATE</a>
<br/>
<table class="table table-striped table-bordered table-hover">
	<thead>
	<th>#</th>
	<c:forEach var="column" items="${listColumns}">
		<th>
			${column}
				<a class="icon-large icon-arrow-down pull-right" href="${column}-asc"></a>
				<a class="icon-large icon-arrow-up pull-right" href="${column}-desc"></a>
		</th>
	</c:forEach>
	<th class="list-icon-cell"></th>
	</thead>
	<tbody>
	<c:choose>
		<c:when test="${!empty list}">
			<%Integer number = (Integer) request.getAttribute("pageStart") + 1;%>
			<c:forEach items="${list}" var="current">
				<tr>
					<td><%=number++%></td>
					<c:forEach var="column" items="${listColumns}">
						<td>${current[column]}</td>
					</c:forEach>
					<td>
						<a href="${crud}view/${current.id}" class="list-icon icon-eye-open"></a>
						<a href="${crud}edit/${current.id}" class="list-icon icon-edit"></a>
						<a href="${crud}delete/${current.id}" class="list-icon icon-remove"></a>
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

<script type="text/javascript">
	$(function(){
		initPaginator(${pageStart}, ${pageEnd}, ${count},'${path}/list');
	})
</script>
<div >
	<div class="text-left" style="float: left;">From ${pageStart+1} to ${pageEnd} of ${count}</div>
	<div class="pagination text-right">
		<ul>
			<li class="pagination-prev"><a href="#">Prev</a></li>
			<li class="pagination-next"><a href="#">Next</a></li>
		</ul>
	</div>
</div>
<a class="btn btn-primary" class = "text-right" href="${crud}create">CREATE</a>
