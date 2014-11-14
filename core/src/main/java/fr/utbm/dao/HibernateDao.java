package fr.utbm.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class HibernateDao extends DAO {

	private static Session session;

	static {
		session = getSession();
	}

	public static long getCount(String entityName) {
		begin();
		Query query = session.createQuery("select count(*) from " + entityName);
		commit();
		return (Long) query.uniqueResult();
	}

	public Object get(Class<?> classObject, String id) {
		begin();
		return session.get(classObject, id);
	}

	public Object get(Class<?> classObject, int id) {
		begin();
		return session.get(classObject, id);
	}

	public void update(Object object) {
		begin();
		session.update(object);
		commit();
	}

	public void persist(Object object) {
		begin();
		session.persist(object);
		commit();
	}

	public void delete(Object object) {
		begin();
		session.delete(object);
		commit();
	}

	public List<?> getAll(String entityName) {
		begin();
		Query query = session.createQuery("from " + entityName);
		commit();
		return query.list();
	}

	public List<?> getAll(Class<?> entityClass) {
		Criteria cr = session.createCriteria(entityClass);
		return cr.list();
	}
}
