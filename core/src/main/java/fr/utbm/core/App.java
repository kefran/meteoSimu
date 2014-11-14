package fr.utbm.core;

import fr.utbm.core.entity.Temperature;
import fr.utbm.core.tools.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Hello world!
 */
public class App {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		// Sélection des températures
		Query q = session.createQuery("from Temperature");
		List<Temperature> temperatures = q.list();

		System.out.println("Listage des températures :");
		System.out.println(temperatures.size() + " températures trouvées");
		for (Temperature t : temperatures) {
			System.out.println("Température lue : " + t.getValue());
		}

		session.getTransaction().commit();
		session.close();
	}
}
