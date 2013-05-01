package ua.pp.chuprin.web100.cinema.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.pp.chuprin.web100.cinema.service.WorkerService;

@Controller
@RequestMapping("/worker")
public class WorkerController {

	@Autowired
	private WorkerService service;

	@RequestMapping("/")
	public String home() {
		return "worker/index";
	}

	@RequestMapping("/list")
	public String list(Map<String, Object> pageVariableMap) {
		pageVariableMap.put("workers", service.getWorkers());

		return "worker/list";
	}

	@RequestMapping("/stop/{id}")
	@ResponseBody
	public String stop(
		@PathVariable("id")
		Integer id) {
		if (service.stop(id)) {
			return "Success";
		} else {
			return "Error";
		}
	}

	@RequestMapping("/start/{id}")
	@ResponseBody
	public String start(
		@PathVariable("id")
		Integer id) {
		if (service.start(id)) {
			return "Success";
		} else {
			return "Error";
		}
	}

	@RequestMapping("/status/{id}")
	@ResponseBody
	public String status(
		@PathVariable("id")
		Integer id) {
		return service.status(id);
	}
}
