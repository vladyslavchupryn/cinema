package ua.pp.chuprin.web100.cinema.tools.crud;

import java.util.Collection;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import ua.pp.chuprin.web100.cinema.domain.Category;
import ua.pp.chuprin.web100.cinema.tools.SorterBuilder;

public abstract class CRUDDaoImpl<T> implements CRUDDao<T> {

	@Autowired
	private SessionFactory factory;

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
	public T get(int id) {
		return (T) getSession().get(domain(), id);
	}

	@Override
	public Collection<T> list(int start, int count, SorterBuilder.Sorter sorter) {
		return getSession().createQuery("from " + domain().getName() + sorter.hql())
			.setFirstResult(start)
			.setMaxResults(count)
			.list();
	}

	@Override
	public void save(T film) {
		getSession().saveOrUpdate(film);
	}

	protected abstract Class<T> domain();

	protected Session getSession() {
		return factory.getCurrentSession();
	}
}
