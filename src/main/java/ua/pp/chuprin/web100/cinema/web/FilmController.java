package ua.pp.chuprin.web100.cinema.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.pp.chuprin.web100.cinema.service.FilmService;

@Controller
@RequestMapping("/film")
public class FilmController {

	@Autowired
	private FilmService service;

	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id,
		Map<String, Object> variables) {

		return editBody(id, variables);
	}

	@RequestMapping(value = "/edit/{id}", params = "fragments=body")
	public String editBody(
		@PathVariable("id") int id, Map<String, Object> variables) {
		variables.put("film", service.getFilm(id));
		variables.put("id", id);

		return "film/edit";
	}

	@RequestMapping(value = "/list")
	public String list(Map<String, Object> variables) {

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
		variables.put("film", service.getFilm(id));
		variables.put("id", id);

		return "film/edit";
	}

}
