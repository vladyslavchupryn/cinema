package ua.pp.chuprin.web100.cinema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.pp.chuprin.web100.cinema.dao.CorrelationDAO;
import ua.pp.chuprin.web100.cinema.domain.Correlation;
import ua.pp.chuprin.web100.cinema.service.CorrelationService;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDDao;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDServiceImpl;

@Service
public class CorrelationServiceImpl extends CRUDServiceImpl<Correlation> implements CorrelationService {

	@Autowired
	private CorrelationDAO dao;

	@Override
	protected CRUDDao<Correlation> dao() {
		return dao;
	}
}
