package ua.pp.chuprin.web100.cinema.dao;

import java.util.Collection;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ua.pp.chuprin.web100.cinema.domain.Correlation;
import ua.pp.chuprin.web100.cinema.domain.Order;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDDao;

@Repository
public class OrderDAO extends CRUDDao<Order> {

	public OrderDAO(SessionFactory factory) {
		super(Order.class, factory);
	}

	public Collection<Correlation> correlations() {
		return getSession().createQuery("from Correlation where expiration > now() or expiration is null").list();
	}
}
