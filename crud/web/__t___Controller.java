package ua.pp.chuprin.web100.cinema.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.pp.chuprin.web100.cinema.domain.__template__;
import ua.pp.chuprin.web100.cinema.service.__template__Service;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDController;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDService;

@Controller
@RequestMapping("/film")
public class __template__Controller extends CRUDController {

	@Autowired
	private __template__Service service;

	protected Object create() {
		return new __template__();
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
}
