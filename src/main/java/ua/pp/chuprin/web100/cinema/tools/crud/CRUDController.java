package ua.pp.chuprin.web100.cinema.tools.crud;

import java.util.Map;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

public abstract class CRUDController {

	@RequestMapping(value = "/create")
	public String create(Map<String, Object> variables) {
		variables.put("object", create());

		variables.put("editColumns", editColumns());

		return "crud/edit";
	}

	protected abstract Object create();

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@ResponseBody
	public String delete(@PathVariable("id") int id) {
		service().delete(id);

		return "";
	}

	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id,
		Map<String, Object> variables) {

		return editBody(id, variables);
	}

	@RequestMapping(value = "/edit/{id}", params = "fragments=body")
	public String editBody(
		@PathVariable("id") Integer id, Map<String, Object> variables) {
		variables.put("object", service().get(id));
		variables.put("id", id);

		variables.put("editColumns", editColumns());

		return "crud/edit";
	}

	protected abstract String[] editColumns();

	@RequestMapping("/")
	public String home() {
		return "redirect:/" + path() + "/list";
	}

	@RequestMapping(value = "/list")
	public String list(
		@RequestParam(value = "pageStart", defaultValue = "0") int pageStart,
		@RequestParam(value = "pageEnd", defaultValue = "10")
		int pageEnd,
		@RequestParam(value = "sort", defaultValue = "") String sort,
		Map<String, Object> variables) {

		variables.put("list", service().list(pageStart, pageEnd, sort));
		Long count = service().count();
		variables.put("count", count);
		variables.put("pageStart", pageStart);
		variables.put("pageEnd", pageEnd > count ? count : pageEnd);

		variables.put("listColumns", listColumns());
		variables.put("path", path());

		return "crud/list";
	}

	protected abstract String[] listColumns();

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("object") Object object) {
		service().save(object);

		return "redirect:/" + path() + "/list";
	}

	@RequestMapping("/view/{id}")
	public String view(@PathVariable("id") int id,
		Map<String, Object> variables) {

		return viewBody(id, variables);
	}

	@RequestMapping(value = "/view/{id}", params = "fragments=body")
	public String viewBody(
		@PathVariable("id") int id, Map<String, Object> variables) {
		variables.put("object", service().get(id));
		variables.put("id", id);

		return "crud/view";
	}

	protected abstract String path();

	protected abstract CRUDService service();

}