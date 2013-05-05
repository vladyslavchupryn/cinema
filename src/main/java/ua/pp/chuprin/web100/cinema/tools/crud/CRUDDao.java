package ua.pp.chuprin.web100.cinema.tools.crud;

import java.util.Collection;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import ua.pp.chuprin.web100.cinema.domain.Category;
import ua.pp.chuprin.web100.cinema.domain.Film;
import ua.pp.chuprin.web100.cinema.tools.SorterBuilder;

public class CRUDDao<T> {

	private final SessionFactory factory;

	private final Class<T> domain;

	public CRUDDao(Class<T> domain, SessionFactory factory) {
		this.domain = domain;
		this.factory = factory;
	}

	public Long count() {
		return (Long) getSession().createQuery("select count(*) from " + domain().getName()).iterate().next();
	}

	public void delete(int id) {
		getSession().createQuery(
			"delete " +
				"from " +
				"   " + domain().getName() + " " +
				"where " +
				"   id = :id"
		).setInteger("id", id).executeUpdate();
	}

	public <A> Collection<A> findAll(Class<A> type) {
		return getSession().createQuery("from " + type.getCanonicalName()).list();
	}

	public T get(int id) {
		return (T) getSession().get(domain(), id);
	}

	public Collection<T> list(int start, int count, SorterBuilder.Sorter sorter) {
		return getSession().createQuery("from " + domain().getName() + sorter.hql())
			.setFirstResult(start)
			.setMaxResults(count)
			.list();
	}

	public void save(T object) {
		getSession().merge(object);
	}

	public final Class<T> domain() {
		return domain;
	}

	protected Session getSession() {
		return factory.getCurrentSession();
	}
}
