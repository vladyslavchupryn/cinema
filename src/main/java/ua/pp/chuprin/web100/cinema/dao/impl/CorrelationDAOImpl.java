package ua.pp.chuprin.web100.cinema.dao.impl;

import org.springframework.stereotype.Repository;
import ua.pp.chuprin.web100.cinema.dao.CorrelationDAO;
import ua.pp.chuprin.web100.cinema.domain.Correlation;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDDaoImpl;

@Repository
public class CorrelationDAOImpl extends CRUDDaoImpl<Correlation> implements CorrelationDAO {

	@Override
	protected Class<Correlation> domain() {
		return Correlation.class;
	}
}
