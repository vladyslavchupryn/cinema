package ua.pp.chuprin.web100.cinema.service;

import java.util.Collection;

import ua.pp.chuprin.web100.cinema.domain.Correlation;
import ua.pp.chuprin.web100.cinema.domain.Order;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDService;

public interface OrderService extends CRUDService<Order> {
	Collection<Correlation> correlations();

	Long count();

	void delete(int id);

	public Order get(Integer id);

	public Collection<Order> list(int pageStart, int countPerPage, String sort);

	void save(Order film);
}
