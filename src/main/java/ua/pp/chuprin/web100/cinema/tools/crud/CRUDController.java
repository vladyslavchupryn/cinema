package ua.pp.chuprin.web100.cinema.tools.crud;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

public abstract class CRUDController<T> {

	@InitBinder
	public void binder(WebDataBinder binder) {
		binder.registerCustomEditor(Timestamp.class,
			new PropertyEditorSupport() {
				public void setAsText(String value) {
					try {
						Date parsedDate = new SimpleDateFormat("dd.MM.yyyy HH:mm").parse(value);
						setValue(new Timestamp(parsedDate.getTime()));
					} catch (ParseException e) {
						setValue(null);
					}
				}
			});
	}

	@RequestMapping(value = "/create")
	public String create(Map<String, Object> variables) {
		variables.put("object", create());

		variables.put("columns", editColumns());
		variables.put("path", path());

		return editPage();
	}

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

		variables.put("columns", editColumns());
		variables.put("path", path());

		return editPage();
	}

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

		variables.put("columns", listColumns());
		variables.put("path", path());
		variables.put("sort", sort);

		return "crud/list";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute T object) {
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

		variables.put("columns", viewColumns());
		variables.put("path", path());

		return "crud/view";
	}

	protected abstract T create();

	protected abstract Object[] editColumns();

	protected String editPage() {
		return "crud/edit";
	}

	protected abstract Object[] listColumns();

	protected abstract String path();

	protected abstract CRUDService<T> service();

	protected abstract Object[] viewColumns();
}
