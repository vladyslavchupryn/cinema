package ua.pp.chuprin.web100.cinema.service.tools;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ua.pp.chuprin.web100.cinema.domain.dataset.client.ClientDataset;

public class ClientDatasetXmlBuilder extends XmlBuilder {
	private ClientDataset dataset;

	public ClientDatasetXmlBuilder(Document document, ClientDataset dataset) {
		super(document);
		this.dataset = dataset;
	}

	public Element build() {
		Element result = document.createElement("group");
		result.setAttribute("name", dataset.getName());

		Element id = document.createElement("id");
		setText(id, dataset.getId());
		result.appendChild(id);

		Element description = document.createElement("description");
		setText(description, dataset.getDescription());
		result.appendChild(description);

		Element timeStep = createTimeStep();
		result.appendChild(timeStep);

		// TODO этот вариант или предыдущий?
		// appendTimeStepOldFormat(result);

		Element layer = createLayer();
		result.appendChild(layer);

		Element dataProvider = createDataProvider();
		result.appendChild(dataProvider);

		Element dataTime = createTime();
		result.appendChild(dataTime);

		return result;
	}

	private Element createTime() {
		Element result = document.createElement("time");

		Element interval = createInterval();
		result.appendChild(interval);

		return result;
	}

	private Element createInterval() {
		Element interval = document.createElement("interval");

		Element start = document.createElement("start");
		setText(start, dataset.getTimeInterval().getStart());
		interval.appendChild(start);

		Element end = document.createElement("end");
		setText(end, dataset.getTimeInterval().getEnd());
		interval.appendChild(end);
		return interval;
	}

	private Element createDataProvider() {
		Element result = document.createElement("dataProvider");

		Element type = document.createElement("type");
		setText(type, dataset.getDataProvider().getTypeValue().getValue());
		result.appendChild(type);

		Element datasetId = document.createElement("dataset_id");
		setText(datasetId, dataset.getDataProvider().getDatasetId());
		result.appendChild(datasetId);

		return result;
	}

	private Element createLayer() {
		Element result = document.createElement("layer");

		Element type = document.createElement("type");
		setText(type, dataset.getLayer().getType());
		result.appendChild(type);

		Element isolines = document.createElement("isolines");
		setText(isolines, dataset.getLayer().getIsolines());
		result.appendChild(isolines);

		return result;
	}

	private Element createTimeStep() {
		Element result = document.createElement("time_step");

		Element inMilli = document.createElement("in_milli");
		setText(inMilli, dataset.getTimeStep().getInMilli());
		result.appendChild(inMilli);

		Element stepType = document.createElement("type");
		setText(stepType, dataset.getTimeStep().getType());
		result.appendChild(stepType);

		return result;
	}

	private void appendTimeStepOldFormat(Element result) {
		Element inMilli = document.createElement("time_step_in_milli");
		setText(inMilli, dataset.getTimeStep().getInMilli());
		result.appendChild(inMilli);

		Element stepType = document.createElement("time_step_type");
		setText(stepType, dataset.getTimeStep().getType());
		result.appendChild(stepType);
	}
}
