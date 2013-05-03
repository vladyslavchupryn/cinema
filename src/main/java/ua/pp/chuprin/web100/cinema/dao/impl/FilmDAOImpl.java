package ua.pp.chuprin.web100.cinema.dao.impl;

import org.springframework.stereotype.Repository;
import ua.pp.chuprin.web100.cinema.dao.FilmDAO;
import ua.pp.chuprin.web100.cinema.domain.Film;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDDaoImpl;

@Repository
public class FilmDAOImpl extends CRUDDaoImpl<Film> implements FilmDAO {

	@Override
	protected Class<Film> domain() {
		return Film.class;
	}
}
