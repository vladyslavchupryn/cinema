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
import ua.pp.chuprin.web100.cinema.dao.ClientDatasetDAO;
import ua.pp.chuprin.web100.cinema.domain.dataset.client.ClientDataset;
import ua.pp.chuprin.web100.cinema.domain.dataset.client.DataProviderType;
import ua.pp.chuprin.web100.cinema.domain.dataset.client.LayerType;
import ua.pp.chuprin.web100.cinema.domain.dataset.client.TimeStepType;
import ua.pp.chuprin.web100.cinema.service.ClientDatasetService;
import ua.pp.chuprin.web100.cinema.service.tools.ClientDatasetXmlBuilder;

@Service
public class ClientDatasetServiceImpl implements ClientDatasetService {

	private static final int TREE_DEPTH = 1;

	@Autowired
	private ClientDatasetDAO dao;

	@Override
	@Transactional(readOnly = true)
	public List<ClientDataset> listClientDataset() {
		return dao.listClientDataset();
	}

	@Override
	@Transactional(readOnly = true)
	public List<ClientDataset> listClientDatasetByParent(Integer parentId) {
		return dao.listClientDatasetByParent(parentId);
	}

	@Override
	@Transactional
	public void remove(Integer id) {
		dao.removeClientDataset(id);
	}

	@Override
	@Transactional(readOnly = true)
	public String createTreeJson(Integer parentId) {
		StringBuilder result = new StringBuilder();
		createTreeJson(parentId, result, TREE_DEPTH);

		return result.toString();
	}

	@Override
	public ClientDataset createChildDataset(Integer parentId) {
		ClientDataset newDataset = new ClientDataset();
		newDataset.setParent(parentId);

		return newDataset;
	}

	@Override
	@Transactional(readOnly = true)
	public ClientDataset getDataset(int id) {
		return dao.getDataset(id);
	}

	@Override
	@Transactional(readOnly = true)
	public void writeXml() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();
			document.appendChild(document.createElement("root"));

			writeXml(document, document.getDocumentElement(), null);

			String filePath = "d:/client_metadata.xml";
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			Result outputFile = new StreamResult(new File(filePath));
			Source inputDocument = new DOMSource(document);

			transformer.setOutputProperty(OutputKeys.METHOD, "html");
			transformer.transform(inputDocument, outputFile);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			throw new InternalError("Cannot create new xml");
		} catch (TransformerException e) {
			e.printStackTrace();
			throw new InternalError("Cannot create new xml");
		}
	}

	@Override
	@Transactional
	public void testHibernate() {
		dao.testHibernate();
	}

	@Override
	@Transactional(readOnly = true)
	public List<LayerType> getLayerTypes() {
		return dao.getLayerTypes();
	}

	@Override
	@Transactional(readOnly = true)
	public List<DataProviderType> getDataProviderTypes() {
		return dao.getDataProviderTypes();
	}

	@Override
	@Transactional(readOnly = true)
	public List<TimeStepType> getTimeTypes() {
		return dao.getTimeStepTypes();
	}

	private void writeXml(Document document, Element parent, Integer parentId) {
		List<ClientDataset> childList = dao.listClientDatasetByParent(parentId);
		for (ClientDataset childDataset : childList) {

			ClientDatasetXmlBuilder builder = new ClientDatasetXmlBuilder(document, childDataset);
			Element childElement = builder.build();

			parent.appendChild(childElement);

			writeXml(document, childElement, childDataset.getId());
		}
	}

	private void createTreeJson(Integer parentId, StringBuilder result, int depth) {
		if (depth > 0) {
			List<Object[]> childList = dao.listChildByParent(parentId);

			boolean isFirst = true;
			for (Object[] currentChild : childList) {
				String name = (String) currentChild[0];
				Integer parent = (Integer) currentChild[1];

				if (isFirst) {
					isFirst = false;
				} else {
					result.append(",");
				}
				result.append("{\"label\":\"");
				result.append(name);
				result.append("\",\"id\":");
				result.append(parent);
				if (dao.hasChild(parent)) {
					if (depth == 1) {
						result.append(",\"load_on_demand\":true");
					} else { // depth > 1
						result.append("',children:[");
						createTreeJson(parent, result, depth - 1);
						result.append("]");
					}
				}
				result.append("}");
			}
		}
	}

	@Override
	@Transactional
	public void saveClientDataset(ClientDataset clientDataset) {
		dao.saveClientDataset(clientDataset);
	}
}
