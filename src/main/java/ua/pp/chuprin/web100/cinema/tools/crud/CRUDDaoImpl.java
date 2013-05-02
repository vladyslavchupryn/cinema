package ua.pp.chuprin.web100.cinema.tools.crud;

import java.util.Collection;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import ua.pp.chuprin.web100.cinema.domain.Film;
import ua.pp.chuprin.web100.cinema.tools.SorterBuilder;

public abstract class CRUDDaoImpl implements CRUDDao {

	@Autowired
	private SessionFactory factory;

	protected abstract Class domain();

	@Override
	public Long count() {
		return (Long) getSession().createQuery("select count(*) from " + domain().getName()).iterate().next();
	}

	@Override
	public void delete(int id) {
		getSession().createQuery(
			"delete " +
				"from " +
				"   " + domain().getName() + " " +
				"where " +
				"   id = :id"
		).setInteger("id", id).executeUpdate();
	}

	@Override
	public Film get(int id) {
		return (Film) getSession().get(domain(), id);
	}

	@Override
	public Collection<Film> list(int start, int count, SorterBuilder.Sorter sorter) {
		return getSession().createQuery("from " + domain().getName() + sorter.hql())
			.setFirstResult(start)
			.setMaxResults(count)
			.list();
	}

	@Override
	public void save(Object film) {
		getSession().save(film);
	}

	private Session getSession() {
		return factory.getCurrentSession();
	}
}
