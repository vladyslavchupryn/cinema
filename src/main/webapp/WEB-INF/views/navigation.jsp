<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<div class="well sidebar-nav">
	<ul class="nav nav-list">
		<li class="nav-header">Sessions and Films</li>
		<li class="active"><a href="<spring:url value="/session/" />">Sessions</a></li>
		<li><a href="<spring:url value="/film/" />">Films</a></li>

		<li class="nav-header">Administration</li>
		<li><a href="<spring:url value="/hall/" />">Halls</a></li>
		<li><a href="<spring:url value="/placeType/" />#">Place Types</a></li>
		<li><a href="<spring:url value="/category/" />#">Place Price Categories</a></li>
		<li><a href="<spring:url value="/place/" />#">Places</a></li>

		<li class="nav-header">Reports</li>
		<li><a href="#">Customers by session</a></li>
		<li><a href="#">Customers by film</a></li>
		<li><a href="#">Customers by services and discounts</a></li>
	</ul>
</div><!--/.well -->
