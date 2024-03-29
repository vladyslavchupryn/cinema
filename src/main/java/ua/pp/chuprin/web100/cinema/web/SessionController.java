package ua.pp.chuprin.web100.cinema.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.pp.chuprin.web100.cinema.domain.Session;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDController;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDService;

@Controller
@RequestMapping("/session")
public class SessionController extends CRUDController<Session> {

	@Autowired
	@Qualifier("sessionServiceImpl")
	private CRUDService<Session> service;

	@Override
	protected CRUDService<Session> service() {
		return service;
	}

	@Override
	protected Class<Session> domain() {
		return Session.class;
	}
}

