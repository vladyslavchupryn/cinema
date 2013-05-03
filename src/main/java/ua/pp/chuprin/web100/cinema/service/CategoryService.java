package ua.pp.chuprin.web100.cinema.service;

import java.util.Collection;

import ua.pp.chuprin.web100.cinema.domain.Category;
import ua.pp.chuprin.web100.cinema.domain.Hall;
import ua.pp.chuprin.web100.cinema.domain.PlaceType;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDService;

public interface CategoryService extends CRUDService<Category> {
	Long count();

	void delete(int id);

	public Category get(Integer id);

	Collection<Hall> halls();

	public Collection<Category> list(int pageStart, int countPerPage, String sort);

	void save(Category film);

	Collection<PlaceType> types();
}
