package ua.pp.chuprin.web100.cinema.dao;

import java.util.List;

import ua.pp.chuprin.web100.cinema.domain.worker.Worker;

public interface WorkerDAO {

	public Worker getWorker(Integer id);

	public List<Worker> getWorkers();
}
