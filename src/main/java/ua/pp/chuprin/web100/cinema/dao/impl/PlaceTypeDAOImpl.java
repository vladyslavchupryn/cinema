package ua.pp.chuprin.web100.cinema.dao.impl;

import org.springframework.stereotype.Repository;
import ua.pp.chuprin.web100.cinema.dao.PlaceTypeDAO;
import ua.pp.chuprin.web100.cinema.domain.PlaceType;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDDaoImpl;

@Repository
public class PlaceTypeDAOImpl extends CRUDDaoImpl<PlaceType> implements PlaceTypeDAO {

	@Override
	protected Class<PlaceType> domain() {
		return PlaceType.class;
	}
}
