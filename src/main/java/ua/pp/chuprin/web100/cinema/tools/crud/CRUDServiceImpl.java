package ua.pp.chuprin.web100.cinema.tools.crud;

import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;
import ua.pp.chuprin.web100.cinema.tools.SorterBuilder;

public class CRUDServiceImpl<T> implements CRUDService<T> {

	private CRUDDao<T> dao = null;

	protected CRUDServiceImpl() {
	}

	/* package */ CRUDServiceImpl(Class<T> type) {
		this.dao = new CRUDDaoImpl<T>(type);
	}

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

	protected CRUDDao<T> dao() {
		if (dao == null) {
			throw new IllegalStateException("Class can used if dao was provided");
		} else {
			return dao;
		}
	}
}
