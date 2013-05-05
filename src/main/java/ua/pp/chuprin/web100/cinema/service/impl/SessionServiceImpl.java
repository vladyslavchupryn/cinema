package ua.pp.chuprin.web100.cinema.service.impl;

import javax.annotation.PostConstruct;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.pp.chuprin.web100.cinema.domain.Session;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDDao;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDServiceImpl;

@Service
public class SessionServiceImpl extends CRUDServiceImpl<Session> {

	@Autowired
	private SessionFactory factory;

	private CRUDDao<Session> dao;

	@PostConstruct
	public void init() {
		dao = new CRUDDao<Session>(Session.class, factory);
	}

	@Override
	protected CRUDDao<Session> dao() {
		return dao;
	}
}
