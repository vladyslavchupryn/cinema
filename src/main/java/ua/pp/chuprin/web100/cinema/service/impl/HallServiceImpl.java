package ua.pp.chuprin.web100.cinema.service.impl;

import javax.annotation.PostConstruct;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.pp.chuprin.web100.cinema.domain.Hall;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDDao;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDServiceImpl;

@Service
public class HallServiceImpl extends CRUDServiceImpl<Hall> {

	@Autowired
	private SessionFactory factory;

	private CRUDDao<Hall> dao;

	@PostConstruct
	public void init() {
		dao = new CRUDDao<Hall>(Hall.class, factory);
	}

	@Override
	protected CRUDDao<Hall> dao() {
		return dao;
	}
}
