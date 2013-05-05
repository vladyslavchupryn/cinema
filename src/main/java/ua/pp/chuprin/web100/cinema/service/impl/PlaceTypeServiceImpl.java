package ua.pp.chuprin.web100.cinema.service.impl;

import javax.annotation.PostConstruct;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.pp.chuprin.web100.cinema.domain.PlaceType;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDDao;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDServiceImpl;

@Service
public class PlaceTypeServiceImpl extends CRUDServiceImpl<PlaceType> {

	@Autowired
	private SessionFactory factory;

	private CRUDDao<PlaceType> dao;

	@PostConstruct
	public void init() {
		dao = new CRUDDao<PlaceType>(PlaceType.class, factory);
	}

	@Override
	protected CRUDDao<PlaceType> dao() {
		return dao;
	}
}
