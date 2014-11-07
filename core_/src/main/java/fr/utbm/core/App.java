package fr.utbm.core;

import fr.utbm.core.entity.User;
import fr.utbm.core.tools.HibernateUtil;
import org.hibernate.Session;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        User user = new User();
        user.setUsername("toto");
        session.persist(user);
        session.getTransaction().commit();
        session.close();
    }
}
