package ua.pp.chuprin.web100.cinema.dao.impl;

import org.springframework.stereotype.Repository;
import ua.pp.chuprin.web100.cinema.dao.__template__DAO;
import ua.pp.chuprin.web100.cinema.domain.__template__;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDDaoImpl;

@Repository
public class __template__DAOImpl extends CRUDDaoImpl implements __template__DAO {

	@Override
	protected Class domain() {
		return __template__.class;
	}
}
