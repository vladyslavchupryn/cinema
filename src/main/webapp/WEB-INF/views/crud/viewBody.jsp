<%@page language="java" contentType="text/html; charset=utf8"
        pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<dl class="dl-horizontal">
	<dt>Name:</dt>
	<dd>${object.name}</dd>
	<dt>Author:</dt>
	<dd>${object.author}</dd>
	<dt>Genre:</dt>
	<dd>${object.genre}</dd>
	<dt>Country:</dt>
	<dd>${object.country}</dd>
	<dt>Year:</dt>
	<dd>${object.year}</dd>
	<dt>Duration:</dt>
	<dd>${object.duration}</dd>
</dl>
