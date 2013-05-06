<%@page language="java" contentType="text/html; charset=utf8"
        pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<div class="page-header">
	<h1>Настройка проекта</h1>
</div>

<dl>
	<dt>Maven</dt>
	<dd>
		Укажите настройки доступа к серверу томкат (пользователь должен обладать ролью <strong>manager-script</strong>):
		<div class="well well-small">
		<xmp>
			<server>
				<id>cinema-server</id>
				<username>****</username>
				<password>****</password>
			</server>
		</xmp>
		</div>
		Создайте профиль в settings.xml:
		<div class="well well-small">
		<xmp>
			<profile>
				<id>cinema-production</id>
				<properties>
					<jdbc-url>jdbc:postgresql://[host]/[db]</jdbc-url>
					<jdbc-username>****</jdbc-username>
					<jdbc-password>****</jdbc-password>

					<server-url-manager>http://cinema.web100.chuprin.pp.ua/manager</server-url-manager>
					<server-id>cinema-server</server-id>

				</properties>
			</profile>
		</xmp>
		</div>
	</dd>
	<dt>Postgres</dt>
	<dd>
		Для того чтобы обновить структуру БД выполните:
		<div class="well well-small">
			mvn flyway:migrate
		</div>

		В случае каких либо проблем скрипты со структурой БД находятся по пути
		<strong>[project]/db/migration/</strong>
	</dd>
	<dt>Tomcat 6</dt>
	<dd>
		Для развертывания проекта в контейнере сервлетов выолните:
		<div class="well well-small">
			mvn tomcat6:deploy
		</div>
	</dd>

</dl>
