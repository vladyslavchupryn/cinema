package ua.pp.chuprin.web100.cinema.dao;

import java.util.Collection;

import ua.pp.chuprin.web100.cinema.domain.Category;
import ua.pp.chuprin.web100.cinema.domain.Hall;
import ua.pp.chuprin.web100.cinema.domain.PlaceType;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDDao;

public interface CategoryDAO extends CRUDDao<Category> {
	Collection<Hall> halls();

	Collection<PlaceType> types();
}
