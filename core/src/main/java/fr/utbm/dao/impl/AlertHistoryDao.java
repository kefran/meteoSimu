package fr.utbm.dao.impl;// default package
// Generated 31 oct. 2014 13:51:02 by Hibernate Tools 3.4.0.CR1

import fr.utbm.core.entity.AlertHistory;
import fr.utbm.dao.HibernateDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

/**
 * Home object for domain model class Alerthishis.
 *
 * @author Hibernate Tools
 * @see .Alerthishis
 */
public class AlertHistoryDao extends HibernateDao {

	private static final Log log = LogFactory.getLog(AlertHistoryDao.class);

	public void persist(AlertHistory transientInstance) {
		log.debug("persisting Alerthis instance");
		super.persist(transientInstance);
	}

	public void update(AlertHistory instance) {
		log.debug("attaching dirty Alerthis instance");
		super.update(instance);
	}

	public void delete(AlertHistory persistentInstance) {
		log.debug("deleting Alerthis instance");
		super.delete(persistentInstance);
	}

	public AlertHistory findById(int id) {
		log.debug("getting Alerthis instance with id: " + id);
		return (AlertHistory) super.get(AlertHistory.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<AlertHistory> getAll() {
		log.debug("getting all Alerthis instances");
		return (List<AlertHistory>) super.getAll(AlertHistory.class);
	}
}
