package ua.pp.chuprin.web100.cinema.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.pp.chuprin.web100.cinema.domain.PlaceType;
import ua.pp.chuprin.web100.cinema.service.PlaceTypeService;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDController;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDService;

@Controller
@RequestMapping("/placeType")
public class PlaceTypeController extends CRUDController<PlaceType> {

	@Autowired
	private PlaceTypeService service;

	protected PlaceType create() {
		return new PlaceType();
	}

	@Override
	protected Object[] editMetadata() {
		return allColumns();
	}

	protected Object[] listMetadata() {
		return allColumns();
	}

	@Override
	protected Object[] viewMetadata() {
		return allColumns();
	}

	@Override
	protected String path() {
		return "placeType";
	}

	@Override
	protected CRUDService<PlaceType> service() {
		return service;
	}

	private Object[] allColumns() {
		return new String[]{"name"};
	}
}
