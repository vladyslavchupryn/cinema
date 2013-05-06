package ua.pp.chuprin.web100.cinema.web;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.pp.chuprin.web100.cinema.domain.Order;
import ua.pp.chuprin.web100.cinema.service.OrderService;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDController;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDService;

@Controller
@RequestMapping("/order")
public class OrderController extends CRUDController<Order> {

	@Autowired
	private OrderService service;

	@Override
	protected CRUDService<Order> service() {
		return service;
	}

	@Override
	protected Class<Order> domain() {
		return Order.class;
	}

	@Override
	protected String customEditFragment() {
		return "order/js";
	}

	@RequestMapping(value = "/customers-by-sessions")
	public String customersBySessions(Map<String, Object> variables) {

		Collection data = service.calcCustomersBySessions();
		variables.put("data", data);
		variables.put("path", "order/customers-by-sessions");

		return "order/customers-by-sessions";
	}

	@RequestMapping(value = "/customers-by-films")
	public String customersByFilms(Map<String, Object> variables) {

		Collection data = service.calcCustomersByFilms();
		variables.put("data", data);
		variables.put("path", "order/customers-by-films");

		return "order/customers-by-films";
	}


}
