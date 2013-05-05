package ua.pp.chuprin.web100.cinema.service.impl;

import javax.annotation.PostConstruct;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.pp.chuprin.web100.cinema.domain.Category;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDDao;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDServiceImpl;

@Service
public class CategoryServiceImpl extends CRUDServiceImpl<Category> {

	@Autowired
	private SessionFactory factory;

	private CRUDDao<Category> dao;

	@PostConstruct
	public void init() {
		dao = new CRUDDao<Category>(Category.class, factory);
	}

	@Override
	protected CRUDDao<Category> dao() {
		return dao;
	}
}
