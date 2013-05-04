package ua.pp.chuprin.web100.cinema.tools.crud;

import javax.persistence.ManyToOne;
import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.pp.chuprin.web100.cinema.tools.crud.annotations.CRUD;

public abstract class CRUDController<T> {

	@InitBinder
	public void binder(WebDataBinder binder) {
		binder.registerCustomEditor(Timestamp.class,
			new PropertyEditorSupport() {
				private final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

				@Override
				public String getAsText() {
					Timestamp timestamp = (Timestamp) getValue();
					return FORMAT.format(timestamp);
				}

				@Override
				public void setAsText(String value) {
					try {
						Date parsedDate = FORMAT.parse(value);
						setValue(new Timestamp(parsedDate.getTime()));
					} catch (ParseException e) {
						setValue(null);
					}
				}
			});
	}

	@RequestMapping(value = "/create")
	public String create(Map<String, Object> variables) {
		T object = create();
		variables.put("object", object);

		return prepareEdit(object, variables);
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

		T object = service().get(id);
		variables.put("object", object);

		return prepareEdit(object, variables);
	}

	private String prepareEdit(T object, Map<String, Object> variables) {
		List<Column> columns = getColumns(object, Operation.EDIT);
		variables.put("columns", columns);

		variables.put("path", path());

		return editPage();
	}

	private Column readEditColumn(Class<T> clazz, Field field, CRUD config) {
		String cssClass = getCssClass(clazz, field, config);
		short order = config.order();

		if(field.isAnnotationPresent(ManyToOne.class)) {
			Collection variants = service().findAll(field.getType());
			return new ManyToOneColumn(field.getName(), cssClass, order, variants);
		} else {
			return new Column(field.getName(), cssClass, order);
		}
	}

	private String getCssClass(Class<T> clazz, Field field, CRUD config) {
		String cssClass = config.cssClass();
		if(cssClass.equals("")) {
			cssClass = clazz.getCanonicalName().replace(".", "_") + "-" + field.getName();
		}
		return cssClass;
	}

	private Column readViewColumn(Class<T> clazz, Field field, CRUD config) {
		String cssClass = getCssClass(clazz, field, config);

		short order = config.order();

		if(field.isAnnotationPresent(ManyToOne.class)) {
			Collection variants = service().findAll(field.getType());
			return new ManyToOneColumn(field.getName(), cssClass, order, null);
		} else {
			return new Column(field.getName(), cssClass, order);
		}
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

		variables.put("columns", getColumns(domain(),Operation.LIST));
		variables.put("path", path());
		variables.put("sort", sort);

		return "crud/list";
	}

	protected abstract Class<T> domain();

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("object") T object, BindingResult result, Map<String, Object> variables) {
		if (result.hasErrors()) {
			return prepareEdit(object, variables);
		} else {
			service().save(object);

			return "redirect:/" + path() + "/list";
		}
	}

	@RequestMapping("/view/{id}")
	public String view(@PathVariable("id") int id,
		Map<String, Object> variables) {

		return viewBody(id, variables);
	}

	@RequestMapping(value = "/view/{id}", params = "fragments=body")
	public String viewBody(
		@PathVariable("id") int id, Map<String, Object> variables) {

		T object = service().get(id);
		variables.put("object", object);

		List<Column> columns = getColumns(object, Operation.VIEW);

		variables.put("columns", columns);
		variables.put("path", path());

		return "crud/view";
	}

	private static enum Operation {
		EDIT,
		VIEW,
		LIST
	}

	private List<Column> getColumns(T object, Operation operation) {
		return getColumns((Class<T>) object.getClass(),operation);
	}

	private List<Column> getColumns(Class<T> clazz, Operation operation) {
		List<Column> columns = new ArrayList<Column>();
		for (Field field : clazz.getDeclaredFields()) {
			if(field.isAnnotationPresent(CRUD.class)) {
				CRUD config = field.getAnnotation(CRUD.class);

				Column column = null;
				switch (operation) {
					case VIEW:
						if(config.view()) {
							column = readViewColumn(clazz, field, config);
						}
						break;
					case EDIT:
						if(config.edit()) {
							column = readEditColumn(clazz, field, config);
						}
						break;
					case LIST:
						if(config.list()) {
							column = readListColumn(clazz, field, config);
						}
						break;
				}

				if(column != null) {
					columns.add(column);
				}
			}
		}
		Collections.sort(columns);
		return columns;
	}

	private Column readListColumn(Class<T> clazz, Field field, CRUD config) {
		String cssClass = getCssClass(clazz, field, config);

		short order = config.order();

		if(field.isAnnotationPresent(ManyToOne.class)) {
			return new ManyToOneColumn(field.getName(), cssClass, order, null);
		} else {
			return new Column(field.getName(), cssClass, order);
		}
	}

	protected T create() {
		try {
			return  (T) domain().newInstance();
		} catch (InstantiationException e) {
			throw new IllegalStateException(e);
		} catch (IllegalAccessException e) {
			throw new IllegalStateException(e);
		}
	}

	protected String editPage() {
		return "crud/edit";
	}

	protected String path() {
		String className = domain().getSimpleName();
		return StringUtils.uncapitalize(className);
	}

	protected CRUDService<T> service() {
		return new CRUDServiceImpl<T>(domain());
	}
}
