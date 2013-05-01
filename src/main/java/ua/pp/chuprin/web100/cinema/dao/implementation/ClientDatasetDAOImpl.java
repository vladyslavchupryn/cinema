package ua.pp.chuprin.web100.cinema.dao.implementation;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.pp.chuprin.web100.cinema.dao.ClientDatasetDAO;
import ua.pp.chuprin.web100.cinema.domain.dataset.client.ClientDataset;
import ua.pp.chuprin.web100.cinema.domain.dataset.client.DataProviderType;
import ua.pp.chuprin.web100.cinema.domain.dataset.client.LayerType;
import ua.pp.chuprin.web100.cinema.domain.dataset.client.TimeStepType;

@Repository
public class ClientDatasetDAOImpl implements ClientDatasetDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveClientDataset(ClientDataset dataset) {
		getSession().saveOrUpdate(dataset);
		if (dataset.getWorkerDataset() != null) {
			getSession().saveOrUpdate(dataset.getWorkerDataset());
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ClientDataset> listClientDataset() {
		return getSession().createQuery("from ClientDataset").list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ClientDataset> listClientDatasetByParent(Integer parentId) {
		Criteria criteria = getSession().createCriteria(ClientDataset.class);
		criteria.add(parentId == null ?
			Restrictions.isNull("parent") : Restrictions.eq("parent", parentId));

		return criteria.list();
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Object[]> listChildByParent(Integer parentId) {
		if (parentId == null) { // TODO
			return getSession().createQuery(
				"select " +
					"   name, " +
					"   id " +
					"from " +
					"   ClientDataset " +
					"where " +
					"   parent is null")
				.list();
		} else {
			return getSession().createQuery(
				"select " +
					"   name, " +
					"   id " +
					"from " +
					"   ClientDataset " +
					"where " +
					"   parent = :parentId")
				.setInteger("parentId", parentId)
				.list();
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean hasChild(Integer parentId) {
		List<Long> result;
		if (parentId == null) { // TODO
			result = getSession().createQuery(
				"select " +
					"   count(*) " +
					"from " +
					"   ClientDataset " +
					"where " +
					"   parent is null ")
				.list();
		} else {
			result = getSession().createQuery(
				"select " +
					"   count(*) " +
					"from " +
					"   ClientDataset " +
					"where " +
					"   parent = :parentId")
				.setInteger("parentId", parentId)
				.list();
		}
		long count = result.get(0);
		return count > 0;
	}

	@Override
	public void testHibernate() {
//		LayerType layerType = (LayerType) sessionFactory.getCurrentSession().load(LayerType.class,(short)11);
//		layerType.setValue("newValue");
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<LayerType> getLayerTypes() {
		return getSession().createQuery("from LayerType").list();
	}

	@Override
	public List<DataProviderType> getDataProviderTypes() {
		return getSession().createQuery("from DataProviderType").list();
	}

	@Override
	public List<TimeStepType> getTimeStepTypes() {
		return getSession().createQuery("from TimeStepType").list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public void removeClientDataset(Integer id) {
		getSession().createQuery(
			"delete " +
				"from " +
				"   ClientDataset " +
				"where " +
				"   id = :id"
		).setInteger("id", id).executeUpdate();
	}

	@Override
	@SuppressWarnings("unchecked")
	public ClientDataset getDataset(Integer id) {
		return (ClientDataset) getSession().get(ClientDataset.class, id);
	}
}
