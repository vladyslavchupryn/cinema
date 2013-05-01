package ua.pp.chuprin.web100.cinema.dao.implementation;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.pp.chuprin.web100.cinema.dao.WorkerDAO;
import ua.pp.chuprin.web100.cinema.domain.worker.Worker;

@Repository
public class WorkerDAOImpl implements WorkerDAO {

	@Autowired
	private SessionFactory factory;

	@Override
	public Worker getWorker(Integer id) {
		return (Worker) getSession().get(Worker.class, id);
	}

	@Override
	public List<Worker> getWorkers() {
		return getSession().createQuery("from Worker").list();
	}

	private Session getSession() {
		return factory.getCurrentSession();
	}
}
