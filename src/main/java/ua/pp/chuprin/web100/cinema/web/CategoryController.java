package ua.pp.chuprin.web100.cinema.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.pp.chuprin.web100.cinema.domain.Category;
import ua.pp.chuprin.web100.cinema.service.CategoryService;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDController;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDService;

@Controller
@RequestMapping("/category")
public class CategoryController extends CRUDController<Category> {

	@Autowired
	private CategoryService service;

	protected Category create() {
		return new Category();
	}

	@Override
	protected Object[] editColumns() {
		return new Object[]{
			"price",
			new Object[]{
				"hall.id",
				service.halls(),
				"hall"
			},
			new Object[]{
				"placeType.id",
				service.types(),
				"placeType"
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
		return "category";
	}

	@Override
	protected CRUDService<Category> service() {
		return service;
	}

	private Object[] allColumns() {
		return new String[]{"hall", "placeType", "price"};
	}
}