package ua.pp.chuprin.web100.cinema.dao;

import java.util.List;

import ua.pp.chuprin.web100.cinema.domain.dataset.client.ClientDataset;
import ua.pp.chuprin.web100.cinema.domain.dataset.client.DataProviderType;
import ua.pp.chuprin.web100.cinema.domain.dataset.client.LayerType;
import ua.pp.chuprin.web100.cinema.domain.dataset.client.TimeStepType;

public interface ClientDatasetDAO {

	public void saveClientDataset(ClientDataset clientDataset);

	public List<ClientDataset> listClientDataset();

	public List<ClientDataset> listClientDatasetByParent(Integer parentId);

	public List<Object[]> listChildByParent(Integer parentId);

	public void removeClientDataset(Integer id);

	public ClientDataset getDataset(Integer id);

	public boolean hasChild(Integer parentId);

	public void testHibernate();

	public List<LayerType> getLayerTypes();

	public List<DataProviderType> getDataProviderTypes();

	public List<TimeStepType> getTimeStepTypes();
}
