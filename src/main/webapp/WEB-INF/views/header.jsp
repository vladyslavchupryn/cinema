<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container-fluid">
			<button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="brand" href="#"><spring:message code="project.name"/></a>
			<div class="nav-collapse collapse">
				<%--<p class="navbar-text pull-right">--%>
					<%--Logged in as <a href="#" class="navbar-link">Username</a>--%>
				<%--</p>--%>
				<ul class="nav">
					<li class="active"><a href="#"><spring:message code="header.home"/></a></li>
					<li><a href="#about"><spring:message code="header.about"/></a></li>
					<li><a href="#contact"><spring:message code="header.contact"/></a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
