package ua.pp.chuprin.web100.cinema.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.pp.chuprin.web100.cinema.dao.PlaceDAO;
import ua.pp.chuprin.web100.cinema.domain.Category;
import ua.pp.chuprin.web100.cinema.domain.Place;
import ua.pp.chuprin.web100.cinema.service.PlaceService;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDDao;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDServiceImpl;

@Service
public class PlaceServiceImpl extends CRUDServiceImpl<Place> implements PlaceService {

	@Autowired
	private PlaceDAO dao;

	@Override
	public Collection<Category> categories() {
		return dao.categories();
	}

	@Override
	protected CRUDDao<Place> dao() {
		return dao;
	}
}
