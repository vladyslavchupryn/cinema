package ua.pp.chuprin.web100.cinema.dao.impl;

import java.util.Collection;

import org.springframework.stereotype.Repository;
import ua.pp.chuprin.web100.cinema.dao.CategoryDAO;
import ua.pp.chuprin.web100.cinema.domain.Category;
import ua.pp.chuprin.web100.cinema.domain.Hall;
import ua.pp.chuprin.web100.cinema.domain.PlaceType;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDDaoImpl;

@Repository
public class CategoryDAOImpl extends CRUDDaoImpl<Category> implements CategoryDAO {

	@Override
	public Collection<Hall> halls() {
		return getSession().createQuery("from Hall").list();
	}

	@Override
	public Collection<PlaceType> types() {
		return getSession().createQuery("from PlaceType").list();
	}

	@Override
	protected Class<Category> domain() {
		return Category.class;
	}
}
