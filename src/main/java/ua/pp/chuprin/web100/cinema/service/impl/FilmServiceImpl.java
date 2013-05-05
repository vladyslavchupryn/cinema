package ua.pp.chuprin.web100.cinema.service.impl;

import javax.annotation.PostConstruct;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.pp.chuprin.web100.cinema.domain.Film;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDDao;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDServiceImpl;

@Service
public class FilmServiceImpl extends CRUDServiceImpl<Film> {

	@Autowired
	private SessionFactory factory;

	private CRUDDao<Film> dao;

	@PostConstruct
	public void init() {
		dao = new CRUDDao<Film>(Film.class, factory);
	}

	@Override
	protected CRUDDao<Film> dao() {
		return dao;
	}
}
