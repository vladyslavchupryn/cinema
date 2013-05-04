package ua.pp.chuprin.web100.cinema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.pp.chuprin.web100.cinema.dao.PlaceTypeDAO;
import ua.pp.chuprin.web100.cinema.domain.PlaceType;
import ua.pp.chuprin.web100.cinema.service.PlaceTypeService;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDDao;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDServiceImpl;

@Service
public class PlaceTypeServiceImpl extends CRUDServiceImpl<PlaceType> implements PlaceTypeService {

	@Autowired
	private PlaceTypeDAO dao;

	@Override
	protected CRUDDao<PlaceType> dao() {
		return dao;
	}
}
