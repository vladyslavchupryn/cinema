package ua.pp.chuprin.web100.cinema.service;

import java.util.Collection;

import ua.pp.chuprin.web100.cinema.tools.crud.CRUDService;

public interface PlaceTypeService extends CRUDService {
	Long count();

	void delete(int id);

	public Object get(Integer id);

	public Collection list(int pageStart, int countPerPage, String sort);

	void save(Object film);
}
