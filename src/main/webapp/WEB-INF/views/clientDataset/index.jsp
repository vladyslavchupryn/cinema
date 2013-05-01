<%@page language="java" contentType="text/html; charset=utf8"
        pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!--SPIKE
мы создаем div просто чтобы кудато подвязать выпадающее меню
такой подход обусловлен несовершенством плагина

в будущем стоит этот плагин переписать
-->
<div id="context" data-toggle="context" data-target="#context-menu"
     style="display:none"></div>
<div id="context-menu">
	<ul class="dropdown-menu" role="menu">
		<li><a tabindex="-1" href="#" id="create-child">Create child</a></li>
		<li><a tabindex="-1" href="#">Separated link</a></li>
	</ul>
</div>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span2">
			<script type="text/javascript"
			        src="<spring:url value="/js/bootstrap/bootstrap-contextmenu.js" />"></script>

			<script type="text/javascript"
			        src="<spring:url value="/js/jquery/jquery.cookie.js" />"></script>

			<script type="text/javascript"
			        src="<spring:url value="/js/jquery/jq_tree/tree.jquery.js" />"></script>
			<link rel="stylesheet" type="text/css"
			      href="<spring:url value="/js/jquery/jq_tree/jqtree.css" />"/>
			<script type="text/javascript"

			        src="<spring:url value="/js/pages/clientDataset.js" />"></script>
			<script type="text/javascript">
				$(function () {

					var tree = new DatasetTree({
						treeSelector         : "#client_dataset_tree",
						currentId            : ${currentId},
						contextDivSelector   : "#context",
						fromContainerSelector: '#current-dataset'
					});

					tree.peekChildCreate("#create-child");
					tree.enableAjax();

					ui.hotkey('Alt+X', function(){
						$('#save-xml-button').click();
					});

					$('#save-xml-button').click(function(){
						$.ajax({
							url : BASE_URL + 'clientDataset/writeXml',
							success : function(){
								ui.notify('Xml regenerate successful');
							},
							error : function(x,error) {
								ui.notify('Xml regeneration',{
									type : 'error'
								});
							}
						});
					});

				});
			</script>
			<style type="text/css">
				#save-xml-button {
					width: 100%;
				}
			</style>
			<a class="btn btn-info" id="save-xml-button">
				Save xml (Ctrl+X)
			</a>

			<div id="client_dataset_tree"
			     data-url="<spring:url value="/clientDataset/childJson" />"></div>
		</div>
		<div class="span10">
			<div id="current-dataset">
				<c:if test="${!empty currentDataset}">
					<tiles:insertAttribute name="form"/>
				</c:if>
			</div>

			<div>
				<c:if test="${!empty clientDatasetList}">
					<h3>Children list</h3>
					<table border="1">
						<tr>
							<th>Parent</th>
							<th>Name</th>
							<th>Data provider dataset id</th>
							<th>Description</th>
							<th>Layer type</th>
							<th>Layer isolines</th>
							<th>Data provider type</th>
							<th>Time interval start</th>
							<th>Time interval end</th>
							<th>Time step in mili</th>
							<th>Time step type</th>
							<th></th>
						</tr>
						<c:forEach items="${clientDatasetList}"
						           var="currentDataset">
							<tr>
								<td>${currentDataset.parent}</td>
								<td>${currentDataset.name}</td>
								<td>${currentDataset.dataProviderDatasetId}</td>
								<td>${currentDataset.description}</td>
								<td>${currentDataset.layerType}</td>
								<td>${currentDataset.layerIsolines}</td>
								<td>${currentDataset.dataProviderType}</td>
								<td>${currentDataset.timeIntervalStart}</td>
								<td>${currentDataset.timeIntervalEnd}</td>
								<td>${currentDataset.timeStepInMilli}</td>
								<td>${currentDataset.timeStepType}</td>
								<td>
									<a href="<spring:url value="/clientDataset/delete" />/${currentDataset.id}">Delete</a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
			</div>
		</div>
	</div>
</div>

