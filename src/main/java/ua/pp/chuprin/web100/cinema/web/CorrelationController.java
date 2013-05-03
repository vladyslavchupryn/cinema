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

	protected Correlation create() {
		return new Correlation();
	}

	@Override
	protected Object[] editColumns() {
		return allColumns();
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
		return "correlation";
	}

	@Override
	protected CRUDService<Correlation> service() {
		return service;
	}

	private Object[] allColumns() {
		return new String[]{"name", "percent", "expiration"};
	}

}