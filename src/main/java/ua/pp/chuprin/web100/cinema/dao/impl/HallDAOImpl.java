package ua.pp.chuprin.web100.cinema.dao.impl;

import org.springframework.stereotype.Repository;
import ua.pp.chuprin.web100.cinema.dao.HallDAO;
import ua.pp.chuprin.web100.cinema.domain.Hall;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDDaoImpl;

@Repository
public class HallDAOImpl extends CRUDDaoImpl<Hall> implements HallDAO {

	@Override
	protected Class<Hall> domain() {
		return Hall.class;
	}
}
