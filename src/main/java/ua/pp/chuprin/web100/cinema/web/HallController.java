package ua.pp.chuprin.web100.cinema.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.pp.chuprin.web100.cinema.domain.Hall;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDController;

@Controller
@RequestMapping("/hall")
public class HallController extends CRUDController<Hall> {

	@Override
	protected Class<Hall> domain() {
		return Hall.class;
	}
}
