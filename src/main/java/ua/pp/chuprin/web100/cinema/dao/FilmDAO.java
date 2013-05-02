package ua.pp.chuprin.web100.cinema.dao;

import java.util.Collection;

import ua.pp.chuprin.web100.cinema.domain.Film;
import ua.pp.chuprin.web100.cinema.tools.SorterBuilder;

public interface FilmDAO {
	Long count();

	void delete(int id);

	Film getFilm(int id);

	Collection<Film> list(int start, int count, SorterBuilder.Sorter build);

	void save(Film film);
}
