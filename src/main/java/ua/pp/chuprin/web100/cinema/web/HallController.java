package ua.pp.chuprin.web100.cinema.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.pp.chuprin.web100.cinema.domain.Hall;
import ua.pp.chuprin.web100.cinema.service.HallService;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDController;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDDao;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDService;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDServiceImpl;

@Controller
@RequestMapping("/hall")
public class HallController extends CRUDController<Hall> {

	@Autowired
	private HallService service;

	@Override
	protected Class<Hall> domain() {
		return Hall.class;
	}
}
