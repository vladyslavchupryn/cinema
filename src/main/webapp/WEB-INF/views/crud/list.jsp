<%@page language="java" contentType="text/html; charset=utf8"
        pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<spring:url var="base" value="/" />
<c:set var="crud" scope="request" value="${base}${path}/"/>

<ul class="breadcrumb">
	<li><a href="${base}"><spring:message code="project.name"/></a> <span class="divider">/</span></li>
	<li class="active"><spring:message code="${path}.list.title"/></li>
</ul>

<script type="text/javascript">
	function decrement(selector) {
		$(selector).text(parseInt($(selector).text())-1);
	}
	$(function(){
		$('.delete-button').click(function(){
			var that = this;
			bootbox.confirm("<spring:message code="crud.delete.confirm"/>", function(result) {
				if(result) {
					$(that).parents("tr").hide();
					$.post($(that).attr('href'),{}, function(){
						$(that).parents("tr").hide();
						decrement('#page-end');
						decrement('#count');

						var start = parseInt($('#page-start').text());
						var end = parseInt($('#page-end').text());
						var pageEmpty = end < start;
						if(pageEmpty) {
							$('#list-info').hide();
							$('.list-empty-page').show();
						}

						ui.notify('<spring:message code="crud.delete.success"/>');
					}).fail(function() {
						ui.notify('<spring:message code="crud.delete.fail"/>',{type:'error'});
					});
				}
			});

			return false;
		});

		var count = $.cookie('${path}' + '-page-count');
		$('.page-length').val(count);

		$('.page-length').change(function(){
			var start = ${pageStart};

			var count = $(this).val();
			var end = start + count;

			$.cookie('${path}' + '-page-count', count);

			window.location = '${crud}list/?sort=${sort}&pageStart='+start+'&pageEnd='+end;
		});
	});
</script>

<div class="row-fluid">
	<div class="text-left" style="float:left;">
		<a class="btn btn-primary uppercase" href="${crud}create" hotkey="alt+n" rel="tooltip" title="Alt + N"><spring:message code="crud.list.create"/></a>
	</div>
	<div class="text-right">
		<select class="page-length">
			<option value="10" selected="selected">10</option>
			<option value="25">25</option>
			<option value="50">50</option>
		</select>
	</div>
</div>

<table class="table table-striped table-bordered table-hover">
	<thead>
	<th>#</th>
	<c:forEach var="current" items="${columns}">
		<th class="uppercase">
			<c:choose>
				<c:when test="${current.type == 'simple'}">
					<spring:message code="${path}.column.${current.name}"/>
				</c:when>
				<c:when test="${current.type == 'many-to-one'}">
					<a href="${base}${current.name}/list">
						<spring:message code="${path}.column.${current.name}"/>
					</a>
				</c:when>
				<c:when test="${current.type == 'many-to-many'}">
					<a href="${base}${current.name}/list">
						<spring:message code="${path}.column.${current.name}"/>
					</a>
				</c:when>
				<c:otherwise>
					Internal error
				</c:otherwise>
			</c:choose>
				<a rel="tooltip" data-placement="bottom" title="<spring:message code="crud.list.descending"/>"
				   class="link-button icon-large icon-arrow-down pull-right"
				   href="${crud}list?sort=${current.name}-desc">
				</a>
				<a rel="tooltip" data-placement="bottom" title="<spring:message code="crud.list.ascending"/>"
				   class="link-button icon-large icon-arrow-up pull-right"
				   href="${crud}list?sort=${current.name}-asc">
				</a>
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
					<c:forEach var="currentColumn" items="${columns}">
						<td>
							<c:choose>
								<c:when test="${currentColumn.type == 'simple'}">
									<c:out value="${current[currentColumn.name]}"/>
								</c:when>
								<c:when test="${currentColumn.type == 'many-to-one'}">
									<a href="${base}${currentColumn.name}/view/${current[currentColumn.name].id}">
										<c:out value="${current[currentColumn.name]}"/>
									</a>
								</c:when>
								<c:when test="${currentColumn.type == 'many-to-many'}">
									<c:forEach items="${current[currentColumn.name]}" var="currentRelation">
										<a href="${base}${currentColumn.relation}/view/${currentRelation.id}">
											<c:out value="${currentRelation}"/>
										</a>
									</c:forEach>
								</c:when>
								<c:otherwise>
									Internal error
								</c:otherwise>
							</c:choose>
						</td>
					</c:forEach>
					<td>
						<a rel="tooltip" data-placement="bottom" title="<spring:message code="crud.list.view"/>" href="${crud}view/${current.id}" class="link-button list-icon icon-eye-open"></a>
						<a rel="tooltip" data-placement="bottom" title="<spring:message code="crud.list.edit"/>" href="${crud}edit/${current.id}" class="link-button list-icon icon-edit"></a>
						<a rel="tooltip" data-placement="bottom" title="<spring:message code="crud.list.delete"/>" href="${crud}delete/${current.id}" class="delete-button link-button list-icon icon-remove"></a>
					</td>
				</tr>
			</c:forEach>
			<tr class="hide list-empty-page">
				<td colspan="${fn:length(columns)+2}" style="text-align: center;"><spring:message code="crud.list.page.empty"/></td>
			</tr>
		</c:when>
		<c:otherwise>
			<tr>
				<td colspan="${fn:length(columns)+2}" style="text-align: center;"><spring:message code="${path}.list.empty"/></td>
			</tr>
		</c:otherwise>
	</c:choose>
	</tbody>
</table>

<script type="text/javascript">
	$(function(){
		initPaginator(${pageStart}, ${pageEnd}, ${count},'${crud}list?sort=${sort}');
	})
</script>
<div class="row-fluid">
	<div class="text-left" style="float:left;margin-top: 10px;margin-right: 10px;">
		<a class="btn btn-primary uppercase" class = "text-right" href="${crud}create" rel="tooltip" title="Alt + N" ><spring:message code="crud.list.create"/></a>
	</div>
	<div class="text-right">
		<c:if test="${count > 0}">
			<div id="list-info" class="text-left" style="float: left;">
				<spring:message code="crud.list.position" arguments="
					<div class=\"inline\" id=\"page-start\">${pageStart+1}</div>,
					<div class=\"inline\" id=\"page-end\">${pageEnd}</div>,
					<div class=\"inline\" id=\"count\">${count}</div>" htmlEscape="false" />
			</div>
			<div class="pagination text-right">
				<ul>
					<li class="pagination-prev"><a href="#" hotkey="alt+left" rel="tooltip" title="Alt + &#8592;"><spring:message code="crud.list.prev"/></a></li>
					<li class="pagination-next"><a href="#" hotkey="alt+right" rel="tooltip" title="Alt + &#8594;"><spring:message code="crud.list.next"/></a></li>
				</ul>
			</div>
		</c:if>
	</div>
</div>
