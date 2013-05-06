package ua.pp.chuprin.web100.cinema.service;

import java.util.Collection;

import ua.pp.chuprin.web100.cinema.domain.Order;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDService;

public interface OrderService extends CRUDService<Order> {
	Collection calcCustomersByFilms();

	Collection calcCustomersBySessions();
}
