package ua.pp.chuprin.web100.cinema.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.pp.chuprin.web100.cinema.domain.Hall;
import ua.pp.chuprin.web100.cinema.service.HallService;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDController;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDService;

@Controller
@RequestMapping("/hall")
public class HallController extends CRUDController<Hall> {

	@Autowired
	private HallService service;

	protected Hall create() {
		return new Hall();
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
		return "hall";
	}

	@Override
	protected CRUDService<Hall> service() {
		return service;
	}

	private Object[] allColumns() {
		return new String[]{"name"};
	}
}
