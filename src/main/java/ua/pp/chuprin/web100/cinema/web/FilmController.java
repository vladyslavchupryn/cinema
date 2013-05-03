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
public class FilmController extends CRUDController<Film> {

	@Autowired
	private FilmService service;

	protected Film create() {
		return new Film();
	}

	@Override
	protected Object[] editColumns() {
		return allColumns();
	}

	protected Object[] listColumns() {
		return allColumns();
	}

	@Override
	protected Object[] viewColumns() {
		return allColumns();
	}

	@Override
	protected String path() {
		return "film";
	}

	@Override
	protected CRUDService<Film> service() {
		return service;
	}

	private Object[] allColumns() {
		return new String[]{"name", "author", "country", "genre", "year", "duration"};
	}

}
