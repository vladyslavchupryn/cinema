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
import ua.pp.chuprin.web100.cinema.domain.Film;
import ua.pp.chuprin.web100.cinema.service.FilmService;

@Controller
@RequestMapping("/film")
public class FilmController {

	@Autowired
	private FilmService service;

	@RequestMapping("/")
	public String home() {
		return "redirect:/film/list";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("object") Film film) {
		service.save(film);

		return "redirect:/film/list";
	}

	@RequestMapping(value = "/create")
	public String create(Map<String, Object> variables) {
		variables.put("film", new Film());

		return "film/edit";
	}

	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id,
		Map<String, Object> variables) {

		return editBody(id, variables);
	}

	@RequestMapping(value = "/edit/{id}", params = "fragments=body")
	public String editBody(
		@PathVariable("id") Integer id, Map<String, Object> variables) {
		variables.put("film", service.get(id));
		variables.put("id", id);

		return "film/edit";
	}

	@RequestMapping(value = "/list")
	public String list(
		@RequestParam(value = "pageStart", defaultValue = "0") int pageStart,
		@RequestParam(value = "countPerPage", defaultValue = "10")
		int countPerPage,
		@RequestParam(value = "sort", defaultValue = "") String sort,
		Map<String, Object> variables) {

		variables.put("list", service.list(pageStart, countPerPage, sort));

		return "film/list";
	}

	@RequestMapping("/view/{id}")
	public String view(@PathVariable("id") int id,
		Map<String, Object> variables) {

		return viewBody(id, variables);
	}

	@RequestMapping(value = "/view/{id}", params = "fragments=body")
	public String viewBody(
		@PathVariable("id") int id, Map<String, Object> variables) {
		variables.put("film", service.get(id));
		variables.put("id", id);

		return "film/edit";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public String delete(@PathVariable("id") int id) {

		service.delete(id);

		return "film/edit";
	}
}
