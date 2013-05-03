package ua.pp.chuprin.web100.cinema.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.pp.chuprin.web100.cinema.domain.Place;
import ua.pp.chuprin.web100.cinema.service.PlaceService;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDController;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDService;

@Controller
@RequestMapping("/place")
public class PlaceController extends CRUDController<Place> {

	@Autowired
	private PlaceService service;

	protected Place create() {
		return new Place();
	}

	@Override
	protected Object[] editColumns() {
		return new Object[]{
			"number",
			new Object[]{
				"category.id",
				service.categories(),
				"category"
			},
		};
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
		return "place";
	}

	@Override
	protected CRUDService<Place> service() {
		return service;
	}

	private Object[] allColumns() {
		return new String[]{"number", "category"};
	}
}
