package ua.pp.chuprin.web100.cinema.service.impl;

import javax.annotation.PostConstruct;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.pp.chuprin.web100.cinema.domain.Hall;
import ua.pp.chuprin.web100.cinema.domain.OrderStatus;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDDao;
import ua.pp.chuprin.web100.cinema.tools.crud.CRUDServiceImpl;

@Service
public class OrderStatusServiceImpl extends CRUDServiceImpl<OrderStatus> {

	@Autowired
	private SessionFactory factory;

	private CRUDDao<OrderStatus> dao;

	@PostConstruct
	public void init() {
		dao = new CRUDDao<OrderStatus>(OrderStatus.class, factory);
	}

	@Override
	protected CRUDDao<OrderStatus> dao() {
		return dao;
	}
}
