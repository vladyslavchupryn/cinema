package ua.pp.chuprin.web100.cinema.service;

import java.util.Collection;

import ua.pp.chuprin.web100.cinema.domain.Film;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDService;

public interface FilmService extends CRUDService<Film> {
	Long count();

	void delete(int id);

	public Film get(Integer id);

	public Collection<Film> list(int pageStart, int countPerPage, String sort);

	void save(Film film);
}
