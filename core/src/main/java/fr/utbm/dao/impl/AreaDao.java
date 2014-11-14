package fr.utbm.dao.impl;// default package
// Generated 31 oct. 2014 13:51:02 by Hibernate Tools 3.4.0.CR1

import fr.utbm.core.entity.Area;
import fr.utbm.dao.HibernateDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

/**
 * Home object for domain model class Area.
 *
 * @author Hibernate Tools
 * @see .Area
 */
public class AreaDao extends HibernateDao {

	private static final Log log = LogFactory.getLog(AreaDao.class);

	public void persist(Area transientInstance) {
		log.debug("persisting Area instance");
		super.persist(transientInstance);
	}

	public void update(Area instance) {
		log.debug("attaching dirty Area instance");
		super.update(instance);
	}

	public void delete(Area persistentInstance) {
		log.debug("deleting Area instance");
		super.delete(persistentInstance);
	}

	public Area findById(int id) {
		log.debug("getting Area instance with id: " + id);
		return (Area) super.get(Area.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Area> getAll() {
		log.debug("getting all Area instances");
		return (List<Area>) super.getAll(Area.class);
	}
}
