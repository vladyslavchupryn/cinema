package ua.pp.chuprin.web100.cinema.service.impl;

import javax.annotation.PostConstruct;
import java.util.Collection;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.pp.chuprin.web100.cinema.dao.OrderDAO;
import ua.pp.chuprin.web100.cinema.domain.Order;
import ua.pp.chuprin.web100.cinema.service.OrderService;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDDao;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDServiceImpl;

@Service
public class OrderServiceImpl extends CRUDServiceImpl<Order> implements OrderService {

	private OrderDAO dao;

	@Autowired
	private SessionFactory factory;

	@PostConstruct
	public void init() {
		dao = new OrderDAO(factory);
	}

	@Override
	public Collection calcCustomersByFilms() {
		return dao.calcCustomersByFilms();
	}

	@Override
	public Collection calcCustomersBySessions() {
		return dao.calcCustomersBySessions();
	}

	@Override
	protected CRUDDao<Order> dao() {
		return dao;
	}
}
