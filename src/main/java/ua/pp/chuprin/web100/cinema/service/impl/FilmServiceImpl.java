package ua.pp.chuprin.web100.cinema.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.pp.chuprin.web100.cinema.dao.FilmDAO;
import ua.pp.chuprin.web100.cinema.domain.Film;
import ua.pp.chuprin.web100.cinema.service.FilmService;
import ua.pp.chuprin.web100.cinema.tools.SorterBuilder;

@Service
public class FilmServiceImpl implements FilmService {

	@Autowired
	private FilmDAO dao;

	@Autowired
	private SorterBuilder builder;

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return dao.count();
	}

	@Override
	@Transactional
	public void delete(int id) {
		dao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Film get(Integer id) {
		if(id == null) {
			return new Film();
		} else {
			return dao.getFilm(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Film> list(int pageStart, int countPerPage, String sort) {
		return dao.list(pageStart, countPerPage, builder.build(sort, Film.class));
	}

	@Override
	@Transactional
	public void save(Film film) {
		dao.save(film);
	}
}
