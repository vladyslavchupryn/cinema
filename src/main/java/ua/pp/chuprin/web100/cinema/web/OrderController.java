package ua.pp.chuprin.web100.cinema.web;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.pp.chuprin.web100.cinema.domain.Order;
import ua.pp.chuprin.web100.cinema.domain.Place;
import ua.pp.chuprin.web100.cinema.domain.Session;
import ua.pp.chuprin.web100.cinema.service.OrderService;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDController;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDService;

@Controller
@RequestMapping("/order")
public class OrderController extends CRUDController<Order> {

	@Autowired
	private OrderService service;

	@Override
	protected String editPage() {
		return "order/edit";
	}

	protected Order create() {
		return new Order();
	}

	@Override
	protected Object[] editColumns() {
		return new Object[]{
			service.places(),
			service.sessions(),
			service.correlations()
		};
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
		return "order";
	}

	@Override
	protected CRUDService<Order> service() {
		return service;
	}

	private Object[] allColumns() {
		return new String[]{"customerName", "price", "place", "session", "comment"};
	}
}
