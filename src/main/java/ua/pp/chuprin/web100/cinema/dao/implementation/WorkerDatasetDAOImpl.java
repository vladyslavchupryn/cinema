package ua.pp.chuprin.web100.cinema.dao.implementation;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.pp.chuprin.web100.cinema.dao.WorkerDatasetDAO;
import ua.pp.chuprin.web100.cinema.domain.dataset.worker.DriverType;
import ua.pp.chuprin.web100.cinema.domain.dataset.worker.HdfDriverType;
import ua.pp.chuprin.web100.cinema.domain.dataset.worker.WorkerDataset;

@Repository
public class WorkerDatasetDAOImpl implements WorkerDatasetDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	public List<WorkerDataset> listClientDatasetByParent(Integer parentId) {
		Query query = getSession().createQuery(
			"select " +
				"   worker " +
				"from " +
				"   WorkerDataset worker inner join worker.clientDataset client " +
				"where " +
				"   client.parent = :parentId "
		);
		query.setInteger("parentId", parentId);

		return query.list();
	}

	@Override
	public List<DriverType> getDriverTypes() {
		return getSession().createQuery("from DriverType").list();
	}

	@Override
	public List<HdfDriverType> getHdfDriverTypes() {
		return getSession().createQuery("from HdfDriverType").list();
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}
