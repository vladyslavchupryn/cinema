package ua.pp.chuprin.web100.cinema.dao;

import java.util.Collection;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ua.pp.chuprin.web100.cinema.domain.Order;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDDao;

@Repository
public class OrderDAO extends CRUDDao<Order> {

	public OrderDAO(SessionFactory factory) {
		super(Order.class, factory);
	}

	public Collection calcCustomersByFilms() {
		StringBuffer q = new StringBuffer();
		q.append("SELECT ");
		q.append("   film.name, ");
		q.append("   count(_order), ");
		q.append("   sum(_order.price) ");
		q.append("FROM ");
		q.append("   Order as _order inner join ");
		q.append("   _order.session as session inner join ");
		q.append("   session.film as film  ");
		q.append("GROUP BY ");
		q.append("   film  ");
		return getSession().createQuery(q.toString()).list();
	}

	public Collection calcCustomersBySessions() {
		StringBuffer q = new StringBuffer();
		q.append("SELECT ");
		q.append("   film.name, " );
		q.append("   session.start, ");
		q.append("   count(_order), ");
		q.append("   sum(_order.price) ");
		q.append("FROM ");
		q.append("   Order as _order inner join ");
		q.append("   _order.session as session inner join ");
		q.append("   session.film as film  ");
		q.append("GROUP BY ");
		q.append("   session, film  ");
		return getSession().createQuery(q.toString()).list();
	}
}
