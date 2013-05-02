package ua.pp.chuprin.web100.cinema.tools.crud;

import java.util.Collection;

import ua.pp.chuprin.web100.cinema.tools.SorterBuilder;

public interface CRUDDao {
	Long count();

	void delete(int id);

	Object get(int id);

	Collection list(int start, int count, SorterBuilder.Sorter build);

	void save(Object film);
}
