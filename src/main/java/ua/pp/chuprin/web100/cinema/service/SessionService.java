package ua.pp.chuprin.web100.cinema.service;

import java.util.Collection;

import ua.pp.chuprin.web100.cinema.domain.Film;
import ua.pp.chuprin.web100.cinema.domain.Hall;
import ua.pp.chuprin.web100.cinema.domain.Session;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDService;

public interface SessionService extends CRUDService<Session> {
	Long count();

	void delete(int id);

	Collection<Film> films();

	public Session get(Integer id);

	Collection<Hall> halls();

	public Collection<Session> list(int pageStart, int countPerPage, String sort);

	void save(Session film);
}
