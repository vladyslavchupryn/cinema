package ua.pp.chuprin.web100.cinema.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.pp.chuprin.web100.cinema.domain.Correlation;
import ua.pp.chuprin.web100.cinema.service.CorrelationService;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDController;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDService;

@Controller
@RequestMapping("/correlation")
public class CorrelationController extends CRUDController<Correlation> {

	@Autowired
	private CorrelationService service;

	@Override
	protected Class<Correlation> domain() {
		return Correlation.class;
	}

	@Override
	protected CRUDService<Correlation> service() {
		return service;
	}
}
