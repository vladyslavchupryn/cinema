package ua.pp.chuprin.web100.cinema.dao;

import java.util.Collection;

import ua.pp.chuprin.web100.cinema.domain.Correlation;
import ua.pp.chuprin.web100.cinema.domain.Order;
import ua.pp.chuprin.web100.cinema.domain.Place;
import ua.pp.chuprin.web100.cinema.domain.Session;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDDao;

public interface OrderDAO extends CRUDDao<Order> {
	Collection<Correlation> correlations();

	Collection<Place> places();

	Collection<Session> sessions();
}
