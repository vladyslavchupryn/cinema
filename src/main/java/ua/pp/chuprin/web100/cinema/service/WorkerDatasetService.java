package ua.pp.chuprin.web100.cinema.service;

import java.util.List;

import ua.pp.chuprin.web100.cinema.domain.dataset.worker.DriverType;
import ua.pp.chuprin.web100.cinema.domain.dataset.worker.HdfDriverType;

public interface WorkerDatasetService {
	public void writeXml();

	public List<DriverType> getDriverTypes();

	public List<HdfDriverType> getHdfDriverTypes();
}
