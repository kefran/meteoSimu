package fr.utbm.dao.impl;// default package
// Generated 31 oct. 2014 13:51:02 by Hibernate Tools 3.4.0.CR1

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.utbm.core.entity.Trigger;
import fr.utbm.dao.HibernateDao;

/**
 * Home object for domain model class Trigger.
 * @see .Trigger
 * @author Hibernate Tools
 */
public class TriggerDao extends HibernateDao {

	private static final Log log = LogFactory.getLog(TriggerDao.class);

	public void persist(Trigger transientInstance) {
		log.debug("persisting Trigger instance");
		super.persist(transientInstance);
	}

	public void update(Trigger instance) {
		log.debug("attaching dirty Trigger instance");
		super.update(instance);
	}

	public void delete(Trigger persistentInstance) {
		log.debug("deleting Trigger instance");
		super.delete(persistentInstance);
	}

	public Trigger findById(java.lang.String id) {
		log.debug("getting Trigger instance with id: " + id);
		return (Trigger) super.get(Trigger.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Trigger> getAll() {
		log.debug("getting all Trigger instances");
		return (List<Trigger>) super.getAll(Trigger.class);
	}
}
