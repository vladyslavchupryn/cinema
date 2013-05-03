package ua.pp.chuprin.web100.cinema.tools.crud;

import java.util.Collection;

public interface CRUDService<T> {

	Long count();

	void delete(int id);

	T get(Integer id);

	Collection<T> list(int pageStart, int pageEnd, String sort);

	void save(T film);
}
