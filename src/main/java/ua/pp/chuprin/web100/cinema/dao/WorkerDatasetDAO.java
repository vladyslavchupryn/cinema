package ua.pp.chuprin.web100.cinema.dao;

import java.util.List;

import ua.pp.chuprin.web100.cinema.domain.dataset.worker.DriverType;
import ua.pp.chuprin.web100.cinema.domain.dataset.worker.HdfDriverType;
import ua.pp.chuprin.web100.cinema.domain.dataset.worker.WorkerDataset;

public interface WorkerDatasetDAO {

	public List<WorkerDataset> listClientDatasetByParent(Integer parentId);

	public List<DriverType> getDriverTypes();

	public List<HdfDriverType> getHdfDriverTypes();
}
