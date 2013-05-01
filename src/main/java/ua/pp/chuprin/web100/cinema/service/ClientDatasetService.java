package ua.pp.chuprin.web100.cinema.service;

import java.util.List;

import ua.pp.chuprin.web100.cinema.domain.dataset.client.ClientDataset;
import ua.pp.chuprin.web100.cinema.domain.dataset.client.DataProviderType;
import ua.pp.chuprin.web100.cinema.domain.dataset.client.LayerType;
import ua.pp.chuprin.web100.cinema.domain.dataset.client.TimeStepType;

public interface ClientDatasetService {

	public void saveClientDataset(ClientDataset clientDataset);

	public List<ClientDataset> listClientDataset();

	public List<ClientDataset> listClientDatasetByParent(Integer parentId);

	public void remove(Integer id);

	public String createTreeJson(Integer parentId);

	public ClientDataset createChildDataset(Integer parentId);

	public ClientDataset getDataset(int id);

	public void writeXml();

	public void testHibernate();

	public List<LayerType> getLayerTypes();

	public List<DataProviderType> getDataProviderTypes();

	public List<TimeStepType> getTimeTypes();
}
