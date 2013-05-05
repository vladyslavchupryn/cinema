package ua.pp.chuprin.web100.cinema.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.pp.chuprin.web100.cinema.dao.OrderDAO;
import ua.pp.chuprin.web100.cinema.domain.Correlation;
import ua.pp.chuprin.web100.cinema.domain.Order;
import ua.pp.chuprin.web100.cinema.domain.Place;
import ua.pp.chuprin.web100.cinema.domain.Session;
import ua.pp.chuprin.web100.cinema.service.OrderService;
import ua.pp.chuprin.web100.cinema.tools.SorterBuilder;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDDao;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDServiceImpl;

@Service
public class OrderServiceImpl extends CRUDServiceImpl<Order> implements OrderService {

	@Autowired
	private OrderDAO dao;

	@Override
	public Collection<Correlation> correlations() {
		return dao.correlations();
	}

	@Override
	public Collection<Place> places() {
		return dao.places();
	}

	@Override
	@Transactional(readOnly = false)
	public Collection<Order> list(int pageStart, int countPerPage, String sort) {
		SorterBuilder.Sorter sorter = SorterBuilder.build(sort, dao().domain().getClass());
		return dao().list(pageStart, countPerPage, sorter);
	}

	@Override
	public Collection<Session> sessions() {
		return dao.sessions();
	}

	@Override
	protected CRUDDao<Order> dao() {
		return dao;
	}
}
