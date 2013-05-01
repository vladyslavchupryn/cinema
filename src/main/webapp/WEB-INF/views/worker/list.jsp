<%@page language="java" contentType="text/html; charset=utf8"
        pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<h3>Workers list</h3>

<div>
	<c:choose>
		<c:when test="${!empty workers}">
			<table border="1">
				<tr>
					<th>IP</th>
					<th></th>
				</tr>
				<c:forEach items="${workers}"
				           var="current">
					<tr>
						<td>${current.ip}</td>
						<td>
							<a href="<spring:url value="/worker/stop" />/${current.id}">Stop</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			Workers table is empty
		</c:otherwise>
	</c:choose>
	<c:if test="">

	</c:if>
</div>
