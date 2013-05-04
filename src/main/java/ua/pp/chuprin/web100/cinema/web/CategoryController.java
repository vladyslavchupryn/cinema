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

	@Override
	protected Class<Category> domain() {
		return Category.class;
	}

	@Override
	protected CRUDService<Category> service() {
		return service;
	}
}
