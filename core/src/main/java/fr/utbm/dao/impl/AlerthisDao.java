package fr.utbm.dao.impl;// default package
// Generated 31 oct. 2014 13:51:02 by Hibernate Tools 3.4.0.CR1

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.utbm.core.entity.Alerthis;
import fr.utbm.dao.HibernateDao;

/**
 * Home object for domain model class Alerthishis.
 * @see .Alerthishis
 * @author Hibernate Tools
 */
public class AlerthisDao extends HibernateDao {

	private static final Log log = LogFactory.getLog(AlerthisDao.class);

	public void persist(Alerthis transientInstance) {
		log.debug("persisting Alerthis instance");
		super.persist(transientInstance);
	}

	public void update(Alerthis instance) {
		log.debug("attaching dirty Alerthis instance");
		super.update(instance);
	}

	public void delete(Alerthis persistentInstance) {
		log.debug("deleting Alerthis instance");
		super.delete(persistentInstance);
	}

	public Alerthis findById(java.lang.String id) {
		log.debug("getting Alerthis instance with id: " + id);
		return (Alerthis) super.get(Alerthis.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Alerthis> getAll() {
		log.debug("getting all Alerthis instances");
		return (List<Alerthis>) super.getAll(Alerthis.class);
	}
}
