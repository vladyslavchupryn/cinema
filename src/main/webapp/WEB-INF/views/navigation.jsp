<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<div class="well sidebar-nav">
	<ul class="nav nav-list">
		<li class="nav-header"><spring:message code="navigation.session-films"/></li>
		<li class="<c:if test="${path == 'session'}">active</c:if>"><a href="<spring:url value="/session/" />"><spring:message code="navigation.sessions"/></a></li>
		<li class="<c:if test="${path == 'film'}">active</c:if>"><a href="<spring:url value="/film/" />"><spring:message code="navigation.films"/></a></li>

		<li class="nav-header"><spring:message code="navigation.administration"/></li>
		<li class="<c:if test="${path == 'hall'}">active</c:if>"><a href="<spring:url value="/hall/" />"><spring:message code="navigation.halls"/></a></li>
		<li class="<c:if test="${path == 'placeType'}">active</c:if>"><a href="<spring:url value="/placeType/" />#"><spring:message code="navigation.place-types"/></a></li>
		<li class="<c:if test="${path == 'category'}">active</c:if>"><a href="<spring:url value="/category/" />#"><spring:message code="navigation.place-categories"/></a></li>
		<li class="<c:if test="${path == 'place'}">active</c:if>"><a href="<spring:url value="/place/" />#"><spring:message code="navigation.places"/></a></li>
		<li class="<c:if test="${path == 'correlation'}">active</c:if>"><a href="<spring:url value="/correlation/" />#"><spring:message code="navigation.correlation"/></a></li>

		<li class="nav-header"><spring:message code="navigation.sales"/></li>
		<li class="<c:if test="${path == 'order'}">active</c:if>"><a href="<spring:url value="/order/" />"><spring:message code="navigation.order"/></a></li>

		<li class="nav-header"><spring:message code="navigation.reports"/></li>
		<li class="<c:if test="${path == ''}">active</c:if>"><a href="#"><spring:message code="navigation.report.customer-session"/></a></li>
		<li class="<c:if test="${path == ''}">active</c:if>"><a href="#"><spring:message code="navigation.report.customer-film"/></a></li>
		<li class="<c:if test="${path == ''}">active</c:if>"><a href="#"><spring:message code="navigation.report.customer-correlation"/></a></li>
	</ul>
</div>
