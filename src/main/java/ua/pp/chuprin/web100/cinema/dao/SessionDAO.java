package ua.pp.chuprin.web100.cinema.dao;

import java.util.Collection;

import ua.pp.chuprin.web100.cinema.domain.Film;
import ua.pp.chuprin.web100.cinema.domain.Hall;
import ua.pp.chuprin.web100.cinema.domain.Session;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDDao;

public interface SessionDAO extends CRUDDao<Session> {
	Collection<Film> films();

	Collection<Hall> halls();
}
