<%@page language="java" contentType="text/html; charset=utf8"
        pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<div class="page-header">
	<h1><spring:message code="project.name"/> <small>Резервирование и покупка битетов</small></h1>
</div>

<div class="well">
	Использованные технологии (<a href="<spring:url value="/setup/"/> ">инструкция по настройке</a>)
</div>
<dl class="dl-horizontal">
	<dt>СУБД</dt>
	<dd>PostgreSQL 9.23</dd>
	<dt>Фреймворк</dt>
	<dd>Spring 3.2.2</dd>
	<dt>ORM</dt>
	<dd>Hibernate 3.2.2</dd>
	<dt>Сервер приложений</dt>
	<dd>Tomcat 6,7</dd>
	<dt>Инструмент сборки проектов</dt>
	<dd>Maven 3.0.4</dd>
</dl>

<div class="well">
	Основные функции
</div>
<ul>
	<li>работа с несколькими залами</li>
	<li>произвольное количество сеансов</li>
	<li>наличие ценовых категорий мест в зависимоти от зала и типа места</li>
	<li>создание скидок и дополнительных услуг (корреляции)</li>
	<li>автоматический калькулятор стоимости билета с возможностью ручного ввода стоимости</li>
	<li>многоязычность</li>
	<li>отчеты</li>
</ul>

