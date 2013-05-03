package ua.pp.chuprin.web100.cinema.dao.impl;

import java.util.Collection;

import org.springframework.stereotype.Repository;
import ua.pp.chuprin.web100.cinema.dao.SessionDAO;
import ua.pp.chuprin.web100.cinema.domain.Film;
import ua.pp.chuprin.web100.cinema.domain.Hall;
import ua.pp.chuprin.web100.cinema.domain.Session;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDDaoImpl;

@Repository
public class SessionDAOImpl extends CRUDDaoImpl<Session> implements SessionDAO {

	@Override
	public Collection<Film> films() {
		return getSession().createQuery("from Film").list();
	}

	@Override
	public Collection<Hall> halls() {
		return getSession().createQuery("from Hall").list();
	}

	@Override
	protected Class<Session> domain() {
		return Session.class;
	}
}
