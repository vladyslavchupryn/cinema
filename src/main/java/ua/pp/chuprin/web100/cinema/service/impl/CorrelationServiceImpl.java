package ua.pp.chuprin.web100.cinema.service.impl;

import javax.annotation.PostConstruct;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.pp.chuprin.web100.cinema.domain.Correlation;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDDao;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDServiceImpl;

@Service
public class CorrelationServiceImpl extends CRUDServiceImpl<Correlation> {

	@Autowired
	private SessionFactory factory;

	private CRUDDao<Correlation> dao;

	@PostConstruct
	public void init() {
		dao = new CRUDDao<Correlation>(Correlation.class, factory);
	}

	@Override
	protected CRUDDao<Correlation> dao() {
		return dao;
	}
}
