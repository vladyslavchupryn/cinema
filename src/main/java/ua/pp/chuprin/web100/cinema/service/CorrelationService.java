package ua.pp.chuprin.web100.cinema.service;

import java.util.Collection;

import ua.pp.chuprin.web100.cinema.domain.Correlation;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDService;

public interface CorrelationService extends CRUDService<Correlation> {
	Long count();

	void delete(int id);

	public Correlation get(Integer id);

	public Collection<Correlation> list(int pageStart, int countPerPage, String sort);

	void save(Correlation film);
}
