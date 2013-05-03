package ua.pp.chuprin.web100.cinema.service;

import java.util.Collection;

import ua.pp.chuprin.web100.cinema.domain.Correlation;
import ua.pp.chuprin.web100.cinema.domain.Order;
import ua.pp.chuprin.web100.cinema.domain.Place;
import ua.pp.chuprin.web100.cinema.domain.Session;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDService;

public interface OrderService extends CRUDService<Order> {
	Collection<Correlation> correlations();

	Long count();

	void delete(int id);

	public Order get(Integer id);

	public Collection<Order> list(int pageStart, int countPerPage, String sort);

	Collection<Place> places();

	void save(Order film);

	Collection<Session> sessions();
}
