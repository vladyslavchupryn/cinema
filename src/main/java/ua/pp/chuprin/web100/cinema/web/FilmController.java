package ua.pp.chuprin.web100.cinema.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.pp.chuprin.web100.cinema.domain.Film;
import ua.pp.chuprin.web100.cinema.domain.PlaceType;
import ua.pp.chuprin.web100.cinema.service.FilmService;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDController;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDService;

@Controller
@RequestMapping("/film")
public class FilmController extends CRUDController {

	@Autowired
	private FilmService service;

	protected Object create() {
		return new Film();
	}

	@Override
	protected String[] editColumns() {
		return allColumns();
	}

	protected String[] listColumns() {
		return allColumns();
	}

	@Override
	protected String[] viewColumns() {
		return allColumns();
	}

	@Override
	protected String path() {
		return "film";
	}

	@Override
	protected CRUDService service() {
		return service;
	}

	private String[] allColumns() {
		return new String[]{"name", "author", "country", "genre", "year", "duration"};
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute Film object) {
		return saveImpl(object);
	}
}
