package ua.pp.chuprin.web100.cinema.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.pp.chuprin.web100.cinema.domain.Film;
import ua.pp.chuprin.web100.cinema.service.FilmService;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDController;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDService;

@Controller
@RequestMapping("/film")
public class FilmController extends CRUDController {

	@Autowired
	private FilmService service;

	@Override
	protected String path() {
		return "film";
	}

	@Override
	protected CRUDService service() {
		return service;
	}

	protected String[] listColumns() {
		return new String[]{"name", "author", "country", "genre", "year", "duration"};
	}

	protected Object create() {
		return new Film();
	}

	@Override
	protected String[] editColumns() {
		return listColumns();
	}
}
