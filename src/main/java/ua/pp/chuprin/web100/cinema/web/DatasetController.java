package ua.pp.chuprin.web100.cinema.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.pp.chuprin.web100.cinema.domain.dataset.client.ClientDataset;
import ua.pp.chuprin.web100.cinema.service.ClientDatasetService;
import ua.pp.chuprin.web100.cinema.service.WorkerDatasetService;

@Controller
@RequestMapping("/clientDataset")
public class DatasetController {

	@Autowired
	private ClientDatasetService clientService;

	@Autowired
	private WorkerDatasetService workerService;

	@RequestMapping("/index")
	public String listClientDataset(Map<String, Object> pageVariableMap) {
		pageVariableMap.put("newChildren", clientService.createChildDataset(0));
		pageVariableMap.put("clientDatasetList", clientService.listClientDatasetByParent(0));
		pageVariableMap.put("currentId", 0);

		return "clientDataset/index";
	}

	@RequestMapping("/index/{id}")
	public String editDataset(
		@PathVariable("id")
		int id,
		Map<String, Object> pageVariableMap) {
		editDatasetForm(id, pageVariableMap);

		pageVariableMap.put("currentDataset", clientService.getDataset(id));
		pageVariableMap.put("clientDatasetList", clientService.listClientDatasetByParent(id));
		pageVariableMap.put("currentId", id);

		return "clientDataset/index";
	}

	@RequestMapping(value = "/index/{id}", params = "fragments=form")
	public String editDatasetForm(
		@PathVariable("id")
		int id,
		Map<String, Object> pageVariableMap) {
		pageVariableMap.put("layerTypes", clientService.getLayerTypes());
		pageVariableMap.put("currentDataset", clientService.getDataset(id));
		pageVariableMap.put("dataProviderTypes", clientService.getDataProviderTypes());
		pageVariableMap.put("timeTypes", clientService.getTimeTypes());
		pageVariableMap.put("driverTypes", workerService.getDriverTypes());
		pageVariableMap.put("hdfDriverTypes", workerService.getHdfDriverTypes());

		return "clientDataset/index";
	}

	@RequestMapping(value = "/new/{parentId}", params = "fragments=form")
	public String createDatasetForm(
		@PathVariable("parentId")
		int parentId,
		Map<String, Object> pageVariableMap) {
		pageVariableMap.put("currentDataset", clientService.createChildDataset(parentId));

		return "clientDataset/index";
	}

	@RequestMapping("/childJson")
	@ResponseBody
	public String childJson(
		@RequestParam(value = "node", defaultValue = "0")
		Integer parentId) {
		if (parentId == 0) {
			parentId = null;
		}

		return "[" + clientService.createTreeJson(parentId) + "]";
	}

	@RequestMapping("/createChild/{parentId}")
	@ResponseBody
	public String createClientByParent(
		@PathVariable("parentId")
		int parentId) {

		ClientDataset client = clientService.createChildDataset(parentId);
		clientService.saveClientDataset(client);

		return "";
	}

	@RequestMapping("/")
	public String home() {
		return "redirect:/clientDataset/index";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(
		@ModelAttribute("clientDataset")
		ClientDataset dataset,
		BindingResult result) {

		clientService.saveClientDataset(dataset);

		return "redirect:/clientDataset/index/" + dataset.getId();
	}

	@RequestMapping("/writeXml")
	@ResponseBody
	public String writeXml() {
		clientService.writeXml();
		workerService.writeXml();

		return "";
	}

	@RequestMapping("/testHibernate")
	@ResponseBody
	public String testHibernate() {
		clientService.testHibernate();

		return "";
	}

	@RequestMapping("/delete/{datasetId}")
	public String deleteClientDataset(
		@PathVariable("datasetId")
		Integer datasetId) {
		clientService.remove(datasetId);

		return "redirect:/clientDataset/index";
	}
}
