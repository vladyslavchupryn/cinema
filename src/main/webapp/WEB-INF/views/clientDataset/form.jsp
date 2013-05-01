<%@page language="java" contentType="text/html; charset=utf8"
        pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
	.hero-unit {
		padding-top: 10px;
		padding-right: 10px;
		padding-bottom: 10px;
		padding-left: 10px;
	}
</style>

<script type="text/javascript">
	$(function () {
		$("#dataset-form").ajaxForm(function () {
			ui.notify("Save successful");
		});
		ui.hotkey('ctrl+s',function(){
			$("#dataset-form").submit();
		});

		$(".chzn-select").chosen();
	});
</script>

<spring:url var="saveAction" value='/clientDataset/save'/>
<form:form method="post" id="dataset-form" action="${saveAction}"
           commandName="currentDataset" class="form-horizontal">
<form:hidden path="id"/>
<form:hidden path="workerDataset.id"/>
<div class="row-fluid show-grid">
<div class="span6 hero-unit">
	<h3 class="text-center">Client</h3>

	<div class="control-group">
		<label class="control-label">Parent</label>

		<div class="controls"><form:input path="parent"
		                                  cssClass="positive-integer"/></div>
	</div>
	<div class="control-group">
		<label class="control-label">Name</label>

		<div class="controls"><form:input path="name" required="true"/></div>
	</div>
	<div class="control-group">
		<label class="control-label">Description</label>

		<div class="controls"><form:input path="description"/></div>
	</div>
	<div class="control-group">
		<label class="control-label">Data provider dataset id</label>

		<div class="controls"><form:input path="dataProvider.datasetId"
		                                  required="true"/></div>
	</div>
	<div class="control-group">
		<label class="control-label">Data provider type</label>

		<div class="controls">
			<form:select path="dataProvider.type" data-placeholder="Select type..." cssClass="chzn-select">
				<%-- Пример кастомного добавления значений --%>
				<form:option value="" label="empty" />
				<form:options items="${dataProviderTypes}" itemValue="id" itemLabel="name"/>
			</form:select>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">Layer type</label>

		<div class="controls">
			<form:select path="layer.type" data-placeholder="Select type..." cssClass="chzn-select">
				<form:option value="" label="empty" />
				<form:options items="${layerTypes}" itemValue="id" itemLabel="name"/>
			</form:select>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">Layer isolines</label>

		<div class="controls"><form:checkbox path="layer.isolines"/></div>
	</div>
	<div class="control-group">
		<label class="control-label">Time interval start</label>

		<div class="controls"><form:input path="timeInterval.start"
		                                  cssClass="date-in-milli positive-integer"/></div>
	</div>
	<div class="control-group">
		<label class="control-label">Time interval end</label>

		<div class="controls"><form:input path="timeInterval.end"
		                                  cssClass="date-in-milli positive-integer"/></div>
	</div>
	<div class="control-group">
		<label class="control-label">Time step in mili</label>

		<div class="controls"><form:input path="timeStep.inMilli"
		                                  cssClass="positive-integer"/></div>
	</div>
	<div class="control-group">
		<label class="control-label">Time step type</label>

		<div class="controls">
			<form:select path="timeStep.type" data-placeholder="Select type..." cssClass="chzn-select">
				<form:option value="" label="empty" />
				<form:options items="${timeTypes}" itemValue="id" itemLabel="name"/>
			</form:select>
		</div>
	</div>

</div>
<div class="span6 hero-unit">
	<h3 class="text-center">Worker</h3>

	<div class="control-group">
		<label class="control-label">Name</label>

		<div class="controls"><form:input
				path="workerDataset.name"/></div>
	</div>
	<div class="control-group">
		<label class="control-label">Path</label>

		<div class="controls"><form:input
				path="workerDataset.path"/></div>
	</div>
	<div class="control-group">
		<label class="control-label">Grid step lat</label>

		<div class="controls"><form:input
				path="workerDataset.gridStep.lat"
				cssClass="positive-decimal"/></div>
	</div>
	<div class="control-group">
		<label class="control-label">Grid step lon</label>

		<div class="controls"><form:input
				path="workerDataset.gridStep.lon"
				cssClass="positive-decimal"/></div>
	</div>
	<div class="control-group">
		<label class="control-label">Driver type</label>

		<div class="controls">
			<form:select path="workerDataset.driver.type" data-placeholder="Select type..." cssClass="chzn-select">
				<form:option value="" label="empty" />
				<form:options items="${driverTypes}" itemValue="id" itemLabel="name"/>
			</form:select>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">Driver bands</label>

		<div class="controls"><form:checkbox
				path="workerDataset.driver.bands"/></div>
	</div>
	<div class="control-group">
		<label class="control-label" cssClass="positive-integer">Driver time
			step in milli</label>

		<div class="controls"><form:input
				path="workerDataset.driver.timeStepInMilli"/></div>
	</div>
	<div class="control-group">
		<label class="control-label">Driver pathname rule regex</label>

		<div class="controls"><form:input
				path="workerDataset.driver.pathnameRuleRegex"/></div>
	</div>
	<div class="control-group">
		<label class="control-label">Driver pathname description
			regex</label>

		<div class="controls"><form:input
				path="workerDataset.driver.pathnameDescriptionRegex"/></div>
	</div>
	<div class="control-group">
		<label class="control-label">Driver pathname description
			string</label>

		<div class="controls"><form:input
				path="workerDataset.driver.pathnameDescriptionString"/></div>
	</div>
	<div class="control-group">
		<label class="control-label">Driver metadata prefix</label>

		<div class="controls"><form:input
				path="workerDataset.driver.metadataPrefix"/></div>
	</div>
	<div class="control-group">
		<label class="control-label">Driver hdf driver type</label>

		<div class="controls">

			<form:select path="workerDataset.driver.hdfDriverType"  data-placeholder="Select type..." cssClass="chzn-select">
				<form:option value="" label="empty" />
				<form:options items="${hdfDriverTypes}" itemValue="id" itemLabel="name"/>
			</form:select>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">Driver folder in
			fileWithGroups</label>

		<div class="controls"><form:input
				path="workerDataset.driver.folderInFileWithGroups"/></div>
	</div>
	<div class="control-group">
		<label class="control-label">Driver start lat index
			offset</label>

		<div class="controls"><form:input
				path="workerDataset.driver.startLatIndexOffset"
				cssClass="positive-integer"/></div>
	</div>
	<div class="control-group">
		<label class="control-label">Driver end lat index offset</label>

		<div class="controls"><form:input
				path="workerDataset.driver.endLatIndexOffset"
				cssClass="positive-integer"/></div>
	</div>
	<div class="control-group">
		<label class="control-label">Driver start lat offset</label>

		<div class="controls"><form:input
				path="workerDataset.driver.startLatOffset"
				cssClass="positive-decimal"/></div>
	</div>
	<div class="control-group">
		<label class="control-label">Driver end lat offset</label>

		<div class="controls"><form:input
				path="workerDataset.driver.endLatOffset"
				cssClass="positive-decimal"/></div>
	</div>
	<div class="control-group">
		<label class="control-label">Driver path in file</label>

		<div class="controls"><form:input
				path="workerDataset.driver.pathInFile"/></div>
	</div>
	<div class="control-group">
		<label class="control-label">Metadata add offset key</label>

		<div class="controls"><form:input
				path="workerDataset.metadata.addOffsetKey"/></div>
	</div>
	<div class="control-group">
		<label class="control-label">Metadata scale factor key</label>

		<div class="controls"><form:input
				path="workerDataset.metadata.scaleFactorKey"/></div>
	</div>
	<div class="control-group">
		<label class="control-label">Metadata missing value key</label>

		<div class="controls"><form:input
				path="workerDataset.metadata.missingValueKey"/></div>
	</div>
	<div class="control-group">
		<label class="control-label">Metadata fill value key</label>

		<div class="controls"><form:input
				path="workerDataset.metadata.fillValueKey"/></div>
	</div>
	<div class="control-group">
		<label class="control-label">Metadata add offset</label>

		<div class="controls"><form:input
				path="workerDataset.metadata.addOffset"
				cssClass="positive-integer"/></div>
	</div>
	<div class="control-group">
		<label class="control-label">Metadata scale factor</label>

		<div class="controls"><form:input
				path="workerDataset.metadata.scaleFactor"
				cssClass="positive-integer"/></div>
	</div>
	<div class="control-group">
		<label class="control-label">Metadata missing value</label>

		<div class="controls"><form:input
				path="workerDataset.metadata.missingValue"
				cssClass="positive-decimal"/></div>
	</div>
	<div class="control-group">
		<label class="control-label">Metadata fill value</label>

		<div class="controls"><form:input
				path="workerDataset.metadata.fillValue"
				cssClass="positive-decimal"/></div>
	</div>
	<div class="control-group">
		<label class="control-label">Scan</label>

		<div class="controls"><form:input
				path="workerDataset.scan"/></div>
	</div>
</div>
</div>
<input type="submit" value="UPDATE (Ctrl+S)"
       class="btn" style="width: 100%"/>

</form:form>
