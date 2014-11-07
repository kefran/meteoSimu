package fr.utbm.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.utbm.core.entity.Alert;
import fr.utbm.core.tools.HibernateUtil;

/**
 * Provide DAO with basic session operations
 * 
 * @author Kevin Le Roy
 * @author Lionel Cabasson
 */
public abstract class DAO {

	@SuppressWarnings("rawtypes")
	private static final ThreadLocal session = new ThreadLocal();
	private static final SessionFactory sessionFactory = HibernateUtil
			.getSessionFactory();

	/**
	 * Build a new DAO
	 */
	protected DAO() {
		
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			public void run() {
				close();
			}
		}));
		
	}

	/**
	 * Return the DAO session
	 * 
	 * @return session object
	 */
	@SuppressWarnings("unchecked")
	public static Session getSession() {
		Session session = (Session) DAO.session.get();
		if (session == null) {
			session = sessionFactory.openSession();
			DAO.session.set(session);
		}
		return session;
	}

	/**
	 * Begin a new transaction
	 */
	protected static void begin() {
		getSession().beginTransaction();
	}

	/**
	 * Commit current transaction
	 */
	protected static void commit() {
		getSession().getTransaction().commit();
	}

	/**
	 * Rollback current transaction
	 */
	@SuppressWarnings("unchecked")
	protected static void rollback() {
		try {
			getSession().getTransaction().rollback();
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		}
		try {
			getSession().close();
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		}
		DAO.session.set(null);
	}

	/**
	 * Close current session
	 */
	@SuppressWarnings("unchecked")
	public static void close() {
		getSession().close();
		DAO.session.set(null);
	}
	
	protected abstract void persist(Object object);
	public abstract Object get(Class<?> classObject, String id);
	protected abstract void delete(Object object);
	protected abstract void update(Object object);
	
	public static void main(String[] args) {
		Alert alert = new Alert();
		alert.setAlrCode("TEST");
		alert.setAlrLabel("TEST");
		alert.setAlrDescription("TEST");
		DaoFactory.getAlertDao().persist(alert);
	}
}