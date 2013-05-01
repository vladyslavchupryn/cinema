package ua.pp.chuprin.web100.cinema.service.tools;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ua.pp.chuprin.web100.cinema.domain.dataset.worker.GridStep;
import ua.pp.chuprin.web100.cinema.domain.dataset.worker.WorkerDataset;
import ua.pp.chuprin.web100.cinema.domain.dataset.worker.WorkerDriver;
import ua.pp.chuprin.web100.cinema.domain.dataset.worker.WorkerMetadata;

public class WorkerDatasetXmlBuilder extends XmlBuilder {
	private WorkerDataset dataset;

	public WorkerDatasetXmlBuilder(Document document, WorkerDataset dataset) {
		super(document);
		this.dataset = dataset;
	}

	public Element build() {
		Element result = document.createElement("group");
		result.setAttribute("name", dataset.getName());

		Element id = document.createElement("id");
		setText(id, dataset.getId());
		result.appendChild(id);

		Element path = document.createElement("path");
		setText(path, dataset.getPath());
		result.appendChild(path);

		Element scan = document.createElement("scan");
		setText(scan, dataset.getScan());
		result.appendChild(scan);

		Element metadata = createMetadata(dataset.getMetadata());
		result.appendChild(metadata);

		Element gridStep = createGridStep(dataset.getGridStep());
		result.appendChild(gridStep);

		Element driver = createDriver(dataset.getDriver());
		result.appendChild(driver);

		return result;
	}

	private Element createMetadata(WorkerMetadata metadata) {
		Element result = document.createElement("metadata");

		Element add_offset_key = document.createElement("add_offset_key");
		setText(add_offset_key, metadata.getAddOffsetKey());
		result.appendChild(add_offset_key);

		Element scale_factor_key = document.createElement("scale_factor_key");
		setText(scale_factor_key, metadata.getScaleFactorKey());
		result.appendChild(scale_factor_key);

		Element missing_value_key = document.createElement("missing_value_key");
		setText(missing_value_key, metadata.getMissingValueKey());
		result.appendChild(missing_value_key);

		Element fill_value_key = document.createElement("fill_value_key");
		setText(fill_value_key, metadata.getFillValueKey());
		result.appendChild(fill_value_key);

		Element add_offset = document.createElement("add_offset");
		setText(add_offset, metadata.getAddOffset());
		result.appendChild(add_offset);

		Element scale_factor = document.createElement("scale_factor");
		setText(scale_factor, metadata.getScaleFactor());
		result.appendChild(scale_factor);

		Element missing_value = document.createElement("missing_value");
		setText(missing_value, metadata.getMissingValue());
		result.appendChild(missing_value);

		Element fill_value = document.createElement("fill_value");
		setText(fill_value, metadata.getFillValue());
		result.appendChild(fill_value);

		return result;
	}

	private Element createGridStep(GridStep gridStep) {
		Element result = document.createElement("grid_step");

		Element lat = document.createElement("lat");
		setText(lat, gridStep.getLat());
		result.appendChild(lat);

		Element lon = document.createElement("lon");
		setText(lon, gridStep.getLon());
		result.appendChild(lon);

		return result;
	}

	private Element createDriver(WorkerDriver driver) {
		Element result = document.createElement("driver");

		Element type = document.createElement("type");

		setText(type, driver.getType());
		result.appendChild(type);

		Element bands = document.createElement("bands");
		setText(bands, driver.getBands());
		result.appendChild(bands);

		Element time_step_in_milli = document.createElement("time_step_in_milli");
		setText(time_step_in_milli, driver.getTimeStepInMilli());
		result.appendChild(time_step_in_milli);

		Element pathname_rule_regex = document.createElement("pathname_rule_regex");
		setText(pathname_rule_regex, driver.getPathnameRuleRegex());
		result.appendChild(pathname_rule_regex);

		Element pathname_description_regex = document.createElement("pathname_description_regex");
		setText(pathname_description_regex, driver.getPathnameDescriptionRegex());
		result.appendChild(pathname_description_regex);

		Element pathname_description_string = document.createElement("pathname_description_string");
		setText(pathname_description_string, driver.getPathnameDescriptionString());
		result.appendChild(pathname_description_string);

		Element metadata_prefix = document.createElement("metadata_prefix");
		setText(metadata_prefix, driver.getMetadataPrefix());
		result.appendChild(metadata_prefix);

		Element hdf_driver_type = document.createElement("hdf_driver_type");
		setText(hdf_driver_type, driver.getHdfDriverType());
		result.appendChild(hdf_driver_type);

		Element folder_in_file_with_groups = document.createElement("folder_in_file_with_groups");
		setText(folder_in_file_with_groups, driver.getFolderInFileWithGroups());
		result.appendChild(folder_in_file_with_groups);

		Element start_lat_index_offset = document.createElement("start_lat_index_offset");
		setText(start_lat_index_offset, driver.getStartLatIndexOffset());
		result.appendChild(start_lat_index_offset);

		Element end_lat_offset = document.createElement("end_lat_offset");
		setText(end_lat_offset, driver.getEndLatIndexOffset());
		result.appendChild(end_lat_offset);

		Element path_in_file = document.createElement("path_in_file");
		setText(path_in_file, driver.getPathInFile());
		result.appendChild(path_in_file);

		return result;
	}

}
