package ua.pp.chuprin.web100.cinema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.pp.chuprin.web100.cinema.dao.__template__DAO;
import ua.pp.chuprin.web100.cinema.service.__template__Service;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDDao;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDServiceImpl;

@Service
public class __template__ServiceImpl extends CRUDServiceImpl implements __template__Service {

	@Autowired
	private __template__DAO dao;

	@Override
	protected CRUDDao dao() {
		return dao;
	}
}
