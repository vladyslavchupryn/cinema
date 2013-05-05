package ua.pp.chuprin.web100.cinema.dao.impl;

import java.util.Collection;

import org.springframework.stereotype.Repository;
import ua.pp.chuprin.web100.cinema.dao.OrderDAO;
import ua.pp.chuprin.web100.cinema.domain.Correlation;
import ua.pp.chuprin.web100.cinema.domain.Order;
import ua.pp.chuprin.web100.cinema.domain.Place;
import ua.pp.chuprin.web100.cinema.domain.Session;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDDaoImpl;

@Repository
public class OrderDAOImpl extends CRUDDaoImpl<Order> implements OrderDAO {

	@Override
	public Collection<Correlation> correlations() {
		return getSession().createQuery("from Correlation where expiration > now() or expiration is null").list();
	}

	@Override
	public Collection<Place> places() {
		return getSession().createQuery("from Place").list();
	}

	@Override
	public Collection<Session> sessions() {
		return getSession().createQuery("from Session").list();
	}

	@Override
	public Class<Order> domain() {
		return Order.class;
	}
}
