<%@page language="java" contentType="text/html; charset=utf8"
        pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<spring:url var="base" value="/"/>
<c:set var="crud" scope="request" value="${base}${path}/"/>

<ul class="breadcrumb">
	<li><a href="${base}"><spring:message code="project.name"/></a> <span class="divider">/</span></li>
	<li><a href="${crud}/list"><spring:message code="${path}.list.title"/></a> <span class="divider">/</span></li>
	<li class="active"><spring:message code="${path}.view.title"/></li>
</ul>

<div class="well well-large" >
	<tiles:insertAttribute name="editBody"/>
</div>
