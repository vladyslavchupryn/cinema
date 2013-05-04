package ua.pp.chuprin.web100.cinema.web;

import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.pp.chuprin.web100.cinema.domain.Session;
import ua.pp.chuprin.web100.cinema.service.SessionService;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDController;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDService;

@Controller
@RequestMapping("/session")
public class SessionController extends CRUDController<Session> {

	@Autowired
	private SessionService service;

	@Override
	protected CRUDService<Session> service() {
		return service;
	}

	@Override
	protected Class<Session> domain() {
		return Session.class;
	}

}

