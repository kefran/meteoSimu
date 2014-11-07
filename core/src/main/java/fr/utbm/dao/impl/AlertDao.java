package fr.utbm.dao.impl;// default package
// Generated 31 oct. 2014 13:51:02 by Hibernate Tools 3.4.0.CR1

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.utbm.core.entity.Alert;
import fr.utbm.dao.HibernateDao;

/**
 * Home object for domain model class Alert.
 * @see .Alert
 * @author Hibernate Tools
 */
public class AlertDao extends HibernateDao{

	private static final Log log = LogFactory.getLog(AlertDao.class);

	public void persist(Alert transientInstance) {
		log.debug("persisting Alert instance");
		super.persist(transientInstance);
	}

	public void update(Alert instance) {
		log.debug("attaching dirty Alert instance");
		super.update(instance);
	}

	public void delete(Alert persistentInstance) {
		log.debug("deleting Alert instance");
		super.delete(persistentInstance);
	}

	public Alert findById(java.lang.String id) {
		log.debug("getting Alert instance with id: " + id);
		return (Alert) super.get(Alert.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Alert> getAll() {
		log.debug("getting all Alert instances");
		return (List<Alert>) super.getAll(Alert.class);
	}
}
