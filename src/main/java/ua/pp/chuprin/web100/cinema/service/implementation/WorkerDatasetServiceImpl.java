package ua.pp.chuprin.web100.cinema.service.implementation;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ua.pp.chuprin.web100.cinema.dao.WorkerDatasetDAO;
import ua.pp.chuprin.web100.cinema.domain.dataset.worker.DriverType;
import ua.pp.chuprin.web100.cinema.domain.dataset.worker.HdfDriverType;
import ua.pp.chuprin.web100.cinema.domain.dataset.worker.WorkerDataset;
import ua.pp.chuprin.web100.cinema.service.WorkerDatasetService;
import ua.pp.chuprin.web100.cinema.service.tools.WorkerDatasetXmlBuilder;

@Service
public class WorkerDatasetServiceImpl implements WorkerDatasetService {

	@Autowired
	private WorkerDatasetDAO dao;

	@Override
	@Transactional(readOnly = true)
	public void writeXml() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();
			document.appendChild(document.createElement("root"));

			writeXml(document, document.getDocumentElement(), 0);

			String filePath = "d:/worker_metadata.xml";
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			Result outputFile = new StreamResult(new File(filePath));
			Source inputDocument = new DOMSource(document);

			transformer.setOutputProperty(OutputKeys.METHOD, "html");
			transformer.transform(inputDocument, outputFile);
		} catch (TransformerException e) {
			e.printStackTrace();
			throw new InternalError("Cannot create new xml");
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			throw new InternalError("Cannot create new xml");
		}
	}

	@Transactional(readOnly = true)
	@Override
	public List<DriverType> getDriverTypes() {
		return dao.getDriverTypes();
	}

	@Override
	@Transactional(readOnly = true)
	public List<HdfDriverType> getHdfDriverTypes() {
		return dao.getHdfDriverTypes();
	}

	public void writeXml(Document document, Element parent, int parentId) {
		List<WorkerDataset> childList = dao.listClientDatasetByParent(parentId);
		for (WorkerDataset childDataset : childList) {

			WorkerDatasetXmlBuilder builder = new WorkerDatasetXmlBuilder(document, childDataset);
			Element childElement = builder.build();

			parent.appendChild(childElement);

			writeXml(document, childElement, childDataset.getId());
		}
	}
}
