package ua.pp.chuprin.web100.cinema.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.pp.chuprin.web100.cinema.dao.SessionDAO;
import ua.pp.chuprin.web100.cinema.domain.Film;
import ua.pp.chuprin.web100.cinema.domain.Hall;
import ua.pp.chuprin.web100.cinema.domain.Session;
import ua.pp.chuprin.web100.cinema.service.SessionService;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDDao;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDServiceImpl;

@Service
public class SessionServiceImpl extends CRUDServiceImpl<Session> implements SessionService {

	@Autowired
	private SessionDAO dao;

	@Override
	public Collection<Film> films() {
		return dao.films();
	}

	@Override
	public Collection<Hall> halls() {
		return dao.halls();
	}

	@Override
	protected CRUDDao<Session> dao() {
		return dao;
	}
}
