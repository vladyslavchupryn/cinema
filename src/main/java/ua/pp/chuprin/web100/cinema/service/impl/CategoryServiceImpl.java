package ua.pp.chuprin.web100.cinema.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.pp.chuprin.web100.cinema.dao.CategoryDAO;
import ua.pp.chuprin.web100.cinema.domain.Category;
import ua.pp.chuprin.web100.cinema.service.CategoryService;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDDao;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDServiceImpl;

@Service
public class CategoryServiceImpl extends CRUDServiceImpl<Category> implements CategoryService {

	@Autowired
	private CategoryDAO dao;

	@Override
	@Transactional(readOnly = true)
	public Collection halls() {
		return dao.halls();
	}

	@Override
	@Transactional(readOnly = true)
	public Collection types() {
		return dao.types();
	}

	@Override
	protected CRUDDao<Category> dao() {
		return dao;
	}
}
