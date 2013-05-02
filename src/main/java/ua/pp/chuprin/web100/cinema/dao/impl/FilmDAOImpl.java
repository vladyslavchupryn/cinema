package ua.pp.chuprin.web100.cinema.dao.impl;

import java.util.Collection;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.pp.chuprin.web100.cinema.dao.FilmDAO;
import ua.pp.chuprin.web100.cinema.domain.Film;
import ua.pp.chuprin.web100.cinema.tools.SorterBuilder;

@Repository
public class FilmDAOImpl implements FilmDAO {

	@Autowired
	private SessionFactory factory;

	@Override
	public Long count() {
		return (Long) getSession().createQuery("select count(*) from Film").iterate().next();
	}

	@Override
	public void delete(int id) {
		getSession().createQuery(
			"delete " +
			"from " +
			"   Film " +
			"where " +
			"   id = :id"
		).setInteger("id", id).executeUpdate();	}

	@Override
	public Film getFilm(int id) {
		return (Film) getSession().get(Film.class, id);
	}

	@Override
	public Collection<Film> list(int start, int count, SorterBuilder.Sorter sorter) {
		return getSession().createQuery("from Film" + sorter.hql())
			.setFirstResult(start)
			.setMaxResults(count)
			.list();
	}

	@Override
	public void save(Film film) {
		getSession().save(film);
	}

	private Session getSession() {
		return factory.getCurrentSession();
	}
}
