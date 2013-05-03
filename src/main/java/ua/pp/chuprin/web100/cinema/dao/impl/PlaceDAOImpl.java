package ua.pp.chuprin.web100.cinema.dao.impl;

import java.util.Collection;

import org.springframework.stereotype.Repository;
import ua.pp.chuprin.web100.cinema.dao.PlaceDAO;
import ua.pp.chuprin.web100.cinema.domain.Category;
import ua.pp.chuprin.web100.cinema.domain.Place;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDDaoImpl;

@Repository
public class PlaceDAOImpl extends CRUDDaoImpl<Place> implements PlaceDAO {

	@Override
	public Collection<Category> categories() {
		return getSession().createQuery("from Category").list();
	}

	@Override
	protected Class<Place> domain() {
		return Place.class;
	}
}
