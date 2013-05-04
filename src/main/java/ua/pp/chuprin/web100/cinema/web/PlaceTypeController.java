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

	@Override
	protected String path() {
		return "placeType";
	}

	@Override
	protected CRUDService<PlaceType> service() {
		return service;
	}

	@Override
	protected Class<PlaceType> domain() {
		return PlaceType.class;
	}

}
