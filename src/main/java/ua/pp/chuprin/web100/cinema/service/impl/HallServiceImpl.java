package ua.pp.chuprin.web100.cinema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.pp.chuprin.web100.cinema.dao.HallDAO;
import ua.pp.chuprin.web100.cinema.domain.Hall;
import ua.pp.chuprin.web100.cinema.service.HallService;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDDao;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDServiceImpl;

@Service
public class HallServiceImpl extends CRUDServiceImpl<Hall> implements HallService {

	@Autowired
	private HallDAO dao;

	@Override
	protected CRUDDao<Hall> dao() {
		return dao;
	}
}
