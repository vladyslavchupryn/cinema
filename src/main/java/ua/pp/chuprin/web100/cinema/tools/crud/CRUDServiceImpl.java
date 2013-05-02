package ua.pp.chuprin.web100.cinema.tools.crud;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ua.pp.chuprin.web100.cinema.domain.Film;
import ua.pp.chuprin.web100.cinema.tools.SorterBuilder;

public abstract class CRUDServiceImpl implements CRUDService {

	@Autowired
	private SorterBuilder builder;

	protected abstract CRUDDao dao();

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
	public Object get(Integer id) {
		if (id == null) {
			return new Film();
		} else {
			return dao().get(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Collection list(int pageStart, int countPerPage, String sort) {
		return dao().list(pageStart, countPerPage, builder.build(sort, Film.class));
	}

	@Override
	@Transactional
	public void save(Object film) {
		dao().save(film);
	}
}
