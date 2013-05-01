package ua.pp.chuprin.web100.cinema.service.implementation;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.pp.chuprin.web100.cinema.dao.WorkerDAO;
import ua.pp.chuprin.web100.cinema.domain.worker.Worker;
import ua.pp.chuprin.web100.cinema.service.WorkerService;
import ua.pp.chuprin.web100.cinema.service.tools.WorkerConnector;

@Service
public class WorkerServiceImpl implements WorkerService {

	@Autowired
	private WorkerDAO dao;

	@Override
	public boolean start(Integer id) {
		Worker worker = dao.getWorker(id);

		WorkerConnector connector = null;
		try {
			connector = new WorkerConnector(worker);

			return connector.start();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (connector != null) {
				connector.close();
			}
		}
	}

	@Override
	public String status(Integer id) {
		Worker worker = dao.getWorker(id);

		WorkerConnector connector = null;
		try {
			connector = new WorkerConnector(worker);

			return connector.status();
		} catch (IOException e) {
			e.printStackTrace();
			return "internal-error";
		} finally {
			if (connector != null) {
				connector.close();
			}
		}
	}

	@Override
	public boolean stop(Integer id) {
		Worker worker = dao.getWorker(id);
		return stop(worker);
	}

	private boolean stop(Worker worker) {
		WorkerConnector connector = null;
		try {
			connector = new WorkerConnector(worker);

			return connector.stop();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (connector != null) {
				connector.close();
			}
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Worker> getWorkers() {
		return dao.getWorkers();
	}
}
