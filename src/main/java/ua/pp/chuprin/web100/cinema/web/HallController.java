package ua.pp.chuprin.web100.cinema.web;

import javax.validation.Valid;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
