package ua.pp.chuprin.web100.cinema.service;

import java.util.List;

import ua.pp.chuprin.web100.cinema.domain.worker.Worker;

public interface WorkerService {

	public boolean start(Integer id);

	public String status(Integer id);

	public boolean stop(Integer id);

	public List<Worker> getWorkers();
}
