package ua.pp.chuprin.web100.cinema.service.impl;

import javax.annotation.PostConstruct;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.pp.chuprin.web100.cinema.domain.Place;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDDao;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDServiceImpl;

@Service
public class PlaceServiceImpl extends CRUDServiceImpl<Place> {

	@Autowired
	private SessionFactory factory;

	private CRUDDao<Place> dao;

	@PostConstruct
	public void init() {
		dao = new CRUDDao<Place>(Place.class, factory);
	}

	@Override
	protected CRUDDao<Place> dao() {
		return dao;
	}
}
