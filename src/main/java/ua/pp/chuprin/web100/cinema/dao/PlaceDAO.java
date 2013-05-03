package ua.pp.chuprin.web100.cinema.dao;

import java.util.Collection;

import ua.pp.chuprin.web100.cinema.domain.Category;
import ua.pp.chuprin.web100.cinema.domain.Place;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDDao;

public interface PlaceDAO extends CRUDDao<Place> {
	Collection<Category> categories();
}
