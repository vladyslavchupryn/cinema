package ua.pp.chuprin.web100.cinema.service;

import java.util.Collection;

import ua.pp.chuprin.web100.cinema.domain.Hall;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDService;

public interface HallService extends CRUDService<Hall> {
	Long count();

	void delete(int id);

	public Hall get(Integer id);

	public Collection<Hall> list(int pageStart, int countPerPage, String sort);

	void save(Hall film);
}
