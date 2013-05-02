package ua.pp.chuprin.web100.cinema.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.pp.chuprin.web100.cinema.domain.PlaceType;
import ua.pp.chuprin.web100.cinema.service.PlaceTypeService;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDController;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDService;

@Controller
@RequestMapping("/placeType")
public class PlaceTypeController extends CRUDController {

	@Autowired
	private PlaceTypeService service;

	protected Object create() {
		return new PlaceType();
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
		return "placeType";
	}

	@Override
	protected CRUDService service() {
		return service;
	}

	private String[] allColumns() {
		return new String[]{"name"};
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute PlaceType object) {
		return saveImpl(object);
	}
}
