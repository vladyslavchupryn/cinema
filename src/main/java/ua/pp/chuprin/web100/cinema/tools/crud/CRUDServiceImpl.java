package ua.pp.chuprin.web100.cinema.tools.crud;

import java.util.Collection;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import ua.pp.chuprin.web100.cinema.tools.SorterBuilder;

public abstract class CRUDServiceImpl<T> implements CRUDService<T> {

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return dao().count();
	}

	@Override
	@Transactional
	public void delete(int id) {
		dao().delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public <A> Collection<A> findAll(Class<A> type) {
		return dao().findAll(type);
	}

	@Override
	@Transactional(readOnly = true)
	public T get(Integer id) {
		return dao().get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<T> list(int pageStart, int countPerPage, String sort) {
		SorterBuilder.Sorter sorter = SorterBuilder.build(sort, dao().domain().getClass());
		return dao().list(pageStart, countPerPage, sorter);
	}

	@Override
	@Transactional
	public void save(T film) {
		dao().save(film);
	}

	protected abstract CRUDDao<T> dao();
}
