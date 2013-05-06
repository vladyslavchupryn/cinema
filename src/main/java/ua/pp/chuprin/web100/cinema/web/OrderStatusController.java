package ua.pp.chuprin.web100.cinema.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.pp.chuprin.web100.cinema.domain.Hall;
import ua.pp.chuprin.web100.cinema.domain.OrderStatus;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDController;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDService;

@Controller
@RequestMapping("/orderStatus")
public class OrderStatusController extends CRUDController<OrderStatus> {

	@Autowired
	@Qualifier("orderStatusServiceImpl")
	private CRUDService<OrderStatus> service;

	@Override
	protected CRUDService<OrderStatus> service() {
		return service;
	}

	@Override
	protected Class<OrderStatus> domain() {
		return OrderStatus.class;
	}
}
