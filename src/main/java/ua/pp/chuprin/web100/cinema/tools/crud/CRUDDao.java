package ua.pp.chuprin.web100.cinema.tools.crud;

import java.util.Collection;

import ua.pp.chuprin.web100.cinema.tools.SorterBuilder;

public interface CRUDDao<T> {
	Long count();

	void delete(int id);

	T get(int id);

	Collection<T> list(int start, int count, SorterBuilder.Sorter build);

	void save(T film);
}
