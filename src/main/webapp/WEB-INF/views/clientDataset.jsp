<%@page language="java" contentType="text/html; charset=utf8"
        pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style type="text/css">
	.left-menu {
		min-width: 200px;
		float: left;
	}

	.content {
		margin-left: 200px;
	}

	.current-dataset {
		margin-top: -21px;
		padding-right: 30px;
		display: block;
	}

	.children-dataset {
	}

	#ui-datepicker-div {
		font-size: 11px;
	}

	#create-childer-div {
		display: none;
		position: relative;
		background: #90ee90;
		z-index: 1;
		width: 200px;
	}

	.worker-table {
		float: left;
		margin-right: 50px;
	}
</style>

<div id="create-childer-div" parent-id="0">
	<a href="">Create chilren</a>
</div>

<div class="left-menu">
	<script type="text/javascript"
	        src="<spring:url value="/js/jquery.cookie.js" />"></script>
	<script type="text/javascript"
	        src="<spring:url value="/js/jquery.numeric.js" />"></script>
	<script type="text/javascript"
	        src="<spring:url value="/js/jq_tree/tree.jquery.js" />"></script>
	<link rel="stylesheet" type="text/css"
	      href="<spring:url value="/js/jq_tree/jqtree.css" />"/>
	<script type="text/javascript"
	        src="<spring:url value="/js/pages/clientDataset.js" />"></script>
	<script type="text/javascript">
		$(function () {
			createDatasetTree({
				currentId:${currentId},
				indexUrl: "<spring:url value="/clientDataset/index" />",
				treeJson: ${treeJson}
			});
			peekChildCreate("#create-childer-div", "<spring:url value="/clientDataset/createChild" />");
		});
	</script>
	<div id="client_dataset_tree"
	     data-url="<spring:url value="/clientDataset/childJson" />"></div>
</div>

<spring:url var="saveAction" value='/clientDataset/save'/>
<div class="content">
<c:if test="${!empty currentDataset}">
<div class="current-dataset">
	<h2>Update current dataset</h2>

	<form:form method="post" action="${saveAction}"
	           commandName="currentDataset">
		<form:hidden path="id"/>
		<form:hidden path="workerDataset.id"/>
		<table class="worker-table">
			<tr>
				<td colspan="2"><h3>Worker</h3></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><form:input path="workerDataset.name"/></td>
			</tr>
			<tr>
				<td>Path</td>
				<td><form:input path="workerDataset.path"/></td>
			</tr>
			<tr>
				<td>Grid step lat</td>
				<td><form:input path="workerDataset.gridStepLat"
				                cssClass="positive-decimal"/></td>
			</tr>
			<tr>
				<td>Grid step lon</td>
				<td><form:input path="workerDataset.gridStepLon"
				                cssClass="positive-decimal"/></td>
			</tr>
			<tr>
				<td>Driver type</td>
				<td><form:input path="workerDataset.driverType"/></td>
			</tr>
			<tr>
				<td>Driver bands</td>
				<td><form:checkbox path="workerDataset.driverBands"/></td>
			</tr>
			<tr>
				<td>Driver time step in milli</td>
				<td><form:input
						path="workerDataset.driverTimeStepInMilli"/></td>
			</tr>
			<tr>
				<td>Driver pathname rule regex</td>
				<td><form:input
						path="workerDataset.driverPathnameRuleRegex"/></td>
			</tr>
			<tr>
				<td>Driver pathname description regex</td>
				<td><form:input
						path="workerDataset.driverPathnameDescriptionRegex"/></td>
			</tr>
			<tr>
				<td>Driver pathname description string</td>
				<td><form:input
						path="workerDataset.driverPathnameDescriptionString"/></td>
			</tr>
			<tr>
				<td>Driver metadata prefix</td>
				<td><form:input
						path="workerDataset.driverMetadataPrefix"/></td>
			</tr>
			<tr>
				<td>Metadata add offset key</td>
				<td><form:input
						path="workerDataset.metadataAddOffsetKey"/></td>
			</tr>
			<tr>
				<td>Metadata scale factor key</td>
				<td><form:input
						path="workerDataset.metadataScaleFactorKey"/></td>
			</tr>
			<tr>
				<td>Metadata missing value key</td>
				<td><form:input
						path="workerDataset.metadataMissingValueKey"/></td>
			</tr>
			<tr>
				<td>Metadata fill value key</td>
				<td><form:input
						path="workerDataset.metadataFillValueKey"/></td>
			</tr>
			<tr>
				<td>Driver hdf driver type</td>
				<td><form:input
						path="workerDataset.driverHdfDriverType"/></td>
			</tr>
			<tr>
				<td>Driver folder in fileWithGroups</td>
				<td><form:input
						path="workerDataset.driverFolderInFileWithGroups"/></td>
			</tr>
			<tr>
				<td>Driver start lat index offset</td>
				<td><form:input
						path="workerDataset.driverStartLatIndexOffset"/></td>
			</tr>
			<tr>
				<td>Driver end lat index offset</td>
				<td><form:input
						path="workerDataset.driverEndLatIndexOffset"/></td>
			</tr>
			<tr>
				<td>Driver start lat offset</td>
				<td><form:input
						path="workerDataset.driverStartLatOffset"/></td>
			</tr>
			<tr>
				<td>Driver end lat offset</td>
				<td><form:input
						path="workerDataset.driverEndLatOffset"/></td>
			</tr>
			<tr>
				<td>Driver path in file</td>
				<td><form:input
						path="workerDataset.driverPathInFile"/></td>
			</tr>
			<tr>
				<td>Metadata add offset</td>
				<td><form:input
						path="workerDataset.metadataAddOffset"/></td>
			</tr>
			<tr>
				<td>Metadata scale factor</td>
				<td><form:input
						path="workerDataset.metadataScaleFactor"/></td>
			</tr>
			<tr>
				<td>Metadata missing value</td>
				<td><form:input
						path="workerDataset.metadataMissingValue"/></td>
			</tr>
			<tr>
				<td>Metadata fill value</td>
				<td><form:input
						path="workerDataset.metadataFillValue"/></td>
			</tr>
			<tr>
				<td>Scan</td>
				<td><form:input path="workerDataset.scan"/></td>
			</tr>
		</table>

		<table class="client-table">
			<tr>
				<td colspan="2"><h3>Client</h3></td>
			</tr>
			<tr>
				<td>Parent</td>
				<td><form:input path="parent"/></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><form:input path="name"/></td>
			</tr>
			<tr>
				<td>Data provider dataset id</td>
				<td><form:input path="dataProviderDatasetId"/></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><form:input path="description"/></td>
			</tr>
			<tr>
				<td>Layer type</td>
				<td><form:input path="layerType"/></td>
			</tr>
			<tr>
				<td>Layer isolines</td>
				<td><form:checkbox path="layerIsolines"/></td>
			</tr>
			<tr>
				<td>Data provider type</td>
				<td><form:input path="dataProviderType"/></td>
			</tr>
			<tr>
				<td>Time interval start</td>
				<td><form:input path="timeIntervalStart"
				                cssClass="date-in-milli"/></td>
			</tr>
			<tr>
				<td>Time interval end</td>
				<td><form:input path="timeIntervalEnd"
				                cssClass="date-in-milli"/></td>
			</tr>
			<tr>
				<td>Time step in mili</td>
				<td><form:input path="timeStepInMilli"/></td>
			</tr>
			<tr>
				<td>Time step type</td>
				<td><form:input path="timeStepType"/></td>
			</tr>
			<tr colspan="2">
				<td>
					<input type="submit" value="Update current dataset"/>
				</td>
			</tr>
		</table>
	</form:form>
</div>
</c:if>

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
			<c:forEach items="${clientDatasetList}" var="currentDataset">
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
