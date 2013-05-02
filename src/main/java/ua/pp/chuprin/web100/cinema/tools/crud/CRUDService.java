package ua.pp.chuprin.web100.cinema.tools.crud;

public interface CRUDService {

	Long count();

	void delete(int id);

	Object get(Integer id);

	Object list(int pageStart, int pageEnd, String sort);

	void save(Object film);
}
