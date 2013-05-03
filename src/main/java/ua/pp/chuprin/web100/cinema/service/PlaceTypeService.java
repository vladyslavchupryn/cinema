package ua.pp.chuprin.web100.cinema.service;

import java.util.Collection;

import ua.pp.chuprin.web100.cinema.domain.PlaceType;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDService;

public interface PlaceTypeService extends CRUDService<PlaceType> {
	Long count();

	void delete(int id);

	public PlaceType get(Integer id);

	public Collection<PlaceType> list(int pageStart, int countPerPage, String sort);

	void save(PlaceType film);
}
