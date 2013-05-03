package ua.pp.chuprin.web100.cinema.service;

import java.util.Collection;

import ua.pp.chuprin.web100.cinema.domain.Category;
import ua.pp.chuprin.web100.cinema.domain.Place;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDService;

public interface PlaceService extends CRUDService<Place> {
	Collection<Category> categories();

	Long count();

	void delete(int id);

	public Place get(Integer id);

	public Collection<Place> list(int pageStart, int countPerPage, String sort);

	void save(Place film);
}
