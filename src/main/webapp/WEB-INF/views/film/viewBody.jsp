<%@page language="java" contentType="text/html; charset=utf8"
        pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<dl class="dl-horizontal">
	<dt>Name:</dt>
	<dd>${film.name}</dd>
	<dt>Author:</dt>
	<dd>${film.author}</dd>
	<dt>Genre:</dt>
	<dd>${film.genre}</dd>
	<dt>Country:</dt>
	<dd>${film.country}</dd>
	<dt>Year:</dt>
	<dd>${film.year}</dd>
	<dt>Duration:</dt>
	<dd>${film.duration}</dd>
</dl>
